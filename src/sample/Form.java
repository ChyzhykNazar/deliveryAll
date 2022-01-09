package sample;

import java.sql.*;

public class Form {
    private int idForm;
    private int idSender;
    private int idRecipient;
    private PersonalData senderPersonalData;
    private PersonalData recipientPersonalData;
    private double length;
    private double width;
    private double height;
    private double weight;
    private String shippingAddress;
    private String receivingAddress;
    private double costDeparture;
    private double costParcel;
    private double contentsShipping;
    private Date dateOfDeparture;
    private Form[] forms;

    public Form(){}

    public Form(int idForm, int idSender, int idRecipient, PersonalData senderPersonalData,
                PersonalData recipientPersonalData, double size, double weight, String cityOfDeparture,
                String cityOfReceipt, double cost, Date dateOfDeparture){
        this.idForm = idForm;
        this.idSender = idSender;
        this.idRecipient = idRecipient;
        this.senderPersonalData = senderPersonalData;
        this.recipientPersonalData = recipientPersonalData;
        this.weight = weight;
        this.dateOfDeparture = dateOfDeparture;
    }

    public Form(int idForm, int idSender, int idRecipient, String cityOfDeparture,
                String cityOfReceipt, double cost, Date dateOfDeparture){
        this.idForm = idForm;
        this.idSender = idSender;
        this.idRecipient = idRecipient;
        this.dateOfDeparture = dateOfDeparture;
    }

    public int getIdForm() {
        return idForm;
    }

    public int getIdSender() {
        return idSender;
    }

    public int getIdRecipient() {
        return idRecipient;
    }

    public PersonalData getSenderPersonalData() {
        return senderPersonalData;
    }

    public PersonalData getRecipientPersonalData() {
        return recipientPersonalData;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public String getReceivingAddress() {
        return receivingAddress;
    }

    public double getCostParcel() {
        return costParcel;
    }

    public double getCostDeparture() {
        return costDeparture;
    }

    public double getContentsShipping() {
        return contentsShipping;
    }

    public Date getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setIdForm(int idForm) {
        this.idForm = idForm;
    }

    public void setIdSender(int idSender) {
        this.idSender = idSender;
    }

    public void setIdRecipient(int idRecipient) {
        this.idRecipient = idRecipient;
    }

    public void setSenderPersonalData(PersonalData senderPersonalData) {
        this.senderPersonalData = senderPersonalData;
    }

    public void setRecipientPersonalData(PersonalData recipientPersonalData) {
        this.recipientPersonalData = recipientPersonalData;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setCostDeparture(double costDeparture) {
        this.costDeparture = costDeparture;
    }

    public void setCostParcel(double costParcel) {
        this.costParcel = costParcel;
    }

    public void setReceivingAddress(String receivingAddress) {
        this.receivingAddress = receivingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setDateOfDeparture(Date dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public void setContentsShipping(double contentsShipping) { this.contentsShipping = contentsShipping; }

    public Form[] getForms() {
        return forms;
    }

    public void setForms(Form[] forms) {
        this.forms = forms;
    }

    /*public Form getFormFromDatabase(int idClient, int i){
        Form form = null;
        String selectFromForm = "SELECT " + Const.ALL + " FROM " + Const.FORM_TABLE + " WHERE " + Const.FORM_ID_SENDER + " = " + String.valueOf(idClient);
        //System.out.println(selectFromForm);
        int idFormLocal = 0;
        int idSenderLocal = 0;
        int idRecipientLocal = 0;
        String cityOfDepartureLocal = "";
        String cityOfReceiptLocal = "";
        double costLocal = 0;
        Date dateOfDepartureLocal = null;
        int iLocal = 0;
        try {
            Statement statementForm = getDbConnection().createStatement();
            ResultSet resultSet = statementForm.executeQuery(selectFromForm);
            while(iLocal < i){
                resultSet.next();
                iLocal++;
            }
            while (resultSet.next())
            {
                idFormLocal = resultSet.getInt(Const.FORM_ID_FORM);
                idSenderLocal = resultSet.getInt(Const.FORM_ID_SENDER);
                idRecipientLocal = resultSet.getInt(Const.FORM_ID_RECIPIENT);
                cityOfDepartureLocal = resultSet.getString(Const.FORM_CITY_OF_DEPARTURE);
                cityOfReceiptLocal = resultSet.getString(Const.FORM_CITY_OF_RECEIPT);
                costLocal = resultSet.getInt(Const.FORM_COST);
                dateOfDepartureLocal = resultSet.getDate(Const.FORM_DATE_OF_DEPARTURE);
                form = new Form(idFormLocal, idSenderLocal,idRecipientLocal,cityOfDepartureLocal,cityOfReceiptLocal,costLocal,dateOfDepartureLocal);
                return form;
                //i++;
                //return  form;
            }
            //form = new Form(idFormLocal, idSenderLocal,idRecipientLocal,cityOfDepartureLocal,cityOfReceiptLocal,costLocal,dateOfDepartureLocal);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return form;
    }*/

    /*public void getAllForm(int idClient){
        Form[] forms = new Form[10];
        Form form = new Form();
        int i = 0;
        do{
            form = form.getFormFromDatabase(1, i);
            forms[i] = form;
            i++;
        }while (form.getIdSender() == idClient);

        //return forms;
    }*/

    /*public Form[] getFormsFromDatabase(int idClient){
        Form[] forms = new Form[2];
        Form form = new Form();
        int i = 0;
        while (forms[i - 1] != null){
            //orm form = new Form();
            forms[i] = form.getFormFromDatabase(idClient, i);
            i++;
        }
        //assertNotNull(form);
        return forms;
    }*/

    /*public void checkCorrectData(int idSender, int idRecipient, PersonalData senderPersonalData, PersonalData recipientPersonalData,
                             double size, double weight, String cityOfDeparture, String cityOfReceipt, double cost, Date dateOfDeparture){

    }*/
}
