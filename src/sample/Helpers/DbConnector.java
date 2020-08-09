package sample.Helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/OOP2";
    static final String USER = "root";
    static final String PASSWORD = "toor";

    private DbConnector() {
    }

    public static DbConnector getInstances() {
        return new DbConnector();
    }

    public Connection getConnection() {


        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
