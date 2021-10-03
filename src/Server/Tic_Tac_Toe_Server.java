package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Tic_Tac_Toe_Server {
    final static ArrayList<Users> users = Server.ServerMain.getList();
    static String str = "X";
    static String player1 = users.get(0).username;
    static String player2 = users.get(1).username;
    Tic_Tac_Toe_Server() {
        try {
            ServerSocket serverSocket = new ServerSocket(6602);

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
            writer.write(Tic_Tac_Toe_Server.player1+"\n");
            Tic_Tac_Toe_Server.player1 = Tic_Tac_Toe_Server.player2;
            writer.flush();
            while (true) {
                String str1 = reader.readLine();
                String str2 = reader.readLine();
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