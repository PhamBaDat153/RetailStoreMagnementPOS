package Project.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Kết nối hệ thống với database
public class DatabaseConnector {
    public static Connection connectDatabase() throws SQLException {
        // Database connection
        String url = "jdbc:mysql://localhost:3306/pos";
        String user = "root";
        String password = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver không tìm thấy", e);
        }

        return DriverManager.getConnection(url, user, password);
    }

}
