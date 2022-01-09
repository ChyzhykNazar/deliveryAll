package sample;


import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SignInControllerForCarrier {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
            loader.setLocation(getClass().getResource("/sample/signUpForCarrier.fxml"));

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
        Carrier carrier = new Carrier();
        PersonalData personalData = new PersonalData();
        personalData.setLogin(login);
        personalData.setPassword(password);
        carrier.setPersonalData(personalData);
        ResultSet resultSet = databaseHandler.getCarrier(carrier);
        int localId = 0;
        try {
            while (resultSet.next()){
                localId = resultSet.getInt(1);
                /*signInButton.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader() ;
                loader.setLocation(SystemControllerForClient.class.getResource("systemForCarrier.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Parent root = loader.getRoot();
                Stage stage= new Stage();
                stage.setScene(new Scene(root));
                stage.show();*/
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        carrier.setIdCarrier(localId);
        ResultSet resultSetIdCarrier = databaseHandler.getIdCarrier(carrier);
        int localIdCarrier = 0;
        try{
            while (resultSetIdCarrier.next()){
                localIdCarrier = resultSetIdCarrier.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        if(localId == localIdCarrier && localId != 0){
            signInButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader() ;
            loader.setLocation(SystemControllerForClient.class.getResource("systemForCarrier.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            SystemControllerForCarrier systemControllerForCarrier = loader.getController();
            systemControllerForCarrier.initData(login, password);

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
