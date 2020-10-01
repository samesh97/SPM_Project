package database;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import enums.Location;
import javafx.scene.control.TableColumn;

public class DatabaseHandler_Locations {
	
public static boolean createLocationTable() {
		 
		
		if(DatabaseHandler.conn != null)
		{
			String tableName = "location";
			boolean exists = false;
			try {
				exists = DatabaseHandler.conn.getMetaData().getTables(null, null, tableName, null).next();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(!exists){
			 
				 String query = " CREATE TABLE location (LID int NOT NULL AUTO_INCREMENT,buildingId VARCHAR(20),blockId VARCHAR(20),roomId VARCHAR(20),roomType VARCHAR(20),PRIMARY KEY (LID))";  
				 
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
				System.out.println("location table already exists");
			}
		}
		
		
		return false;		
		
	}


	public static boolean addLocations(String buildingId,String blockId,String roomId,String roomType)
	{
		createLocationTable();
		
		if(DatabaseHandler.conn != null)
		{
			String query = " INSERT into location(buildingId,blockId,roomId,roomType)" + " VALUES (?,?,?,?)";
	
			 
		    try
		    {
				PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
				
				preparedStmt.setString(1, buildingId);
				preparedStmt.setString(2, blockId);
				preparedStmt.setString(3, roomId);
				preparedStmt.setString(4, roomType);
		
				
			
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
	
	public static ResultSet getAllLocations()
	{
		if(DatabaseHandler.conn != null)
		{
			String query = " SELECT * FROM location";

			 
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
	
	//Delete a particular record from database
	public static boolean deleteLocations(String Locationid) {
		if(DatabaseHandler.conn != null)
		{
			String query = " DELETE FROM location WHERE LID = (?)";

			 
		    try
		    {
				PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
				preparedStmt.setString(1, Locationid);
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
	
	public static boolean deleteAllLocations() {
		if(DatabaseHandler.conn != null)
		{
			String query = "DELETE * FROM location";

			 
		    try
		    {
				PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
				
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
	
	
	//Update a selected record from database
	public static boolean updateLocation(String id, String buildingId, String blockId, String roomId, String roomType)
	{
		
		if(DatabaseHandler.conn != null)
		{
			String query = " UPDATE location SET buildingId=(?),blockId=(?),roomId=(?),roomType=(?) WHERE LID=(?) ";

			 
			try
		    {
				PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
				
				preparedStmt.setString(1, buildingId);
				preparedStmt.setString(2, blockId);
				preparedStmt.setString(3, roomId);
				preparedStmt.setString(4, roomType);
				preparedStmt.setString(5, id);
				preparedStmt.execute();
				return true;
				
		
			} 
		    catch (SQLException e)
		    {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} 
		    	 
		}
		return false;		
	}
}

//Done