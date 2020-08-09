package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class HomeController implements Initializable {

    @FXML
    void handleClose(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void min(MouseEvent event) {
        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();
        stage.setIconified(true);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
