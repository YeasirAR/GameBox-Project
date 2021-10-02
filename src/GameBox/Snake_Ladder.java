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
    Pane Player1,Player2;

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
            dice.setText(String.valueOf(dice_n));
            //  i++;
        } else {
            turn.setText("Player 1 Turn");
            int[] dice_arr = {1, 2, 3, 4, 5, 6};
            Random random = new Random();
            int dice_roll = random.nextInt(6);
            dice_n = dice_arr[dice_roll];
            dice.setText(String.valueOf(dice_n));
            //   i++;
        }
        writer.write("Dice\n");
        writer.write(dice_n + "\n");
        writer.flush();
    }
//        int [] dice_arr = {1,2,3,4,5,6};
//        Random random = new Random();
//        int dice_roll = random.nextInt(6);
//        int dice_n = dice_arr[dice_roll];
//        dice.setText(String.valueOf(dice_n));

//        if (dice_n + prev_dice1 == 1) {
//            if(str.equals("Player1")){
//                label_1.setGraphic(guti1_label);
//                prev_dice1 = 1;
//            }
//            else{
//                label_1.setGraphic(guti2_label);
//                prev_dice2 = 1;
//            }
//
//        } else if (dice_n + prev_dice1 == 2) {
//            label_2.setGraphic(guti1_label);
//            prev_dice1 = 2;
//        } else if (dice_n + prev_dice1 == 3) {
//            label_3.setGraphic(guti1_label);
//            prev_dice1 = 3;
//        } else if (dice_n + prev_dice1 == 4) {
//            label_4.setGraphic(guti1_label);
//            prev_dice1 = 4;
//        } else if (dice_n + prev_dice1 == 5) {
//            label_5.setGraphic(guti1_label);
//            prev_dice1 = 5;
//        } else if (dice_n + prev_dice1 == 6) {
//            label_6.setGraphic(guti1_label);
//            prev_dice1 = 6;
//        } else if (dice_n + prev_dice1 == 7) {
//            label_7.setGraphic(guti1_label);
//            prev_dice1 = 7;
//        } else if (dice_n + prev_dice1 == 8) {
//            label_8.setGraphic(guti1_label);
//            if (dice_n + prev_dice1 == 8) {
//                label_35.setGraphic(guti1_label);
//                prev_dice1 = 35;
//            }
//            // prev_dice = 8;
//        } else if (dice_n + prev_dice1 == 9) {
//            label_9.setGraphic(guti1_label);
//            prev_dice1 = 9;
//        } else if (dice_n + prev_dice1 == 10) {
//            label_10.setGraphic(guti1_label);
//            prev_dice1 = 10;
//        } else if (dice_n + prev_dice1 == 11) {
//            label_11.setGraphic(guti1_label);
//            prev_dice1 = 11;
//        } else if (dice_n + prev_dice1 == 12) {
//            label_12.setGraphic(guti1_label);
//            prev_dice1 = 12;
//        } else if (dice_n + prev_dice1 == 13) {
//            label_13.setGraphic(guti1_label);
//            prev_dice1 = 13;
//        } else if (dice_n + prev_dice1 == 14) {
//            label_14.setGraphic(guti1_label);
//            prev_dice1 = 14;
//        } else if (dice_n + prev_dice1 == 15) {
//            label_15.setGraphic(guti1_label);
//            prev_dice1 = 15;
//        } else if (dice_n + prev_dice1 == 16) {
//            label_16.setGraphic(guti1_label);
//            prev_dice1 = 16;
//        } else if (dice_n + prev_dice1 == 17) {
//            label_17.setGraphic(guti1_label);
//            prev_dice1 = 17;
//        } else if (dice_n + prev_dice1 == 18) {
//            label_18.setGraphic(guti1_label);
//            prev_dice1 = 18;
//        } else if (dice_n + prev_dice1 == 19) {
//            label_19.setGraphic(guti1_label);
//            prev_dice1 = 19;
//        } else if (dice_n + prev_dice1 == 20) {
//            label_20.setGraphic(guti1_label);
//            prev_dice1 = 20;
//        } else if (dice_n + prev_dice1 == 21) {
//            label_21.setGraphic(guti1_label);
//            prev_dice1 = 21;
//        } else if (dice_n + prev_dice1 == 22) {
//            label_22.setGraphic(guti1_label);
//            prev_dice1 = 22;
//        } else if (dice_n + prev_dice1 == 23) {
//            label_23.setGraphic(guti1_label);
//            prev_dice1 = 23;
//        } else if (dice_n + prev_dice1 == 24) {
//            label_24.setGraphic(guti1_label);
//            prev_dice1 = 24;
//        } else if (dice_n + prev_dice1 == 25) {
//            label_25.setGraphic(guti1_label);
//            prev_dice1 = 25;
//        } else if (dice_n + prev_dice1 == 26) {
//            label_26.setGraphic(guti1_label);
//            prev_dice1 = 26;
//        } else if (dice_n + prev_dice1 == 27) {
//            label_27.setGraphic(guti1_label);
//            if (dice_n + prev_dice1 == 27) {
//                label_77.setGraphic(guti1_label);
//                prev_dice1 = 77;
//            }
//            //prev_dice = 27;
//        } else if (dice_n + prev_dice1 == 28) {
//            label_28.setGraphic(guti1_label);
//            prev_dice1 = 28;
//        } else if (dice_n + prev_dice1 == 29) {
//            label_29.setGraphic(guti1_label);
//            prev_dice1 = 29;
//        } else if (dice_n + prev_dice1 == 30) {
//            label_30.setGraphic(guti1_label);
//            prev_dice1 = 30;
//        } else if (dice_n + prev_dice1 == 31) {
//            label_31.setGraphic(guti1_label);
//            if (dice_n + prev_dice1 == 31) {
//                label_10.setGraphic(guti1_label);
//                prev_dice1 = 10;
//            }
//            // prev_dice = 31;
//        } else if (dice_n + prev_dice1 == 32) {
//            label_32.setGraphic(guti1_label);
//            prev_dice1 = 32;
//        } else if (dice_n + prev_dice1 == 33) {
//            label_33.setGraphic(guti1_label);
//            prev_dice1 = 33;
//        } else if (dice_n + prev_dice1 == 34) {
//            label_34.setGraphic(guti1_label);
//            prev_dice1 = 34;
//        } else if (dice_n + prev_dice1 == 35) {
//            label_35.setGraphic(guti1_label);
//            prev_dice1 = 35;
//        } else if (dice_n + prev_dice1 == 36) {
//            label_36.setGraphic(guti1_label);
//            prev_dice1 = 36;
//        } else if (dice_n + prev_dice1 == 37) {
//            label_37.setGraphic(guti1_label);
//            prev_dice1 = 37;
//        } else if (dice_n + prev_dice1 == 38) {
//            label_38.setGraphic(guti1_label);
//            prev_dice1 = 38;
//        } else if (dice_n + prev_dice1 == 39) {
//            label_39.setGraphic(guti1_label);
//            if (dice_n + prev_dice1 == 39) {
//                label_60.setGraphic(guti1_label);
//                prev_dice1 = 60;
//            }
//            //  prev_dice = 39;
//        } else if (dice_n + prev_dice1 == 40) {
//            label_44.setGraphic(guti1_label);
//            prev_dice1 = 40;
//        } else if (dice_n + prev_dice1 == 41) {
//            label_41.setGraphic(guti1_label);
//            prev_dice1 = 41;
//        } else if (dice_n + prev_dice1 == 42) {
//            label_42.setGraphic(guti1_label);
//            prev_dice1 = 42;
//        } else if (dice_n + prev_dice1 == 43) {
//            label_43.setGraphic(guti1_label);
//            prev_dice1 = 43;
//        } else if (dice_n + prev_dice1 == 44) {
//            label_44.setGraphic(guti1_label);
//            prev_dice1 = 44;
//        } else if (dice_n + prev_dice1 == 45) {
//            label_45.setGraphic(guti1_label);
//            prev_dice1 = 45;
//        } else if (dice_n + prev_dice1 == 46) {
//            label_46.setGraphic(guti1_label);
//            prev_dice1 = 46;
//        } else if (dice_n + prev_dice1 == 47) {
//            label_47.setGraphic(guti1_label);
//            prev_dice1 = 47;
//        } else if (dice_n + prev_dice1 == 48) {
//            label_48.setGraphic(guti1_label);
//            prev_dice1 = 48;
//        } else if (dice_n + prev_dice1 == 49) {
//            label_49.setGraphic(guti1_label);
//            prev_dice1 = 49;
//        } else if (dice_n + prev_dice1 == 50) {
//            label_50.setGraphic(guti1_label);
//            prev_dice1 = 50;
//        } else if (dice_n + prev_dice1 == 51) {
//            label_51.setGraphic(guti1_label);
//            prev_dice1 = 51;
//        } else if (dice_n + prev_dice1 == 52) {
//            label_52.setGraphic(guti1_label);
//            prev_dice1 = 52;
//        } else if (dice_n + prev_dice1 == 53) {
//            label_53.setGraphic(guti1_label);
//            if (dice_n + prev_dice1 == 53) {
//                label_81.setGraphic(guti1_label);
//                prev_dice1 = 81;
//            }
//            // prev_dice = 53;
//        } else if (dice_n + prev_dice1 == 54) {
//            label_54.setGraphic(guti1_label);
//            prev_dice1 = 54;
//        } else if (dice_n + prev_dice1 == 55) {
//            label_55.setGraphic(guti1_label);
//            prev_dice1 = 55;
//        } else if (dice_n + prev_dice1 == 56) {
//            label_56.setGraphic(guti1_label);
//            prev_dice1 = 56;
//        } else if (dice_n + prev_dice1 == 57) {
//            label_57.setGraphic(guti1_label);
//            prev_dice1 = 57;
//        } else if (dice_n + prev_dice1 == 58) {
//            label_58.setGraphic(guti1_label);
//            prev_dice1 = 58;
//        } else if (dice_n + prev_dice1 == 59) {
//            label_59.setGraphic(guti1_label);
//            prev_dice1 = 59;
//        } else if (dice_n + prev_dice1 == 60) {
//            label_60.setGraphic(guti1_label);
//            prev_dice1 = 60;
//        } else if (dice_n + prev_dice1 == 61) {
//            label_61.setGraphic(guti1_label);
//            prev_dice1 = 61;
//        } else if (dice_n + prev_dice1 == 62) {
//            label_62.setGraphic(guti1_label);
//            prev_dice1 = 62;
//        } else if (dice_n + prev_dice1 == 63) {
//            label_63.setGraphic(guti1_label);
//            prev_dice1 = 63;
//        } else if (dice_n + prev_dice1 == 64) {
//            label_64.setGraphic(guti1_label);
//            prev_dice1 = 64;
//        } else if (dice_n + prev_dice1 == 65) {
//            label_65.setGraphic(guti1_label);
//            prev_dice1 = 65;
//        } else if (dice_n + prev_dice1 == 66) {
//            label_66.setGraphic(guti1_label);
//            prev_dice1 = 66;
//        } else if (dice_n + prev_dice1 == 67) {
//            label_67.setGraphic(guti1_label);
//            prev_dice1 = 67;
//        } else if (dice_n + prev_dice1 == 68) {
//            label_68.setGraphic(guti1_label);
//            prev_dice1 = 68;
//        } else if (dice_n + prev_dice1 == 69) {
//            label_69.setGraphic(guti1_label);
//            prev_dice1 = 69;
//        } else if (dice_n + prev_dice1 == 70) {
//            label_70.setGraphic(guti1_label);
//            prev_dice1 = 70;
//        } else if (dice_n + prev_dice1 == 71) {
//            label_71.setGraphic(guti1_label);
//            prev_dice1 = 71;
//        } else if (dice_n + prev_dice1 == 72) {
//            label_72.setGraphic(guti1_label);
//            prev_dice1 = 72;
//        } else if (dice_n + prev_dice1 == 73) {
//            label_73.setGraphic(guti1_label);
//            prev_dice1 = 73;
//        } else if (dice_n + prev_dice1 == 74) {
//            label_74.setGraphic(guti1_label);
//            prev_dice1 = 74;
//        } else if (dice_n + prev_dice1 == 75) {
//            label_75.setGraphic(guti1_label);
//            prev_dice1 = 75;
//        } else if (dice_n + prev_dice1 == 76) {
//            label_76.setGraphic(guti1_label);
//            prev_dice1 = 76;
//        } else if (dice_n + prev_dice1 == 77) {
//            label_77.setGraphic(guti1_label);
//            prev_dice1 = 77;
//        } else if (dice_n + prev_dice1 == 78) {
//            label_78.setGraphic(guti1_label);
//            prev_dice1 = 78;
//        } else if (dice_n + prev_dice1 == 79) {
//            label_79.setGraphic(guti1_label);
//            prev_dice1 = 79;
//        } else if (dice_n + prev_dice1 == 80) {
//            label_80.setGraphic(guti1_label);
//            if (dice_n + prev_dice1 == 80) {
//                label_38.setGraphic(guti1_label);
//                prev_dice1 = 38;
//            }
//            //  prev_dice = 80;
//        } else if (dice_n + prev_dice1 == 81) {
//            label_81.setGraphic(guti1_label);
//            prev_dice1 = 81;
//        } else if (dice_n + prev_dice1 == 82) {
//            label_82.setGraphic(guti1_label);
//            prev_dice1 = 82;
//        } else if (dice_n + prev_dice1 == 83) {
//            label_83.setGraphic(guti1_label);
//            prev_dice1 = 83;
//        } else if (dice_n + prev_dice1 == 84) {
//            label_84.setGraphic(guti1_label);
//            prev_dice1 = 84;
//        } else if (dice_n + prev_dice1 == 85) {
//            label_85.setGraphic(guti1_label);
//            if (dice_n + prev_dice1 == 85) {
//                label_51.setGraphic(guti1_label);
//                prev_dice1 = 51;
//            }
//            //  prev_dice = 85;
//        } else if (dice_n + prev_dice1 == 86) {
//            label_86.setGraphic(guti1_label);
//            prev_dice1 = 86;
//        } else if (dice_n + prev_dice1 == 87) {
//            label_87.setGraphic(guti1_label);
//            prev_dice1 = 87;
//        } else if (dice_n + prev_dice1 == 88) {
//            label_88.setGraphic(guti1_label);
//            prev_dice1 = 88;
//        } else if (dice_n + prev_dice1 == 89) {
//            label_89.setGraphic(guti1_label);
//            prev_dice1 = 89;
//        } else if (dice_n + prev_dice1 == 90) {
//            label_90.setGraphic(guti1_label);
//            prev_dice1 = 90;
//        } else if (dice_n + prev_dice1 == 91) {
//            label_91.setGraphic(guti1_label);
//            prev_dice1 = 91;
//        } else if (dice_n + prev_dice1 == 92) {
//            label_92.setGraphic(guti1_label);
//            prev_dice1 = 92;
//        } else if (dice_n + prev_dice1 == 93) {
//            label_93.setGraphic(guti1_label);
//            prev_dice1 = 93;
//        } else if (dice_n + prev_dice1 == 94) {
//            label_94.setGraphic(guti1_label);
//            prev_dice1 = 94;
//        } else if (dice_n + prev_dice1 == 95) {
//            label_95.setGraphic(guti1_label);
//            prev_dice1 = 95;
//        } else if (dice_n + prev_dice1 == 96) {
//            label_96.setGraphic(guti1_label);
//            prev_dice1 = 96;
//        } else if (dice_n + prev_dice1 == 97) {
//            label_97.setGraphic(guti1_label);
//            if (dice_n + prev_dice1 == 97) {
//                label_15.setGraphic(guti1_label);
//                prev_dice1 = 15;
//            }
//            //  prev_dice = 97;
//        } else if (dice_n + prev_dice1 == 98) {
//            label_98.setGraphic(guti1_label);
//            prev_dice1 = 98;
//        } else if (dice_n + prev_dice1 == 99) {
//            label_99.setGraphic(guti1_label);
//            prev_dice1 = 99;
//        } else if (dice_n + prev_dice1 == 100) {
//            label_100.setGraphic(guti1_label);
//            prev_dice1 = 100;
//            turn.setText("Player 1 Win!!");
//        }
//
//    }

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


}