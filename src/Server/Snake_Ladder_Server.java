package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Snake_Ladder_Server {
    final static ArrayList<Users>gamers = Server.ServerMain.getList();
    static String Player = "Player1";
    static String gamer1 = gamers.get(0).username;
    static String gamer2 = gamers.get(1).username;
    Snake_Ladder_Server(){
        try{
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
            writer.write(Snake_Ladder_Server.Player +"\n");
            Snake_Ladder_Server.Player = "Player2";
            writer.write(Snake_Ladder_Server.gamer1+ "\n");
            Snake_Ladder_Server.gamer1 = Snake_Ladder_Server.gamer2;
            writer.flush();
            while (true) {
                String str1 = reader.readLine();
                String str2 = reader.readLine();
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