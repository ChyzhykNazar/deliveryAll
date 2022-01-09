package sample;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SystemControllerForCarrier {

    @FXML
    private AnchorPane backgroundAnchorPane;

    @FXML
    private Tab tabConfirmDeparture;

    @FXML
    private AnchorPane anchorPaneConfirmDeparture;

    @FXML
    private TableView<DepartureAndForm> tableviewconfirmingdeparture;

    @FXML
    private TableColumn<DepartureAndForm, Integer> columnnumberofconfirmdeparture;

    @FXML
    private TableColumn<DepartureAndForm, String> columnconfirmfirstnamerecipient;

    @FXML
    private TableColumn<DepartureAndForm, String> columnconfirmlastnamerecipient;

    @FXML
    private TableColumn<DepartureAndForm, String> columnconfirmshippingaddress;

    @FXML
    private TableColumn<DepartureAndForm, String> columnconfirmreceivingaddress;

    @FXML
    private TableColumn<DepartureAndForm, String> columnconfirmcostdeparture;

    @FXML
    private TableColumn<DepartureAndForm, String> columnconfirmcontentsdeparture;

    @FXML
    private Tab tabAvailableShipments;

    @FXML
    private AnchorPane anchorPaneAvailableShipments;

    @FXML
    private TableView<DepartureAndForm> tableviewavavailableingdeparture;

    @FXML
    private TableColumn<DepartureAndForm, Integer> columnnumberofavailabledeparture;

    @FXML
    private TableColumn<DepartureAndForm, String> columnavailableshippingaddress;

    @FXML
    private TableColumn<DepartureAndForm, String> columnavailablereceivingaddress;

    @FXML
    private TableColumn<DepartureAndForm, String> columnavailablecostdeparture;

    @FXML
    private TableColumn<DepartureAndForm, String> columnavailablecostpercel;

    @FXML
    private Tab tabArchiveDeparture;

    @FXML
    private AnchorPane anchorPaneArchiveDeparture;

    @FXML
    private TableView<DepartureAndForm> tableviewarchivedeparture;

    @FXML
    private TableColumn<DepartureAndForm, Integer> columnnumberofarchivedeparture;

    @FXML
    private TableColumn<DepartureAndForm, String> columnarchivefirstnamerecipient;

    @FXML
    private TableColumn<DepartureAndForm, String> columnarchivelastnamerecipient;

    @FXML
    private TableColumn<DepartureAndForm, String> columnarchiveshippingaddress;

    @FXML
    private TableColumn<DepartureAndForm, String> columnarchivereceivingaddress;

    @FXML
    private TableColumn<DepartureAndForm, String> columnarchivecostdeparture;

    @FXML
    private TableColumn<DepartureAndForm, String> columnarchivecontentsdeparture;

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
    private TextField typeCarField;

    @FXML
    private TextField brandCarField;

    @FXML
    private TextField numberCarField;

    @FXML
    private TextField colorCarField;

    @FXML
    private Button saveButton;

    @FXML
    private Button refreshButton;

    @FXML
    private Button exitButton;

    private int id;

    private String login;

    private String password;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    private int idCarGlobal;

    private String type;

    private String brand;

    private String color;

    private String number;

    @FXML
    void initialize() {
        saveButton.setOnAction(actionEvent -> {
            savePersonalData();
        });
        refreshButton.setOnAction(actionEvent -> {
            setPersonalCarrierData();
            setAvailableDeparture();
            setConfirmDeparture();
            setArchiveDeparture();
        });
        exitButton.setOnAction(actionEvent -> {
            exitButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader() ;
            loader.setLocation(getClass().getResource("sample.fxml"));

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
        tableviewarchivedeparture.setOnMouseClicked(event -> {
            if (event.getClickCount() > 1) {
                DepartureAndForm departureAndForm = tableviewarchivedeparture.getSelectionModel().getSelectedItem();
                //System.out.println(departureAndForm.getIddeparture());
                FXMLLoader loader = new FXMLLoader() ;
                loader.setLocation(SystemControllerForClient.class.getResource("departureInformation.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                DepartureInformationController departureInformationController = loader.getController();
                departureInformationController.initData(id, departureAndForm.getIddeparture(), "Архів");

                Parent root = loader.getRoot();
                Stage stage= new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            }
        });
        tableviewconfirmingdeparture.setOnMouseClicked(event -> {
            if (event.getClickCount() > 1) {
                DepartureAndForm departureAndForm = tableviewconfirmingdeparture.getSelectionModel().getSelectedItem();
                //System.out.println(departureAndForm.getIddeparture());
                FXMLLoader loader = new FXMLLoader() ;
                loader.setLocation(SystemControllerForClient.class.getResource("departureInformation.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                DepartureInformationController departureInformationController = loader.getController();
                departureInformationController.initData(id, departureAndForm.getIddeparture(), "Підтверджено");

                Parent root = loader.getRoot();
                Stage stage= new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            }
        });
        tableviewavavailableingdeparture.setOnMouseClicked(event -> {
            if (event.getClickCount() > 1) {
                DepartureAndForm departureAndForm = tableviewavavailableingdeparture.getSelectionModel().getSelectedItem();
                //System.out.println(departureAndForm.getIddeparture());
                FXMLLoader loader = new FXMLLoader() ;
                loader.setLocation(SystemControllerForClient.class.getResource("departureInformation.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                DepartureInformationController departureInformationController = loader.getController();
                departureInformationController.initData(id, departureAndForm.getIddeparture(), "Доступні");

                Parent root = loader.getRoot();
                Stage stage= new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            }
        });
    }

    private void savePersonalData() {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        databaseHandler.updatePersonalData(id, Const.PERSONAL_DATA_LOGIN, loginField.getText());
        databaseHandler.updatePersonalData(id, Const.PERSONAL_DATA_PASSWORD, passwordField.getText());
        databaseHandler.updatePersonalData(id, Const.PERSONAL_DATA_FIRST_NAME, firstNameField.getText());
        databaseHandler.updatePersonalData(id, Const.PERSONAL_DATA_LAST_NAME, lastNameField.getText());
        databaseHandler.updatePersonalData(id, Const.PERSONAL_DATA_PHONE, phoneField.getText());
        databaseHandler.updatePersonalData(id, Const.PERSONAL_DATA_EMAIL, emailField.getText());
        databaseHandler.updateCar(idCarGlobal, Const.CAR_TYPE, typeCarField.getText());
        databaseHandler.updateCar(idCarGlobal, Const.CAR_BRAND, brandCarField.getText());
        databaseHandler.updateCar(idCarGlobal, Const.CAR_NUMBER, numberCarField.getText());
        databaseHandler.updateCar(idCarGlobal, Const.CAR_COLOR, colorCarField.getText());
        login = loginField.getText();
        password = passwordField.getText();
        setPersonalCarrierData();
    }

    public void initData(String login_, String password_){
        login = login_;
        password = password_;
        loginField.setText(login);
        passwordField.setText(password);
        DatabaseHandler databaseHandler = new DatabaseHandler();
        Carrier carrier = new Carrier();
        PersonalData personalData = new PersonalData();
        personalData.setLogin(login);
        personalData.setPassword(password);
        carrier.setPersonalData(personalData);
        ResultSet resultSetLoginAndPassword = databaseHandler.getCarrier(carrier);
        try {
            while (resultSetLoginAndPassword.next()){
                id = resultSetLoginAndPassword.getInt(1);
                firstName = resultSetLoginAndPassword.getString(4);
                lastName = resultSetLoginAndPassword.getString(5);
                phone = resultSetLoginAndPassword.getString(6);
                email = resultSetLoginAndPassword.getString(7);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        carrier.setIdCarrier(id);
        ResultSet resultSetIdCarrier = databaseHandler.getIdCarrier(carrier);
        int idTransportData = 0;
        try{
            while (resultSetIdCarrier.next()){
                idTransportData = resultSetIdCarrier.getInt(2);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        TransportData transportData = new TransportData();
        transportData.setIdTransportData(idTransportData);
        ResultSet resultSetTransportData = databaseHandler.getDataTransportData(transportData);
        int idCar = 0;
        try{
            while (resultSetTransportData.next()){
                idCar = resultSetTransportData.getInt(2);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        idCarGlobal = idCar;
        Car car = new Car();
        car.setIdCar(idCar);
        ResultSet resultSetCarData = databaseHandler.getCarData(car);
        try{
            while (resultSetCarData.next()){
                type = resultSetCarData.getString(2);
                brand = resultSetCarData.getString(3);
                color = resultSetCarData.getString(4);
                number = resultSetCarData.getString(5);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        setPersonalCarrierData();
        setConfirmDeparture();
        setAvailableDeparture();
        setArchiveDeparture();
    }

    private void setArchiveDeparture() {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        Departure departure = new Departure();
        departure.setStatusOfDeparture("Доставлено");
        Carrier carrier = new Carrier();
        carrier.setIdCarrier(id);
        departure.setCarrier(carrier);
        ResultSet resultSet = databaseHandler.getDepartureCarrier(departure);
        tableviewarchivedeparture.getItems().clear();
        columnnumberofarchivedeparture.setCellValueFactory(new PropertyValueFactory<>("iddeparture"));
        columnarchivefirstnamerecipient.setCellValueFactory(new PropertyValueFactory<>("firstNameRecipient"));
        columnarchivelastnamerecipient.setCellValueFactory(new PropertyValueFactory<>("lastNameRecipient"));
        columnarchiveshippingaddress.setCellValueFactory(new PropertyValueFactory<>("shippingAddress"));
        columnarchivereceivingaddress.setCellValueFactory(new PropertyValueFactory<>("receivingAddress"));
        columnarchivecostdeparture.setCellValueFactory(new PropertyValueFactory<>("costDeparture"));
        columnarchivecontentsdeparture.setCellValueFactory(new PropertyValueFactory<>("contentsShipping"));
        tableviewarchivedeparture.getColumns().clear();
        tableviewarchivedeparture.getColumns().addAll(columnnumberofarchivedeparture,columnarchivefirstnamerecipient,
                columnarchivelastnamerecipient,columnarchiveshippingaddress,columnarchivereceivingaddress,
                columnarchivecostdeparture, columnarchivecontentsdeparture);
        try {
            while (resultSet.next()){
                DepartureAndForm departureAndForm = new DepartureAndForm();
                departureAndForm.setIddeparture(resultSet.getInt(1));
                departureAndForm.setShippingAddress(resultSet.getString(7));
                departureAndForm.setReceivingAddress(resultSet.getString(8));
                departureAndForm.setCostDeparture(resultSet.getString(13));
                departureAndForm.setContentsShipping(resultSet.getString(15));
                PersonalData personalData = new PersonalData();
                personalData.setIdPersonalData(resultSet.getInt(6));
                ResultSet resultSet1 = databaseHandler.getIdPersonalData(personalData);
                while (resultSet1.next()){
                    departureAndForm.setFirstNameRecipient(resultSet1.getString(4));
                    departureAndForm.setLastNameRecipient(resultSet1.getString(5));
                }
                tableviewarchivedeparture.getItems().add(departureAndForm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setAvailableDeparture() {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        Departure departure = new Departure();
        departure.setStatusOfDeparture("Очікується");
        ResultSet resultSet = databaseHandler.getAvailableDepartureCarrier(departure);
        tableviewavavailableingdeparture.getItems().clear();
        columnnumberofavailabledeparture.setCellValueFactory(new PropertyValueFactory<>("iddeparture"));
        columnavailableshippingaddress.setCellValueFactory(new PropertyValueFactory<>("shippingAddress"));
        columnavailablereceivingaddress.setCellValueFactory(new PropertyValueFactory<>("receivingAddress"));
        columnavailablecostdeparture.setCellValueFactory(new PropertyValueFactory<>("costDeparture"));
        columnavailablecostpercel.setCellValueFactory(new PropertyValueFactory<>("costParcel"));
        tableviewavavailableingdeparture.getColumns().clear();
        tableviewavavailableingdeparture.getColumns().addAll(columnnumberofavailabledeparture,columnavailableshippingaddress,
                columnavailablereceivingaddress,columnavailablecostdeparture,columnavailablecostpercel);
        try {
            while (resultSet.next()){
                DepartureAndForm departureAndForm = new DepartureAndForm();
                departureAndForm.setIddeparture(resultSet.getInt(1));
                departureAndForm.setShippingAddress(resultSet.getString(7));
                departureAndForm.setReceivingAddress(resultSet.getString(8));
                departureAndForm.setCostDeparture(resultSet.getString(13));
                departureAndForm.setCostParcel(resultSet.getString(14));
                tableviewavavailableingdeparture.getItems().add(departureAndForm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setConfirmDeparture() {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        Departure departure = new Departure();
        departure.setStatusOfDeparture("Підтверджено");
        Carrier carrier = new Carrier();
        carrier.setIdCarrier(id);
        departure.setCarrier(carrier);
        ResultSet resultSet = databaseHandler.getDepartureCarrier(departure);
        tableviewconfirmingdeparture.getItems().clear();
        columnnumberofconfirmdeparture.setCellValueFactory(new PropertyValueFactory<>("iddeparture"));
        columnconfirmfirstnamerecipient.setCellValueFactory(new PropertyValueFactory<>("firstNameRecipient"));
        columnconfirmlastnamerecipient.setCellValueFactory(new PropertyValueFactory<>("lastNameRecipient"));
        columnconfirmshippingaddress.setCellValueFactory(new PropertyValueFactory<>("shippingAddress"));
        columnconfirmreceivingaddress.setCellValueFactory(new PropertyValueFactory<>("receivingAddress"));
        columnconfirmcostdeparture.setCellValueFactory(new PropertyValueFactory<>("costDeparture"));
        columnconfirmcontentsdeparture.setCellValueFactory(new PropertyValueFactory<>("contentsShipping"));
        tableviewconfirmingdeparture.getColumns().clear();
        tableviewconfirmingdeparture.getColumns().addAll(columnnumberofconfirmdeparture,columnconfirmfirstnamerecipient,
                columnconfirmlastnamerecipient,columnconfirmshippingaddress,columnconfirmreceivingaddress,
                columnconfirmcostdeparture, columnconfirmcontentsdeparture);
        try {
            while (resultSet.next()){
                DepartureAndForm departureAndForm = new DepartureAndForm();
                departureAndForm.setIddeparture(resultSet.getInt(1));
                departureAndForm.setShippingAddress(resultSet.getString(7));
                departureAndForm.setReceivingAddress(resultSet.getString(8));
                departureAndForm.setCostDeparture(resultSet.getString(13));
                departureAndForm.setContentsShipping(resultSet.getString(15));
                PersonalData personalData = new PersonalData();
                personalData.setIdPersonalData(resultSet.getInt(6));
                ResultSet resultSet1 = databaseHandler.getIdPersonalData(personalData);
                while (resultSet1.next()){
                    departureAndForm.setFirstNameRecipient(resultSet1.getString(4));
                    departureAndForm.setLastNameRecipient(resultSet1.getString(5));
                }
                tableviewconfirmingdeparture.getItems().add(departureAndForm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setPersonalCarrierData() {
        firstNameField.setText(firstName);
        lastNameField.setText(lastName);
        phoneField.setText(phone);
        emailField.setText(email);
        typeCarField.setText(type);
        brandCarField.setText(brand);
        colorCarField.setText(color);
        numberCarField.setText(number);
    }
}
