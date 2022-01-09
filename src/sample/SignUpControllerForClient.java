package sample;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
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

import javax.xml.crypto.Data;

public class SignUpControllerForClient extends DatabaseHandler {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane backgroundAnchorPane;

    @FXML
    private Button signUpButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField loginField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField emailField;

    @FXML
    void initialize() {
        signUpButton.setOnAction(actionEvent -> {
            signUpClient(loginField, passwordField, phoneField, lastNameField, firstNameField, emailField);
        });
    }

    private void signUpClient(TextField loginField, PasswordField passwordField, TextField phoneField, TextField lastNameField, TextField firstNameField, TextField emailField) {
        String login = loginField.getText();
        String password = passwordField.getText();
        String phone = phoneField.getText();
        String lastName = lastNameField.getText();
        String firstName = firstNameField.getText();
        String email = emailField.getText();

        if(!login.equals("") && !password.equals("") && !phone.equals("") && !lastName.equals("") && !firstName.equals("") && !email.equals("")) {
            DatabaseHandler databaseHandler = new DatabaseHandler();
            PersonalData personalDataPhone = new PersonalData();
            personalDataPhone.setPhone(phone);
            ResultSet resultSetPhone = databaseHandler.getPhonePersonalData(personalDataPhone);
            try {
                if (resultSetPhone.next()) {
                    int localId = resultSetPhone.getInt(1);
                    updatePersonalData(localId, Const.PERSONAL_DATA_LOGIN, login);
                    updatePersonalData(localId, Const.PERSONAL_DATA_PASSWORD, password);
                    updatePersonalData(localId, Const.PERSONAL_DATA_EMAIL, email);
                    updatePersonalData(localId, Const.PERSONAL_DATA_FIRST_NAME, firstName);
                    updatePersonalData(localId, Const.PERSONAL_DATA_LAST_NAME, lastName);
                    outToClientPage();
                }else {
                    if (!login.equals("") && !password.equals("") && !phone.equals("") && !lastName.equals("") && !firstName.equals("") && !email.equals("")) {
                        String insert = "INSERT INTO " + Const.PERSONAL_DATA_TABLE + "( " + Const.PERSONAL_DATA_LOGIN + " , " + Const.PERSONAL_DATA_PASSWORD + " , "
                                + Const.PERSONAL_DATA_FIRST_NAME + " , " + Const.PERSONAL_DATA_LAST_NAME + " , " + Const.PERSONAL_DATA_PHONE + " , "
                                + Const.PERSONAL_DATA_EMAIL + " ) " + "VALUES(?,?,?,?,?,?)";

                        try {
                            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
                            preparedStatement.setString(1, login);
                            preparedStatement.setString(2, password);
                            preparedStatement.setString(3, firstName);
                            preparedStatement.setString(4, lastName);
                            preparedStatement.setString(5, phone);
                            preparedStatement.setString(6, email);
                            preparedStatement.executeUpdate();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Alert Confirmation = new Alert(Alert.AlertType.CONFIRMATION);
                        Confirmation.setTitle("CONFIRMATION");
                        Confirmation.setContentText("Заповніть усі поля у вкладці персональна інформація");
                        Confirmation.setHeaderText("Помилка вводу інформації");
                        Confirmation.show();
                    }

                    PersonalData personalData = new PersonalData();
                    personalData.setLogin(login);
                    personalData.setPassword(password);
                    Client client = new Client();
                    client.setPersonalData(personalData);
                    ResultSet resultSet = getClient(client);
                    int idPersonalDataLocal = 0;
                    try {
                        while (resultSet.next()) {
                            idPersonalDataLocal = resultSet.getInt(1);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    if (idPersonalDataLocal != 0) {
                        String insertToClient = "INSERT INTO " + Const.CLIENT_TABLE + " ( " + Const.CLIENT_ID + " ) VALUES(?)";
                        PreparedStatement preparedStatement = null;
                        try {
                            preparedStatement = getDbConnection().prepareStatement(insertToClient);
                            preparedStatement.setInt(1, idPersonalDataLocal);
                            preparedStatement.executeUpdate();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }

                        Alert information = new Alert(Alert.AlertType.INFORMATION);
                        information.setTitle("Information");
                        information.setContentText("Ви зареєстувалися в системі");
                        information.setHeaderText("Інформація");
                        information.show();

                        outToClientPage();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void outToClientPage() {
        signUpButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(SystemControllerForClient.class.getResource("signInForClient.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
