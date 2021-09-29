package GameBox;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.util.Objects;



public class MainController {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label login_failed;
    @FXML
    private FontAwesomeIconView userIcon;
    @FXML
    private FontAwesomeIconView keyIcon;
    @FXML
    private Button login_click;
//    @FXML
//    ImageView image;
//    Image img = new Image(Objects.requireNonNull(getClass().getResourceAsStream("image/logo.png")));

    BufferedReader reader;
    BufferedWriter writer;
    public MainController(){
//        image.setImage(img);
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
    private void login_click(){
        try {
            String UserName = username.getText();
            String Password = password.getText();
            if (UserName.length() == 0 || Password.length() == 0){
                login_failed.setText("Please Enter Valid Info");
            }
            else {
                writer.write(UserName + "\n");
                writer.write(Password + "\n");
                writer.flush();
                userIcon.setVisible(false);
                keyIcon.setVisible(false);
                password.setVisible(false);
                username.setVisible(false);
                login_click.setVisible(false);
                login_failed.setVisible(false);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void tic_tac_toe(ActionEvent e) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Tic_Tac_Toe.fxml")));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setTitle("Tic Tac Toe Game");
        window.setScene(new Scene(parent, 800, 650));
        window.show();

    }
    @FXML
    private void chess(ActionEvent e) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Tic_Tac_Toe.fxml")));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setTitle("Tic Tac Toe Game");
        window.setScene(new Scene(parent, 800, 650));
        window.show();
    }
    @FXML
    private void snake_ladder(ActionEvent e) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Tic_Tac_Toe.fxml")));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setTitle("Tic Tac Toe Game");
        window.setScene(new Scene(parent, 800, 650));
        window.show();
    }

}
