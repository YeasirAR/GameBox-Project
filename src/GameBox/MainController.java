package GameBox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainController {

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
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Snake_Ladder.fxml")));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setTitle("Snake Ladder Game");
        window.setScene(new Scene(parent, 800, 650));
        window.show();
    }

}
