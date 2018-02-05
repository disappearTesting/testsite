package unitTests.loginPage;

import pom.MySQLQueries_Testsite;

import java.sql.*;

public class  SQLConnector {
    public static void  main(String[] args) throws  ClassNotFoundException, SQLException {
        MySQLQueries_Testsite mysqlConnect = new MySQLQueries_Testsite();

        String sql = "SELECT * FROM `testsite.users`";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.execute();
            System.out.println(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.disconnect();
        }
    }
}