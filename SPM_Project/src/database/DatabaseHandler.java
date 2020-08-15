package database;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DatabaseHandler
{
	private static final String DATABASE_NAME = "test";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "12345";
	
	public static void makeConnection()
	{
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DATABASE_NAME,USER_NAME,PASSWORD);
			System.out.println("Successfully Connected to the Database");
		}
		catch(Exception e)
		{
			System.out.println("Error while connecting to the Database");
			e.printStackTrace();
		}
	}
}
