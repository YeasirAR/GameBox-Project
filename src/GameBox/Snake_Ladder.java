package GameBox;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import javax.swing.text.html.ImageView;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.Socket;
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
    Pane Player1,Player2, block_roll;

    public BufferedWriter writer;
    public BufferedReader reader;
    String str;


    public Snake_Ladder(){
        Socket sc = null;
        try{
            sc = new Socket("127.0.0.1",6603);
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
            str = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        th.start();
    }
    @FXML
    private void send_button(){

    }
    @FXML
    private void restart(){

    }
    @FXML
    private void exit(){

    }
    int prev_dice1 = 0;
    int prev_dice2 = 0;
    int i = 1;
    int dice_n;
    @FXML
    private void roll() throws IOException {
        if (i % 2 == 1) {
            turn.setText("Player 2 Turn");
            int[] dice_arr = {1, 2, 3, 4, 5, 6};
            Random random = new Random();
            int dice_roll = random.nextInt(6);
            dice_n = dice_arr[dice_roll];
            //  i++;
        } else {
            turn.setText("Player 1 Turn");
            int[] dice_arr = {1, 2, 3, 4, 5, 6};
            Random random = new Random();
            int dice_roll = random.nextInt(6);
            dice_n = dice_arr[dice_roll];
            //   i++;
        }
        dice.setText(String.valueOf(dice_n));
        writer.write("Dice\n");
        writer.write(dice_n + "\n");
        writer.flush();
    }
    Thread th = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                while (true) {
                    String str1 = reader.readLine();
                    if(str1.equals("Dice")) {
                        int n = Integer.parseInt(reader.readLine());
                        if (n + prev_dice1 == 1) {
                            if (str.equals("Player1")) {
                                Platform.runLater(() -> {
                                    label_1.setGraphic(guti1_label);
                                });
                                prev_dice1 = 1;
                            } else {
                                Platform.runLater(() -> {
                                    label_1.setGraphic(guti2_label);
                                });
                                prev_dice2 = 1;
                            }

                        } else if (n + prev_dice1 == 2) {

                            if (str.equals("Player1")) {
                                Platform.runLater(() -> {
                                    label_2.setGraphic(guti1_label);
                                });
                                prev_dice1 = 2;
                            } else {
                                Platform.runLater(() -> {
                                    label_2.setGraphic(guti2_label);
                                });
                                prev_dice2 = 2;
                            }
                        } else if (n + prev_dice1 == 3) {
                            if (str.equals("Player1")) {
                                Platform.runLater(() -> {
                                    label_3.setGraphic(guti1_label);
                                });
                                prev_dice1 = 3;
                            } else {
                                Platform.runLater(() -> {
                                    label_3.setGraphic(guti2_label);
                                });
                                prev_dice2 = 3;
                            }
                        } else if (n + prev_dice1 == 4) {
                            if (str.equals("Player1")) {
                                Platform.runLater(() -> {
                                    label_4.setGraphic(guti1_label);
                                });
                                prev_dice1 = 4;
                            } else {
                                Platform.runLater(() -> {
                                    label_4.setGraphic(guti2_label);
                                });
                                prev_dice2 = 4;
                            }
                        } else if (n + prev_dice1 == 5) {
                            if (str.equals("Player1")) {
                                Platform.runLater(() -> {
                                    label_5.setGraphic(guti1_label);
                                });
                                prev_dice1 = 5;
                            } else {
                                Platform.runLater(() -> {
                                    label_5.setGraphic(guti2_label);
                                });
                                prev_dice2 = 5;
                            }
                        } else if (n + prev_dice1 == 6) {
                            if (str.equals("Player1")) {
                                Platform.runLater(() -> {
                                    label_6.setGraphic(guti1_label);
                                });
                                prev_dice1 = 6;
                            } else {
                                Platform.runLater(() -> {
                                    label_6.setGraphic(guti2_label);
                                });
                                prev_dice2 = 6;
                            }
                        } else if (n + prev_dice1 == 7) {
                            if (str.equals("Player1")) {
                                Platform.runLater(() -> {
                                    label_7.setGraphic(guti1_label);
                                });
                                prev_dice1 = 7;
                            } else {
                                Platform.runLater(() -> {
                                    label_7.setGraphic(guti2_label);
                                });
                                prev_dice2 = 7;
                            }
                        } else if (n + prev_dice1 == 8) {
                            if (str.equals("Player1")) {
                                Platform.runLater(() -> {
                                    label_8.setGraphic(guti1_label);
                                });
                                prev_dice1 = 8;
                            } else {
                                Platform.runLater(() -> {
                                    label_8.setGraphic(guti2_label);
                                });
                                prev_dice2 = 8;
                            }
                        } else if (n + prev_dice1 == 9) {
                            if (str.equals("Player1")) {
                                Platform.runLater(() -> {
                                    label_9.setGraphic(guti1_label);
                                });
                                prev_dice1 = 9;
                            } else {
                                Platform.runLater(() -> {
                                    label_9.setGraphic(guti2_label);
                                });
                                prev_dice2 = 9;
                            }
                        } else if (n + prev_dice1 == 10) {
                            if (str.equals("Player1")) {
                                Platform.runLater(() -> {
                                    label_10.setGraphic(guti1_label);
                                });
                                prev_dice1 = 10;
                            } else {
                                Platform.runLater(() -> {
                                    label_10.setGraphic(guti2_label);
                                });
                                prev_dice2 = 10;
                            }
                        }
                    }
                }

            } catch (IOException io) {
                io.printStackTrace();
            }

        }
    });
}