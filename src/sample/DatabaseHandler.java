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

    public ResultSet getLoginAndPassword(String login, String password){
        ResultSet resultSet = null;

        String select = "SELECT " + Const.ALL + "FROM " + Const.PERSONAL_DATA_TABLE + "WHERE " + Const.PERSONAL_DATA_LOGIN +
                " = " + login + " AND " + Const.PERSONAL_DATA_PASSWORD + " = " + password;

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
