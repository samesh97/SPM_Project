package database;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DatabaseHandler_Lecturers {

	private static Connection conn = null;
	
	
		//conn= DatabaseHandler.makeConnection();
	
	

		
	public static void addSubjects(String SubjectCode,String SubjectName,String OfferedYear,String OfferedSem,String LectureHrs,String TutorialHrs,String LabHrs,String EvaluationHrs)
	{
		
		boolean isSuccess= false;
		if(conn != null)
		{
			String query = " INSERT into Subjects(SubjectCode,SubjectName,OfferedYear,OfferedSem,LectureHrs,TutorialHrs,LabHrs,EvaluationHrs)" + " VALUES (SubjectCode,SubjectName,OfferedYear,OfferedSem,LectureHrs,TutorialHrs,LabHrs,EvaluationHrs)";

			 
		    try
		    {
				PreparedStatement preparedStmt = (PreparedStatement) conn.clientPrepareStatement(query);
				preparedStmt.setString(1, "SubjectCode");
				preparedStmt.setString(2, "SubjectName");
				preparedStmt.setString(3, "OfferedYear");
				preparedStmt.setString(4, "OfferedSem");
				preparedStmt.setString(5, "LectureHrsE");
				preparedStmt.setString(6, "TutorialHrs");
				preparedStmt.setString(7, "LabHrs");
				preparedStmt.setString(8, "EvaluationHrs");
				
				preparedStmt.execute();
			} 
		    catch (SQLException e)
		    {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		 
		}
	}

}
