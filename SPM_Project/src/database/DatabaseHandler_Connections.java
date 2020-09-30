package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;

public class DatabaseHandler_Connections {

	public static boolean createConnectionTable() {
		 
		if(DatabaseHandler.conn != null)
		{
			String tableName = "connection";
			boolean exists = false;
			try {
				exists = DatabaseHandler.conn.getMetaData().getTables(null, null, tableName, null).next();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(!exists){
			 
				 String query = " CREATE TABLE connection (CID int NOT NULL AUTO_INCREMENT,roomId VARCHAR(20),tag VARCHAR(20),subjectCode VARCHAR(20),lecturer VARCHAR(20), groupId VARCHAR(20), dayOfSession VARCHAR(20), startTime VARCHAR(20), endTime VARCHAR(20), PRIMARY KEY (CID))";  
				 
				    try
				    {
						PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
						
						preparedStmt.execute();
						System.out.println("Created table " + tableName); 
						return true;
					} 
				    catch (SQLException e)
				    {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
						return false;
					}
				    
				   
				}
			
			
			else 
			{
				System.out.println("connection table already exists");
			}
		}
		
		
		return false;		
		
	}
	
	
	
	
	
	
	//Get tag details from tags table
	public static ResultSet getTagDetails()
	{
		if(DatabaseHandler.conn != null)
		{
			String query = " SELECT name FROM tags";

			 
		    try
		    {
				PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
				return preparedStmt.executeQuery();
		
			} 
		    catch (SQLException e)
		    {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}    
		 
		}
		return null;	
	}
	
	
	//Get subject codes from Subjects table
	public static ResultSet getSubjectCodes()
	{
		if(DatabaseHandler.conn != null)
		{
			String query = " SELECT SubjectCode FROM Subjects "; 
			    
			try
		    {
				PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
				return preparedStmt.executeQuery();
				
		
			} 
		    catch (SQLException e)
		    {
			
				e.printStackTrace();
				
			} 
		
		}
		
			return null;
	}
	
	
	//Get lecturer names from lecturer table
	public static ResultSet getLecturerNames()
	{
		if(DatabaseHandler.conn != null)
		{
			String query = " SELECT LecturerName FROM Lecturers "; 
			    
			try
		    {
				PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
				return preparedStmt.executeQuery();
				
		
			} 
		    catch (SQLException e)
		    {
			
				e.printStackTrace();
				
			} 
		
		}
		
			return null;	
		
	}
	
	
	//Get group ids from student table
	public static ResultSet getGroupIds()
	{
		if(DatabaseHandler.conn != null)
		{
			String query = " SELECT groupId FROM student "; 
			    
			try
		    {
				PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
				return preparedStmt.executeQuery();
				
		
			} 
		    catch (SQLException e)
		    {
			
				e.printStackTrace();
				
			} 
		
		}
		
			return null;	
		
	}
	
	
	//Get preffered room from location table
	public static ResultSet getPrefferedRooms()
	{
		if(DatabaseHandler.conn != null)
		{
			String query = " SELECT roomId FROM location "; 
			    
			try
		    {
				PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
				return preparedStmt.executeQuery();
				
		
			} 
		    catch (SQLException e)
		    {
			
				e.printStackTrace();
				
			} 
		
		}
		
			return null;	
		
	}

}
