package database;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class DatabaseHandler_Tags {
	
public static boolean createTagsTable() {
		 
		
		if(DatabaseHandler.conn != null)
		{
			String tableName = "tags";
			boolean exists = false;
			try {
				exists = DatabaseHandler.conn.getMetaData().getTables(null, null, tableName, null).next();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(!exists){
			
				 String query = " CREATE TABLE tags (TID int NOT NULL AUTO_INCREMENT,tag VARCHAR(20),name VARCHAR(20),yearSem VARCHAR(10),dis VARCHAR(50),PRIMARY KEY (TID))";  
				 
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
				System.out.println("tags table already exists");
			}
		}
		
		
		return false;		
		
	}
public static boolean addTags(String tag,String name,String yearSem,String dis )
{
	createTagsTable();
	
	if(DatabaseHandler.conn != null)
	{
		String query = " INSERT into tags(tag,name,yearSem,dis)" + " VALUES (?,?,?,?)";

		 
	    try
	    {
			PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
			preparedStmt.setString(1, tag);
			preparedStmt.setString(2, name);
			preparedStmt.setString(3, yearSem);
			preparedStmt.setString(4, dis);
			
			
			
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
