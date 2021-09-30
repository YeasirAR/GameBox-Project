package GameBox;
import GameBox.MainController.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;

public class Tic_Tac_Toe extends MainController{
    @FXML
    private TextArea Chat_List;
    @FXML
    private TextField Send_Msg;

//    public BufferedReader reader;
//    public BufferedWriter writer;
//    Tic_Tac_Toe(){
//        OutputStreamWriter o = new OutputStreamWriter(sc.getOutputStream());
//        writer = new BufferedWriter(o);
//        InputStreamReader isr = new InputStreamReader(sc.getInputStream());
//        reader = new BufferedReader(isr);
//    }

    @FXML
    private void Send_Msg_Method(){
        String s = null;
        try {
            s = reader.readLine();
            if(s.equals("ChatBox Before Game")){
                Chat_List.appendText(s+"\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
