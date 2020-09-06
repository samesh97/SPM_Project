package database;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class DatabaseHandler_Students {
	
public static boolean createStudentTable() {
		 
		
		if(DatabaseHandler.conn != null)
		{
			String tableName = "student";
			boolean exists = false;
			try {
				exists = DatabaseHandler.conn.getMetaData().getTables(null, null, tableName, null).next();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(!exists){
			 //   s = DatabaseHandler.conn.createStatement();
			 //   s.execute(" CREATE TABLE Subjects (SubjectCode VARCHAR(6),SubjectName VARCHAR(30),OfferedYear int,OfferedSem int,LectureHrs int,TutorialHrs int,LabHrs int,EvaluationHrs int)");
				 String query = " CREATE TABLE student (SID int NOT NULL AUTO_INCREMENT,yearSem VARCHAR(10),program VARCHAR(10),groupNo VARCHAR(10),subGroupNo VARCHAR(10),groupId VARCHAR(10),subGroupId VARCHAR(10),PRIMARY KEY (SID))";  
				 
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
				System.out.println("students table already exists");
			}
		}
		
		
		return false;		
		
	}
public static boolean addStudents(String yearSem,String program,String groupNo,String subGroupNo,String groupId,String subGroupId )
{
	createStudentTable();
	
	if(DatabaseHandler.conn != null)
	{
		String query = " INSERT into student(yearSem,program,groupNo,subGroupNo,groupId,subGroupId)" + " VALUES (?,?,?,?,?,?)";

		 
	    try
	    {
			PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
			preparedStmt.setString(1, yearSem);
			preparedStmt.setString(2, program);
			preparedStmt.setString(3, groupNo);
			preparedStmt.setString(4, subGroupNo);
			preparedStmt.setString(5, groupId);
			preparedStmt.setString(6, subGroupId);
			
			
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
public static ResultSet getAllStudents()
{
	if(DatabaseHandler.conn != null)
	{
		String query = " SELECT * FROM student";

		 
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
