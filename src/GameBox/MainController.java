package GameBox;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.util.Objects;



public class MainController {
    @FXML
    private TextField username;
    @FXML
    private TextField secret_key;
    @FXML
    private Label login_failed;
    @FXML
    private FontAwesomeIconView userIcon;
    @FXML
    private FontAwesomeIconView keyIcon;
    @FXML
    private FontAwesomeIconView keyIcon1;
    @FXML
    private Button login_click;

    @FXML
    private TextField connect_key;
    @FXML
    private Label account_created;
    @FXML
    private Label connect_label;
    @FXML
    private Button connect_click;


    BufferedReader reader;
    BufferedWriter writer;
    public MainController(){
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
            String Password = secret_key.getText();
            if (UserName.length() == 0 || Password.length() == 0){
                login_failed.setText("Please Enter Valid Info");
            }
            else {
                writer.write("Login Button\n");
                writer.write(UserName + "\n");
                writer.write(Password + "\n");
                writer.flush();
                userIcon.setVisible(false);
                keyIcon.setVisible(false);
                secret_key.setVisible(false);
                username.setVisible(false);
                login_click.setVisible(false);
                login_failed.setVisible(false);
                // after login
                keyIcon1.setVisible(true);
                connect_click.setVisible(true);
                connect_key.setVisible(true);
                account_created.setVisible(true);
                connect_label.setVisible(true);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void connect_click(ActionEvent e){
        String str = connect_key.getText();
        if(str.length() != 0){
            try {
                writer.write("Connection Button\n");
                writer.write(str+"\n");
                writer.flush();
                if(reader.readLine().equals("true")){
                    System.out.println("True");

                        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GameSelectionFrame.fxml")));
                        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
                        window.setTitle("GameBox");
                        window.setScene(new Scene(parent, 900, 650));
                        window.show();

                }
                else {
                    System.out.println("False");
                    login_failed.setVisible(true);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
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
