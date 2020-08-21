package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

public class QueriesOfWorkingDays
{
	public static boolean addNumberOfWorkingDays(int type,int value)
	{
		
			if(DatabaseHandler.conn != null)
			{
				boolean res= checkWhetherARowExists(type);
				//if this is true update it
				//if false create the row
				
				if(!res)
				{
					//insert
					String query = " INSERT into WorkingDaysAndHours(Type,NumberOfWorkingDays)" + " VALUES (?,?)";

					 
				    try
				    {
						PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
						preparedStmt.setInt(1,type);
						preparedStmt.setInt(2,value);
						
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
				else
				{
					//update
					String query = " UPDATE WorkingDaysAndHours SET NumberOfWorkingDays=(?) WHERE Type=(?)";

					 
				    try
				    {
						PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
						preparedStmt.setInt(1,value);
						preparedStmt.setInt(2,type);
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
				
				
				
			}
			return false;
		
	}
	public static boolean addWorkingTimeDuration(int type,int hours, int minutes)
	{
		
		if(DatabaseHandler.conn != null)
		{
			
			boolean res= checkWhetherARowExists(type);
			if(res)
			{
				//update
				String query = " UPDATE WorkingDaysAndHours SET WorkingTimeHours=(?),WorkingTimeMinutes=(?) WHERE Type=(?)";

				 
			    try
			    {
					PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
					preparedStmt.setInt(1,hours);
					preparedStmt.setInt(2,minutes);
					preparedStmt.setInt(3,type);
					
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
			else
			{
				
				//insert
				String query = " INSERT into WorkingDaysAndHours(Type,WorkingTimeHours,WorkingTimeMinutes)" + " VALUES (?,?,?)";

				 
			    try
			    {
					PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
					preparedStmt.setInt(1,type);
					preparedStmt.setInt(2,hours);
					preparedStmt.setInt(3,minutes);
					
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
			
		}
		
		
		return false;
	}
	public static boolean deleteNumberOfWorkingDays(int type)
	{
		boolean res= checkWhetherARowExists(type);
		if(res)
		{
			//update
			String query = " UPDATE WorkingDaysAndHours SET NumberOfWorkingDays=(?) WHERE Type=(?)";

			 
		    try
		    {
				PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
				preparedStmt.setInt(1,-99);
				preparedStmt.setInt(2,type);
	
				
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
	public static boolean deleteWorkingTimeDuration(int type)
	{
		boolean res= checkWhetherARowExists(type);
		if(res)
		{
			//update
			String query = " UPDATE WorkingDaysAndHours SET WorkingTimeHours=(?),WorkingTimeMinutes=(?) WHERE Type=(?)";

			 
		    try
		    {
				PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
				preparedStmt.setInt(1,-99);
				preparedStmt.setInt(2,-99);
				preparedStmt.setInt(3,type);
	
				
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
	public static ResultSet sync(int type)
	{
		
		if(DatabaseHandler.conn != null)
		{
			String query = " SELECT * FROM WorkingDaysAndHours WHERE Type=(?)";

			 
		    try
		    {
				PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
				preparedStmt.setInt(1,type);
				return preparedStmt.executeQuery();
			} 
		    catch (SQLException e)
		    {
				e.printStackTrace();
			}
		}
		return null;
	}
	public static boolean checkWhetherARowExists(int type)
	{
		if(DatabaseHandler.conn != null)
		{
			String query = "SELECT * FROM WorkingDaysAndHours WHERE Type=(?)";

			 
		    try
		    {
				PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
				preparedStmt.setInt(1,type);
				
				ResultSet set = preparedStmt.executeQuery();
				if(set != null)
				{
					set.next();
					boolean value = set.isLast();
					return value;
				
				}
				return false;
			} 
		    catch (SQLException e)
		    {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	public static boolean createNewSlot(int type,String duration,int startHours,int startMinutes)
	{
		if(DatabaseHandler.conn != null)
		{
			//insert
			String query = " INSERT into Slots(Type,Duration,StartTimeInHours,StartTimeInMinutes)" + " VALUES (?,?,?,?)";
		    try
		    {
				PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
				preparedStmt.setInt(1,type);
				preparedStmt.setString(2,duration);
				preparedStmt.setInt(3,startHours);
				preparedStmt.setInt(4,startMinutes);
				
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
	public static ResultSet getWorkingDays(int type)
	{
		
		if(DatabaseHandler.conn != null)
		{
			String query = " SELECT * FROM WorkingDays WHERE Type=(?)";

			 
		    try
		    {
				PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
				preparedStmt.setInt(1,type);
				return preparedStmt.executeQuery();
			} 
		    catch (SQLException e)
		    {
				e.printStackTrace();
			}
		}
		return null;
	}
	public static boolean updateWorkingDays(int id,boolean isTrue)
	{
			if(DatabaseHandler.conn != null)
			{
				String query = " UPDATE WorkingDays SET isSelected=(?) WHERE Id=(?)";

			    try
			    {
					PreparedStatement preparedStmt = (PreparedStatement) DatabaseHandler.conn.clientPrepareStatement(query);
					preparedStmt.setString(1,String.valueOf(isTrue));
					preparedStmt.setInt(2, id);
					preparedStmt.execute();
				} 
			    catch (SQLException e)
			    {
					e.printStackTrace();
				}
			}
		return true;
	}
}
