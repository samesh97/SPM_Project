package database;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import listeners.OnTaskCompleteListener;

public class DatabaseHandler
{
	//DB4Free
//	private static final String USER_NAME = "error_404";
//	private static final String PASSWORD = "error_404";
	
	//FREE SQL HOSTING
	private static final String USER_NAME = "sql12368186";
	private static final String PASSWORD = "CYPPc3tUHC";
	
	//Local DB
//	private static final String USER_NAME = "root";
//	private static final String PASSWORD = "12345";
	
	public static Connection conn = null;
	

	public static void makeConnection(OnTaskCompleteListener listener)
	{
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			//Local DB
//			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/spm_timetable_db",USER_NAME,PASSWORD);
			
			//DB4Free
//			conn = (Connection) DriverManager.getConnection("jdbc:mysql://db4free.net:3306/spm_timetable_db",USER_NAME,PASSWORD);
			
			//FREE SQL HOSTING
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12368186",USER_NAME,PASSWORD);
			listener.onFinished(true);
			System.out.println("Successfully Connected to the Database");
			
		}
		catch(Exception e)
		{
			listener.onFinished(false);
			System.out.println("Error while connecting to the Database");
			e.printStackTrace();
		}
		
		
	}

}
