package GameBox;import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.util.Objects;

public class Tic_Tac_Toe {
    @FXML
    private Pane Pane1;
    @FXML
    private Pane Pane2;
    @FXML
    private Pane Pane3;
    @FXML
    private Pane Pane4;
    @FXML
    private Label isTurn;
    @FXML
    private Label isTurn4x4;
    @FXML
    private TextField Send_Msg;
    @FXML
    private TextArea Chat_List;

    @FXML
    private Button button1,button2,button3,button4,
            button5,button6,button7,button8,button9;
    @FXML
    private Button button11,button12,button13,button14,
            button15,button16,button17,button18,button19,
            button20,button21,button22,button23,button24,
            button25,button26;

    public BufferedReader reader;
    public BufferedWriter writer;
    private String str;
    private String name;

    public Tic_Tac_Toe() {
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
    public void button_clicked(ActionEvent event) throws IOException {
        writer.write("Who's Turn\n");
        writer.write(name+"\n");
        writer.flush();

        if(event.getSource() == button1){
            writer.write("button1\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button2){
            writer.write("button2\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button3){
            writer.write("button3\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button4){
            writer.write("button4\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button5){
            writer.write("button5\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button6){
            writer.write("button6\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button7){
            writer.write("button7\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button8){
            writer.write("button8\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button9){
            writer.write("button9\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button11){
            writer.write("button11\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button12){
            writer.write("button12\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button13){
            writer.write("button13\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button14){
            writer.write("button14\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button15){
            writer.write("button15\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button16){
            writer.write("button16\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button17){
            writer.write("button17\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button18){
            writer.write("button18\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button19){
            writer.write("button19\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button20){
            writer.write("button20\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button21){
            writer.write("button21\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button22){
            writer.write("button22\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button23){
            writer.write("button23\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button24){
            writer.write("button24\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button25){
            writer.write("button25\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button26){
            writer.write("button26\n");
            writer.write(str+"\n");
            writer.flush();
        }

    }
    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                while (true) {
                    String str1 = reader.readLine();

                    if(str1.equals("Who's Turn")){
                        String tmpName = reader.readLine();
                        if(!name.equals(tmpName)){
                            Platform.runLater(() -> {
                                isTurn.setText("YOUR TURN");
                                isTurn4x4.setText("YOUR TURN");
                            });
                        }
                        else {
                            Platform.runLater(() -> {
                                isTurn.setText("");
                                isTurn4x4.setText("");
                            });
                        }
                    }

                    if (str1.equals("Send Message")) {
                        String str2 = reader.readLine();
                        Platform.runLater(() -> {
                            Chat_List.appendText(str2+"\n");
                        });
                    }
                    if (str1.equals("Start 3x3")) {
                        reader.readLine();
                        Pane2.setVisible(false);
                        Pane3.setVisible(true);
                    }
                    if (str1.equals("Start 4x4")) {
                        reader.readLine();
                        Pane2.setVisible(false);
                        Pane4.setVisible(true);
                    }
                    if (str1.equals("Back To Tic Tac Toe")) {
                        reader.readLine();
                        Pane2.setVisible(true);
                        Pane3.setVisible(false);
                        Pane4.setVisible(false);
                    }



                    if (str1.equals("button1")) {
                        String str2 = reader.readLine();
                        Platform.runLater(() -> {
                            button1.setText(str2);
                            checkWinner();
                        });
                    }
                    else if (str1.equals("button2")) {
                        String str2 = reader.readLine();
                        Platform.runLater(() -> {
                            button2.setText(str2);
                            checkWinner();
                        });

                    }
                    else if (str1.equals("button3")) {
                        String str2 = reader.readLine();
                        Platform.runLater(() -> {
                            button3.setText(str2);
                            checkWinner();
                        });

                    }
                    else if (str1.equals("button4")) {
                        String str2 = reader.readLine();
                        Platform.runLater(() -> {
                            button4.setText(str2);
                            checkWinner();
                        });

                    }
                    else if (str1.equals("button5")) {
                        String str2 = reader.readLine();
                        Platform.runLater(() -> {
                            button5.setText(str2);
                            checkWinner();
                        });

                    }
                    else if (str1.equals("button6")) {
                        String str2 = reader.readLine();
                        Platform.runLater(() -> {
                            button6.setText(str2);
                            checkWinner();
                        });

                    }
                    else if (str1.equals("button7")) {
                        String str2 = reader.readLine();
                        Platform.runLater(() -> {
                            button7.setText(str2);
                            checkWinner();
                        });

                    }
                    else if (str1.equals("button8")) {
                        String str2 = reader.readLine();
                        Platform.runLater(() -> {
                            button8.setText(str2);
                            checkWinner();
                        });
                    }
                    else if (str1.equals("button9")) {
                        String str2 = reader.readLine();
                        Platform.runLater(() -> {
                            button9.setText(str2);
                            checkWinner();
                        });
                    }
                    else if (str1.equals("button11")) {
                        String str2 = reader.readLine();
                        Platform.runLater(() -> {
                            button11.setText(str2);
                            checkWinner();
                        });
                    }
                    else if (str1.equals("button12")) {
                        String str2 = reader.readLine();
                        Platform.runLater(() -> {
                            button12.setText(str2);
                            checkWinner();
                        });
                    }
                    else if (str1.equals("button13")) {
                        String str2 = reader.readLine();
                        Platform.runLater(() -> {
                            button13.setText(str2);
                            checkWinner();
                        });
                    }
                    else if (str1.equals("button14")) {
                        String str2 = reader.readLine();
                        Platform.runLater(() -> {
                            button14.setText(str2);
                            checkWinner();
                        });
                    }
                    else if (str1.equals("button15")) {
                        String str2 = reader.readLine();
                        Platform.runLater(() -> {
                            button15.setText(str2);
                            checkWinner();
                        });
                    }
                    else if (str1.equals("button16")) {
                        String str2 = reader.readLine();
                        Platform.runLater(() -> {
                            button16.setText(str2);
                            checkWinner();
                        });
                    }
                    else if (str1.equals("button17")) {
                        String str2 = reader.readLine();
                        Platform.runLater(() -> {
                            button17.setText(str2);
                            checkWinner();
                        });
                    }
                    else if (str1.equals("button18")) {
                        String str2 = reader.readLine();
                        Platform.runLater(() -> {
                            button18.setText(str2);
                            checkWinner();
                        });
                    }
                    else if (str1.equals("button19")) {
                        String str2 = reader.readLine();
                        Platform.runLater(() -> {
                            button19.setText(str2);
                            checkWinner();
                        });
                    }
                    else if (str1.equals("button20")) {
                        String str2 = reader.readLine();
                        Platform.runLater(() -> {
                            button20.setText(str2);
                            checkWinner();
                        });
                    }
                    else if (str1.equals("button21")) {
                        String str2 = reader.readLine();
                        Platform.runLater(() -> {
                            button21.setText(str2);
                            checkWinner();
                        });
                    }
                    else if (str1.equals("button22")) {
                        String str2 = reader.readLine();
                        Platform.runLater(() -> {
                            button22.setText(str2);
                            checkWinner();
                        });
                    }
                    else if (str1.equals("button23")) {
                        String str2 = reader.readLine();
                        Platform.runLater(() -> {
                            button23.setText(str2);
                            checkWinner();
                        });
                    }
                    else if (str1.equals("button24")) {
                        String str2 = reader.readLine();
                        Platform.runLater(() -> {
                            button24.setText(str2);
                            checkWinner();
                        });
                    }
                    else if (str1.equals("button25")) {
                        String str2 = reader.readLine();
                        Platform.runLater(() -> {
                            button25.setText(str2);
                            checkWinner();
                        });
                    }
                    else if (str1.equals("button26")) {
                        String str2 = reader.readLine();
                        Platform.runLater(() -> {
                            button26.setText(str2);
                            checkWinner();
                        });
                    }

                    if (str1.equals("restart")) {
                        reader.readLine();
                        Platform.runLater(() -> {
                            button1.setText(" ");
                            button2.setText(" ");
                            button3.setText(" ");
                            button4.setText(" ");
                            button5.setText(" ");
                            button6.setText(" ");
                            button7.setText(" ");
                            button8.setText(" ");
                            button9.setText(" ");
                            button11.setText(" ");
                            button12.setText(" ");
                            button13.setText(" ");
                            button14.setText(" ");
                            button15.setText(" ");
                            button16.setText(" ");
                            button17.setText(" ");
                            button18.setText(" ");
                            button19.setText(" ");
                            button20.setText(" ");
                            button21.setText(" ");
                            button22.setText(" ");
                            button23.setText(" ");
                            button24.setText(" ");
                            button25.setText(" ");
                            button26.setText(" ");
                            Platform.runLater(() -> {
                                isTurn.setText("");
                                isTurn4x4.setText("");
                            });
                        });
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    });

    @FXML
    private void restart(){
        try {
            writer.write("restart\n");
            writer.write("Discard Text\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void exit(ActionEvent e) {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }

    private void checkWinner(){
        //X Won
        if(button1.getText().equals("X") && button2.getText().equals("X")
                && button3.getText().equals("X")){
            if(str.equals("X"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button4.getText().equals("X") && button5.getText().equals("X")
                && button6.getText().equals("X")){
            if(str.equals("X"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button7.getText().equals("X") && button8.getText().equals("X")
                && button9.getText().equals("X")){
            if(str.equals("X"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button1.getText().equals("X") && button4.getText().equals("X")
                && button7.getText().equals("X")){
            if(str.equals("X"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button2.getText().equals("X") && button5.getText().equals("X")
                && button8.getText().equals("X")){
            if(str.equals("X"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button3.getText().equals("X") && button6.getText().equals("X")
                && button9.getText().equals("X")){
            if(str.equals("X"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button1.getText().equals("X") && button5.getText().equals("X")
                && button9.getText().equals("X")){
            if(str.equals("X"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button3.getText().equals("X") && button5.getText().equals("X")
                && button7.getText().equals("X")){
            if(str.equals("X"))
                WinDialog();
            else
                LoseDialog();
        }
        // O Won
        else if(button1.getText().equals("O") && button2.getText().equals("O")
                && button3.getText().equals("O")){
            if(str.equals("O"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button4.getText().equals("O") && button5.getText().equals("O")
                && button6.getText().equals("O")){
            if(str.equals("O"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button7.getText().equals("O") && button8.getText().equals("O")
                && button9.getText().equals("O")){
            if(str.equals("O"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button1.getText().equals("O") && button4.getText().equals("O")
                && button7.getText().equals("O")){
            if(str.equals("O"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button2.getText().equals("O") && button5.getText().equals("O")
                && button8.getText().equals("O")){
            if(str.equals("O"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button3.getText().equals("O") && button6.getText().equals("O")
                && button9.getText().equals("O")){
            if(str.equals("O"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button1.getText().equals("O") && button5.getText().equals("O")
                && button9.getText().equals("O")){
            if(str.equals("O"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button3.getText().equals("O") && button5.getText().equals("O")
                && button7.getText().equals("O")){
            if(str.equals("O"))
                WinDialog();
            else
                LoseDialog();
        }
        //draw
        else if(!button1.getText().equals(" ") && !button2.getText().equals(" ")
                && !button3.getText().equals(" ") && !button4.getText().equals(" ")
                && !button5.getText().equals(" ") && !button6.getText().equals(" ")
                && !button7.getText().equals(" ") && !button8.getText().equals(" ")
                && !button9.getText().equals(" ")) {
            DrawDialog();
        }
        //for 4x4 tic_tac_toe
        // X WON
        else if(button11.getText().equals("X") && button12.getText().equals("X")
                && button13.getText().equals("X") && button14.getText().equals("X")){
            if(str.equals("X"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button15.getText().equals("X") && button16.getText().equals("X")
                && button17.getText().equals("X") && button18.getText().equals("X")){
            if(str.equals("X"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button19.getText().equals("X") && button20.getText().equals("X")
                && button21.getText().equals("X") && button22.getText().equals("X")){
            if(str.equals("X"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button23.getText().equals("X") && button23.getText().equals("X")
                && button25.getText().equals("X") && button26.getText().equals("X")){
            if(str.equals("X"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button11.getText().equals("X") && button15.getText().equals("X")
                && button19.getText().equals("X") && button23.getText().equals("X")){
            if(str.equals("X"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button12.getText().equals("X") && button16.getText().equals("X")
                && button20.getText().equals("X") && button24.getText().equals("X")){
            if(str.equals("X"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button13.getText().equals("X") && button17.getText().equals("X")
                && button21.getText().equals("X") && button25.getText().equals("X")){
            if(str.equals("X"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button14.getText().equals("X") && button18.getText().equals("X")
                && button22.getText().equals("X") && button26.getText().equals("X")){
            if(str.equals("X"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button11.getText().equals("X") && button16.getText().equals("X")
                && button21.getText().equals("X") && button26.getText().equals("X")){
            if(str.equals("X"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button14.getText().equals("X") && button17.getText().equals("X")
                && button20.getText().equals("X") && button23.getText().equals("X")){
            if(str.equals("X"))
                WinDialog();
            else
                LoseDialog();
        }
        // O WON
        else if(button11.getText().equals("O") && button12.getText().equals("O")
                && button13.getText().equals("O") && button14.getText().equals("O")){
            if(str.equals("O"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button15.getText().equals("O") && button16.getText().equals("O")
                && button17.getText().equals("O") && button18.getText().equals("O")){
            if(str.equals("O"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button19.getText().equals("O") && button20.getText().equals("O")
                && button21.getText().equals("O") && button22.getText().equals("O")){
            if(str.equals("O"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button23.getText().equals("O") && button23.getText().equals("O")
                && button25.getText().equals("O") && button26.getText().equals("O")){
            if(str.equals("O"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button11.getText().equals("O") && button15.getText().equals("O")
                && button19.getText().equals("O") && button23.getText().equals("O")){
            if(str.equals("O"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button12.getText().equals("O") && button16.getText().equals("O")
                && button20.getText().equals("O") && button24.getText().equals("O")){
            if(str.equals("O"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button13.getText().equals("O") && button17.getText().equals("O")
                && button21.getText().equals("O") && button25.getText().equals("O")){
            if(str.equals("O"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button14.getText().equals("O") && button18.getText().equals("O")
                && button22.getText().equals("O") && button26.getText().equals("O")){
            if(str.equals("O"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button11.getText().equals("O") && button16.getText().equals("O")
                && button21.getText().equals("O") && button26.getText().equals("O")){
            if(str.equals("O"))
                WinDialog();
            else
                LoseDialog();
        }
        else if(button14.getText().equals("O") && button17.getText().equals("O")
                && button20.getText().equals("O") && button23.getText().equals("O")){
            if(str.equals("O"))
                WinDialog();
            else
                LoseDialog();
        }
        // DRAW
        else if(!button11.getText().equals(" ") && !button12.getText().equals(" ")
                && !button13.getText().equals(" ") && !button14.getText().equals(" ")
                && !button15.getText().equals(" ") && !button16.getText().equals(" ")
                && !button17.getText().equals(" ") && !button18.getText().equals(" ")
                && !button19.getText().equals(" ") && !button20.getText().equals(" ")
                && !button21.getText().equals(" ") && !button22.getText().equals(" ")
                && !button23.getText().equals(" ") && !button24.getText().equals(" ")
                && !button25.getText().equals(" ") && !button26.getText().equals(" ")) {
            DrawDialog();
        }

    }

    @FXML
    public void initialize() {
        try {
            str = reader.readLine();
            name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        thread.start();
    }

    @FXML
    private void Send_Msg_Method() {
        try {
            writer.write("Send Message\n");
            writer.write(name+": "+Send_Msg.getText()+"\n");
            writer.flush();
            Send_Msg.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void start_game() {
        try {
            writer.write("Start 3x3\n");
            writer.write("Discard Text\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void backToMain(ActionEvent e) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GameSelectionFrame.fxml")));
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setTitle("GameBox");
        window.setScene(new Scene(parent, 900, 650));
        window.show();
    }
    @FXML
    private void goBackTicTacToe(){
        try {
            writer.write("Back To Tic Tac Toe\n");
            writer.write("Discard Text\n");
            writer.flush();
            writer.write("restart\n");
            writer.write("Discard Text\n");
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void start_game_4x4() {
        try {
            writer.write("Start 4x4\n");
            writer.write("Discard Text\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void WinDialog() {
        Alert dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.setTitle("YOU WON!");
        dialog.setContentText("Congratulations! YOU WON");
        dialog.showAndWait();
    }
    private void LoseDialog() {
        Alert dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.setTitle("YOU LOSE!");
        dialog.setContentText("Better luck next time! YOU LOSE");
        dialog.showAndWait();
    }
    private void DrawDialog() {
        Alert dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.setTitle("DRAW!");
        dialog.setContentText("WELL PLAYED! MATCH DRAW!");
        dialog.showAndWait();
    }
}
