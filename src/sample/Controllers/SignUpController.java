package sample.Controllers;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Helpers.DbConnector;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import static javafx.fxml.FXMLLoader.load;

public class SignUpController implements Initializable {

    @FXML
    private JFXTextField tf_username;

    @FXML
    private JFXTextField tf_email;

    @FXML
    private JFXPasswordField pf_password;

    @FXML
    void closeWindow(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void createAccount(MouseEvent event) {
        Connection connection = DbConnector.getInstances().getConnection();
        String username = tf_username.getText();
        String email = tf_email.getText();
        String password = pf_password.getText();

        try {
            Statement statement = connection.createStatement();

            int status = statement.executeUpdate("insert into users (Username, Email, password)" +
                    "values ('" + username + "','" + email + "','" + password + "' )");

            if (status > 0) {
                System.out.println("User Registered");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @FXML
    void logIn(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Views/Login.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));

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
