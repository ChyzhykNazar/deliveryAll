package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private AnchorPane backgroundAnchorPane;

    @FXML
    private Button carrierButton;

    @FXML
    private Button clientButton;


    @FXML
    void initialize() {
        carrierButton.setOnAction(actionEvent -> {
            carrierButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader() ;
            loader.setLocation(getClass().getResource("/sample/signInForCarrier.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader. getRoot () ;
            Stage stage= new Stage() ;
            stage. setScene(new Scene( root));
            stage.show();
        });

        clientButton.setOnAction(actionEvent -> {
            clientButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader() ;
            loader.setLocation(getClass().getResource("/sample/signInForClient.fxml"));
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
}