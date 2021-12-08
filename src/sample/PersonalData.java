package sample;

public class PersonalData {
    private int idPersonalData;
    private int login;
    private int password;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    public PersonalData(){}

    public PersonalData( String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getIdPersonalData() {
        return idPersonalData;
    }

    public int getLogin() { return login; }

    public int getPassword() { return password; }

    public String getFirstName() { return firstName; }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setIdPersonalData(int idPersonalData) {
        this.idPersonalData = idPersonalData;
    }

    public void setLogin(int login) { this.login = login; }

    public void setPassword(int password) { this.password = password; }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*public PersonalData getPersonalDataSender(Form form){
        PersonalData personalData = new PersonalData();
        String selectFromPersonalDataForSender = "SELECT " + Const.ALL + " FROM " + Const.PERSONAL_DATA_TABLE + " WHERE " +
                Const.PERSONAL_DATA_ID_PERSONAL_DATA + " = " + String.valueOf(form.getIdSender());
        String firstNameSenderLocal = "";
        String lastNameSenderLocal = "";
        try {
            Statement statementForm = getDbConnection().createStatement();
            ResultSet resultSet = statementForm.executeQuery(selectFromPersonalDataForSender);
            while (resultSet.next())
            {
                firstNameSenderLocal = resultSet.getString(Const.PERSONAL_DATA_FIRST_NAME);
                lastNameSenderLocal = resultSet.getString(Const.PERSONAL_DATA_LAST_NAME);
            }
            personalData =new PersonalData(firstNameSenderLocal, lastNameSenderLocal);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  personalData;
    }

    public PersonalData getPersonalDataRecipient(Form form){
        PersonalData personalData = null;
        String selectFromPersonalDataForRecipient = "SELECT " + Const.ALL + " FROM " + Const.PERSONAL_DATA_TABLE + " WHERE " +
                Const.PERSONAL_DATA_ID_PERSONAL_DATA + " = " + String.valueOf(form.getIdRecipient());
        String firstNameRecipientLocal = "";
        String lastNameRecipientLocal = "";
        try {
            Statement statementForm = getDbConnection().createStatement();
            ResultSet resultSet = statementForm.executeQuery(selectFromPersonalDataForRecipient);
            while (resultSet.next())
            {
                firstNameRecipientLocal = resultSet.getString(Const.PERSONAL_DATA_FIRST_NAME);
                lastNameRecipientLocal = resultSet.getString(Const.PERSONAL_DATA_LAST_NAME);
            }
            personalData =new PersonalData(firstNameRecipientLocal, lastNameRecipientLocal);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  personalData;
    }*/
}
