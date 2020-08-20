package database;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DatabaseHandler_Lecturers {

	private static Connection conn = null;
	
	
		//conn= DatabaseHandler.makeConnection();
	
	

		
	public static void addSubjects(String SubjectCode,String SubjectName,String OfferedYear,String OfferedSem,String LectureHrs,String TutorialHrs,String LabHrs,String EvaluationHrs)
	{
		if(conn != null)
		{
			String query = " INSERT into Subjects(SubjectCode,SubjectName,OfferedYear,OfferedSem,LectureHrs,TutorialHrs,LabHrs,EvaluationHrs)" + " VALUES (SubjectCode)";

			 
		    try
		    {
				PreparedStatement preparedStmt = (PreparedStatement) conn.clientPrepareStatement(query);
				preparedStmt.setString(1, "SubjectCode");
				preparedStmt.setString(2, "SPM_SAMPLE");
				preparedStmt.setString(3, "SPM_SAMPLE");
				preparedStmt.setString(4, "SPM_SAMPLE");
				preparedStmt.setString(5, "SPM_SAMPLE");
				preparedStmt.setString(6, "SPM_SAMPLE");
				preparedStmt.setString(7, "SPM_SAMPLE");
				preparedStmt.setString(8, "SPM_SAMPLE");
				
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
