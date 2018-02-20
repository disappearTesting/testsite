package pom;

import java.sql.*;
import java.util.Properties;

public class MySQLQueries_Testsite {
    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL_DATABASE = "jdbc:mysql://localhost:3306/testsite";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "354Godsmack";

    private Connection connection;
    private Properties properties;

    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
        }
        return properties;
    }

    public Connection connect() {
        if (connection == null) {
            try {
                Class.forName(DATABASE_DRIVER);
                connection = DriverManager.getConnection(URL_DATABASE, getProperties());
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int getSQLQuery_executeUpdate(String sql) {
        int result = 0;
        try {
            //for each String sql create PreparedStatement statement
            PreparedStatement statement = connect().prepareStatement(sql);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void getSQLQuery_executeQuery(String sql) {
        //ResultSet resultSet = null;
        try {
            //for each String sql create PreparedStatement statement
            PreparedStatement statement = connect().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                System.out.println("getRow(): " + resultSet.getRow()
                        + "\t getInt(): " + resultSet.getInt("id")
                        + "\t" + resultSet.getString("mobile"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //return resultSet;
    }
}