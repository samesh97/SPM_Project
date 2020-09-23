package views.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

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
			
			RowConstraints row = new RowConstraints();
			row.setPercentHeight(100 / 7);
	         //column.setMaxWidth(timetablegrid.getMaxWidth() / 7);
//	         column.setMinWidth(timetablegrid.getMaxWidth() / 7);
			for (int i = 0; i < 7; i++) {
		         
			        timetablegrid.getColumnConstraints().add(column);
			        timetablegrid.getRowConstraints().add(row);
		     }
			Label label1 = new Label("Monday");
			label1.setAlignment(Pos.CENTER);
			label1.setMaxWidth(Double.MAX_VALUE);
		
			Label label2 = new Label("Tuesday");
			label2.setAlignment(Pos.CENTER);
			label2.setMaxWidth(Double.MAX_VALUE);
			
			Label label3 = new Label("Wednesday");
			label3.setAlignment(Pos.CENTER);
			label3.setMaxWidth(Double.MAX_VALUE);
			
			Label label4 = new Label("Thursday");
			label4.setAlignment(Pos.CENTER);
			label4.setMaxWidth(Double.MAX_VALUE);
			
			Label label5 = new Label("Friday");
			label5.setAlignment(Pos.CENTER);
			label5.setMaxWidth(Double.MAX_VALUE);
			
			Label label6 = new Label("Saturday");
			label6.setAlignment(Pos.CENTER);
			label6.setMaxWidth(Double.MAX_VALUE);
			
			Label label7 = new Label("Sunday");
			label7.setAlignment(Pos.CENTER);
			label7.setMaxWidth(Double.MAX_VALUE);

	        timetablegrid.add(label1, 0, 0, 1, 1);
	        timetablegrid.add(label2, 1, 0, 1, 1);
	        timetablegrid.add(label3, 2, 0, 1, 1);
	        timetablegrid.add(label4, 3, 0, 1, 1);
	        timetablegrid.add(label5, 4, 0, 1, 1);
	        timetablegrid.add(label6, 5, 0, 1, 1);
	        timetablegrid.add(label7, 6, 0, 1, 1);
	}

}
