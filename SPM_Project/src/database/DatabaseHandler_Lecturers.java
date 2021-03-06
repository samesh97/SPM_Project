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
				 String query = " CREATE TABLE Subjects (SubjectCode VARCHAR(6) PRIMARY KEY,SubjectName VARCHAR(100),OfferedYear int,OfferedSem int,LectureHrs int,TutorialHrs int,LabHrs int,EvaluationHrs int)";  
				 
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
	
	
		    	 
	
	
	//method to delete a selected record in database
	public static boolean deleteSubjects(String Subjectid)
	{
		
		if(DatabaseHandler.conn != null)
		{
			String query = " DELETE FROM Subjects WHERE SubjectCode=(?) ";

			 
			try
		    {
				PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
				preparedStmt.setString(1, Subjectid);
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
	
	//method to update a record in database
	public static boolean updateSubjects(String SubjectCode,String SubjectName,int OfferedYear,int OfferedSem,int LectureHrs,int TutorialHrs,int LabHrs,int EvaluationHrs)
	{
		
		if(DatabaseHandler.conn != null)
		{
			String query = " UPDATE Subjects SET SubjectCode=(?),SubjectName=(?),OfferedYear=(?),OfferedSem=(?),LectureHrs=(?),TutorialHrs=(?),LabHrs=(?),EvaluationHrs=(?) WHERE SubjectCode=(?) ";

			 
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
				preparedStmt.setString(9, SubjectCode);
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
				 
					 String query = " CREATE TABLE Lecturers (LecturerName VARCHAR(200),EmployeeID VARCHAR(6) PRIMARY KEY,Faculty VARCHAR(200),Department VARCHAR(200),Center VARCHAR(200),Building VARCHAR(200),Level VARCHAR(200),ranking VARCHAR(200),FacultyId int,DeptId int,CenterId int,BuildingId int,LevelId int)"; 
					 
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
		public static boolean addLecturers(String LecturerName,String EmployeeID,String Faculty,String Department,String Center,String Building,String Level,String Rank,int FacultyId,int DeptId,int CenterId,int BuildingId,int LevelId)
		{
		
		
		if(DatabaseHandler.conn != null)
		{
			String query = " INSERT into Lecturers(LecturerName,EmployeeID,Faculty,Department,Center,Building,Level,ranking,FacultyId,DeptId,CenterId,BuildingId,LevelId)" + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

			 
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
				preparedStmt.setInt(9, FacultyId);
				preparedStmt.setInt(10, DeptId);
				preparedStmt.setInt(11, CenterId);
				preparedStmt.setInt(12, BuildingId);
				preparedStmt.setInt(13, LevelId);
				
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
		
		//the method to delete a selected lecturer
		public static boolean deleteLecturers(String Lecturerid)
		{
			
			if(DatabaseHandler.conn != null)
			{
				String query = " DELETE FROM Lecturers WHERE EmployeeID=(?) ";

				 
				try
			    {
					PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
					preparedStmt.setString(1, Lecturerid);
					return preparedStmt.execute();
					
			
				} 
			    catch (SQLException e)
			    {
				
					e.printStackTrace();
					
				} 
			    	 
			}
			return false;		
		}
		
		
//method to update a lecturer
		public static boolean updateLecturers(String LecturerName,String EmployeeID,String Faculty,String Department,String Center,String Building,String Level,String Rank,int FacultyId,int DeptId,int CenterId,int BuildingId,int LevelId)
		{
			
			if(DatabaseHandler.conn != null)
			{
				String query = " UPDATE Lecturers SET LecturerName=(?),EmployeeID=(?),Faculty=(?),Department=(?),Center=(?),Building=(?),Level=(?),ranking=(?),FacultyId=(?),DeptId=(?),CenterId=(?),BuildingId=(?),LevelId=(?) WHERE EmployeeID=(?) ";
				//Lecturers(LecturerName,EmployeeID,Faculty,Department,Center,Building,Level,ranking,FacultyId,DeptId,CenterId,BuildingId,LevelId)
				 
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
					preparedStmt.setInt(9, FacultyId);
					preparedStmt.setInt(10, DeptId);
					preparedStmt.setInt(11, CenterId);
					preparedStmt.setInt(12, BuildingId);
					preparedStmt.setInt(13, LevelId);
					
					preparedStmt.setString(14, EmployeeID);
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
		
//-------------Sessions methods--------------------------------------------------------------
		
//method to create the sessions table
		public static boolean createSessionTable() {
			

			if(DatabaseHandler.conn != null)
			{
				
				String tableName = "Sessions";
				boolean exists = false;
				try {
					exists = DatabaseHandler.conn.getMetaData().getTables(null, null, tableName, null).next();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(!exists){
					
					
					 String query = " CREATE TABLE Sessions (SessionId int PRIMARY KEY AUTO_INCREMENT,LecturerName VARCHAR(100),SubjectCode VARCHAR(50),Tag VARCHAR(20),StudentGroup VARCHAR(50),StuCount int,Duration int)"; 
					 
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
					System.out.println("Sessions table already exists");
				}
			}
			
			return false;
			
		}
		
		
//retrieve values from lecturers table to set to the lecturers combo box
		public static ResultSet getDropDownLecturers()
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
		
		
//retrieve values from Subjects table to set to the subjects combo box		
		public static ResultSet getDropDownSubjects()
		{
			if(DatabaseHandler.conn != null)
			{
				String query = " SELECT SubjectName FROM Subjects "; 
				    
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
		

//retrieve values from tags table to set to the tags combo box
		public static ResultSet getDropDownTags()
		{
			if(DatabaseHandler.conn != null)
			{
				String query = " SELECT name FROM tags "; 
				    
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
		
		
//retrieve values from student table to set to the studentGroup combo box		
		public static ResultSet getDropDownGroups()
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
		
		
//	add sessions to the database
		
		public static boolean addSession(String LecturerName ,String SubjectCode,String Tag,String StudentGroup,int StuCount,int Duration)
		{
			
			if(DatabaseHandler.conn != null)
			{
				String query = " INSERT into Sessions(LecturerName,SubjectCode,Tag,StudentGroup,StuCount,Duration)" + " VALUES (?,?,?,?,?,?)";

				 
			    try
			    {
					PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
					
					preparedStmt.setString(1, LecturerName);
					preparedStmt.setString(2, SubjectCode);
					preparedStmt.setString(3, Tag);
					preparedStmt.setString(4, StudentGroup);
					preparedStmt.setInt(5, StuCount);
					preparedStmt.setInt(6, Duration);
				
					
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
		
//View sessions

				public static ResultSet getAllSessions()
				{
					if(DatabaseHandler.conn != null)
					{
						String query = " SELECT * FROM Sessions";

						 
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
				
				
//method to display only the searched result in the data grid Sessions
				public static ResultSet getAllSessionsFilterByLecturer(String LecturerName)
				{
					if(DatabaseHandler.conn != null)
					{
						String query = " SELECT * FROM Sessions WHERE LecturerName=(?)";

						 
					    try
					    {
							PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
							preparedStmt.setString(1, LecturerName);
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
				

//method to display results in data grid sessions
				
				public static ResultSet getAllSessionsFilterBySubject(String SubjectCode)
				{
					if(DatabaseHandler.conn != null)
					{
						String query = " SELECT * FROM Sessions WHERE SubjectCode=(?)";

						 
					    try
					    {
							PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
							preparedStmt.setString(1, SubjectCode);
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
		
//method to display results in data grid sessions
				
				public static ResultSet getAllSessionsFilterByGroup(String StudentGroup)
				{
					if(DatabaseHandler.conn != null)
					{
						String query = " SELECT * FROM Sessions WHERE StudentGroup=(?)";

						 
					    try
					    {
							PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
							preparedStmt.setString(1, StudentGroup);
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
				
				
//method to delete all sessions
				public static boolean deleteAllSessions()
				{
					
					if(DatabaseHandler.conn != null)
					{
						String query = " DELETE FROM Sessions ";

						 
						try
					    {
							PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
							
							return preparedStmt.execute();
							
					
						} 
					    catch (SQLException e)
					    {
						
							e.printStackTrace();
							
						} 
					    	 
					}
					return false;		
				}			
				
				
//method to delete all Session_location table data
				
				public static boolean deleteSessionLocation()
				{
					
					if(DatabaseHandler.conn != null)
					{
						String query = " DELETE FROM session_location ";

						 
						try
					    {
							PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
							
							return preparedStmt.execute();
							
					
						} 
					    catch (SQLException e)
					    {
						
							e.printStackTrace();
							
						} 
					    	 
					}
					return false;		
				}
				
				
				
//last bracket	
}
