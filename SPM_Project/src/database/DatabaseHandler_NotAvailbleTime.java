package database;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class DatabaseHandler_NotAvailbleTime {

	
public static boolean createAllocatedSessionsTable() {
		 
		
		if(DatabaseHandler.conn != null)
		{
			String tableName = "allocatedSessions";
			boolean exists = false;
			try {
				exists = DatabaseHandler.conn.getMetaData().getTables(null, null, tableName, null).next();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(!exists){
			 
				 String query = " CREATE TABLE allocatedSessions(SID int NOT NULL AUTO_INCREMENT,type VARCHAR(30),name VARCHAR(30),startingTime VARCHAR(10),duration VARCHAR(10),day int,PRIMARY KEY (SID))";  
//				 String query = "drop table allocatedSessions";
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
				System.out.println("allocatedSessions table already exists");
			}
		}
		
		
		return false;		
		
	}
public static boolean addNotAllocatedTime(String type,String name,String startingTime,String duration,int day)
{
	createAllocatedSessionsTable();
	
	if(DatabaseHandler.conn != null)
	{
		String query = " INSERT into allocatedSessions(type,name,startingTime,duration,day)" + " VALUES (?,?,?,?,?)";

		 
	    try
	    {
			PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
			preparedStmt.setString(1, type);
			preparedStmt.setString(2, name);
			preparedStmt.setString(3, startingTime);
			preparedStmt.setString(4, duration);
			preparedStmt.setInt(5, day);
	
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

}
