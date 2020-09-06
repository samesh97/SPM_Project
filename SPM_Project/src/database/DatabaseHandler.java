package database;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DatabaseHandler
{
	//DB4Free
	private static final String USER_NAME = "error_404";
	private static final String PASSWORD = "error_404";
	
	//FREE SQL HOSTING
//	private static final String USER_NAME = "sql12361005";
//	private static final String PASSWORD = "IwIYLZd2HX";
	
	public static Connection conn = null;
	
	public static void makeConnection()
	{
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			//DB4Free
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://db4free.net:3306/spm_timetable_db",USER_NAME,PASSWORD);
			
			//FREE SQL HOSTING
//			conn = (Connection) DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12361005",USER_NAME,PASSWORD);
			System.out.println("Successfully Connected to the Database");
		}
		catch(Exception e)
		{
			System.out.println("Error while connecting to the Database");
			e.printStackTrace();
		}
		
		
	}
}
