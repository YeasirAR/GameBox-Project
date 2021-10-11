package GameBox;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.util.Objects;
import java.util.Random;

public class Snake_Ladder {

    @FXML
    private Label label_1,label_2,label_3,label_4,label_5,label_6,label_7,label_8,label_9,label_10,label_11,label_12,label_13,label_14,label_15,label_16,label_17,label_18,label_19,label_20;
    @FXML
    private Label label_21,label_22,label_23,label_24,label_25,label_26,label_27,label_28,label_29,label_30,label_31,label_32,label_33,label_34,label_35,label_36,label_37,label_38,label_39,label_40;
    @FXML
    private Label label_41,label_42,label_43,label_44,label_45,label_46,label_47,label_48,label_49,label_50,label_51,label_52,label_53,label_54,label_55,label_56,label_57,label_58,label_59,label_60;
    @FXML
    private Label label_61,label_62,label_63,label_64,label_65,label_66,label_67,label_68,label_69,label_70,label_71,label_72,label_73,label_74,label_75,label_76,label_77,label_78,label_79,label_80;
    @FXML
    private Label label_81,label_82,label_83,label_84,label_85,label_86,label_87,label_88,label_89,label_90,label_91,label_92,label_93,label_94,label_95,label_96,label_97,label_98,label_99,label_100;
    @FXML
    private TextArea Chat_Area;
    @FXML
    private TextField send_msg;
    @FXML
    private Label dice;
    @FXML
    Label guti1_label,guti2_label;
    @FXML
    Label turn;
    @FXML
    Label reset1,reset2;
    @FXML
    Pane Player1,Player2, block_roll;

    public BufferedWriter writer;
    public BufferedReader reader;
    String Player;
    String Player_name;
    int prev_dice1 = 0;
    int prev_dice2 = 0;
    int dice_n;
    int check = 1;

