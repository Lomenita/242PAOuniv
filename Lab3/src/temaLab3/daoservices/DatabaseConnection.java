package temaLab3.daoservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static temaLab3.utils.Constants.*;

public class DatabaseConnection{
    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if(connection == null){
            connection = DriverManager.getConnection(JDBC_DRIVER, JDBC_USER, JDBC_PWD);
        }
        return connection;
    }
}
