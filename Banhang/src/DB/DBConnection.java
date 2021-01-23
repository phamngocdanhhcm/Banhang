package DB;
import java.sql.*;
public class DBConnection {
	public static Connection CreateConnection()
	{
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/banhang";
		String name = "root";
		String pass = "123456";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			conn = DriverManager.getConnection(url,name,pass);
		
		} catch (Exception e) {
			// TODO: handle exception
		}

		
		return conn;
	}
}
