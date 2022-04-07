package itmo.web_services.dao;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/web-services";
    private static final String JDBC_USER = "student";
    private static final String JDBC_PASSWORD = "student";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Driver driver = (Driver) Class.forName("org.postgresql.Driver").newInstance();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
