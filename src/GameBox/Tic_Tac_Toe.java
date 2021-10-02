package GameBox;import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class Tic_Tac_Toe {
    @FXML
    private Button button1,button2,button3,button4,
            button5,button6,button7,button8,button9;
    public BufferedReader reader;
    public BufferedWriter writer;
    private String str;
    public Tic_Tac_Toe() {
        Socket sc = null;
        try {
            sc = new Socket("127.0.0.1", 6601);
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

        if(event.getSource() == button1){
            System.out.println("1 clicked");
            writer.write("button1\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button2){
            System.out.println("2 clicked");
            writer.write("button2\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button3){
            System.out.println("3 clicked");
            writer.write("button3\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button4){
            System.out.println("4 clicked");
            writer.write("button4\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button5){
            System.out.println("5 clicked");
            writer.write("button5\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button6){
            System.out.println("6 clicked");
            writer.write("button6\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button7){
            System.out.println("7 clicked");
            writer.write("button7\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button8){
            System.out.println("8 clicked");
            writer.write("button8\n");
            writer.write(str+"\n");
            writer.flush();
        }
        if(event.getSource() == button9){
            System.out.println("9 clicked");
            writer.write("button9\n");
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
                    System.out.println(str1);
                    if (str1.equals("button1")) {
                        String str2 = reader.readLine();
                        System.out.println(str2);
                        Platform.runLater(() -> {
                            button1.setText(str2);
                            checkWinner();
                        });

                    }
                    if (str1.equals("button2")) {
                        String str2 = reader.readLine();
                        System.out.println(str2);
                        Platform.runLater(() -> {
                            button2.setText(str2);
                            checkWinner();
                        });

                    }
                    if (str1.equals("button3")) {
                        String str2 = reader.readLine();
                        System.out.println(str2);
                        Platform.runLater(() -> {
                            button3.setText(str2);
                            checkWinner();
                        });

                    }
                    if (str1.equals("button4")) {
                        String str2 = reader.readLine();
                        System.out.println(str2);
                        Platform.runLater(() -> {
                            button4.setText(str2);
                            checkWinner();
                        });

                    }
                    if (str1.equals("button5")) {
                        String str2 = reader.readLine();
                        System.out.println(str2);
                        Platform.runLater(() -> {
                            button5.setText(str2);
                            checkWinner();
                        });

                    }
                    if (str1.equals("button6")) {
                        String str2 = reader.readLine();
                        System.out.println(str2);
                        Platform.runLater(() -> {
                            button6.setText(str2);
                            checkWinner();
                        });

                    }
                    if (str1.equals("button7")) {
                        String str2 = reader.readLine();
                        System.out.println(str2);
                        Platform.runLater(() -> {
                            button7.setText(str2);
                            checkWinner();
                        });

                    }
                    if (str1.equals("button8")) {
                        String str2 = reader.readLine();
                        System.out.println(str2);
                        Platform.runLater(() -> {
                            button8.setText(str2);
                            checkWinner();
                        });

                    }
                    if (str1.equals("button9")) {
                        String str2 = reader.readLine();
                        System.out.println(str2);
                        Platform.runLater(() -> {
                            button9.setText(str2);
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
            System.out.println("X Won");
        }
        else if(button4.getText().equals("X") && button5.getText().equals("X")
                && button6.getText().equals("X")){
            System.out.println("X Won");
        }
        else if(button7.getText().equals("X") && button8.getText().equals("X")
                && button9.getText().equals("X")){
            System.out.println("X Won");
        }
        else if(button1.getText().equals("X") && button4.getText().equals("X")
                && button7.getText().equals("X")){
            System.out.println("X Won");
        }
        else if(button2.getText().equals("X") && button5.getText().equals("X")
                && button8.getText().equals("X")){
            System.out.println("X Won");
        }
        else if(button3.getText().equals("X") && button6.getText().equals("X")
                && button9.getText().equals("X")){
            System.out.println("X Won");
        }
        else if(button1.getText().equals("X") && button5.getText().equals("X")
                && button9.getText().equals("X")){
            System.out.println("X Won");
        }
        else if(button3.getText().equals("X") && button5.getText().equals("X")
                && button7.getText().equals("X")){
            System.out.println("X Won");
        }
        // O Won
        else if(button1.getText().equals("O") && button2.getText().equals("O")
                && button3.getText().equals("O")){
            System.out.println("O Won");
        }
        else if(button4.getText().equals("O") && button5.getText().equals("O")
                && button6.getText().equals("O")){
            System.out.println("O Won");
        }
        else if(button7.getText().equals("O") && button8.getText().equals("O")
                && button9.getText().equals("O")){
            System.out.println("O Won");
        }
        else if(button1.getText().equals("O") && button4.getText().equals("O")
                && button7.getText().equals("O")){
            System.out.println("O Won");
        }
        else if(button2.getText().equals("O") && button5.getText().equals("O")
                && button8.getText().equals("O")){
            System.out.println("O Won");
        }
        else if(button3.getText().equals("O") && button6.getText().equals("O")
                && button9.getText().equals("O")){
            System.out.println("O Won");
        }
        else if(button1.getText().equals("O") && button5.getText().equals("O")
                && button9.getText().equals("O")){
            System.out.println("O Won");
        }
        else if(button3.getText().equals("O") && button5.getText().equals("O")
                && button7.getText().equals("O")){
            System.out.println("O Won");
        }
        //draw
        else if(!button1.getText().equals(" ") && !button2.getText().equals(" ")
                && !button3.getText().equals(" ") && !button4.getText().equals(" ")
                && !button5.getText().equals(" ") && !button6.getText().equals(" ")
                && !button7.getText().equals(" ") && !button8.getText().equals(" ")
                && !button9.getText().equals(" ")) {
            System.out.println("Draw");
        }
    }

    @FXML
    public void initialize() {
        try {
            str = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        thread.start();
    }

}
