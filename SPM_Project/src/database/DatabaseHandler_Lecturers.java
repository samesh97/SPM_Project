package database;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DatabaseHandler_Lecturers {

	
		
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

}
