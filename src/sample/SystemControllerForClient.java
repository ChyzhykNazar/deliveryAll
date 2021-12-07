package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SystemControllerForClient {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane backgroundAnchorPane;

    @FXML
    private Tab tabCurrentDeparture;

    @FXML
    private AnchorPane anchorPaneCurrentDeparture;

    @FXML
    private ListView<?> listviewCurrentDeparture;

    @FXML
    private Tab tabArchiveDeparture;

    @FXML
    private AnchorPane anchorPaneArchiveDeparture;

    @FXML
    private ListView<?> listViewArchiveDeparture;

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
    private TextField lenghtField;

    @FXML
    private TextField costDepartureField;

    @FXML
    private TextField costParcelField;

    @FXML
    private TextField heightField;

    @FXML
    private TextField dateShppingField;

    @FXML
    private TextField lastNameSenderField;

    @FXML
    private TextField widthField;

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

    }
}