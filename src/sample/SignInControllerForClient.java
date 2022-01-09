package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        signInButton.setOnAction(actionEvent -> {
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
        });
        signUpButton.setOnAction(actionEvent -> {
            signUpButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader() ;
            loader.setLocation(getClass().getResource("/sample/signUpForClient.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot ();
            Stage stage= new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
    }

    private void loginUser(String login, String password) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        Client client = new Client();
        PersonalData personalData = new PersonalData();
        personalData.setLogin(login);
        personalData.setPassword(password);
        client.setPersonalData(personalData);
        ResultSet resultSetLoginAndPassword = databaseHandler.getClient(client);
        int localId = 0;
        try {
            while (resultSetLoginAndPassword.next()){
                localId = resultSetLoginAndPassword.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        client.setIdClient(localId);
        ResultSet resultSetIdClient = databaseHandler.getIdClient(client);
        int localIdClient = 0;
        try{
            while (resultSetIdClient.next()){
                localIdClient = resultSetIdClient.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        if(localId == localIdClient && localId != 0){
            signInButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SystemControllerForClient.class.getResource("systemForClient.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            SystemControllerForClient systemControllerForClient = loader.getController();
            systemControllerForClient.initData(login, password);

            Parent root = loader.getRoot();
            Stage stage= new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }else{
            Alert ERROR = new Alert(Alert.AlertType.ERROR);
            ERROR.setTitle("ERROR");
            ERROR.setContentText("Даного користувача не знайдено");
            ERROR.setHeaderText("Помилка входу");
            ERROR.show();
            loginField.clear();
            passwordField.clear();
        }
    }
}
