package database;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DatabaseHandler
{
	private static final String DATABASE_NAME = "spm_timetable_db";
	private static final String USER_NAME = "error_404";
	private static final String PASSWORD = "error_404";
	
	private static Connection conn = null;
	
	public static void makeConnection()
	{
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://db4free.net:3306/spm_timetable_db",USER_NAME,PASSWORD);
			System.out.println("Successfully Connected to the Database");
		}
		catch(Exception e)
		{
			System.out.println("Error while connecting to the Database");
			e.printStackTrace();
		}
	}
	public static void addSampledata()
	{
		if(conn != null)
		{
			String query = " INSERT into sample(Name)" + " VALUES (?)";

			 
		    try
		    {
				PreparedStatement preparedStmt = (PreparedStatement) conn.clientPrepareStatement(query);
				preparedStmt.setString(1, "SPM_SAMPLE");
				
				preparedStmt.execute();
			} 
		    catch (SQLException e)
		    {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
