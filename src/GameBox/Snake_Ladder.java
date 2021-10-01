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

    Label [] label = new Label[]{label_1, label_2, label_3, label_4,label_5,label_6,label_7,label_8,label_9,label_10,label_11,label_12};

    @FXML
    private TextArea Chat_Area;
   @FXML
    private TextField send_msg;
   @FXML
    private Label dice;
   @FXML
    Label guti1_label;
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
        label[dice_n+prev_dice].setGraphic(guti1_label);
        prev_dice = dice_n;
    }




}
