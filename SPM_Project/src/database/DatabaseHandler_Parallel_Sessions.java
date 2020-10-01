package database;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class DatabaseHandler_Parallel_Sessions {
	
public static boolean createParallelSessionTable() {
		 
	if(DatabaseHandler.conn != null)
	{
		String tableName = "parallelSession";
		boolean exists = false;
		try {
			exists = DatabaseHandler.conn.getMetaData().getTables(null, null, tableName, null).next();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(!exists){
		 
			 String query = " CREATE TABLE parallelSession(PID int NOT NULL AUTO_INCREMENT,slotID int,day int,duration VARCHAR(30),PRIMARY KEY (PID))";  
//			 String query = "drop table allocatedSessions";
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
			System.out.println("parallelSession table already exists");
		}
		
	}

		return false;
	}

	public static boolean createParallelSessionListTable() {
	 
		if(DatabaseHandler.conn != null)
		{
	//sessions tsble
			String tableName = "parallelSessionList";
			boolean exists = false;
			try {
				exists = DatabaseHandler.conn.getMetaData().getTables(null, null, tableName, null).next();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(!exists){
			 
				 String query = " CREATE TABLE parallelSessionList(SID int PRIMARY KEY AUTO_INCREMENT,LecturerName VARCHAR(100),SubjectCode VARCHAR(50),Tag VARCHAR(20),StudentGroup VARCHAR(50),StuCount int,SlotID int)";  
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
				System.out.println("parallelSessionList table already exists");
			}
		}
		
		
		return false;	
	
}

public static ResultSet getAllSessions()
{
	if(DatabaseHandler.conn != null)
	{
		String query = " SELECT * FROM parallelSession";

		 
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

public static boolean addParallelSessione(int slotID,String duration,int day)
{
	createParallelSessionTable();
	
	if(DatabaseHandler.conn != null)
	{
		String query = " INSERT into parallelSession(slotID,day,duration)" + " VALUES (?,?,?)";

		 
	    try
	    {
			PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
			preparedStmt.setInt(1, slotID);
			preparedStmt.setInt(2, day);
			preparedStmt.setString(3, duration);
			
	
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
public static boolean addSession(String LecturerName ,String SubjectCode,String Tag,String StudentGroup,String StuCount,int SlotID)
{
	
	if(DatabaseHandler.conn != null)
	{
		String query = " INSERT into parallelSessionList(LecturerName,SubjectCode,Tag,StudentGroup,StuCount,SlotID)" + " VALUES (?,?,?,?,?,?)";

		 
	    try
	    {
			PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
			
			preparedStmt.setString(1, LecturerName);
			preparedStmt.setString(2, SubjectCode);
			preparedStmt.setString(3, Tag);
			preparedStmt.setString(4, StudentGroup);
			preparedStmt.setString(5, StuCount);
			preparedStmt.setInt(6, SlotID);
		
			
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
