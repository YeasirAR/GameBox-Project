package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class GameBoxServer{
    public static void main(String[] args) {
        try {
            System.out.println("Server is waiting for client.");
            ServerSocket serverSocket = new ServerSocket(6601);

            while (true){
                Socket sc = serverSocket.accept();
                ServerMain serverMain = new ServerMain(sc);
                Thread t = new Thread(serverMain);
                t.start();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
class ServerMain implements Runnable{
    BufferedReader reader;
    BufferedWriter writer;

    final static ArrayList<Users> user = new ArrayList<>();

    ServerMain(Socket sc){
        try {
            OutputStreamWriter o = new OutputStreamWriter(sc.getOutputStream());
            writer = new BufferedWriter(o);
            InputStreamReader isr = new InputStreamReader(sc.getInputStream());
            reader = new BufferedReader(isr);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while (true) {
            try {
                user.add(new Users(reader.readLine(), reader.readLine()));
                System.out.println(user);
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}

class Users{
    String username;
    String password;

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
