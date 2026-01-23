import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/uni_university";
        String user = "postgres";
        String password = "2102";

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loaded!");

            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to PostgreSQL!");
            conn.close();

        } catch (Exception e) {
            System.out.println("❌ Connection failed");
            e.printStackTrace();
        }
    }
}