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
			 
				 String query = " CREATE TABLE connection (CID int NOT NULL AUTO_INCREMENT,subjectCode VARCHAR(20),tag VARCHAR(20),lecturer VARCHAR(50), groupId VARCHAR(20), location VARCHAR(20), PRIMARY KEY (CID))";  
				 
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
	
	
	//Create session_location table 
	public static boolean createSessionLocationTable() {
		 
		if(DatabaseHandler.conn != null)
		{
			String tableName = "session_location";
			boolean exists = false;
			try {
				exists = DatabaseHandler.conn.getMetaData().getTables(null, null, tableName, null).next();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(!exists){
			 
				 String query = " CREATE TABLE session_location (SLID int NOT NULL AUTO_INCREMENT, sessionId int, locationId int,locationName VARCHAR(200), PRIMARY KEY (SLID))";  
				 
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
				System.out.println("session_location table already exists");
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
			String query = " SELECT groupId,subGroupId FROM student "; 
			    
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
	
	
	//Get session id from Sessions table
	public static ResultSet getAllSessions()
	{
		if(DatabaseHandler.conn != null)
		{
			String query = " SELECT * FROM Sessions "; 
			    
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

	
	//Get location id from location table
	public static ResultSet getAllLocations()
	{
		if(DatabaseHandler.conn != null)
		{
			String query = " SELECT * FROM location "; 
				    
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
	
	
	public static ResultSet generateRoom()
	{
		if(DatabaseHandler.conn != null)
		{
			//if(tag == )
		
		}
		
			return null;	
		
	}
	

	public static boolean addConnections(String subjectCode,String tag,String lecturer,String groupId, String location)
	{
		
		
		if(DatabaseHandler.conn != null)
		{
			String query = " INSERT into connection(subjectCode,tag,lecturer,groupId,location)" + " VALUES (?,?,?,?,?)";
	
			 
		    try
		    {
				PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
				
				preparedStmt.setString(1, subjectCode);
				preparedStmt.setString(2, tag);
				preparedStmt.setString(3, lecturer);
				preparedStmt.setString(4, groupId);
				preparedStmt.setString(5, location);
				
			
				preparedStmt.execute();
				return true;
			} 
		    catch (SQLException e)
		    {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		    	 
		}
		return false;		
	}
	
	
	public static boolean addConnectionsLocations(int sessionId, int locationId,String locationName)
	{
		
		
		if(DatabaseHandler.conn != null)
		{
			String query = " INSERT into session_location(sessionId,locationId,locationName)" + " VALUES (?,?,?)";
	
			 
		    try
		    {
				PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
				
				preparedStmt.setInt(1, sessionId);
				preparedStmt.setInt(2, locationId);
				preparedStmt.setString(3, locationName);
				
			
				preparedStmt.execute();
				return true;
			} 
		    catch (SQLException e)
		    {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		    	 
		}
		return false;		
	}
	
	

	public static ResultSet getAllConnections()
	{
		if(DatabaseHandler.conn != null)
		{
			String query = " SELECT * FROM connection";

			 
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
	
	
	public static ResultSet getRoomAccordingToTag(String tag) {
		if(DatabaseHandler.conn != null) {
			String query = " SELECT roomId FROM location WHERE roomType='Lecture' ";
			
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


}
