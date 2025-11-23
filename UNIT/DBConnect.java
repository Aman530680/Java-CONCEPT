import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

    public static Connection getConnection() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/unit5javafx",
                "root",
                "Asha530680@");
    }
}
