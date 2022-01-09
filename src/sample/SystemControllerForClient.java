package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SystemControllerForClient extends DatabaseHandler{

    @FXML
    private AnchorPane backgroundAnchorPane;

    @FXML
    private Button refreshButton;

    @FXML
    private Button exitButton;

    @FXML
    private Tab tabCurrentDeparture;

    @FXML
    private AnchorPane anchorPaneCurrentDeparture;

    @FXML
    private TableView<DepartureAndForm> tableviewwaitingdeparture;

    @FXML
    private TableColumn<DepartureAndForm, Integer> columnnumberofwaitdeparture;

    @FXML
    private TableColumn<DepartureAndForm, String> columnwaitfirstnamesender;

    @FXML
    private TableColumn<DepartureAndForm, String> columnwaitlastnamesender;

    @FXML
    private TableColumn<DepartureAndForm, String> columnwaitfirstnamerecipient;

    @FXML
    private TableColumn<DepartureAndForm, String> columnwaitlastnamerecipient;

    @FXML
    private Tab tabConfirmDeparture;

    @FXML
    private AnchorPane anchorPaneConfirmDeparture;

    @FXML
    private TableView<DepartureAndForm> tableviewconfirmingdeparture;

    @FXML
    private TableColumn<DepartureAndForm, Integer> columnnumberofconfirmdeparture;

    @FXML
    private TableColumn<DepartureAndForm, String> columnconfirmfirstnamesender;

    @FXML
    private TableColumn<DepartureAndForm, String> columnconfirmlastnamesender;

    @FXML
    private TableColumn<DepartureAndForm, String> columnconfirmfirstnamerecipient;

    @FXML
    private TableColumn<DepartureAndForm, String> columnconfirmlastnamerecipient;

    @FXML
    private TableColumn<DepartureAndForm, String> columnconfirmfirstnamecarrier;

    @FXML
    private TableColumn<DepartureAndForm, String> columnconfirmlastnamecarrier;

    @FXML
    private Tab tabArchiveDeparture;

    @FXML
    private AnchorPane anchorPaneArchiveDeparture;

    @FXML
    private TableView<DepartureAndForm> tableviewarchivingdeparture;

    @FXML
    private TableColumn<DepartureAndForm, Integer> columnnumberofarchivedeparture;

    @FXML
    private TableColumn<DepartureAndForm, String> columnarchivefirstnamesender;

    @FXML
    private TableColumn<DepartureAndForm, String> columnarchivelastnamesender;

    @FXML
    private TableColumn<DepartureAndForm, String> columnarchivefirstnamerecipient;

    @FXML
    private TableColumn<DepartureAndForm, String> columnarchivelastnamerecipient;

    @FXML
    private TableColumn<DepartureAndForm, String> columnarchivefirstnamecarrier;

    @FXML
    private TableColumn<DepartureAndForm, String> columnarchivelastnamecarrier;

    @FXML
    private Tab tabDirectDeparture;

    @FXML
    private AnchorPane anchorPaneDirectDeparture;

    @FXML
    private TableView<DepartureAndForm> tableviewdirectdeparture;

    @FXML
    private TableColumn<DepartureAndForm, Integer> columnnumberofdirectdeparture;

    @FXML
    private TableColumn<DepartureAndForm, String> columndirectfirstnamesender;

    @FXML
    private TableColumn<DepartureAndForm, String> columndirectlastnamesender;

    @FXML
    private TableColumn<DepartureAndForm, String> columndirectfirstnamerecipient;

    @FXML
    private TableColumn<DepartureAndForm, String> columndirectlastnamerecipient;

    @FXML
    private TableColumn<DepartureAndForm, String> columndirectfirstnamecarrier;

    @FXML
    private TableColumn<DepartureAndForm, String> columndirectlastnamecarrier;

    @FXML
    private Button confirmDeparture;

    @FXML
    private TextField firstNameSenderField;

    @FXML
    private TextField lastNameRecipientField;

    @FXML
    private TextField shippingAdressField;

    @FXML
    private TextField firstNameRecipientField;

    @FXML
    private TextField receivingAddressField;

    @FXML
    private TextField lengthField;

    @FXML
    private TextField costDepartureField;

    @FXML
    private TextField costParcelField;

    @FXML
    private TextField heightField;

    @FXML
    private TextField phoneRecipientField;

    @FXML
    private TextField lastNameSenderField;

    @FXML
    private TextField widthField;

    @FXML
    private TextField weightField;

    @FXML
    private TextField contentShippingField;

    @FXML
    private Button changePersonalDataButton;

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

    int id;

    String login;

    String password;

    String firstName;

    String lastName;

    String phone;

    String email;

    @FXML
    void initialize() {
        confirmDeparture.setOnAction(actionEvent -> {
            confirmDepartureVoid();
        });
        refreshButton.setOnAction(actionEvent -> {
            setPersonalClientData();
            setWaitingDeparture();
            setConfirmDeparture();
            setArchiveDeparture();
            setDirectDeparture();
        });
        changePersonalDataButton.setOnAction(actionEvent -> {
            changePersonalData();
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
        tableviewarchivingdeparture.setOnMouseClicked(event -> {
            if (event.getClickCount() > 1) {
                DepartureAndForm departureAndForm = tableviewarchivingdeparture.getSelectionModel().getSelectedItem();
                //System.out.println(departureAndForm.getIddeparture());
                FXMLLoader loader = new FXMLLoader() ;
                loader.setLocation(SystemControllerForClient.class.getResource("departureInformation.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                DepartureInformationController departureInformationController = loader.getController();
                departureInformationController.initData(0, departureAndForm.getIddeparture(), "Архів");

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
                departureInformationController.initData(0, departureAndForm.getIddeparture(), "Підтверджено");

                Parent root = loader.getRoot();
                Stage stage= new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            }
        });
        tableviewwaitingdeparture.setOnMouseClicked(event -> {
            if (event.getClickCount() > 1) {
                DepartureAndForm departureAndForm = tableviewwaitingdeparture.getSelectionModel().getSelectedItem();
                //System.out.println(departureAndForm.getIddeparture());
                FXMLLoader loader = new FXMLLoader() ;
                loader.setLocation(SystemControllerForClient.class.getResource("departureInformation.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                DepartureInformationController departureInformationController = loader.getController();
                departureInformationController.initData(0, departureAndForm.getIddeparture(), "Очікують");

                Parent root = loader.getRoot();
                Stage stage= new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            }
        });
        tableviewdirectdeparture.setOnMouseClicked(event -> {
            if (event.getClickCount() > 1) {
                DepartureAndForm departureAndForm = tableviewdirectdeparture.getSelectionModel().getSelectedItem();
                //System.out.println(departureAndForm.getIddeparture());
                FXMLLoader loader = new FXMLLoader() ;
                loader.setLocation(SystemControllerForClient.class.getResource("departureInformation.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                DepartureInformationController departureInformationController = loader.getController();
                departureInformationController.initData(0, departureAndForm.getIddeparture(), "Прямують");

                Parent root = loader.getRoot();
                Stage stage= new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            }
        });
    }

    private void changePersonalData() {
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
        updatePersonalData(localId, Const.PERSONAL_DATA_LOGIN, loginField.getText());
        updatePersonalData(localId, Const.PERSONAL_DATA_PASSWORD, passwordField.getText());
        updatePersonalData(localId, Const.PERSONAL_DATA_FIRST_NAME, firstNameField.getText());
        updatePersonalData(localId, Const.PERSONAL_DATA_LAST_NAME, lastNameField.getText());
        updatePersonalData(localId, Const.PERSONAL_DATA_PHONE, phoneField.getText());
        updatePersonalData(localId, Const.PERSONAL_DATA_EMAIL, emailField.getText());
        login = loginField.getText();
        password = passwordField.getText();
        firstName = firstNameField.getText();
        lastName = lastNameField.getText();
        phone =phoneField.getText();
        email = emailField.getText();
        setPersonalClientData();
    }

    private void confirmDepartureVoid() {
        String firstNameSender = firstNameSenderField.getText().trim();
        String lastNameSender = lastNameSenderField.getText().trim();
        String firstNameRecipient = firstNameRecipientField.getText().trim();
        String lastNameRecipient = lastNameRecipientField.getText().trim();
        String shippingAddress = shippingAdressField.getText().trim();
        String receivingAddress = receivingAddressField.getText().trim();
        String phoneRecipient = phoneRecipientField.getText().trim();
        String length = lengthField.getText().trim();
        String width = widthField.getText().trim();
        String height = heightField.getText().trim();
        String weight = weightField.getText().trim();
        String costDeparture = costDepartureField.getText().trim();
        String costParcel = costParcelField.getText().trim();
        String contentShipping = contentShippingField.getText().trim();
        DatabaseHandler databaseHandler = new DatabaseHandler();
        PersonalData personalData = new PersonalData();
        personalData.setPhone(phoneRecipient);
        ResultSet resultSetGetPersonalDataFromPhone = databaseHandler.getPhonePersonalData(personalData);
        int idRecipient = 0;
        try {
            if (resultSetGetPersonalDataFromPhone.next()) {
                idRecipient = resultSetGetPersonalDataFromPhone.getInt(1);
                int idFormLocal = getIdForm();
                addToFormData(idFormLocal, id, idRecipient, shippingAddress, receivingAddress, length, width,height, weight,
                        costDeparture, costParcel, contentShipping);
                addToDepartureData(idFormLocal, "Очікується");
            }else{
                if (!phoneRecipient.equals("") && !lastNameRecipient.equals("") && !firstNameRecipient.equals("")) {
                    String insert = "INSERT INTO " + Const.PERSONAL_DATA_TABLE + "( " + Const.PERSONAL_DATA_FIRST_NAME
                            + " , " + Const.PERSONAL_DATA_LAST_NAME + " , " + Const.PERSONAL_DATA_PHONE + " ) " + "VALUES(?,?,?)";
                    try {
                        PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
                        preparedStatement.setString(1, firstNameRecipient);
                        preparedStatement.setString(2, lastNameRecipient);
                        preparedStatement.setString(3, phoneRecipient);
                        preparedStatement.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                } else {
                    Alert Confirmation = new Alert(Alert.AlertType.ERROR);
                    Confirmation.setTitle("ERROR");
                    Confirmation.setContentText("Заповніть поле 'Ім'я отримувача', 'Прізвище отримувача', 'Телефон отримувача'");
                    Confirmation.setHeaderText("Помилка");
                    Confirmation.show();
                }
                PersonalData personalData1 = new PersonalData();
                personalData1.setPhone(phoneRecipient);
                ResultSet resultSet = getPhonePersonalData(personalData1);
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
                    }
                resultSetGetPersonalDataFromPhone = databaseHandler.getPhonePersonalData(personalData);
                while(resultSetGetPersonalDataFromPhone.next()){
                    idRecipient = resultSetGetPersonalDataFromPhone.getInt(1);
                }
                int idFormLocal = getIdForm();
                addToFormData(idFormLocal,id, idRecipient, shippingAddress, receivingAddress, length, width,height, weight,
                        costDeparture, costParcel, contentShipping);
                addToDepartureData(idFormLocal, "Очікується");
                }
            } catch(SQLException e){
                e.printStackTrace();
            }
    }

    private void addToDepartureData(int idFormLocal, String state) {
        String insert = "INSERT INTO " + Const.DEPARTURE_TABLE + "( " + Const.DEPARTURE_ID_FORM + " , " + Const.DEPARTURE_STATUS_OF_DEPARTURE + " ) "
                + "VALUES(?,?)";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setInt(1, idFormLocal);
            preparedStatement.setString(2, state);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void addToFormData(int idForm, int id, int idRecipient, String shippingAddress, String receivingAddress, String length,
                               String width, String height, String weight, String costDeparture,
                               String costParcel, String contentShipping) {
        String insert = "INSERT INTO " + Const.FORM_TABLE + "( " + Const.FORM_ID_FORM + " , " + Const.FORM_ID_SENDER +
                " , " + Const.FORM_ID_RECIPIENT + " , " + Const.FORM_SHIPPING_ADDRESS + " , " + Const.FORM_RECEIVING_ADDRESS +
                " , " + Const.FORM_LENGTH + " , " + Const.FORM_WIDTH + " , " + Const.FORM_HEIGHT + " , " + Const.FORM_WEIGHT + " , " +
                Const.FORM_COST_DEPARTURE + " , " + Const.FORM_COST_PARCEL + " , " + Const.FORM_CONTENT_SHIPPING + " , "
                + Const.FORM_DATE_SHIPPING + " ) " + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setInt(1, idForm);
            preparedStatement.setInt(2, id);
            preparedStatement.setInt(3, idRecipient);
            preparedStatement.setString(4, shippingAddress);
            preparedStatement.setString(5, receivingAddress);
            preparedStatement.setDouble(6, Double.parseDouble(length));
            preparedStatement.setDouble(7, Double.parseDouble(width));
            preparedStatement.setDouble(8, Double.parseDouble(height));
            preparedStatement.setDouble(9, Double.parseDouble(weight));
            preparedStatement.setDouble(10, Double.parseDouble(costDeparture));
            preparedStatement.setDouble(11, Double.parseDouble(costParcel));
            preparedStatement.setString(12, contentShipping);
            preparedStatement.setDate(13, Date.valueOf(java.time.LocalDate.now()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void initData(String login_, String password_){
        login = login_;
        password = password_;
        loginField.setText(login);
        passwordField.setText(password);
        DatabaseHandler databaseHandler = new DatabaseHandler();
        Client client = new Client();
        PersonalData personalData = new PersonalData();
        personalData.setLogin(login);
        personalData.setPassword(password);
        client.setPersonalData(personalData);
        ResultSet resultSetLoginAndPassword = databaseHandler.getClient(client);
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
        setPersonalClientData();
        setWaitingDeparture();
        setConfirmDeparture();
        setArchiveDeparture();
        setDirectDeparture();
    }

    private void setPersonalClientData(){
        firstNameField.setText(firstName);
        lastNameField.setText(lastName);
        phoneField.setText(phone);
        emailField.setText(email);
        firstNameSenderField.setText(firstName);
        lastNameSenderField.setText(lastName);
    }

    private void setWaitingDeparture(){
        DatabaseHandler databaseHandler = new DatabaseHandler();
        Departure departure = new Departure();
        Form form = new Form();
        departure.setStatusOfDeparture("Очікується");
        form.setIdSender(id);
        departure.setForm(form);
        ResultSet resultSet = databaseHandler.getDepartureSender(departure);
        tableviewwaitingdeparture.getItems().clear();
        columnnumberofwaitdeparture.setCellValueFactory(new PropertyValueFactory<>("iddeparture"));
        columnwaitfirstnamesender.setCellValueFactory(new PropertyValueFactory<>("firstNameSender"));
        columnwaitlastnamesender.setCellValueFactory(new PropertyValueFactory<>("firstNameSender"));
        columnwaitfirstnamerecipient.setCellValueFactory(new PropertyValueFactory<>("firstNameRecipient"));
        columnwaitlastnamerecipient.setCellValueFactory(new PropertyValueFactory<>("lastNameRecipient"));
        tableviewwaitingdeparture.getColumns().clear();
        tableviewwaitingdeparture.getColumns().addAll(columnnumberofwaitdeparture,columnwaitfirstnamesender,
                columnwaitlastnamesender,columnwaitfirstnamerecipient,columnwaitlastnamerecipient);
        /*tableviewwaitingdeparture.getColumns().add(columnwaitfirstnamesender);
        tableviewwaitingdeparture.getColumns().add(columnwaitlastnamesender);
        tableviewwaitingdeparture.getColumns().add(columnwaitfirstnamerecipient);
        tableviewwaitingdeparture.getColumns().add(columnwaitlastnamerecipient);*/
        try {
            while (resultSet.next()){
                DepartureAndForm departureAndForm = new DepartureAndForm();
                departureAndForm.setIddeparture(resultSet.getInt(1));
                departureAndForm.setFirstNameSender(firstName);
                departureAndForm.setLastNameSender(lastName);
                PersonalData personalData = new PersonalData();
                personalData.setIdPersonalData(resultSet.getInt(6));
                ResultSet resultSet1 = databaseHandler.getIdPersonalData(personalData);
                while (resultSet1.next()){
                    departureAndForm.setFirstNameRecipient(resultSet1.getString(4));
                    departureAndForm.setLastNameRecipient(resultSet1.getString(5));
                }
                tableviewwaitingdeparture.getItems().add(departureAndForm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setConfirmDeparture(){
        DatabaseHandler databaseHandler = new DatabaseHandler();
        Departure departure = new Departure();
        Form form = new Form();
        departure.setStatusOfDeparture("Підтверджено");
        form.setIdSender(id);
        departure.setForm(form);
        ResultSet resultSet = databaseHandler.getDepartureSender(departure);
        tableviewconfirmingdeparture.getItems().clear();
        columnnumberofconfirmdeparture.setCellValueFactory(new PropertyValueFactory<>("iddeparture"));
        columnconfirmfirstnamesender.setCellValueFactory(new PropertyValueFactory<>("firstNameSender"));
        columnconfirmlastnamesender.setCellValueFactory(new PropertyValueFactory<>("lastNameSender"));
        columnconfirmfirstnamerecipient.setCellValueFactory(new PropertyValueFactory<>("firstNameRecipient"));
        columnconfirmlastnamerecipient.setCellValueFactory(new PropertyValueFactory<>("lastNameRecipient"));
        columnconfirmfirstnamecarrier.setCellValueFactory(new PropertyValueFactory<>("firstNameCarrier"));
        columnconfirmlastnamecarrier.setCellValueFactory(new PropertyValueFactory<>("lastNameCarrier"));
        tableviewconfirmingdeparture.getColumns().clear();
        tableviewconfirmingdeparture.getColumns().addAll(columnnumberofconfirmdeparture,columnconfirmfirstnamesender,
                columnconfirmlastnamesender,columnconfirmfirstnamerecipient,columnconfirmlastnamerecipient,
                columnconfirmfirstnamecarrier, columnconfirmlastnamecarrier);
        /*tableviewconfirmingdeparture.getColumns().add(columnconfirmfirstnamesender);
        tableviewconfirmingdeparture.getColumns().add(columnconfirmlastnamesender);
        tableviewconfirmingdeparture.getColumns().add(columnconfirmfirstnamerecipient);
        tableviewconfirmingdeparture.getColumns().add(columnconfirmlastnamerecipient);
        tableviewconfirmingdeparture.getColumns().add(columnconfirmfirstnamecarrier);
        tableviewconfirmingdeparture.getColumns().add(columnconfirmlastnamecarrier);*/
        try {
            while (resultSet.next()){
                DepartureAndForm departureAndForm = new DepartureAndForm();
                departureAndForm.setIddeparture(resultSet.getInt(1));
                departureAndForm.setFirstNameSender(firstName);
                departureAndForm.setLastNameSender(lastName);
                PersonalData personalData = new PersonalData();
                personalData.setIdPersonalData(resultSet.getInt(6));
                ResultSet resultSet1 = databaseHandler.getIdPersonalData(personalData);
                while (resultSet1.next()){
                    departureAndForm.setFirstNameRecipient(resultSet1.getString(4));
                    departureAndForm.setLastNameRecipient(resultSet1.getString(5));
                }
                personalData.setIdPersonalData(resultSet.getInt(2));
                resultSet1 = databaseHandler.getIdPersonalData(personalData);
                while (resultSet1.next()){
                    departureAndForm.setFirstNameCarrier(resultSet1.getString(4));
                    departureAndForm.setLastNameCarrier(resultSet1.getString(5));
                }
                tableviewconfirmingdeparture.getItems().add(departureAndForm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void setArchiveDeparture(){
        DatabaseHandler databaseHandler = new DatabaseHandler();
        Departure departure = new Departure();
        Form form = new Form();
        departure.setStatusOfDeparture("Доставлено");
        form.setIdSender(id);
        departure.setForm(form);
        ResultSet resultSet = databaseHandler.getDepartureSender(departure);
        tableviewarchivingdeparture.getItems().clear();
        columnnumberofarchivedeparture.setCellValueFactory(new PropertyValueFactory<>("iddeparture"));
        columnarchivefirstnamesender.setCellValueFactory(new PropertyValueFactory<>("firstNameSender"));
        columnarchivelastnamesender.setCellValueFactory(new PropertyValueFactory<>("lastNameSender"));
        columnarchivefirstnamerecipient.setCellValueFactory(new PropertyValueFactory<>("firstNameRecipient"));
        columnarchivelastnamerecipient.setCellValueFactory(new PropertyValueFactory<>("lastNameRecipient"));
        columnarchivefirstnamecarrier.setCellValueFactory(new PropertyValueFactory<>("firstNameCarrier"));
        columnarchivelastnamecarrier.setCellValueFactory(new PropertyValueFactory<>("lastNameCarrier"));
        tableviewarchivingdeparture.getColumns().clear();
        tableviewarchivingdeparture.getColumns().addAll(columnnumberofarchivedeparture,columnarchivefirstnamesender,
                columnarchivelastnamesender,columnarchivefirstnamerecipient,columnarchivelastnamerecipient,
                columnarchivefirstnamecarrier, columnarchivelastnamecarrier);
        try {
            while (resultSet.next()){
                DepartureAndForm departureAndForm = new DepartureAndForm();
                departureAndForm.setIddeparture(resultSet.getInt(1));
                departureAndForm.setFirstNameSender(firstName);
                departureAndForm.setLastNameSender(lastName);
                PersonalData personalData = new PersonalData();
                personalData.setIdPersonalData(resultSet.getInt(6));
                ResultSet resultSet1 = databaseHandler.getIdPersonalData(personalData);
                while (resultSet1.next()){
                    departureAndForm.setFirstNameRecipient(resultSet1.getString(4));
                    departureAndForm.setLastNameRecipient(resultSet1.getString(5));
                }
                personalData.setIdPersonalData(resultSet.getInt(2));
                resultSet1 = databaseHandler.getIdPersonalData(personalData);
                while (resultSet1.next()){
                    departureAndForm.setFirstNameCarrier(resultSet1.getString(4));
                    departureAndForm.setLastNameCarrier(resultSet1.getString(5));
                }
                tableviewarchivingdeparture.getItems().add(departureAndForm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        form.setIdRecipient(id);
        departure.setForm(form);
        resultSet = databaseHandler.getDepartureRecipient(departure);
        try {
            while (resultSet.next()){
                DepartureAndForm departureAndForm = new DepartureAndForm();
                departureAndForm.setIddeparture(resultSet.getInt(1));
                departureAndForm.setFirstNameRecipient(firstName);
                departureAndForm.setLastNameRecipient(lastName);
                PersonalData personalData = new PersonalData();
                personalData.setIdPersonalData(resultSet.getInt(5));
                ResultSet resultSet1 = databaseHandler.getIdPersonalData(personalData);
                while (resultSet1.next()){
                    departureAndForm.setFirstNameSender(resultSet1.getString(4));
                    departureAndForm.setLastNameSender(resultSet1.getString(5));
                }
                personalData.setIdPersonalData(resultSet.getInt(2));
                resultSet1 = databaseHandler.getIdPersonalData(personalData);
                while (resultSet1.next()){
                    departureAndForm.setFirstNameCarrier(resultSet1.getString(4));
                    departureAndForm.setLastNameCarrier(resultSet1.getString(5));
                }
                tableviewarchivingdeparture.getItems().add(departureAndForm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void setDirectDeparture(){
        DatabaseHandler databaseHandler = new DatabaseHandler();
        Departure departure = new Departure();
        Form form = new Form();
        departure.setStatusOfDeparture("Підтверджено");
        form.setIdRecipient(id);
        departure.setForm(form);
        ResultSet resultSet = databaseHandler.getDepartureRecipient(departure);
        tableviewdirectdeparture.getItems().clear();
        columnnumberofdirectdeparture.setCellValueFactory(new PropertyValueFactory<>("iddeparture"));
        columndirectfirstnamesender.setCellValueFactory(new PropertyValueFactory<>("firstNameSender"));
        columndirectlastnamesender.setCellValueFactory(new PropertyValueFactory<>("lastNameSender"));
        columndirectfirstnamerecipient.setCellValueFactory(new PropertyValueFactory<>("firstNameRecipient"));
        columndirectlastnamerecipient.setCellValueFactory(new PropertyValueFactory<>("lastNameRecipient"));
        columndirectfirstnamecarrier.setCellValueFactory(new PropertyValueFactory<>("firstNameCarrier"));
        columndirectlastnamecarrier.setCellValueFactory(new PropertyValueFactory<>("lastNameCarrier"));
        tableviewdirectdeparture.getColumns().clear();
        tableviewdirectdeparture.getColumns().addAll(columnnumberofdirectdeparture,columndirectfirstnamesender,
                columndirectlastnamesender,columndirectfirstnamerecipient,columndirectlastnamerecipient,
                columndirectfirstnamecarrier, columndirectlastnamecarrier);
        try {
            while (resultSet.next()){
                DepartureAndForm departureAndForm = new DepartureAndForm();
                departureAndForm.setIddeparture(resultSet.getInt(1));
                departureAndForm.setFirstNameRecipient(firstName);
                departureAndForm.setLastNameRecipient(lastName);
                PersonalData personalData = new PersonalData();
                personalData.setIdPersonalData(resultSet.getInt(5));
                ResultSet resultSet1 = databaseHandler.getIdPersonalData(personalData);
                while (resultSet1.next()){
                    departureAndForm.setFirstNameSender(resultSet1.getString(4));
                    departureAndForm.setLastNameSender(resultSet1.getString(5));
                }
                personalData.setIdPersonalData(resultSet.getInt(2));
                resultSet1 = databaseHandler.getIdPersonalData(personalData);
                while (resultSet1.next()){
                    departureAndForm.setFirstNameCarrier(resultSet1.getString(4));
                    departureAndForm.setLastNameCarrier(resultSet1.getString(5));
                }
                tableviewdirectdeparture.getItems().add(departureAndForm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}