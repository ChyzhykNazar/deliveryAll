package sample;

import java.util.Vector;

public class Departure extends DatabaseHandler {
    private int idDeparture;
    private String statusOfDeparture;
    private Form form;
    private Carrier carrier;

    public Departure() {
    }

    public Departure(Form form) {
        this.form = form;
    }

    public int getIdDeparture() {
        return idDeparture;
    }

    public void setIdDeparture(int idDeparture) {
        this.idDeparture = idDeparture;
    }

    public String getStatusOfDeparture() {
        return statusOfDeparture;
    }

    public void setStatusOfDeparture(String statusOfDeparture) {
        this.statusOfDeparture = statusOfDeparture;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    /*public void viewDeparture(int idClient){
        Form form = new Form();
        //form = form.getFormFromDatabase(idClient);
        PersonalData personalDataForSender = new PersonalData();
        PersonalData personalDataForRecipient = new PersonalData();
        personalDataForSender = personalDataForSender.getPersonalDataSender(form);
        personalDataForRecipient = personalDataForRecipient.getPersonalDataRecipient(form);
        /*System.out.printf("%-20s%-20s%-20s%-20s%-30s%-30s%-10s%-10s%n","Прізвище","Ім'я","Прізвище","Ім'я","Місто відправлення","Місто отримання","Ціна","Дата");
        System.out.println("------------------------------------------------------------------------------------"+
                "-----------------------------------------------------------------------------");
        System.out.printf("%-20s%-20s%-20s%-20s%-30s%-30s%-10.2f%-10s%n",personalDataForSender.getLastName(),personalDataForSender.getFirstName(),
                personalDataForRecipient.getLastName(),personalDataForRecipient.getFirstName(),form.getCityOfDeparture(),
                form.getCityOfReceipt(),form.getCost(),form.getDateOfDeparture());*/
        /*String format = "%10s%n";
        System.out.printf(format , "Прізвище");
        System.out.printf (format, "Ім'я");
        System.out.printf(format , "Прізвище");
        System.out.printf (format, "Ім'я");
        System.out.printf(format , "Місто відправлення");
        System.out.printf (format, "Місто отримання");
        System.out.printf(format, "Ціна");
        System.out.println("Дата");
        System.out.printf(format, personalDataForSender.getLastName() + " ");
        System.out.printf(format, personalDataForSender.getFirstName() + " ");
        System.out.printf(format, personalDataForRecipient.getLastName() + " ");
        System.out.printf(format, personalDataForRecipient.getFirstName() + " ");
        System.out.printf(format, form.getCityOfDeparture() + " ");
        System.out.printf(format, form.getCityOfReceipt() + " ");
        System.out.printf(format, form.getCost() + " ");
        System.out.println(form.getDateOfDeparture());


        /*String selectFromPersonalDataForSender = "SELECT " + Const.ALL + " FROM " + Const.PERSONAL_DATA_TABLE + " WHERE " +
                Const.PERSONAL_DATA_ID_PERSONAL_DATA + " = " + String.valueOf(form.getIdSender());
        String selectFromPersonalDataForRecipient = "SELECT " + Const.ALL + " FROM " + Const.PERSONAL_DATA_TABLE + " WHERE " +
                Const.PERSONAL_DATA_ID_PERSONAL_DATA + " = " + String.valueOf(form.getIdRecipient());
        String firstNameSenderLocal = "";
        String lastNameSenderLocal = "";
        String firstNameRecipientLocal = "";
        String lastNameRecipientLocal = "";
        try {
            Statement statementForm = getDbConnection().createStatement();
            ResultSet resultSet = statementForm.executeQuery(selectFromPersonalDataForSender);
            while (resultSet.next())
            {
                firstNameSenderLocal = resultSet.getString(Const.PERSONAL_DATA_FIRST_NAME);
                lastNameSenderLocal = resultSet.getString(Const.PERSONAL_DATA_LAST_NAME);
            }
            personalDataForSender =new PersonalData(idFormLocal, idSenderLocal,idRecipientLocal,cityOfDepartureLocal,cityOfReceiptLocal,costLocal,dateOfDepartureLocal);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/

    /*public Vector<Departure> searchDepartureIdReceipt(int idClient, int idReceipt) {
        Vector<Departure> departureVector = new Vector<>();
        Departure departure = new Departure();
        Form[] forms = new Form[2];
        Form form1 = new Form();
        int i = 0;
        while (i < 2) {
            forms[i] = form1.getFormFromDatabase(idClient, i);
            i++;
        }
        i = 0;
        for (int j = 0; j < 2; j++) {
            if (forms[j].getIdRecipient() == idReceipt) {
                departure = new Departure(forms[j]);
                departureVector.add(departure);
                i++;
            }
        }
        System.out.printf("%-20s%-20s%-20s%-20s%-30s%-30s%-10s%-10s%n", "Прізвище", "Ім'я", "Прізвище", "Ім'я", "Місто відправлення", "Місто отримання", "Ціна", "Дата");
        for (int j = 0; j < i; j++) {
            Form form = new Form();
            //form = form.getFormFromDatabase(idClient);
            form = departureVector.get(j).getForm();
            PersonalData personalDataForSender = new PersonalData();
            PersonalData personalDataForRecipient = new PersonalData();
            personalDataForSender = personalDataForSender.getPersonalDataSender(form);
            personalDataForRecipient = personalDataForRecipient.getPersonalDataRecipient(form);
            System.out.println("------------------------------------------------------------------------------------" +
                    "-----------------------------------------------------------------------------");
            System.out.printf("%-20s%-20s%-20s%-20s%-30s%-30s%-10.2f%-10s%n", personalDataForSender.getLastName(), personalDataForSender.getFirstName(),
                    personalDataForRecipient.getLastName(), personalDataForRecipient.getFirstName(), form.getCityOfDeparture(),
                    form.getCityOfReceipt(), form.getCost(), form.getDateOfDeparture());
        }
        return departureVector;
    }*/
}