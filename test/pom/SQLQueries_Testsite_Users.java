package pom;

import  java.sql.Connection;
import  java.sql.Statement;
import  java.sql.DriverManager;
import  java.sql.SQLException;

public class SQLQueries_Testsite_Users {

    private static final String URL_CONNECT_DB = "jdbc:mysql://127.0.0.1:3036/testsite";

    private String username = "root";
    private String password = "354Godsmack";

    private Connection connection;
    private Statement statement;

    public void getQueryDeleteFromWhere(String tableName, String columnName, String rowValue) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        connection = DriverManager.getConnection(URL_CONNECT_DB, username, password);

        statement = connection.createStatement();

        String query = "delete from" + tableName + "where" + columnName + "=" + rowValue + ";";

        statement.executeQuery(query);

        connection.close();
    }
}