    public Snake_Ladder(){
        try{
            Socket sc = new Socket("127.0.0.1",6603);
            OutputStreamWriter ow = new OutputStreamWriter(sc.getOutputStream());
            writer = new BufferedWriter(ow);
            InputStreamReader isr = new InputStreamReader(sc.getInputStream());
            reader = new BufferedReader(isr);
        }catch (IOException io){
            io.printStackTrace();
        }
    }
    @FXML
    public void initialize() {
        try {
            Player = reader.readLine();
            Player_name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        th.start();
    }
    @FXML
    private void send_button(){
        try{
            writer.write("Send Message\n");
            writer.write(Player_name+ ": " +send_msg.getText()+ "\n");
            writer.flush();
            send_msg.clear();
        }catch (IOException io){
            io.printStackTrace();
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
    private void restart(){
        prev_dice1 = 0;
        prev_dice2 = 0;
        Platform.runLater(() -> reset1.setGraphic(guti1_label));
        Platform.runLater(() -> reset2.setGraphic(guti2_label));
        Player1.setVisible(false);
        Player2.setVisible(false);
        block_roll.setVisible(false);
    }
    @FXML
    public void exit(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
    @FXML
    private void roll() throws IOException {
        int[] dice_arr = {1, 2, 3, 4, 5, 6};
        Random random = new Random();
        int dice_roll = random.nextInt(6);
        dice_n = dice_arr[dice_roll];
        writer.write(Player+"\n");
        writer.write(dice_n + "\n");
        writer.flush();
    }

    Thread th = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                while (true) {
                    String str1 = reader.readLine();

                    if (str1.equals("Send Message")){
                        String str2 = reader.readLine();
                        Platform.runLater(() -> Chat_Area.appendText(str2+"\n"));
                    }
                    ////PLayer1
                    else if(str1.equals("Player1") && check == 1){
                        check = 0;

                        Platform.runLater(() -> turn.setText("Player 2 turn"));
                        int n = Integer.parseInt(reader.readLine());
                        Platform.runLater(() -> dice.setText(String.valueOf(n)));

                        if (n + prev_dice1 == 1){
                            Platform.runLater(() -> label_1.setGraphic(guti1_label));
                            prev_dice1 = 1;
                        }
                        else if (n + prev_dice1 == 2){
                            Platform.runLater(() -> label_2.setGraphic(guti1_label));
                            prev_dice1 = 2;
                        }
                        else if (n + prev_dice1 == 3){
                            Platform.runLater(() -> label_3.setGraphic(guti1_label));
                            prev_dice1 = 3;
                        }
                        else if (n + prev_dice1 == 4){
                            Platform.runLater(() -> label_4.setGraphic(guti1_label));
                            prev_dice1 = 4;
                        }
                        else if (n + prev_dice1 == 5){
                            Platform.runLater(() -> label_5.setGraphic(guti1_label));
                            prev_dice1 = 5;
                        }
                        else if (n + prev_dice1 == 6){
                            Platform.runLater(() -> label_6.setGraphic(guti1_label));
                            prev_dice1 = 6;
                        }
                        else if (n + prev_dice1 == 7){
                            Platform.runLater(() -> label_7.setGraphic(guti1_label));
                            prev_dice1 = 7;
                        }
                        else if (n + prev_dice1 == 8){
                            Platform.runLater(() -> label_8.setGraphic(guti1_label));
                            Thread.sleep(1000);
                            if(n+prev_dice1 == 8){
                                Platform.runLater(() -> label_35.setGraphic(guti1_label));
                                prev_dice1 = 35;
                            }
                            else {
                                prev_dice1 = 8;
                            }
                        }
                        else if (n + prev_dice1 == 9){
                            Platform.runLater(() -> label_9.setGraphic(guti1_label));
                            prev_dice1 = 9;
                        }
                        else if (n + prev_dice1 == 10){
                            Platform.runLater(() -> label_10.setGraphic(guti1_label));
                            prev_dice1 = 10;
                        }
                        else if (n + prev_dice1 == 11){
                            Platform.runLater(() -> label_11.setGraphic(guti1_label));
                            prev_dice1 = 11;
                        }
                        else if (n + prev_dice1 == 12){
                            Platform.runLater(() -> label_12.setGraphic(guti1_label));
                            prev_dice1 = 12;
                        }
                        else if (n + prev_dice1 == 13){
                            Platform.runLater(() -> label_13.setGraphic(guti1_label));
                            prev_dice1 = 13;
                        }
                        else if (n + prev_dice1 == 14){
                            Platform.runLater(() -> label_14.setGraphic(guti1_label));
                            prev_dice1 = 14;
                        }
                        else if (n + prev_dice1 == 15){
                            Platform.runLater(() -> label_15.setGraphic(guti1_label));
                            prev_dice1 = 15;
                        }
                        else if (n + prev_dice1 == 16){
                            Platform.runLater(() -> label_16.setGraphic(guti1_label));
                            prev_dice1 = 16;
                        }
                        else if (n + prev_dice1 == 17){
                            Platform.runLater(() -> label_17.setGraphic(guti1_label));
                            prev_dice1 = 17;
                        }
                        else if (n + prev_dice1 == 18){
                            Platform.runLater(() -> label_18.setGraphic(guti1_label));
                            prev_dice1 = 18;
                        }
                        else if (n + prev_dice1 == 19){
                            Platform.runLater(() -> label_19.setGraphic(guti1_label));
                            prev_dice1 = 19;
                        }
                        else if (n + prev_dice1 == 20){
                            Platform.runLater(() -> label_20.setGraphic(guti1_label));
                            prev_dice1 = 20;
                        }
                        else if (n + prev_dice1 == 21){
                            Platform.runLater(() -> label_21.setGraphic(guti1_label));
                            prev_dice1 = 21;
                        }
                        else if (n + prev_dice1 == 22){
                            Platform.runLater(() -> label_22.setGraphic(guti1_label));
                            prev_dice1 = 22;
                        }
                        else if (n + prev_dice1 == 23){
                            Platform.runLater(() -> label_23.setGraphic(guti1_label));
                            prev_dice1 = 23;
                        }
                        else if (n + prev_dice1 == 24){
                            Platform.runLater(() -> label_24.setGraphic(guti1_label));
                            prev_dice1 = 24;
                        }
                        else if (n + prev_dice1 == 25){
                            Platform.runLater(() -> label_25.setGraphic(guti1_label));
                            prev_dice1 = 25;
                        }
                        else if (n + prev_dice1 == 26){
                            Platform.runLater(() -> label_26.setGraphic(guti1_label));
                            prev_dice1 = 26;
                        }
                        else if (n + prev_dice1 == 27){
                            Platform.runLater(() -> label_27.setGraphic(guti1_label));
                            Thread.sleep(1000);
                            if(n+prev_dice1 == 27){
                                Platform.runLater(() -> label_77.setGraphic(guti1_label));
                                prev_dice1 = 77;
                            }
                            else {
                                prev_dice1 = 27;
                            }
                        }
                        else if (n + prev_dice1 == 28){
                            Platform.runLater(() -> label_28.setGraphic(guti1_label));
                            prev_dice1 = 28;
                        }
                        else if (n + prev_dice1 == 29){
                            Platform.runLater(() -> label_29.setGraphic(guti1_label));
                            prev_dice1 = 29;

                        }
                        else if (n + prev_dice1 == 30){
                            Platform.runLater(() -> label_30.setGraphic(guti1_label));
                            prev_dice1 = 30;
                        }
                        else if (n + prev_dice1 == 31){
                            Platform.runLater(() -> label_31.setGraphic(guti1_label));
                            Thread.sleep(1000);
                            if(n+prev_dice1 == 31){
                                Platform.runLater(() -> label_10.setGraphic(guti1_label));
                                prev_dice1 = 10;
                            }
                            else {
                                prev_dice1 = 31;
                            }
                        }
                        else if (n + prev_dice1 == 32){
                            Platform.runLater(() -> label_32.setGraphic(guti1_label));
                            prev_dice1 = 32;
                        }
                        else if (n + prev_dice1 == 33){
                            Platform.runLater(() -> label_33.setGraphic(guti1_label));
                            prev_dice1 = 33;
                        }
                        else if (n + prev_dice1 == 34){
                            Platform.runLater(() -> label_34.setGraphic(guti1_label));
                            prev_dice1 = 34;
                        }
                        else if (n + prev_dice1 == 35){
                            Platform.runLater(() -> label_35.setGraphic(guti1_label));
                            prev_dice1 = 35;
                        }
                        else if (n + prev_dice1 == 36){
                            Platform.runLater(() -> label_36.setGraphic(guti1_label));
                            prev_dice1 = 36;
                        }
                        else if (n + prev_dice1 == 37){
                            Platform.runLater(() -> label_37.setGraphic(guti1_label));
                            prev_dice1 = 37;
                        }
                        else if (n + prev_dice1 == 38){
                            Platform.runLater(() -> label_38.setGraphic(guti1_label));
                            prev_dice1 = 38;
                        }
                        else if (n + prev_dice1 == 39){
                            Platform.runLater(() -> label_39.setGraphic(guti1_label));
                            Thread.sleep(1000);
                            if(n+prev_dice1 == 39){
                                Platform.runLater(() -> label_60.setGraphic(guti1_label));
                                prev_dice1 = 60;
                            }
                            else {
                                prev_dice1 = 39;
                            }
                        }
                        else if (n + prev_dice1 == 40){
                            Platform.runLater(() -> label_40.setGraphic(guti1_label));
                            prev_dice1 = 40;
                        }
                        else if (n + prev_dice1 == 41){
                            Platform.runLater(() -> label_41.setGraphic(guti1_label));
                            prev_dice1 = 41;
                        }
                        else if (n + prev_dice1 == 42){
                            Platform.runLater(() -> label_42.setGraphic(guti1_label));
                            prev_dice1 = 42;
                        }
                        else if (n + prev_dice1 == 43){
                            Platform.runLater(() -> label_43.setGraphic(guti1_label));
                            prev_dice1 = 43;
                        }
                        else if (n + prev_dice1 == 44){
                            Platform.runLater(() -> label_44.setGraphic(guti1_label));
                            prev_dice1 = 44;
                        }
                        else if (n + prev_dice1 == 45){
                            Platform.runLater(() -> label_45.setGraphic(guti1_label));
                            prev_dice1 = 45;
                        }
                        else if (n + prev_dice1 == 46){
                            Platform.runLater(() -> label_46.setGraphic(guti1_label));
                            prev_dice1 = 46;
                        }
                        else if (n + prev_dice1 == 47){
                            Platform.runLater(() -> label_47.setGraphic(guti1_label));
                            prev_dice1 = 47;
                        }
                        else if (n + prev_dice1 == 48){
                            Platform.runLater(() -> label_48.setGraphic(guti1_label));
                            prev_dice1 = 48;
                        }
                        else if (n + prev_dice1 == 49){
                            Platform.runLater(() -> label_49.setGraphic(guti1_label));
                            prev_dice1 = 49;
                        }
                        else if (n + prev_dice1 == 50){
                            Platform.runLater(() -> label_50.setGraphic(guti1_label));
                            prev_dice1 = 50;
                        }
                        else if (n + prev_dice1 == 51){
                            Platform.runLater(() -> label_51.setGraphic(guti1_label));
                            prev_dice1 = 51;
                        }
                        else if (n + prev_dice1 == 52){
                            Platform.runLater(() -> label_52.setGraphic(guti1_label));
                            prev_dice1 = 52;
                        }
                        else if (n + prev_dice1 == 53){
                            Platform.runLater(() -> label_53.setGraphic(guti1_label));
                            Thread.sleep(1000);
                            if(n+prev_dice1 == 53){
                                Platform.runLater(() -> label_81.setGraphic(guti1_label));
                                prev_dice1 = 81;
                            }
                            else {
                                prev_dice1 = 53;
                            }
                        }
                        else if (n + prev_dice1 == 54){
                            Platform.runLater(() -> label_54.setGraphic(guti1_label));
                            prev_dice1 = 54;
                        }
                        else if (n + prev_dice1 == 55){
                            Platform.runLater(() -> label_55.setGraphic(guti1_label));
                            prev_dice1 = 55;
                        }
                        else if (n + prev_dice1 == 56){
                            Platform.runLater(() -> label_56.setGraphic(guti1_label));
                            prev_dice1 = 56;
                        }
                        else if (n + prev_dice1 == 57){
                            Platform.runLater(() -> label_57.setGraphic(guti1_label));
                            prev_dice1 = 57;
                        }
                        else if (n + prev_dice1 == 58){
                            Platform.runLater(() -> label_58.setGraphic(guti1_label));
                            Thread.sleep(1000);
                            if(n+prev_dice1 == 58){
                                Platform.runLater(() -> label_28.setGraphic(guti1_label));
                                prev_dice1 = 28;
                            }
                            else {
                                prev_dice1 = 58;
                            }
                        }
                        else if (n + prev_dice1 == 59){
                            Platform.runLater(() -> label_59.setGraphic(guti1_label));
                            prev_dice1 = 59;
                        }
                        else if (n + prev_dice1 == 60){
                            Platform.runLater(() -> label_60.setGraphic(guti1_label));
                            prev_dice1 = 60;
                        }
                        else if (n + prev_dice1 == 61){
                            Platform.runLater(() -> label_61.setGraphic(guti1_label));
                            prev_dice1 = 61;
                        }
                        else if (n + prev_dice1 == 62){
                            Platform.runLater(() -> label_62.setGraphic(guti1_label));
                            prev_dice1 = 62;
                        }
                        else if (n + prev_dice1 == 63){
                            Platform.runLater(() -> label_63.setGraphic(guti1_label));
                            prev_dice1 = 63;
                        }
                        else if (n + prev_dice1 == 64){
                            Platform.runLater(() -> label_64.setGraphic(guti1_label));
                            prev_dice1 = 64;
                        }
                        else if (n + prev_dice1 == 65){
                            Platform.runLater(() -> label_65.setGraphic(guti1_label));
                            Thread.sleep(1000);
                            if(n+prev_dice1 == 65){
                                Platform.runLater(() -> label_60.setGraphic(guti1_label));
                                prev_dice1 = 23;
                            }
                            else {
                                prev_dice1 = 65;
                            }
                        }
                        else if (n + prev_dice1 == 66){
                            Platform.runLater(() -> label_66.setGraphic(guti1_label));
                            prev_dice1 = 66;
                        }
                        else if (n + prev_dice1 == 67){
                            Platform.runLater(() -> label_67.setGraphic(guti1_label));
                            prev_dice1 = 67;
                        }
                        else if (n + prev_dice1 == 68){
                            Platform.runLater(() -> label_68.setGraphic(guti1_label));
                            prev_dice1 = 68;
                        }
                        else if (n + prev_dice1 == 69){
                            Platform.runLater(() -> label_69.setGraphic(guti1_label));
                            prev_dice1 = 69;
                        }
                        else if (n + prev_dice1 == 70){
                            Platform.runLater(() -> label_70.setGraphic(guti1_label));
                            prev_dice1 = 70;
                        }
                        else if (n + prev_dice1 == 71){
                            Platform.runLater(() -> label_71.setGraphic(guti1_label));
                            prev_dice1 = 71;
                        }
                        else if (n + prev_dice1 == 72){
                            Platform.runLater(() -> label_72.setGraphic(guti1_label));
                            prev_dice1 = 72;
                        }
                        else if (n + prev_dice1 == 73){
                            Platform.runLater(() -> label_73.setGraphic(guti1_label));
                            prev_dice1 = 73;
                        }
                        else if (n + prev_dice1 == 74){
                            Platform.runLater(() -> label_74.setGraphic(guti1_label));
                            prev_dice1 = 74;
                        }
                        else if (n + prev_dice1 == 75){
                            Platform.runLater(() -> label_75.setGraphic(guti1_label));
                            prev_dice1 = 75;
                        }
                        else if (n + prev_dice1 == 76){
                            Platform.runLater(() -> label_76.setGraphic(guti1_label));
                            prev_dice1 = 76;
                        }
                        else if (n + prev_dice1 == 77){
                            Platform.runLater(() -> label_77.setGraphic(guti1_label));
                            prev_dice1 = 77;
                        }
                        else if (n + prev_dice1 == 78){
                            Platform.runLater(() -> label_78.setGraphic(guti1_label));
                            prev_dice1 = 78;
                        }
                        else if (n + prev_dice1 == 79){
                            Platform.runLater(() -> label_79.setGraphic(guti1_label));
                            prev_dice1 = 79;
                        }
                        else if (n + prev_dice1 == 80){
                            Platform.runLater(() -> label_80.setGraphic(guti1_label));
                            Thread.sleep(1000);
                            if(n+prev_dice1 == 80){
                                Platform.runLater(() -> label_38.setGraphic(guti1_label));
                                prev_dice1 = 38;
                            }
                            else {
                                prev_dice1 = 80;
                            }
                        }
                        else if (n + prev_dice1 == 81){
                            Platform.runLater(() -> label_81.setGraphic(guti1_label));
                            prev_dice1 = 81;
                        }
                        else if (n + prev_dice1 == 82){
                            Platform.runLater(() -> label_82.setGraphic(guti1_label));
                            prev_dice1 = 82;
                        }
                        else if (n + prev_dice1 == 83){
                            Platform.runLater(() -> label_83.setGraphic(guti1_label));
                            prev_dice1 = 83;
                        }
                        else if (n + prev_dice1 == 84){
                            Platform.runLater(() -> label_84.setGraphic(guti1_label));
                            prev_dice1 = 84;
                        }
                        else if (n + prev_dice1 == 85){
                            Platform.runLater(() -> label_85.setGraphic(guti1_label));
                            Thread.sleep(1000);
                            if(n+prev_dice1 == 85){
                                Platform.runLater(() -> label_51.setGraphic(guti1_label));
                                prev_dice1 = 51;
                            }
                            else {
                                prev_dice1 = 85;
                            }
                        }
                        else if (n + prev_dice1 == 86){
                            Platform.runLater(() -> label_86.setGraphic(guti1_label));
                            prev_dice1 = 86;
                        }
                        else if (n + prev_dice1 == 87){
                            Platform.runLater(() -> label_87.setGraphic(guti1_label));
                            prev_dice1 = 87;
                        }
                        else if (n + prev_dice1 == 88){
                            Platform.runLater(() -> label_88.setGraphic(guti1_label));
                            prev_dice1 = 88;
                        }
                        else if (n + prev_dice1 == 89){
                            Platform.runLater(() -> label_89.setGraphic(guti1_label));
                            prev_dice1 = 89;
                        }
                        else if (n + prev_dice1 == 90){
                            Platform.runLater(() -> label_90.setGraphic(guti1_label));
                            prev_dice1 = 90;
                        }
                        else if (n + prev_dice1 == 91){
                            Platform.runLater(() -> label_91.setGraphic(guti1_label));
                            prev_dice1 = 91;
                        }
                        else if (n + prev_dice1 == 92){
                            Platform.runLater(() -> label_92.setGraphic(guti1_label));
                            prev_dice1 = 92;
                        }
                        else if (n + prev_dice1 == 93){
                            Platform.runLater(() -> label_93.setGraphic(guti1_label));
                            prev_dice1 = 93;
                        }
                        else if (n + prev_dice1 == 94){
                            Platform.runLater(() -> label_94.setGraphic(guti1_label));
                            prev_dice1 = 94;
                        }
                        else if (n + prev_dice1 == 95){
                            Platform.runLater(() -> label_95.setGraphic(guti1_label));
                            prev_dice1 = 95;
                        }
                        else if (n + prev_dice1 == 96){
                            Platform.runLater(() -> label_96.setGraphic(guti1_label));
                            prev_dice1 = 96;
                        }
                        else if (n + prev_dice1 == 97){
                            Platform.runLater(() -> label_97.setGraphic(guti1_label));
                            Thread.sleep(1000);
                            if(n+prev_dice1 == 97){
                                Platform.runLater(() -> label_15.setGraphic(guti1_label));
                                prev_dice1 = 15;
                            }
                            else {
                                prev_dice1 = 97;
                            }
                        }
                        else if (n + prev_dice1 == 98){
                            Platform.runLater(() -> label_98.setGraphic(guti1_label));
                            prev_dice1 = 98;
                        }
                        else if (n + prev_dice1 == 99){
                            Platform.runLater(() -> label_99.setGraphic(guti1_label));
                            prev_dice1 = 99;
                        }
                        else if (n + prev_dice1 == 100){
                            Platform.runLater(() -> label_100.setGraphic(guti1_label));
                            prev_dice1 = 100;
                            turn.setText("Game Over");
                            Player1.setVisible(true);
                            block_roll.setVisible(true);
                        }
                    }
                    ///Player2
                    else if(str1.equals("Player2") && check == 0){
                        check = 1;

                        Platform.runLater(() -> turn.setText("Player 1 turn"));
                        int n = Integer.parseInt(reader.readLine());
                        Platform.runLater(() -> dice.setText(String.valueOf(n)));

                        if (n + prev_dice2 == 1) {
                            Platform.runLater(() -> label_1.setGraphic(guti2_label));
                            prev_dice2 = 1;
                        }
                        else if (n + prev_dice2 == 2) {
                            Platform.runLater(() -> label_2.setGraphic(guti2_label));
                            prev_dice2 = 2;
                        }
                        else if (n + prev_dice2 == 3) {
                            Platform.runLater(() -> label_3.setGraphic(guti2_label));
                            prev_dice2 = 3;
                        }
                        else if (n + prev_dice2 == 4) {
                            Platform.runLater(() -> label_4.setGraphic(guti2_label));
                            prev_dice2 = 4;
                        }
                        else if (n + prev_dice2 == 5) {
                            Platform.runLater(() -> label_5.setGraphic(guti2_label));
                            prev_dice2 = 5;
                        }
                        else if (n + prev_dice2 == 6) {
                            Platform.runLater(() -> label_6.setGraphic(guti2_label));
                            prev_dice2 = 6;
                        }
                        else if (n + prev_dice2 == 7) {
                            Platform.runLater(() -> label_7.setGraphic(guti2_label));
                            prev_dice2 = 7;
                        }
                        else if (n + prev_dice2 == 8) {
                            Platform.runLater(() -> label_8.setGraphic(guti2_label));
                            Thread.sleep(1000);
                            if (n + prev_dice2 == 8) {
                                Platform.runLater(() -> label_35.setGraphic(guti2_label));
                                prev_dice2 = 35;
                            } else {
                                prev_dice2 = 8;
                            }
                        }
                        else if (n + prev_dice2 == 9) {
                            Platform.runLater(() -> label_9.setGraphic(guti2_label));
                            prev_dice2 = 9;
                        }
                        else if (n + prev_dice2 == 10) {
                            Platform.runLater(() -> label_10.setGraphic(guti2_label));
                            prev_dice2 = 10;
                        }
                        else if (n + prev_dice2 == 11) {
                            Platform.runLater(() -> label_11.setGraphic(guti2_label));
                            prev_dice2 = 11;
                        }
                        else if (n + prev_dice2 == 12) {
                            Platform.runLater(() -> label_12.setGraphic(guti2_label));
                            prev_dice2 = 12;
                        }
                        else if (n + prev_dice2 == 13) {
                            Platform.runLater(() -> label_13.setGraphic(guti2_label));
                            prev_dice2 = 13;
                        }
                        else if (n + prev_dice2 == 14) {
                            Platform.runLater(() -> label_14.setGraphic(guti2_label));
                            prev_dice2 = 14;
                        }
                        else if (n + prev_dice2 == 15) {
                            Platform.runLater(() -> label_15.setGraphic(guti2_label));
                            prev_dice2 = 15;
                        }
                        else if (n + prev_dice2 == 16) {
                            Platform.runLater(() -> label_16.setGraphic(guti2_label));
                            prev_dice2 = 16;
                        }
                        else if (n + prev_dice2 == 17) {
                            Platform.runLater(() -> label_17.setGraphic(guti2_label));
                            prev_dice2 = 17;
                        }
                        else if (n + prev_dice2 == 18) {
                            Platform.runLater(() -> label_18.setGraphic(guti2_label));
                            prev_dice2 = 18;
                        }
                        else if (n + prev_dice2 == 19) {
                            Platform.runLater(() -> label_19.setGraphic(guti2_label));
                            prev_dice2 = 19;
                        }
                        else if (n + prev_dice2 == 20) {
                            Platform.runLater(() -> label_20.setGraphic(guti2_label));
                            prev_dice2 = 20;
                        }
                        else if (n + prev_dice2 == 21) {
                            Platform.runLater(() -> label_21.setGraphic(guti2_label));
                            prev_dice2 = 21;
                        }
                        else if (n + prev_dice2 == 22) {
                            Platform.runLater(() -> label_22.setGraphic(guti2_label));
                            prev_dice2 = 22;
                        }
                        else if (n + prev_dice2 == 23) {
                            Platform.runLater(() -> label_23.setGraphic(guti2_label));
                            prev_dice2 = 23;
                        }
                        else if (n + prev_dice2 == 24) {
                            Platform.runLater(() -> label_24.setGraphic(guti2_label));
                            prev_dice2 = 24;
                        }
                        else if (n + prev_dice2 == 25) {
                            Platform.runLater(() -> label_25.setGraphic(guti2_label));
                            prev_dice2 = 25;
                        }
                        else if (n + prev_dice2 == 26) {
                            Platform.runLater(() -> label_26.setGraphic(guti2_label));
                            prev_dice2 = 26;
                        }
                        else if (n + prev_dice2 == 27) {
                            Platform.runLater(() -> label_27.setGraphic(guti2_label));
                            Thread.sleep(1000);
                            if (n + prev_dice2 == 27) {
                                Platform.runLater(() -> label_77.setGraphic(guti2_label));
                                prev_dice2 = 77;
                            } else {
                                prev_dice2 = 27;
                            }
                        }
                        else if (n + prev_dice2 == 28) {
                            Platform.runLater(() -> label_28.setGraphic(guti2_label));
                            prev_dice2 = 28;
                        }
                        else if (n + prev_dice2 == 29) {
                            Platform.runLater(() -> label_29.setGraphic(guti2_label));
                            prev_dice2 = 29;
                        }
                        else if (n + prev_dice2 == 30) {
                            Platform.runLater(() -> label_30.setGraphic(guti2_label));
                            prev_dice2 = 30;
                        }
                        else if (n + prev_dice2 == 31) {
                            Platform.runLater(() -> label_31.setGraphic(guti2_label));
                            Thread.sleep(1000);
                            if (n + prev_dice2 == 31) {
                                Platform.runLater(() -> label_10.setGraphic(guti2_label));
                                prev_dice2 = 10;
                            } else {
                                prev_dice2 = 31;
                            }
                        }
                        else if (n + prev_dice2 == 32) {
                            Platform.runLater(() -> label_32.setGraphic(guti2_label));
                            prev_dice2 = 32;
                        }
                        else if (n + prev_dice2 == 33) {
                            Platform.runLater(() -> label_33.setGraphic(guti2_label));
                            prev_dice2 = 33;
                        }
                        else if (n + prev_dice2 == 34) {
                            Platform.runLater(() -> label_34.setGraphic(guti2_label));
                            prev_dice2 = 34;
                        }
                        else if (n + prev_dice2 == 35) {
                            Platform.runLater(() -> label_35.setGraphic(guti2_label));
                            prev_dice2 = 35;
                        }
                        else if (n + prev_dice2 == 36) {
                            Platform.runLater(() -> label_36.setGraphic(guti2_label));
                            prev_dice2 = 36;
                        }
                        else if (n + prev_dice2 == 37) {
                            Platform.runLater(() -> label_37.setGraphic(guti2_label));
                            prev_dice2 = 37;
                        }
                        else if (n + prev_dice2 == 38) {
                            Platform.runLater(() -> label_38.setGraphic(guti2_label));
                            prev_dice2 = 38;
                        }
                        else if (n + prev_dice2 == 39) {
                            Platform.runLater(() -> label_39.setGraphic(guti2_label));
                            Thread.sleep(1000);
                            if (n + prev_dice2 == 39) {
                                Platform.runLater(() -> label_60.setGraphic(guti2_label));
                                prev_dice2 = 60;
                            } else {
                                prev_dice2 = 39;
                            }
                        }
                        else if (n + prev_dice2 == 40) {
                            Platform.runLater(() -> label_40.setGraphic(guti2_label));
                            prev_dice2 = 40;
                        }
                        else if (n + prev_dice2 == 41) {
                            Platform.runLater(() -> label_41.setGraphic(guti2_label));
                            prev_dice2 = 41;
                        }
                        else if (n + prev_dice2 == 42) {
                            Platform.runLater(() -> label_42.setGraphic(guti2_label));
                            prev_dice2 = 42;
                        }
                        else if (n + prev_dice2 == 43) {
                            Platform.runLater(() -> label_43.setGraphic(guti2_label));
                            prev_dice2 = 43;
                        }
                        else if (n + prev_dice2 == 44) {
                            Platform.runLater(() -> label_44.setGraphic(guti2_label));
                            prev_dice2 = 44;
                        }
                        else if (n + prev_dice2 == 45) {
                            Platform.runLater(() -> label_45.setGraphic(guti2_label));
                            prev_dice2 = 45;
                        }
                        else if (n + prev_dice2 == 46) {
                            Platform.runLater(() -> label_46.setGraphic(guti2_label));
                            prev_dice2 = 46;
                        }
                        else if (n + prev_dice2 == 47) {
                            Platform.runLater(() -> label_47.setGraphic(guti2_label));
                            prev_dice2 = 47;
                        }
                        else if (n + prev_dice2 == 48) {
                            Platform.runLater(() -> label_48.setGraphic(guti2_label));
                            prev_dice2 = 48;
                        }
                        else if (n + prev_dice2 == 49) {
                            Platform.runLater(() -> label_49.setGraphic(guti2_label));
                            prev_dice2 = 49;
                        }
                        else if (n + prev_dice2 == 50) {
                            Platform.runLater(() -> label_50.setGraphic(guti2_label));
                            prev_dice2 = 50;
                        }
                        else if (n + prev_dice2 == 51) {
                            Platform.runLater(() -> label_51.setGraphic(guti2_label));
                            prev_dice2 = 51;
                        }
                        else if (n + prev_dice2 == 52) {
                            Platform.runLater(() -> label_52.setGraphic(guti2_label));
                            prev_dice2 = 52;
                        }
                        else if (n + prev_dice2 == 53) {
                            Platform.runLater(() -> label_53.setGraphic(guti2_label));
                            Thread.sleep(1000);
                            if (n + prev_dice2 == 53) {
                                Platform.runLater(() -> label_81.setGraphic(guti2_label));
                                prev_dice2 = 81;
                            } else {
                                prev_dice2 = 53;
                            }
                        }
                        else if (n + prev_dice2 == 54) {
                            Platform.runLater(() -> label_54.setGraphic(guti2_label));
                            prev_dice2 = 54;
                        }
                        else if (n + prev_dice2 == 55) {
                            Platform.runLater(() -> label_55.setGraphic(guti2_label));
                            prev_dice2 = 55;
                        }
                        else if (n + prev_dice2 == 56) {
                            Platform.runLater(() -> label_56.setGraphic(guti2_label));
                            prev_dice2 = 56;
                        }
                        else if (n + prev_dice2 == 57) {
                            Platform.runLater(() -> label_57.setGraphic(guti2_label));
                            prev_dice2 = 57;
                        }
                        else if (n + prev_dice2 == 58) {
                            Platform.runLater(() -> label_58.setGraphic(guti2_label));
                            Thread.sleep(1000);
                            if (n + prev_dice2 == 58) {
                                Platform.runLater(() -> label_28.setGraphic(guti2_label));
                                prev_dice2 = 28;
                            } else {
                                prev_dice2 = 58;
                            }
                        }
                        else if (n + prev_dice2 == 59) {
                            Platform.runLater(() -> label_59.setGraphic(guti2_label));
                            prev_dice2 = 59;
                        }
                        else if (n + prev_dice2 == 60) {
                            Platform.runLater(() -> label_60.setGraphic(guti2_label));
                            prev_dice2 = 60;
                        }
                        else if (n + prev_dice2 == 61) {
                            Platform.runLater(() -> label_61.setGraphic(guti2_label));
                            prev_dice2 = 61;
                        }
                        else if (n + prev_dice2 == 62) {
                            Platform.runLater(() -> label_62.setGraphic(guti2_label));
                            prev_dice2 = 62;
                        }
                        else if (n + prev_dice2 == 63) {
                            Platform.runLater(() -> label_63.setGraphic(guti2_label));
                            prev_dice2 = 63;
                        }
                        else if (n + prev_dice2 == 64) {
                            Platform.runLater(() -> label_64.setGraphic(guti2_label));
                            prev_dice2 = 64;
                        }
                        else if (n + prev_dice2 == 65) {
                            Platform.runLater(() -> label_65.setGraphic(guti2_label));
                            Thread.sleep(1000);
                            if (n + prev_dice2 == 65) {
                                Platform.runLater(() -> label_23.setGraphic(guti2_label));
                                prev_dice2 = 23;
                            } else {
                                prev_dice2 = 65;
                            }
                        }
                        else if (n + prev_dice2 == 66) {
                            Platform.runLater(() -> label_66.setGraphic(guti2_label));
                            prev_dice2 = 66;
                        }
                        else if (n + prev_dice2 == 67) {
                            Platform.runLater(() -> label_67.setGraphic(guti2_label));
                            prev_dice2 = 67;
                        }
                        else if (n + prev_dice2 == 68) {
                            Platform.runLater(() -> label_68.setGraphic(guti2_label));
                            prev_dice2 = 68;
                        }
                        else if (n + prev_dice2 == 69) {
                            Platform.runLater(() -> label_69.setGraphic(guti2_label));
                            prev_dice2 = 69;
                        }
                        else if (n + prev_dice2 == 70) {
                            Platform.runLater(() -> label_70.setGraphic(guti2_label));
                            prev_dice2 = 70;
                        }
                        else if (n + prev_dice2 == 71) {
                            Platform.runLater(() -> label_71.setGraphic(guti2_label));
                            prev_dice2 = 71;
                        }
                        else if (n + prev_dice2 == 72) {
                            Platform.runLater(() -> label_72.setGraphic(guti2_label));
                            prev_dice2 = 72;
                        }
                        else if (n + prev_dice2 == 73) {
                            Platform.runLater(() -> label_73.setGraphic(guti2_label));
                            prev_dice2 = 73;
                        }
                        else if (n + prev_dice2 == 74) {
                            Platform.runLater(() -> label_74.setGraphic(guti2_label));
                            prev_dice2 = 74;
                        }
                        else if (n + prev_dice2 == 75) {
                            Platform.runLater(() -> label_75.setGraphic(guti2_label));
                            prev_dice2 = 75;
                        }
                        else if (n + prev_dice2 == 76) {
                            Platform.runLater(() -> label_76.setGraphic(guti2_label));
                            prev_dice2 = 76;
                        }
                        else if (n + prev_dice2 == 77) {
                            Platform.runLater(() -> label_77.setGraphic(guti2_label));
                            prev_dice2 = 77;
                        }
                        else if (n + prev_dice2 == 78) {
                            Platform.runLater(() -> label_78.setGraphic(guti2_label));
                            prev_dice2 = 78;
                        }
                        else if (n + prev_dice2 == 79) {
                            Platform.runLater(() -> label_79.setGraphic(guti2_label));
                            prev_dice2 = 79;
                        }
                        else if (n + prev_dice2 == 80) {
                            Platform.runLater(() -> label_80.setGraphic(guti2_label));
                            Thread.sleep(1000);
                            if (n + prev_dice2 == 80) {
                                Platform.runLater(() -> label_38.setGraphic(guti2_label));
                                prev_dice2 = 38;
                            } else {
                                prev_dice2 = 80;
                            }
                        }
                        else if (n + prev_dice2 == 81) {
                            Platform.runLater(() -> label_81.setGraphic(guti2_label));
                            prev_dice2 = 81;
                        }
                        else if (n + prev_dice2 == 82) {
                            Platform.runLater(() -> label_82.setGraphic(guti2_label));
                            prev_dice2 = 82;
                        }
                        else if (n + prev_dice2 == 83) {
                            Platform.runLater(() -> label_83.setGraphic(guti2_label));
                            prev_dice2 = 83;
                        }
                        else if (n + prev_dice2 == 84) {
                            Platform.runLater(() -> label_84.setGraphic(guti2_label));
                            prev_dice2 = 84;
                        }
                        else if (n + prev_dice2 == 85) {
                            Platform.runLater(() -> label_85.setGraphic(guti2_label));
                            Thread.sleep(1000);
                            if (n + prev_dice2 == 85) {
                                Platform.runLater(() -> label_51.setGraphic(guti2_label));
                                prev_dice2 = 51;
                            } else {
                                prev_dice2 = 85;
                            }
                        }
                        else if (n + prev_dice2 == 86) {
                            Platform.runLater(() -> label_86.setGraphic(guti2_label));
                            prev_dice2 = 86;
                        }
                        else if (n + prev_dice2 == 87) {
                            Platform.runLater(() -> label_87.setGraphic(guti2_label));
                            prev_dice2 = 87;
                        }
                        else if (n + prev_dice2 == 88) {
                            Platform.runLater(() -> label_88.setGraphic(guti2_label));
                            prev_dice2 = 88;
                        }
                        else if (n + prev_dice2 == 89) {
                            Platform.runLater(() -> label_89.setGraphic(guti2_label));
                            prev_dice2 = 89;
                        }
                        else if (n + prev_dice2 == 90) {
                            Platform.runLater(() -> label_90.setGraphic(guti2_label));
                            prev_dice2 = 90;
                        }
                        else if (n + prev_dice2 == 91) {
                            Platform.runLater(() -> label_91.setGraphic(guti2_label));
                            prev_dice2 = 91;
                        }
                        else if (n + prev_dice2 == 92) {
                            Platform.runLater(() -> label_92.setGraphic(guti2_label));
                            prev_dice2 = 92;
                        }
                        else if (n + prev_dice2 == 93) {
                            Platform.runLater(() -> label_93.setGraphic(guti2_label));
                            prev_dice2 = 93;
                        }
                        else if (n + prev_dice2 == 94) {
                            Platform.runLater(() -> label_94.setGraphic(guti2_label));
                            prev_dice2 = 94;
                        }
                        else if (n + prev_dice2 == 95) {
                            Platform.runLater(() -> label_95.setGraphic(guti2_label));
                            prev_dice2 = 95;
                        }
                        else if (n + prev_dice2 == 96) {
                            Platform.runLater(() -> label_96.setGraphic(guti2_label));
                            prev_dice2 = 96;
                        }
                        else if (n + prev_dice2 == 97) {
                            Platform.runLater(() -> label_97.setGraphic(guti2_label));
                            Thread.sleep(1000);
                            if (n + prev_dice2 == 97) {
                                Platform.runLater(() -> label_15.setGraphic(guti2_label));
                                prev_dice2 = 15;
                            } else {
                                prev_dice2 = 97;
                            }
                        }
                        else if (n + prev_dice2 == 98) {
                            Platform.runLater(() -> label_98.setGraphic(guti2_label));
                            prev_dice2 = 98;
                        }
                        else if (n + prev_dice2 == 99) {
                            Platform.runLater(() -> label_99.setGraphic(guti2_label));
                            prev_dice2 = 99;
                        }
                        else if (n + prev_dice2 == 100) {
                            Platform.runLater(() -> label_100.setGraphic(guti2_label));
                            prev_dice2 = 100;
                            turn.setText("Game Over");
                            Player2.setVisible(true);
                            block_roll.setVisible(true);
                        }
                    }
                }
            } catch (IOException | InterruptedException io) {
                io.printStackTrace();
            }
        }
    });
}