package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Snake_Ladder_Server {
    static String str = "Player1";
    Snake_Ladder_Server(){
        try{
            System.out.println("Server is waiting for client.");
            ServerSocket server_socket = new ServerSocket(6603);
            while(true){
                Socket sc = server_socket.accept();
                Server_snake server = new Server_snake(sc);
                Thread th = new Thread(server);
                th.start();
            }
        }catch (IOException io){
            io.printStackTrace();
        }
    }
}
class Server_snake implements Runnable{
    BufferedReader reader;
    BufferedWriter writer;

    final static ArrayList<Server_snake> clients = new ArrayList<>(2);

    Server_snake(Socket sc){
        try{
            OutputStreamWriter ow = new OutputStreamWriter(sc.getOutputStream());
            writer = new BufferedWriter(ow);
            InputStreamReader isr = new InputStreamReader(sc.getInputStream());
            reader = new BufferedReader(isr);
            clients.add(this);
        }catch (IOException io){
            io.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            writer.write(Snake_Ladder_Server.str+"\n");
            Snake_Ladder_Server.str = "Player2";
            writer.flush();
            while (true) {
                String str1 = reader.readLine();
                String str2 = reader.readLine();
                System.out.println(str1);
                System.out.println(str2);
                synchronized (clients) {
                    for (Server_snake s : clients) {
                        s.writer.write(str1 + "\n");
                        s.writer.write(str2 + "\n");
                        s.writer.flush();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}