package database;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class DatabaseHandler_consecutiveSessions {

	
public static boolean createConsecutiveTable() {
		 
		
		if(DatabaseHandler.conn != null)
		{
			String tableName = "Consecutive";
			boolean exists = false;
			try {
				exists = DatabaseHandler.conn.getMetaData().getTables(null, null, tableName, null).next();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(!exists){
			 
				 String query = " CREATE TABLE Consecutive(CID int NOT NULL AUTO_INCREMENT,lecturer VARCHAR(30),constructor VARCHAR(30),subject VARCHAR(10),gid VARCHAR(20),type VARCHAR(20),startingTime VARCHAR(40),durationFirst VARCHAR(40),durationSecond VARCHAR(40),day int,PRIMARY KEY (CID))";  
//				 String query = "drop table Consecutive";
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
				System.out.println("Consecutive table already exists");
			}
		}
		
		
		return false;		
		
	}
public static boolean addConsecutiveSessions(String lecturer,String constructor,String subject,String gid,String type,String startingTime,String durationFirst,String durationSecond,int day)
{
	createConsecutiveTable();
	
	if(DatabaseHandler.conn != null)
	{
		String query = " INSERT into Consecutive(lecturer,constructor,subject,gid,type,startingTime,durationFirst,durationSecond,day)" + " VALUES (?,?,?,?,?,?,?,?,?)";

		 
	    try
	    {
			PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
			preparedStmt.setString(1, lecturer);
			preparedStmt.setString(2, constructor);
			preparedStmt.setString(3, subject);
			preparedStmt.setString(4, gid);
			preparedStmt.setString(5, type);
			preparedStmt.setString(6, startingTime);
			preparedStmt.setString(7, durationFirst);
			preparedStmt.setString(8, durationSecond);
			preparedStmt.setInt(9, day);
	
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
