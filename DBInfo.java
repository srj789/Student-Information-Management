package projectRAT;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBInfo 
{
  static Connection con;
	static
	{
		try
		{
			//load the driver
			Class.forName("com.mysql.jdbc.Driver");
		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","dell@12345");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
}
