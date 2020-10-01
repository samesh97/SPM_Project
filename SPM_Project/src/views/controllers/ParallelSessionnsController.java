package views.controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import database.DatabaseHandler_Lecturers;
import database.DatabaseHandler_Students;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;



public class ParallelSessionnsController implements Initializable{

	
	@FXML
	private ComboBox<String> StartingtimeDrp;
	@FXML
	private ComboBox<String> dayDrp;
	@FXML
	private TextField add_duration;
	@FXML 
	private Button btn_CreateSession;
	
	
	
	public void createSessionClicked() {
		
		
		
	}
	//set comboBoxes
	public void setComboBox() {
		String resultValue;
		ObservableList<String> list = FXCollections.observableArrayList();
		ResultSet set = DatabaseHandler_Students.getAllSlots();
		if(set != null)
		{
			try 
			{
				while(set.next())
				{
					resultValue = set.getString(4).toString() +"."+set.getString(5).toString(); 
					list.add(resultValue);
				}
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		StartingtimeDrp.setItems(null);
		StartingtimeDrp.setItems(list);
		
	}
	 public void setdaysComboBox(){
			
			ObservableList<String> day = FXCollections.observableArrayList();
			day.add("Monday");
			day.add("Tuesday");
			day.add("Wednesday");
			day.add("Thursday");
			day.add("Friday");
			day.add("Saturday");
			day.add("Sunday");
			
			dayDrp.setItems(null);
			dayDrp.setItems(day);
			
		}

	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		setComboBox() ;
		setdaysComboBox();
	}
}
