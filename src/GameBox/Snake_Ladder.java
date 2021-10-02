package GameBox;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.text.html.ImageView;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Random;

public class Snake_Ladder {

    @FXML
    Label label_1,label_2,label_3,label_4,label_5,label_6,label_7,label_8,label_9,label_10,label_11,label_12,label_13,label_14,label_15,label_16,label_17,label_18,label_19,label_20;
    @FXML
    Label label_21,label_22,label_23,label_24,label_25,label_26,label_27,label_28,label_29,label_30,label_31,label_32,label_33,label_34,label_35,label_36,label_37,label_38,label_39,label_40;
    @FXML
    Label label_41,label_42,label_43,label_44,label_45,label_46,label_47,label_48,label_49,label_50,label_51,label_52,label_53,label_54,label_55,label_56,label_57,label_58,label_59,label_60;
    @FXML
    Label label_61,label_62,label_63,label_64,label_65,label_66,label_67,label_68,label_69,label_70,label_71,label_72,label_73,label_74,label_75,label_76,label_77,label_78,label_79,label_80;
    @FXML
    Label label_81,label_82,label_83,label_84,label_85,label_86,label_87,label_88,label_89,label_90,label_91,label_92,label_93,label_94,label_95,label_96,label_97,label_98,label_99,label_100;

