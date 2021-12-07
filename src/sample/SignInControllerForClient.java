package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class SignInControllerForClient {

    @FXML
    private AnchorPane backgroundAnchorPane;

    @FXML
    private Button signUpButton;

    @FXML
    private Button signInButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField loginField;

    @FXML
    void initialize() {
        /*signInButton.setOnAction(actionEvent -> {
            String login = loginField.getText().trim();
            String password = passwordField.getText().trim();

            if(!login.equals("") && !password.equals("")){
                loginUser(login,password);
            }else {
                Alert ERROR = new Alert(Alert.AlertType.ERROR);
                ERROR.setTitle("ERROR");
                ERROR.setContentText("Введіть дані правильно\nПеревірте правильність введених даних");
                ERROR.setHeaderText("Помилка вводу");
                ERROR.show();
                loginField.clear();
                passwordField.clear();
            }
        });*/
    }

    /*private void loginUser(String login, String password) {
        DatabaseHandler databaseHandler;

    }*/
}
