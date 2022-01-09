package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

import javax.xml.crypto.Data;

public class DepartureInformationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane backgroundAnchorPane;

    @FXML
    private AnchorPane informationAnchorPane;

    @FXML
    private Label firstNameSender;

    @FXML
    private Label lastNameSender;

    @FXML
    private Label numberSender;

    @FXML
    private Label firstNameRecipient;

    @FXML
    private Label lastNameRecipient;

    @FXML
    private Label numberRecipient;

    @FXML
    private Label shippingAddress;

    @FXML
    private Label receivingAddress;

    @FXML
    private Label lenght;

    @FXML
    private Label width;

    @FXML
    private Label heigth;

    @FXML
    private Label costDeparture;

    @FXML
    private Label costParcel;

    @FXML
    private Label contentsDeparture;

    @FXML
    private Label dateDeparture;

    @FXML
    private Label weight;

    @FXML
    private Label firstNameCarrier;

    @FXML
    private Label lastNameCarrier;

    @FXML
    private Label numberCarrier;

    @FXML
    private Label emailCarrier;

    @FXML
    private Label type;

    @FXML
    private Label brand;

    @FXML
    private Label color;

    @FXML
    private Label number;

    @FXML
    void initialize() {
    }

    public void initData(int idCarrier, int idDeparture, String typeInformation){
        switch (typeInformation){
            case "Архів": {
                information(idDeparture);
                break;
            }
            case "Підтверджено": {
                information(idDeparture);
                break;
            }
            case ("Очікують"):{
                waitingInformation(idDeparture);
                break;
            }
            case ("Прямують"):{
                directInformation(idDeparture);
                break;
            }
            case ("Доступні"):{
                availableInformation(idCarrier, idDeparture);
                break;
            }
        }
            
        
    }

    private void waitingInformation(int idDeparture) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        Departure departure = new Departure();
        Form form = new Form();
        departure.setIdDeparture(idDeparture);
        ResultSet resultSetDeparture = databaseHandler.getDeparture(departure);
        try {
            while (resultSetDeparture.next()){
                form.setIdForm(resultSetDeparture.getInt(4));
                PersonalData personalData = new PersonalData();
                personalData.setIdPersonalData(resultSetDeparture.getInt(5));
                ResultSet resultSetPersonalData = databaseHandler.getIdPersonalData(personalData);
                while (resultSetPersonalData.next()){
                    firstNameSender.setText(resultSetPersonalData.getString(4));
                    lastNameSender.setText(resultSetPersonalData.getString(5));
                    numberSender.setText(resultSetPersonalData.getString(6));
                }
                personalData.setIdPersonalData(resultSetDeparture.getInt(6));
                resultSetPersonalData = databaseHandler.getIdPersonalData(personalData);
                while (resultSetPersonalData.next()){
                    firstNameRecipient.setText(resultSetPersonalData.getString(4));
                    lastNameRecipient.setText(resultSetPersonalData.getString(5));
                    numberRecipient.setText(resultSetPersonalData.getString(6));
                }
                shippingAddress.setText(resultSetDeparture.getString(7));
                receivingAddress.setText(resultSetDeparture.getString(8));
                lenght.setText(resultSetDeparture.getString(9));
                width.setText(resultSetDeparture.getString(10));
                heigth.setText(resultSetDeparture.getString(11));
                weight.setText(resultSetDeparture.getString(12));
                costDeparture.setText(resultSetDeparture.getString(13));
                costParcel.setText(resultSetDeparture.getString(14));
                contentsDeparture.setText(resultSetDeparture.getString(15));
                dateDeparture.setText(resultSetDeparture.getString(16));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Button TTN = new Button("Накладна");
        TTN.setPrefWidth(214);
        TTN.setPrefHeight(36);
        TTN.setLayoutX(200);
        TTN.setLayoutY(450);
        TTN.setFont(Font.font ("Verdana Bold Italic", 15));
        TTN.setStyle("-fx-background-color: #FEBD69;");
        TTN.setTextFill(Paint.valueOf("WHITE"));
        TTN.setOnAction(actionEvent -> {
            workWithFile(idDeparture);
        });
        Button delete = new Button("Видалити");
        delete.setPrefWidth(214);
        delete.setPrefHeight(36);
        delete.setLayoutX(600);
        delete.setLayoutY(450);
        delete.setFont(Font.font ("Verdana Bold Italic", 15));
        delete.setStyle("-fx-background-color: #FEBD69;");
        delete.setTextFill(Paint.valueOf("WHITE"));
        delete.setOnAction(actionEvent -> {
            departure.setForm(form);
            databaseHandler.deleteDeparture(departure);
        });
        informationAnchorPane.getChildren().addAll(TTN, delete);
    }

    private void directInformation(int idDeparture) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        Departure departure = new Departure();
        departure.setIdDeparture(idDeparture);
        ResultSet resultSetDeparture = databaseHandler.getDeparture(departure);
        try {
            while (resultSetDeparture.next()){
                PersonalData personalData = new PersonalData();
                personalData.setIdPersonalData(resultSetDeparture.getInt(5));
                ResultSet resultSetPersonalData = databaseHandler.getIdPersonalData(personalData);
                while (resultSetPersonalData.next()){
                    firstNameSender.setText(resultSetPersonalData.getString(4));
                    lastNameSender.setText(resultSetPersonalData.getString(5));
                    numberSender.setText(resultSetPersonalData.getString(6));
                }
                personalData.setIdPersonalData(resultSetDeparture.getInt(6));
                resultSetPersonalData = databaseHandler.getIdPersonalData(personalData);
                while (resultSetPersonalData.next()){
                    firstNameRecipient.setText(resultSetPersonalData.getString(4));
                    lastNameRecipient.setText(resultSetPersonalData.getString(5));
                    numberRecipient.setText(resultSetPersonalData.getString(6));
                }
                personalData.setIdPersonalData(resultSetDeparture.getInt(2));
                resultSetPersonalData = databaseHandler.getIdPersonalData(personalData);
                while (resultSetPersonalData.next()){
                    firstNameCarrier.setText(resultSetPersonalData.getString(4));
                    lastNameCarrier.setText(resultSetPersonalData.getString(5));
                    numberCarrier.setText(resultSetPersonalData.getString(6));
                    emailCarrier.setText(resultSetPersonalData.getString(7));
                }
                Carrier carrier = new Carrier();
                carrier.setIdCarrier(resultSetDeparture.getInt(2));
                ResultSet resultSetIdCarrier = databaseHandler.getIdCarrier(carrier);
                int idTransportData = 0;
                while (resultSetIdCarrier.next()){
                    idTransportData = resultSetIdCarrier.getInt(2);
                }
                TransportData transportData = new TransportData();
                transportData.setIdTransportData(idTransportData);
                ResultSet resultSetTransportData = databaseHandler.getDataTransportData(transportData);
                int idCar = 0;
                while (resultSetTransportData.next()){
                    idCar = resultSetTransportData.getInt(2);
                }
                Car car = new Car();
                car.setIdCar(idCar);
                ResultSet resultSetCarData = databaseHandler.getCarData(car);
                try{
                    while (resultSetCarData.next()){
                        type.setText(resultSetCarData.getString(2));
                        brand.setText(resultSetCarData.getString(3));
                        color.setText(resultSetCarData.getString(4));
                        number.setText(resultSetCarData.getString(5));
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
                shippingAddress.setText(resultSetDeparture.getString(7));
                receivingAddress.setText(resultSetDeparture.getString(8));
                lenght.setText(resultSetDeparture.getString(9));
                width.setText(resultSetDeparture.getString(10));
                heigth.setText(resultSetDeparture.getString(11));
                weight.setText(resultSetDeparture.getString(12));
                costDeparture.setText(resultSetDeparture.getString(13));
                costParcel.setText(resultSetDeparture.getString(14));
                contentsDeparture.setText(resultSetDeparture.getString(15));
                dateDeparture.setText(resultSetDeparture.getString(16));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Button TTN = new Button("Накладна");
        TTN.setPrefWidth(214);
        TTN.setPrefHeight(36);
        TTN.setLayoutX(200);
        TTN.setLayoutY(450);
        TTN.setFont(Font.font ("Verdana Bold Italic", 15));
        TTN.setStyle("-fx-background-color: #FEBD69;");
        TTN.setTextFill(Paint.valueOf("WHITE"));
        TTN.setOnAction(actionEvent -> {
            workWithFile(idDeparture);
        });
        Button accept = new Button("Підтвердити отримання");
        accept.setPrefWidth(214);
        accept.setPrefHeight(36);
        accept.setLayoutX(600);
        accept.setLayoutY(450);
        accept.setFont(Font.font ("Verdana Bold Italic", 15));
        accept.setStyle("-fx-background-color: #FEBD69;");
        accept.setTextFill(Paint.valueOf("WHITE"));
        accept.setOnAction(actionEvent -> {
            databaseHandler.updateDeparture(departure, "Доставлено");
        });
        informationAnchorPane.getChildren().addAll(TTN, accept);
    }

    private void availableInformation(int idCarrier, int idDeparture) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        Departure departure = new Departure();
        Form form = new Form();
        departure.setIdDeparture(idDeparture);
        ResultSet resultSetDeparture = databaseHandler.getDeparture(departure);
        try {
            while (resultSetDeparture.next()){
                form.setIdForm(resultSetDeparture.getInt(4));
                PersonalData personalData = new PersonalData();
                personalData.setIdPersonalData(resultSetDeparture.getInt(5));
                ResultSet resultSetPersonalData = databaseHandler.getIdPersonalData(personalData);
                while (resultSetPersonalData.next()){
                    firstNameSender.setText(resultSetPersonalData.getString(4));
                    lastNameSender.setText(resultSetPersonalData.getString(5));
                    numberSender.setText(resultSetPersonalData.getString(6));
                }
                personalData.setIdPersonalData(resultSetDeparture.getInt(6));
                resultSetPersonalData = databaseHandler.getIdPersonalData(personalData);
                while (resultSetPersonalData.next()){
                    firstNameRecipient.setText(resultSetPersonalData.getString(4));
                    lastNameRecipient.setText(resultSetPersonalData.getString(5));
                    numberRecipient.setText(resultSetPersonalData.getString(6));
                }
                shippingAddress.setText(resultSetDeparture.getString(7));
                receivingAddress.setText(resultSetDeparture.getString(8));
                lenght.setText(resultSetDeparture.getString(9));
                width.setText(resultSetDeparture.getString(10));
                heigth.setText(resultSetDeparture.getString(11));
                weight.setText(resultSetDeparture.getString(12));
                costDeparture.setText(resultSetDeparture.getString(13));
                costParcel.setText(resultSetDeparture.getString(14));
                contentsDeparture.setText(resultSetDeparture.getString(15));
                dateDeparture.setText(resultSetDeparture.getString(16));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Button accept = new Button("Підтвердити");
        accept.setPrefWidth(214);
        accept.setPrefHeight(36);
        accept.setLayoutX(600);
        accept.setLayoutY(450);
        accept.setFont(Font.font ("Verdana Bold Italic", 15));
        accept.setStyle("-fx-background-color: #FEBD69;");
        accept.setTextFill(Paint.valueOf("WHITE"));
        accept.setOnAction(actionEvent -> {
            databaseHandler.updateDeparture(departure, idCarrier, "Підтверджено");
        });
        informationAnchorPane.getChildren().addAll(accept);
    }

    private void information(int idDeparture) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        Departure departure = new Departure();
        departure.setIdDeparture(idDeparture);
        ResultSet resultSetDeparture = databaseHandler.getDeparture(departure);
        try {
            while (resultSetDeparture.next()){
                PersonalData personalData = new PersonalData();
                personalData.setIdPersonalData(resultSetDeparture.getInt(5));
                ResultSet resultSetPersonalData = databaseHandler.getIdPersonalData(personalData);
                while (resultSetPersonalData.next()){
                    firstNameSender.setText(resultSetPersonalData.getString(4));
                    lastNameSender.setText(resultSetPersonalData.getString(5));
                    numberSender.setText(resultSetPersonalData.getString(6));
                }
                personalData.setIdPersonalData(resultSetDeparture.getInt(6));
                resultSetPersonalData = databaseHandler.getIdPersonalData(personalData);
                while (resultSetPersonalData.next()){
                    firstNameRecipient.setText(resultSetPersonalData.getString(4));
                    lastNameRecipient.setText(resultSetPersonalData.getString(5));
                    numberRecipient.setText(resultSetPersonalData.getString(6));
                }
                personalData.setIdPersonalData(resultSetDeparture.getInt(2));
                resultSetPersonalData = databaseHandler.getIdPersonalData(personalData);
                while (resultSetPersonalData.next()){
                    firstNameCarrier.setText(resultSetPersonalData.getString(4));
                    lastNameCarrier.setText(resultSetPersonalData.getString(5));
                    numberCarrier.setText(resultSetPersonalData.getString(6));
                    emailCarrier.setText(resultSetPersonalData.getString(7));
                }
                Carrier carrier = new Carrier();
                carrier.setIdCarrier(resultSetDeparture.getInt(2));
                ResultSet resultSetIdCarrier = databaseHandler.getIdCarrier(carrier);
                int idTransportData = 0;
                while (resultSetIdCarrier.next()){
                    idTransportData = resultSetIdCarrier.getInt(2);
                }
                TransportData transportData = new TransportData();
                transportData.setIdTransportData(idTransportData);
                ResultSet resultSetTransportData = databaseHandler.getDataTransportData(transportData);
                int idCar = 0;
                while (resultSetTransportData.next()){
                    idCar = resultSetTransportData.getInt(2);
                }
                Car car = new Car();
                car.setIdCar(idCar);
                ResultSet resultSetCarData = databaseHandler.getCarData(car);
                try{
                    while (resultSetCarData.next()){
                        type.setText(resultSetCarData.getString(2));
                        brand.setText(resultSetCarData.getString(3));
                        color.setText(resultSetCarData.getString(4));
                        number.setText(resultSetCarData.getString(5));
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
                shippingAddress.setText(resultSetDeparture.getString(7));
                receivingAddress.setText(resultSetDeparture.getString(8));
                lenght.setText(resultSetDeparture.getString(9));
                width.setText(resultSetDeparture.getString(10));
                heigth.setText(resultSetDeparture.getString(11));
                weight.setText(resultSetDeparture.getString(12));
                costDeparture.setText(resultSetDeparture.getString(13));
                costParcel.setText(resultSetDeparture.getString(14));
                contentsDeparture.setText(resultSetDeparture.getString(15));
                dateDeparture.setText(resultSetDeparture.getString(16));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Button TTN = new Button("Накладна");
        TTN.setPrefWidth(214);
        TTN.setPrefHeight(36);
        TTN.setLayoutX(200);
        TTN.setLayoutY(450);
        TTN.setFont(Font.font ("Verdana Bold Italic", 15));
        TTN.setStyle("-fx-background-color: #FEBD69;");
        TTN.setTextFill(Paint.valueOf("WHITE"));
        TTN.setOnAction(actionEvent -> {
            workWithFile(idDeparture);
        });
        informationAnchorPane.getChildren().add(TTN);
    }

    private void workWithFile(int idDeparture) {
        try (FileInputStream fileInputStream = new FileInputStream("C:/Users/HP/Documents/GitHub/deliveryAll/TTN.docx")) {
            XWPFDocument docxFile = new XWPFDocument(OPCPackage.open(fileInputStream));
            System.out.println("_____________________________________");
            XWPFWordExtractor extractor = new XWPFWordExtractor(docxFile);
            System.out.println(extractor.getText());

            for (XWPFParagraph p : docxFile.getParagraphs()) {
                List<XWPFRun> runs = p.getRuns();
                if (runs != null) {
                    for (XWPFRun r : runs) {
                        String text = r.getText(0);
                        if (text != null && text.contains("НомерВідправлення")) {
                            text = text.replace("НомерВідправлення", String.valueOf(idDeparture));
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("ДатаВідправлення")) {
                            text = text.replace("ДатаВідправлення", dateDeparture.getText());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("Машина")) {
                            text = text.replace("Машина", brand.getText() + ", " + color.getText());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("Дані")) {
                            text = text.replace("Дані", firstNameCarrier.getText() + " " + lastNameCarrier.getText());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("Відправник")) {
                            text = text.replace("Відправник", firstNameSender.getText() + " " + lastNameSender.getText());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("Одержувач")) {
                            text = text.replace("Одержувач", firstNameRecipient.getText() + " " + lastNameRecipient.getText());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("АдресВідправлення")) {
                            text = text.replace("АдресВідправлення", shippingAddress.getText());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("АдресОтримання")) {
                            text = text.replace("АдресОтримання", receivingAddress.getText());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("ВагаВідправлення")) {
                            text = text.replace("ВагаВідправлення", weight.getText());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("ВартістьВідправлення")) {
                            text = text.replace("ВартістьВідправлення", costParcel.getText());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("ВартістьДоставки")) {
                            text = text.replace("ВартістьДоставки", costDeparture.getText());
                            r.setText(text, 0);
                        }
                        if (text != null && text.contains("ВмістВідправлення")) {
                            text = text.replace("ВмістВідправлення", contentsDeparture.getText());
                            r.setText(text, 0);
                        }
                    }
                }
            }
            docxFile.write(new FileOutputStream("Накладна відправлення № " + idDeparture + " " + dateDeparture.getText() + ".docx"));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
