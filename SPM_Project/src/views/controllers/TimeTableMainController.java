package views.controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import database.QueriesOfWorkingDays;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;

public class TimeTableMainController implements Initializable
{
	@FXML
	private GridPane timetablegrid;
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setGridPane();
		
	}
	

	public void setGridPane()
	{
		
			timetablegrid.setGridLinesVisible(true);
			ColumnConstraints column = new ColumnConstraints();
			column.setPercentWidth(100 / 7);
			
			
			
			for (int i = 0; i < 8; i++)
			{
		         
			        timetablegrid.getColumnConstraints().add(column);
			    
		     }
			Label label0 = new Label();
			label0.setAlignment(Pos.CENTER);
			label0.setMaxWidth(Double.MAX_VALUE);
			label0.setStyle("-fx-font-weight: bold");
			
			
			Label label1 = new Label("Monday");
			label1.setAlignment(Pos.CENTER);
			label1.setMaxWidth(Double.MAX_VALUE);
			label1.setStyle("-fx-font-weight: bold");
		
			Label label2 = new Label("Tuesday");
			label2.setAlignment(Pos.CENTER);
			label2.setMaxWidth(Double.MAX_VALUE);
			label2.setStyle("-fx-font-weight: bold");
			
			Label label3 = new Label("Wednesday");
			label3.setAlignment(Pos.CENTER);
			label3.setMaxWidth(Double.MAX_VALUE);
			label3.setStyle("-fx-font-weight: bold");
			
			Label label4 = new Label("Thursday");
			label4.setAlignment(Pos.CENTER);
			label4.setMaxWidth(Double.MAX_VALUE);
			label4.setStyle("-fx-font-weight: bold");
			
			Label label5 = new Label("Friday");
			label5.setAlignment(Pos.CENTER);
			label5.setMaxWidth(Double.MAX_VALUE);
			label5.setStyle("-fx-font-weight: bold");
			
			Label label6 = new Label("Saturday");
			label6.setAlignment(Pos.CENTER);
			label6.setMaxWidth(Double.MAX_VALUE);
			label6.setStyle("-fx-font-weight: bold");
			
			Label label7 = new Label("Sunday");
			label7.setAlignment(Pos.CENTER);
			label7.setMaxWidth(Double.MAX_VALUE);
			label7.setStyle("-fx-font-weight: bold");

			 timetablegrid.add(label0, 0, 0, 1, 1);
	        timetablegrid.add(label1, 1, 0, 1, 1);
	        timetablegrid.add(label2, 2, 0, 1, 1);
	        timetablegrid.add(label3, 3, 0, 1, 1);
	        timetablegrid.add(label4, 4, 0, 1, 1);
	        timetablegrid.add(label5, 5, 0, 1, 1);
	        timetablegrid.add(label6, 6, 0, 1, 1);
	        timetablegrid.add(label7, 7, 0, 1, 1);
	        
	       
	        
	        ResultSet set = QueriesOfWorkingDays.getSlotsByProgram(0);
	        int size = QueriesOfWorkingDays.getSlotsCountByProgram(0);
	        
	        
	        RowConstraints row = new RowConstraints();
	        //first row is for the days
	        row.setPercentHeight(100);	  
	        timetablegrid.getRowConstraints().add(row);

			if(size > 0)
			{
				row.setPercentHeight(100 / size);	  
				for(int i = 0; i < size; i++)
				{
					timetablegrid.getRowConstraints().add(row);
				}
			}
	      
	        
	        
	        
	        
	        
	        try 
	        {
	        	int i = 0;
	        	while(set.next())
	        	{
	        		i++;
	        		String sHours,sMinutes,eHours,eMinutes;
	        		int startHours = set.getInt(4);
	        		int startMinutes = set.getInt(5);
	        		int endHours = set.getInt(6);
	        		int endMinutes = set.getInt(7);
	        		
	        		if(startHours < 10)
	        		{
	        			sHours = "0" + startHours;
	        		}
	        		else
	        		{
	        			sHours = "" + startHours;
	        		}
	        		
	        		if(startMinutes < 10)
	        		{
	        			sMinutes = "0" + startMinutes;
	        		}
	        		else
	        		{
	        			sMinutes = "" + startMinutes;
	        		}
	        		
	        		if(endHours < 10)
	        		{
	        			eHours = "0" + endHours;
	        		}
	        		else
	        		{
	        			eHours = "" + endHours;
	        		}
	        		
	        		if(endMinutes < 10)
	        		{
	        			eMinutes = "0" + endMinutes;
	        		}
	        		else
	        		{
	        			eMinutes = "" + endMinutes;
	        		}
	        		
	        		
	        		
	        		String text = "" + sHours + ":" + sMinutes + " - " + eHours + ":" + eMinutes;
	        		
	        		
	        		Label label = new Label(text);
	        		label.setAlignment(Pos.CENTER);
	    			label.setMaxWidth(Double.MAX_VALUE);
	    			label.setStyle("-fx-font-weight: bold");
	    			
	        		timetablegrid.addRow(i, label);
	        		
	        	
	        	}
	        	
			
			} 
	        catch (SQLException e)
	        {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
