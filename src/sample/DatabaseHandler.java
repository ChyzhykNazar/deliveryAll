package sample;

import java.sql.*;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost  + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public ResultSet getClient(Client client){
        ResultSet resultSet = null;
        String select = "SELECT " + Const.ALL + " FROM " + Const.PERSONAL_DATA_TABLE + " WHERE " +
                Const.PERSONAL_DATA_LOGIN + " = '" + client.getPersonalData().getLogin() + "' AND " +
                Const.PERSONAL_DATA_PASSWORD + " = '" + client.getPersonalData().getPassword() + "'";
        try {
            Statement preparedStatement = getDbConnection().createStatement();
            resultSet = preparedStatement.executeQuery(select);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getCarrier(Carrier carrier){
        ResultSet resultSet = null;
        String select = "SELECT " + Const.ALL + " FROM " + Const.PERSONAL_DATA_TABLE + " WHERE " +
                Const.PERSONAL_DATA_LOGIN + " = '" + carrier.getPersonalData().getLogin() + "' AND " +
                Const.PERSONAL_DATA_PASSWORD + " = '" + carrier.getPersonalData().getPassword() + "' ";
        try {
            Statement preparedStatement = getDbConnection().createStatement();
            resultSet = preparedStatement.executeQuery(select);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getIdClient(Client client){
        ResultSet resultSet = null;
        String select = "SELECT " + Const.ALL + " FROM " + Const.CLIENT_TABLE + " WHERE " +
                Const.CLIENT_ID + " = " + client.getIdClient();
        try {
            Statement preparedStatement = getDbConnection().createStatement();
            resultSet = preparedStatement.executeQuery(select);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getIdCarrier(Carrier carrier){
        ResultSet resultSet = null;
        String select = "SELECT " + Const.ALL + " FROM " + Const.CARRIER_TABLE + " WHERE " +
                Const.CARRIER_ID + " = " + carrier.getIdCarrier();
        try {
            Statement preparedStatement = getDbConnection().createStatement();
            resultSet = preparedStatement.executeQuery(select);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getIdPersonalData(PersonalData personalData){
        ResultSet resultSet = null;
        String select = "SELECT " + Const.ALL + " FROM " + Const.PERSONAL_DATA_TABLE + " WHERE " +
                Const.PERSONAL_DATA_ID_PERSONAL_DATA + " = " + personalData.getIdPersonalData();
        try {
            Statement preparedStatement = getDbConnection().createStatement();
            resultSet = preparedStatement.executeQuery(select);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getCar(Car car){
        ResultSet resultSet = null;
        String select = "SELECT " + Const.ALL + " FROM " + Const.CAR_TABLE + " WHERE " +
                Const.CAR_NUMBER + " = '" + car.getNumber() + "'";
        try {
            Statement preparedStatement = getDbConnection().createStatement();
            resultSet = preparedStatement.executeQuery(select);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getTransportData(TransportData transportData){
        ResultSet resultSet = null;
        String select = "SELECT " + Const.ALL + " FROM " + Const.TRANSPORT_DATA_TABLE + " WHERE " +
                Const.TRANSPORT_DATA_ID_CAR + " = " + transportData.getCar().getIdCar();
        try {
            Statement preparedStatement = getDbConnection().createStatement();
            resultSet = preparedStatement.executeQuery(select);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getDepartureSender(Departure departure){
        ResultSet resultSet = null;
        String select = "SELECT " + Const.ALL + " FROM " + Const.VIEW_DEPARTURE_AND_FORM + " WHERE " +
                Const.FORM_ID_SENDER + " = " + departure.getForm().getIdSender() + " AND " +
                Const.DEPARTURE_STATUS_OF_DEPARTURE + " = '" + departure.getStatusOfDeparture() + "' ";
        try {
            Statement preparedStatement = getDbConnection().createStatement();
            resultSet = preparedStatement.executeQuery(select);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getDepartureRecipient(Departure departure){
        ResultSet resultSet = null;
        String select = "SELECT " + Const.ALL + " FROM " + Const.VIEW_DEPARTURE_AND_FORM + " WHERE " +
                Const.FORM_ID_RECIPIENT + " = " + departure.getForm().getIdRecipient() + " AND " +
                Const.DEPARTURE_STATUS_OF_DEPARTURE + " = '" + departure.getStatusOfDeparture() + "' ";
        try {
            Statement preparedStatement = getDbConnection().createStatement();
            resultSet = preparedStatement.executeQuery(select);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getPhonePersonalData(PersonalData personalData){
        ResultSet resultSet = null;
        String select = "SELECT " + Const.ALL + " FROM " + Const.PERSONAL_DATA_TABLE + " WHERE " +
                Const.PERSONAL_DATA_PHONE + " = '" + personalData.getPhone() + "'";
        try {
            Statement preparedStatement = getDbConnection().createStatement();
            resultSet = preparedStatement.executeQuery(select);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public int getIdForm(){
        ResultSet resultSet = null;
        int idForm = 0;
        String select = "SELECT MAX(" + Const.FORM_ID_FORM + ") FROM " + Const.FORM_TABLE;
        try {
            Statement preparedStatement = getDbConnection().createStatement();
            resultSet = preparedStatement.executeQuery(select);
            while (resultSet.next()){
                idForm = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ++idForm;
    }
    public void updatePersonalData(int idPersonalData, String columnName, String columnNewValue){
        ResultSet resultSet = null;
        String update = "UPDATE " + Const.PERSONAL_DATA_TABLE + " SET " + columnName + " = ?"  +
                " WHERE " + Const.PERSONAL_DATA_ID_PERSONAL_DATA + " = ?";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(update);
            preparedStatement.setString(1, columnNewValue);
            preparedStatement.setInt(2, idPersonalData);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getDataTransportData(TransportData transportData) {
        ResultSet resultSet = null;
        String select = "SELECT " + Const.ALL + " FROM " + Const.TRANSPORT_DATA_TABLE + " WHERE " +
                Const.TRANSPORT_DATA_ID + " = " + transportData.getIdTransportData();
        try {
            Statement preparedStatement = getDbConnection().createStatement();
            resultSet = preparedStatement.executeQuery(select);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getCarData(Car car) {
        ResultSet resultSet = null;
        String select = "SELECT " + Const.ALL + " FROM " + Const.CAR_TABLE + " WHERE " +
                Const.CAR_ID + " = " + car.getIdCar();
        try {
            Statement preparedStatement = getDbConnection().createStatement();
            resultSet = preparedStatement.executeQuery(select);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getAvailableDepartureCarrier(Departure departure){
        ResultSet resultSet = null;
        String select = "SELECT " + Const.ALL + " FROM " + Const.VIEW_DEPARTURE_AND_FORM + " WHERE " +
                Const.DEPARTURE_STATUS_OF_DEPARTURE + " = '" + departure.getStatusOfDeparture() + "' ";
        try {
            Statement preparedStatement = getDbConnection().createStatement();
            resultSet = preparedStatement.executeQuery(select);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getDepartureCarrier(Departure departure) {
        ResultSet resultSet = null;
        String select = "SELECT " + Const.ALL + " FROM " + Const.VIEW_DEPARTURE_AND_FORM + " WHERE " +
                Const.DEPARTURE_ID_CARRIER + " = " + departure.getCarrier().getIdCarrier() + " AND " +
                Const.DEPARTURE_STATUS_OF_DEPARTURE + " = '" + departure.getStatusOfDeparture() + "' ";
        try {
            Statement preparedStatement = getDbConnection().createStatement();
            resultSet = preparedStatement.executeQuery(select);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void updateCar(int idCar, String columnName, String columnNewValue) {
        ResultSet resultSet = null;
        String update = "UPDATE " + Const.CAR_TABLE + " SET " + columnName + " = ?"  +
                " WHERE " + Const.CAR_ID + " = ?";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(update);
            preparedStatement.setString(1, columnNewValue);
            preparedStatement.setInt(2, idCar);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public ResultSet getDeparture(Departure departure) {
        ResultSet resultSet = null;
        String select = "SELECT " + Const.ALL + " FROM " + Const.VIEW_DEPARTURE_AND_FORM + " WHERE " +
                Const.DEPARTURE_ID_DEPARTURE + " = " + departure.getIdDeparture();
        try {
            Statement preparedStatement = getDbConnection().createStatement();
            resultSet = preparedStatement.executeQuery(select);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void deleteDeparture(Departure departure) {
        String deleteFromDeparture = "DELETE FROM " + Const.DEPARTURE_TABLE + " WHERE " +
                Const.DEPARTURE_ID_DEPARTURE + " = " + departure.getIdDeparture();

        String deleteFromForm = "DELETE FROM " + Const.FORM_TABLE + " WHERE " +
                Const.FORM_ID_FORM + " = " + departure.getForm().getIdForm();
        try {
            Statement preparedStatement = getDbConnection().createStatement();
            preparedStatement.executeUpdate(deleteFromDeparture);
            Statement preparedStatement1 = getDbConnection().createStatement();
            preparedStatement1.executeUpdate(deleteFromForm);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateDeparture(Departure departure, String message) {
        String update = "UPDATE " + Const.DEPARTURE_TABLE + " SET " + Const.DEPARTURE_STATUS_OF_DEPARTURE + " = ?"  +
                " WHERE " + Const.DEPARTURE_ID_DEPARTURE + " = ?";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(update);
            preparedStatement.setString(1, message);
            preparedStatement.setInt(2, departure.getIdDeparture());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateDeparture(Departure departure, int idCarrier ,String message) {
        String update = "UPDATE " + Const.DEPARTURE_TABLE + " SET " + Const.DEPARTURE_ID_CARRIER + " = ? , "
                + Const.DEPARTURE_STATUS_OF_DEPARTURE + " = ?" +
                " WHERE " + Const.DEPARTURE_ID_DEPARTURE + " = ?";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(update);
            preparedStatement.setInt(1, idCarrier);
            preparedStatement.setString(2, message);
            preparedStatement.setInt(3, departure.getIdDeparture());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
