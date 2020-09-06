package database;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DatabaseHandler_Lecturers {

	
	//----------------------------------Subjects methods-------------------------------------------
	
	
	//method to create the Subjects table in database
	
	public static boolean createSubjectTable() {
		 
		
		if(DatabaseHandler.conn != null)
		{
			String tableName = "Subjects";
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
				 String query = " CREATE TABLE Subjects (SubjectCode VARCHAR(6) PRIMARY KEY,SubjectName VARCHAR(30),OfferedYear int,OfferedSem int,LectureHrs int,TutorialHrs int,LabHrs int,EvaluationHrs int)";  
				 
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
				System.out.println("Subjects table already exists");
			}
		}
		
		
		return false;		
		
	}
	
	
	
	//method to add subjects to the database
	public static boolean addSubjects(String SubjectCode,String SubjectName,int OfferedYear,int OfferedSem,int LectureHrs,int TutorialHrs,int LabHrs,int EvaluationHrs)
	{
		
		if(DatabaseHandler.conn != null)
		{
			String query = " INSERT into Subjects(SubjectCode,SubjectName,OfferedYear,OfferedSem,LectureHrs,TutorialHrs,LabHrs,EvaluationHrs)" + " VALUES (?,?,?,?,?,?,?,?)";

			 
		    try
		    {
				PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
				preparedStmt.setString(1, SubjectCode);
				preparedStmt.setString(2, SubjectName);
				preparedStmt.setInt(3, OfferedYear);
				preparedStmt.setInt(4, OfferedSem);
				preparedStmt.setInt(5, LectureHrs);
				preparedStmt.setInt(6, TutorialHrs);
				preparedStmt.setInt(7, LabHrs);
				preparedStmt.setInt(8, EvaluationHrs);
				
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
	
	
	//method to display the subjects list in the data grid
	public static ResultSet getAllSubjects()
	{
		if(DatabaseHandler.conn != null)
		{
			String query = " SELECT * FROM Subjects";

			 
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
	
	
	//method to display only the searched subject in the data grid
	public static ResultSet getAllSubjects(String Subjectid)
	{
		if(DatabaseHandler.conn != null)
		{
			String query = " SELECT * FROM Subjects WHERE SubjectCode=(?)";

			 
		    try
		    {
				PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
				preparedStmt.setString(1, Subjectid);
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
	
	
	
	//----------------------------Lecturers methods ---------------------------------------------------
	
	
	//method to create the Lecturers table in database
		public static boolean createLecturersTable() {
			
			
			
			
			if(DatabaseHandler.conn != null)
			{
				
				String tableName = "Lecturers";
				boolean exists = false;
				try {
					exists = DatabaseHandler.conn.getMetaData().getTables(null, null, tableName, null).next();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(!exists){
				 
					 String query = " CREATE TABLE Lecturers (LecturerName VARCHAR(30),EmployeeID VARCHAR(6)PRIMARY KEY,Faculty VARCHAR(30),Department VARCHAR(30),Center VARCHAR(30),Building VARCHAR(30),Level VARCHAR(30),ranking VARCHAR(30))"; 
					 
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
					System.out.println("Lecturers table already exists");
				}
			}
			
			
			return false;			
			
		}
		
		
		//method to add lecturers to the database
		public static boolean addLecturers(String LecturerName,String EmployeeID,String Faculty,String Department,String Center,String Building,String Level,String Rank)
		{
		
		
		if(DatabaseHandler.conn != null)
		{
			String query = " INSERT into Lecturers(LecturerName,EmployeeID,Faculty,Department,Center,Building,Level,ranking)" + " VALUES (?,?,?,?,?,?,?,?)";

			 
		    try
		    {
				PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
				preparedStmt.setString(1, LecturerName);
				preparedStmt.setString(2, EmployeeID);
				preparedStmt.setString(3, Faculty);
				preparedStmt.setString(4, Department);
				preparedStmt.setString(5, Center);
				preparedStmt.setString(6, Building);
				preparedStmt.setString(7, Level);
				preparedStmt.setString(8, Rank);
				
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
	
	//method to display the lecturer list in the data grid
		public static ResultSet getAllLecturers()
		{
			if(DatabaseHandler.conn != null)
			{
				String query = " SELECT * FROM Lecturers";

				 
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
		
		
		//method to display only the searched lecturer in the data grid
		public static ResultSet getAllLecturers(String Lecturerid)
		{
			if(DatabaseHandler.conn != null)
			{
				String query = " SELECT * FROM Lecturers WHERE EmployeeID=(?)";

				 
			    try
			    {
					PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
					preparedStmt.setString(1, Lecturerid);
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
