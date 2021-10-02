package GameBox;
import GameBox.MainController.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.*;
import java.net.Socket;

public class Tic_Tac_Toe extends MainController{
    @FXML
    private Pane Pane1;
    @FXML
    private Pane Pane2;
    @FXML
    private Pane Pane3;
    @FXML
    private TextArea Chat_List;
    @FXML
    private TextField Send_Msg;
    @FXML
    private Button button1,button2,button3,button4,
            button5,button6,button7,button8,button9;
    private String str;
    private BufferedReader reader;
    private BufferedWriter writer;

    @FXML
    private void start_game(){
        Pane2.setVisible(false);
        Pane3.setVisible(true);
        Socket sc = null;
        try {
            sc = new Socket("127.0.0.1", 6602);
            OutputStreamWriter o = new OutputStreamWriter(sc.getOutputStream());
            writer = new BufferedWriter(o);
            InputStreamReader isr = new InputStreamReader(sc.getInputStream());
            reader = new BufferedReader(isr);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void button_clicked(ActionEvent event){

        if(event.getSource() == button1){
            try {
                writer.write("Test");
                writer.flush();
//                str = reader.readLine();
//                button1.setText(str);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        if(event.getSource() == button2){
            button2.setText(str);
        }
        if(event.getSource() == button3){
            button3.setText(str);
        }
    }


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