    @FXML
    private TextArea Chat_Area;
    @FXML
    private TextField send_msg;
    @FXML
    private Label dice;
    @FXML
    Label guti1_label;
    @FXML
    Label turn;
    @FXML
    private void send_button(){

   }
   int prev_dice = 0;
    @FXML
    private void roll(){
        int [] dice_arr = {1,2,3,4,5,6};
        Random random = new Random();
        int dice_roll = random.nextInt(6);
        int dice_n = dice_arr[dice_roll];
        dice.setText(String.valueOf(dice_n));


        switch (dice_n+prev_dice){
            case 1:
                label_1.setGraphic(guti1_label);
                prev_dice = 1;
                break;
            case 2:
                label_2.setGraphic(guti1_label);
                prev_dice = 2;
                break;
            case 3:
                label_3.setGraphic(guti1_label);
                prev_dice = 3;
                break;
            case 4:
                label_4.setGraphic(guti1_label);
                prev_dice = 4;
                break;
            case 5:
                label_5.setGraphic(guti1_label);
                prev_dice = 5;
                break;
            case 6:
                label_6.setGraphic(guti1_label);
                prev_dice = 6;
                break;
            case 7:
                label_7.setGraphic(guti1_label);
                prev_dice = 7;
                break;
            case 8:
                label_8.setGraphic(guti1_label);
                if(dice_n+prev_dice == 8){
                    label_35.setGraphic(guti1_label);
                    prev_dice = 35;
                }
               // prev_dice = 8;
                break;
            case 9:
                label_9.setGraphic(guti1_label);
                prev_dice = 9;
                break;
            case 10:
                label_10.setGraphic(guti1_label);
                prev_dice = 10;
                break;
            case 11:
                label_11.setGraphic(guti1_label);
                prev_dice = 11;
                break;
            case 12:
                label_12.setGraphic(guti1_label);
                prev_dice = 12;
                break;
            case 13:
                label_13.setGraphic(guti1_label);
                prev_dice = 13;
                break;
            case 14:
                label_14.setGraphic(guti1_label);
                prev_dice = 14;
                break;
            case 15:
                label_15.setGraphic(guti1_label);
                prev_dice = 15;
                break;
            case 16:
                label_16.setGraphic(guti1_label);
                prev_dice = 16;
                break;
            case 17:
                label_17.setGraphic(guti1_label);
                prev_dice = 17;
                break;
            case 18:
                label_18.setGraphic(guti1_label);
                prev_dice = 18;
                break;
            case 19:
                label_19.setGraphic(guti1_label);
                prev_dice = 19;
                break;
            case 20:
                label_20.setGraphic(guti1_label);
                prev_dice = 20;
                break;
            case 21:
                label_21.setGraphic(guti1_label);
                prev_dice = 21;
                break;
            case 22:
                label_22.setGraphic(guti1_label);
                prev_dice = 22;
                break;
            case 23:
                label_23.setGraphic(guti1_label);
                prev_dice = 23;
                break;
            case 24:
                label_24.setGraphic(guti1_label);
                prev_dice = 24;
                break;
            case 25:
                label_25.setGraphic(guti1_label);
                prev_dice = 25;
                break;
            case 26:
                label_26.setGraphic(guti1_label);
                prev_dice = 26;
                break;
            case 27:
                label_27.setGraphic(guti1_label);
                if(dice_n+prev_dice == 27){
                    label_77.setGraphic(guti1_label);
                    prev_dice = 77;
                }
                //prev_dice = 27;
                break;
            case 28:
                label_28.setGraphic(guti1_label);
                prev_dice = 28;
                break;
            case 29:
                label_29.setGraphic(guti1_label);
                prev_dice = 29;
                break;
            case 30:
                label_30.setGraphic(guti1_label);
                prev_dice = 30;
                break;
            case 31:
                label_31.setGraphic(guti1_label);
                if(dice_n+prev_dice == 31){
                    label_10.setGraphic(guti1_label);
                    prev_dice = 10;
                }
               // prev_dice = 31;
                break;
            case 32:
                label_32.setGraphic(guti1_label);
                prev_dice = 32;
                break;
            case 33:
                label_33.setGraphic(guti1_label);
                prev_dice = 33;
                break;
            case 34:
                label_34.setGraphic(guti1_label);
                prev_dice = 34;
                break;
            case 35:
                label_35.setGraphic(guti1_label);
                prev_dice = 35;
                break;
            case 36:
                label_36.setGraphic(guti1_label);
                prev_dice = 36;
                break;
            case 37:
                label_37.setGraphic(guti1_label);
                prev_dice = 37;
                break;
            case 38:
                label_38.setGraphic(guti1_label);
                prev_dice = 38;
                break;
            case 39:
                label_39.setGraphic(guti1_label);
                if(dice_n+prev_dice == 39){
                    label_60.setGraphic(guti1_label);
                    prev_dice = 60;
                }
              //  prev_dice = 39;
                break;
            case 40:
                label_44.setGraphic(guti1_label);
                prev_dice = 40;
                break;
            case 41:
                label_41.setGraphic(guti1_label);
                prev_dice = 41;
                break;
            case 42:
                label_42.setGraphic(guti1_label);
                prev_dice = 42;
                break;
            case 43:
                label_43.setGraphic(guti1_label);
                prev_dice = 43;
                break;
            case 44:
                label_44.setGraphic(guti1_label);
                prev_dice = 44;
                break;
            case 45:
                label_45.setGraphic(guti1_label);
                prev_dice = 45;
                break;
            case 46:
                label_46.setGraphic(guti1_label);
                prev_dice = 46;
                break;
            case 47:
                label_47.setGraphic(guti1_label);
                prev_dice = 47;
                break;
            case 48:
                label_48.setGraphic(guti1_label);
                prev_dice = 48;
                break;
            case 49:
                label_49.setGraphic(guti1_label);
                prev_dice = 49;
                break;
            case 50:
                label_50.setGraphic(guti1_label);
                prev_dice = 50;
                break;
            case 51:
                label_51.setGraphic(guti1_label);
                prev_dice = 51;
                break;
            case 52:
                label_52.setGraphic(guti1_label);
                prev_dice = 52;
                break;
            case 53:
                label_53.setGraphic(guti1_label);
                if(dice_n+prev_dice == 53){
                    label_81.setGraphic(guti1_label);
                    prev_dice = 81;
                }
               // prev_dice = 53;
                break;
            case 54:
                label_54.setGraphic(guti1_label);
                prev_dice = 54;
                break;
            case 55:
                label_55.setGraphic(guti1_label);
                prev_dice = 55;
                break;
            case 56:
                label_56.setGraphic(guti1_label);
                prev_dice = 56;
                break;
            case 57:
                label_57.setGraphic(guti1_label);
                prev_dice = 57;
                break;
            case 58:
                label_58.setGraphic(guti1_label);
                prev_dice = 58;
                break;
            case 59:
                label_59.setGraphic(guti1_label);
                prev_dice = 59;
                break;
            case 60:
                label_60.setGraphic(guti1_label);
                prev_dice = 60;
                break;
            case 61:
                label_61.setGraphic(guti1_label);
                prev_dice = 61;
                break;
            case 62:
                label_62.setGraphic(guti1_label);
                prev_dice = 62;
                break;
            case 63:
                label_63.setGraphic(guti1_label);
                prev_dice = 63;
                break;
            case 64:
                label_64.setGraphic(guti1_label);
                prev_dice = 64;
                break;
            case 65:
                label_65.setGraphic(guti1_label);
                prev_dice = 65;
                break;
            case 66:
                label_66.setGraphic(guti1_label);
                prev_dice = 66;
                break;
            case 67:
                label_67.setGraphic(guti1_label);
                prev_dice = 67;
                break;
            case 68:
                label_68.setGraphic(guti1_label);
                prev_dice = 68;
                break;
            case 69:
                label_69.setGraphic(guti1_label);
                prev_dice = 69;
                break;
            case 70:
                label_70.setGraphic(guti1_label);
                prev_dice = 70;
                break;
            case 71:
                label_71.setGraphic(guti1_label);
                prev_dice = 71;
                break;
            case 72:
                label_72.setGraphic(guti1_label);
                prev_dice = 72;
                break;
            case 73:
                label_73.setGraphic(guti1_label);
                prev_dice = 73;
                break;
            case 74:
                label_74.setGraphic(guti1_label);
                prev_dice = 74;
                break;
            case 75:
                label_75.setGraphic(guti1_label);
                prev_dice = 75;
                break;
            case 76:
                label_76.setGraphic(guti1_label);
                prev_dice = 76;
                break;
            case 77:
                label_77.setGraphic(guti1_label);
                prev_dice = 77;
                break;
            case 78:
                label_78.setGraphic(guti1_label);
                prev_dice = 78;
                break;
            case 79:
                label_79.setGraphic(guti1_label);
                prev_dice = 79;
                break;
            case 80:
                label_80.setGraphic(guti1_label);
                if(dice_n+prev_dice == 80){
                    label_38.setGraphic(guti1_label);
                    prev_dice = 38;
                }
              //  prev_dice = 80;
                break;
            case 81:
                label_81.setGraphic(guti1_label);
                prev_dice = 81;
                break;
            case 82:
                label_82.setGraphic(guti1_label);
                prev_dice = 82;
                break;
            case 83:
                label_83.setGraphic(guti1_label);
                prev_dice = 83;
                break;
            case 84:
                label_84.setGraphic(guti1_label);
                prev_dice = 84;
                break;
            case 85:
                label_85.setGraphic(guti1_label);
                if(dice_n+prev_dice == 85){
                    label_51.setGraphic(guti1_label);
                    prev_dice = 51;
                }
              //  prev_dice = 85;
                break;
            case 86:
                label_86.setGraphic(guti1_label);
                prev_dice = 86;
                break;
            case 87:
                label_87.setGraphic(guti1_label);
                prev_dice = 87;
                break;
            case 88:
                label_88.setGraphic(guti1_label);
                prev_dice = 88;
                break;
            case 89:
                label_89.setGraphic(guti1_label);
                prev_dice = 89;
                break;
            case 90:
                label_90.setGraphic(guti1_label);
                prev_dice = 90;
                break;
            case 91:
                label_91.setGraphic(guti1_label);
                prev_dice = 91;
                break;
            case 92:
                label_92.setGraphic(guti1_label);
                prev_dice = 92;
                break;
            case 93:
                label_93.setGraphic(guti1_label);
                prev_dice = 93;
                break;
            case 94:
                label_94.setGraphic(guti1_label);
                prev_dice = 94;
                break;
            case 95:
                label_95.setGraphic(guti1_label);
                prev_dice = 95;
                break;
            case 96:
                label_96.setGraphic(guti1_label);
                prev_dice = 96;
                break;
            case 97:
                label_97.setGraphic(guti1_label);
                if(dice_n+prev_dice == 97){
                    label_15.setGraphic(guti1_label);
                    prev_dice = 15;
                }
              //  prev_dice = 97;
                break;
            case 98:
                label_98.setGraphic(guti1_label);
                prev_dice = 98;
                break;
            case 99:
                label_99.setGraphic(guti1_label);
                prev_dice = 99;
                break;
            case 100:
                label_100.setGraphic(guti1_label);
                prev_dice = 100;
                turn.setText("Player 1 Win!!");
                break;
        }

    }

}
