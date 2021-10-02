package Server;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Tic_Tac_Toe_Server {
    public static void main(String[] args) {

        try {
            System.out.println("Server is waiting for client.");
            ServerSocket serverSocket = new ServerSocket(6602);
            while (true){
                Socket sc = serverSocket.accept();
                Server s = new Server(sc);
                Thread t = new Thread(s);
                t.start();
            }
        }
        catch (IOException e){
//            e.printStackTrace();
        }
    }
}
class Server implements Runnable{
    BufferedReader reader;
    BufferedWriter writer;

    final static ArrayList<Server> clients = new ArrayList<>(2);
    final static ArrayList<Users> user = ServerMain.getList();

    Server(Socket sc){
        try {
            OutputStreamWriter o = new OutputStreamWriter(sc.getOutputStream());
            writer = new BufferedWriter(o);
            InputStreamReader isr = new InputStreamReader(sc.getInputStream());
            reader = new BufferedReader(isr);
            clients.add(this);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true){
            try {
                System.out.println(reader.readLine());
//               writer.write("O");
//                writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }}
}
