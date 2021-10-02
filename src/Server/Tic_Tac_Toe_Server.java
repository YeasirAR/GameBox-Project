package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Tic_Tac_Toe_Server {
    static String str = "X";
    public static void main(String[] args) {

        try {
            System.out.println("Server is waiting for client.");
            ServerSocket serverSocket = new ServerSocket(6601);

            while (true){
                Socket sc = serverSocket.accept();
                TicTacToeServer s = new TicTacToeServer(sc);
                Thread t = new Thread(s);
                t.start();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
class TicTacToeServer implements Runnable {
    BufferedReader reader;
    BufferedWriter writer;

    final static ArrayList<TicTacToeServer> clients = new ArrayList<>(2);


    TicTacToeServer(Socket sc) {
        try {
            OutputStreamWriter o = new OutputStreamWriter(sc.getOutputStream());
            writer = new BufferedWriter(o);
            InputStreamReader isr = new InputStreamReader(sc.getInputStream());
            reader = new BufferedReader(isr);
            clients.add(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            writer.write(Tic_Tac_Toe_Server.str+"\n");
            Tic_Tac_Toe_Server.str = "O";
            writer.flush();
            while (true) {
                String str1 = reader.readLine();
                String str2 = reader.readLine();
                System.out.println(str1);
                System.out.println(str2);
                synchronized (clients) {
                    for (TicTacToeServer s : clients) {
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