import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private static final String URL = "jdbc:postgresql://localhost:5432/uni_management_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "2102"; // change

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
