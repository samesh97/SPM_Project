package views.controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import database.DatabaseHandler_Lecturers;
import database.DatabaseHandler_NotAvailbleTime;
import database.DatabaseHandler_Students;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;



public class AddNotAvailableTimeController implements Initializable {

	@FXML private ComboBox<String> typeDrp;
	@FXML private ComboBox<String> nameDrp;
	@FXML private TextField timeTxt;
	@FXML private TextField durationTxt;
	@FXML private ComboBox<String> dayDrp;
	
	
	@FXML Button addBtn;
	
	public void addButtonClicked(ActionEvent event){
		
		String type = typeDrp.getValue();
		String name = nameDrp.getValue();
		String startingTime = timeTxt.getText();
		String duration = durationTxt.getText();
		String day = dayDrp.getValue();
		
		if(type == null || startingTime.equals("")||duration.equals("")||name == null || day == null) {
			
			showAlert("Please enter details correctly");
		}
		else {
			try {
			    boolean result= DatabaseHandler_NotAvailbleTime.addNotAllocatedTime(type, name, startingTime, duration, day);
//				boolean result= DatabaseHandler_Students.createStudentTable();
				if(result== true) {
					showAlert("Successfully added");
				}
				else {
					showAlert("Unsuccessful");
				}
		
				}catch(Exception e) {
					showAlert("Please enter details correctly");
				}
	}
		
		
		
		
	}
	public void showAlert(String message)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(message);
		alert.show();
		
	}
	
	//Set combo boxes values
	public void setComboBox(){
		
		ObservableList<String> programType = FXCollections.observableArrayList();
		programType.add("lecturers");
		programType.add("sessions");
		programType.add("groups");
		programType.add("Sub-Groups");
		
		typeDrp.setItems(null);
		typeDrp.setItems(programType);
		
	}
	
	//set days
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
	//set lecturers
	public void lecComboBox() {
		
		ObservableList<String> list = FXCollections.observableArrayList();
		ResultSet set = DatabaseHandler_Lecturers.getAllLecturers();
		if(set != null)
		{
			try 
			{
				while(set.next())
				{
					
					list.add(set.getString(1));
				}
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		nameDrp.setItems(null);
		nameDrp.setItems(list);
	
	}
	
	//getSessions
	public void sessionComboBox() {
		
		ObservableList<String> list = FXCollections.observableArrayList();
		ResultSet set = DatabaseHandler_Lecturers.getAllSubjects();
		if(set != null)
		{
			try 
			{
				while(set.next())
				{
					
					list.add(set.getString(1));
				}
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		nameDrp.setItems(null);
		nameDrp.setItems(list);
	
	}
	//groupsCombo box
		public void groupComboBox() {
			
			ObservableList<String> list = FXCollections.observableArrayList();
			ResultSet set = DatabaseHandler_Students.getAllStudents();
			if(set != null)
			{
				try 
				{
					while(set.next())
					{
						
						list.add(set.getString(6));
					}
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			nameDrp.setItems(null);
			nameDrp.setItems(list);
		
		}
		//groupsCombo box
				public void subGroupComboBox() {
					
					ObservableList<String> list = FXCollections.observableArrayList();
					ResultSet set = DatabaseHandler_Students.getAllStudents();
					if(set != null)
					{
						try 
						{
							while(set.next())
							{
								
								list.add(set.getString(7));
							}
						} 
						catch (SQLException e) 
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					nameDrp.setItems(null);
					nameDrp.setItems(list);
				
				}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		setComboBox();
		setdaysComboBox();
		typeDrp.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) -> {
	        
			if(newValue.equals("lecturers")) {
				lecComboBox();
			}
			else if(newValue.equals("sessions")){
				sessionComboBox();
			}
			else if(newValue.equals("groups")) {
				groupComboBox();
			}
			else if (newValue.equals("Sub-Groups")) {
				subGroupComboBox();
			}
		
			
		}
		); 
		
	}
	

	
	
}
