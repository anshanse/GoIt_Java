package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/test?verifyServerCertificate=false&useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC&createDatabaseIfNotExist=true&autoReconnect=true";
    private static final String USER_NAME = "shanse";
    private static final String PASSWORD = "px48mar23";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("USER", USER_NAME);
        properties.setProperty("PASSWORD", PASSWORD);
        return DriverManager.getConnection(URL, properties);
    }


}
