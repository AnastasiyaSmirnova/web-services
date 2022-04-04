package itmo.web_services.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private Connection connection = null;
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/web-services";
    private static final String JDBC_USER = "student";
    private static final String JDBC_PASSWORD = "student";

    public Connection getConnection() {
        if (connection != null) return connection;

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
