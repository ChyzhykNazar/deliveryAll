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

public class SystemControllerForCarrier {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane backgroundAnchorPane;

    @FXML
    private Tab tabConfirmDeparture;

    @FXML
    private AnchorPane anchorPaneConfirmDeparture;

    @FXML
    private ListView<?> listviewConfirmDeparture;

    @FXML
    private Tab tabAvailableShipments;

    @FXML
    private AnchorPane anchorPaneAvailableShipments;

    @FXML
    private ListView<?> listViewAvailableShipments;

    @FXML
    private Tab tabArchiveDeparture;

    @FXML
    private AnchorPane anchorPaneArchiveDeparture;

    @FXML
    private ListView<?> listViewArchiveDeparture;

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
    private TextField brandMotobikeField;

    @FXML
    private TextField numberMotobikeField;

    @FXML
    private TextField colorMotobikeField;

    @FXML
    private TextField colorBikeField;

    @FXML
    private Button signUpButton;

    @FXML
    void initialize() {


    }
}
