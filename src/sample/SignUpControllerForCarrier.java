package sample;

import java.awt.*;
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

public class SignUpControllerForCarrier extends DatabaseHandler {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane backgroundAnchorPane;

    @FXML
    private PasswordField passwordField1;

    @FXML
    private TextField loginField1;

    @FXML
    private TextField lastNameField1;

    @FXML
    private TextField firstNameField1;

    @FXML
    private TextField phoneField1;

    @FXML
    private TextField emailField1;

    @FXML
    private TextField typeCarField;

    @FXML
    private TextField brandCarField;

    @FXML
    private TextField numberCarField;

    @FXML
    private TextField colorCarField;

    @FXML
    private TextField brandMotobikeField;

    @FXML
    private TextField numberMotobikeField;

    @FXML
    private TextField colorMotobikeField;

    @FXML
    private TextField colorBikeField;

    @FXML
    private TextField uniqueNumberField;

    @FXML
    private Button signUpButton;

    @FXML
    void initialize() {
        signUpButton.setOnAction(actionEvent -> {
            signUpCarrier();
        });

    }

    private void signUpCarrier() {
        String login = loginField1.getText();
        String password = passwordField1.getText();
        String phone = phoneField1.getText();
        String lastName = lastNameField1.getText();
        String firstName = firstNameField1.getText();
        String email = emailField1.getText();

        if(!login.equals("") && !password.equals("") && !phone.equals("") && !lastName.equals("") && !firstName.equals("") && !email.equals("")){
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
        }else{
            Alert Confirmation = new Alert(Alert.AlertType.CONFIRMATION);
            Confirmation.setTitle("CONFIRMATION");
            Confirmation.setContentText("Заповніть усі поля у вкладці персональна інформація");
            Confirmation.setHeaderText("Помилка вводу інформації");
            Confirmation.show();
        }



        /*Insert transportData*/
        String typeCar = typeCarField.getText();
        String  brandCar = brandCarField.getText();
        String numberCar = numberCarField.getText();
        String colorCar = colorCarField.getText();
        /*String brandMotoBike = brandMotobikeField.getText();
        String numberMotoBike = numberMotobikeField.getText();
        String colorMotoBike = colorMotobikeField.getText();
        String colorBike = colorBikeField.getText();
        String uniqueNumber = uniqueNumberField.getText();*/
        int idCarLocal = 0;
        //int idMotobikeLocal = 0;
        //int idBikeLocal = 0;
        int idTransportDataLocal = 0;
        int idPersonalDataLocal = 0;
        //Bike bike = null;
        //Motobike motobike = null;
        Car car = null;

        if(!typeCar.equals("") && !brandCar.equals("") && !numberCar.equals("") && !colorCar.equals("")){
            /*INSERT TO CAR*/
            String insertToCar = "INSERT INTO " + Const.CAR_TABLE + "( " + Const.CAR_TYPE + " , " + Const.CAR_BRAND + " , "
                    + Const.CAR_COLOR + " , " + Const.CAR_NUMBER +  " ) " + "VALUES(?,?,?,?)";

            try {
                PreparedStatement preparedStatement = getDbConnection().prepareStatement(insertToCar);
                preparedStatement.setString(1, typeCar);
                preparedStatement.setString(2, brandCar);
                preparedStatement.setString(3, colorCar);
                preparedStatement.setString(4, numberCar);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            /*GET ID_CAR */
            car = new Car(typeCar, colorCar, brandCar, numberCar);
            ResultSet carResultSet = getCar(car);
            try{
                while (carResultSet.next()){
                    idCarLocal = carResultSet.getInt(1);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }else{
            Alert Confirmation = new Alert(Alert.AlertType.CONFIRMATION);
            Confirmation.setTitle("CONFIRMATION");
            Confirmation.setContentText("Заповніть усі поля у вкладці автомобільні дані");
            Confirmation.setHeaderText("Помилка вводу інформації");
            Confirmation.show();
        }
        /*if(!brandMotoBike.equals("") && !numberMotoBike.equals("") && !colorMotoBike.equals("")) {
            /*INSERT TO MOTOBIKE
            String insertToMotoBike = "INSERT INTO " + Const.MOTOBIKE_TABLE + "( " + Const.MOTOBIKE_BRAND + " , " + Const.MOTOBIKE_COLOR + " , "
                    + Const.MOTOBIKE_NUMBER  +  " ) " + "VALUES(?,?,?)";

            try {
                PreparedStatement preparedStatement = getDbConnection().prepareStatement(insertToMotoBike);
                preparedStatement.setString(1, brandMotoBike);
                preparedStatement.setString(2, colorMotoBike);
                preparedStatement.setString(3, numberMotoBike);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            GET ID_MOTOBIKE
            motobike = new Motobike(brandMotoBike, colorMotoBike, numberMotoBike);;
            ResultSet motobikeResultSet = getMotobike(motobike);
            try{
                while (motobikeResultSet.next()){
                    idMotobikeLocal = motobikeResultSet.getInt(1);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(!colorBike.equals("") && !uniqueNumber.equals("")){
            /*INSERT TO BIKE
            String insertToBike = "INSERT INTO " + Const.BIKE_TABLE + "( " + Const.BIKE_COLOR + " , " +
                    Const.BIKE_UNIQUE_NUMBER +  " ) " + "VALUES(?,?)";
            try {
                PreparedStatement preparedStatement = getDbConnection().prepareStatement(insertToBike);
                preparedStatement.setString(1, colorBike);
                preparedStatement.setInt(2, Integer.parseInt(uniqueNumber));
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            /*GET ID_BIKE
            bike = new Bike(colorBike, Integer.parseInt(uniqueNumber));
            ResultSet bikeResultSet = getBike(bike);
            try{
                while (bikeResultSet.next()){
                    idBikeLocal = bikeResultSet.getInt(1);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }*/

        /*Додається через тригер*/
        /*if(idCarLocal != 0){
            /*INSERT TO transportData
            String insertToTransportData = "INSERT INTO " + Const.TRANSPORT_DATA_TABLE + "( " + Const.TRANSPORT_DATA_ID_CAR + " ) " + "VALUES(?)";
            try {
                PreparedStatement preparedStatement = getDbConnection().prepareStatement(insertToTransportData);
                preparedStatement.setInt(1, idCarLocal);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }*/

        /*GET ID_TRANSPORTDATA*/
        car = new Car(idCarLocal, typeCar, colorCar, brandCar, numberCar);
        TransportData transportData = new TransportData(car);
        ResultSet transportDataResultSet = getTransportData(transportData);
        try{
            while (transportDataResultSet.next()){
                idTransportDataLocal = transportDataResultSet.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        PersonalData personalData = new PersonalData();
        personalData.setLogin(login);
        personalData.setPassword(password);
        Carrier carrier = new Carrier();
        carrier.setPersonalData(personalData);
        ResultSet resultSet = getCarrier(carrier);
        try{
            while (resultSet.next()){
                idPersonalDataLocal = resultSet.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        if(idPersonalDataLocal != 0 && idTransportDataLocal != 0){
            String insertToClient = "INSERT INTO " + Const.CARRIER_TABLE + " ( " + Const.CARRIER_ID + " , " + Const.CARRIER_ID_TRANSPORT_DATA + " ) " + " VALUES(?,?)";
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = getDbConnection().prepareStatement(insertToClient);
                preparedStatement.setInt(1, idPersonalDataLocal);
                preparedStatement.setInt(2, idTransportDataLocal);
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

            signUpButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader() ;
            loader.setLocation(SystemControllerForClient.class.getResource("signInForCarrier.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage= new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }
}
