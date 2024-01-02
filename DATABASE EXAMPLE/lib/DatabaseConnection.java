import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection()throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        
    }
    
}
