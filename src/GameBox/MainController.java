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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.util.Objects;



public class MainController {
    @FXML
    private Pane Game_Selection_Pane;
    @FXML
    private Pane Main_Sub_Pane1;
    @FXML
    private Pane Main_Sub_Pane2;
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

    @FXML
    private TextArea Chat_Area;
    @FXML
    private TextField send_msg;

    public BufferedReader reader;
    public BufferedWriter writer;

    public MainController() {
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

    private String uniqueKey = null;
    private String UserName = null;


    @FXML
    private void login_click() {
        try {
            UserName = username.getText();
            uniqueKey = secret_key.getText();
            if (UserName.length() == 0 || uniqueKey.length() == 0) {
                login_failed.setText("Please Enter Valid Info");
            } else {
                writer.write("Login Button\n");
                writer.write(UserName + "\n");
                writer.write(uniqueKey + "\n");
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
    private void connect_click(ActionEvent e) {
        String str = connect_key.getText();
        if (str.length() != 0 && !uniqueKey.equals(str)) {
            try {
                writer.write("Connection Button\n");
                writer.write(str + "\n");
                writer.flush();
                if (reader.readLine().equals("true")) {
                    Main_Sub_Pane1.setVisible(false);
                    Main_Sub_Pane2.setVisible(false);
                    Game_Selection_Pane.setVisible(true);
                    t.start();

                } else {
                    login_failed.setVisible(true);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    Thread t = new Thread(){
        @Override
        public void run() {
            while (true){
                try {
                    String str = reader.readLine();
                    if (str.equals("ChatBox Before Game")) {
                        String msg = reader.readLine();
                        Chat_Area.appendText(msg + "\n");
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    };

    @FXML
    private void send_button() {
        try {
            writer.write("ChatBox Before Game\n");
            writer.write(UserName+": "+send_msg.getText() + "\n");
            writer.flush();
            send_msg.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void tic_tac_toe(ActionEvent e) throws IOException {
        writer.write("Tic Tac Toe\n");
        writer.flush();
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Tic_Tac_Toe.fxml")));
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setTitle("Tic Tac Toe Game");
        window.setScene(new Scene(parent, 900, 650));
        window.show();
    }

    @FXML
    private void chess(ActionEvent e) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Chess.fxml")));
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setTitle("Chess Game");
        window.setScene(new Scene(parent, 900, 650));
        window.show();
    }

    @FXML
    private void snake_ladder(ActionEvent e) throws IOException {
        writer.write("Snake Ladder\n");
        writer.flush();
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Snake_Ladder.fxml")));
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setTitle("Snake Ladder Game");
        window.setScene(new Scene(parent, 986, 673));
        window.show();
    }

}
