package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static String url = "jdbc:mysql://192.168.2.191:3306/testdb";
    private static String login = "root";
    private static String password = "0000";
    public static Connection connection = Util.connection();

    public static Connection connection() {
        try {
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
