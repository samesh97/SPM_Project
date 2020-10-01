package views.controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import database.DatabaseHandler_Lecturers;
import database.DatabaseHandler_NotAvailbleTime;
import database.DatabaseHandler_Students;
import database.DatabaseHandler_consecutiveSessions;
import enums.Day;
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

public class ConsecutiveSessionsController implements Initializable {
	
	
	@FXML private ComboBox<String> lecDrp;
	@FXML private ComboBox<String> consDrp;
	@FXML private ComboBox<String> subDrp;
	@FXML private ComboBox<String> gidDrp;
	@FXML private ComboBox<String> typeDrp;
	@FXML private ComboBox<String> dayDrp;
	@FXML private TextField timeTxt;
	@FXML private TextField durationTxt;
	@FXML private TextField durationTxt2;
	
	static int dayID;
	
	@FXML Button addBtn;
	
	public void addButtonClicked(ActionEvent event){
		
		String lecturer = lecDrp.getValue();
		String constructor = consDrp.getValue();
		String subject = subDrp.getValue();
		String gid = gidDrp.getValue();
		String type = typeDrp.getValue();
		String startingTime = timeTxt.getText();
		String durationFirst = durationTxt.getText();
		String durationSecond = durationTxt2.getText();
		String day = dayDrp.getValue();
		initDate(day);
		if(lecturer == null || startingTime.equals("")||durationSecond.equals("")||durationFirst.equals("")||subject == null ||gid == null ||constructor == null || day == null) {
			
			showAlert("Please enter details correctly");
		}
		else {
			try {
			    boolean result= DatabaseHandler_consecutiveSessions.addConsecutiveSessions(lecturer, constructor, subject, gid, type, startingTime, durationFirst, durationSecond, dayID);
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
	
	//define the day
			public void initDate(String date) {
				if(date.equals("Monday")) {
					dayID = Day.MONDAY;
				}
				else if (date.equals("Tuesday")) {
					dayID = Day.TUESDAY;
				}
				else if (date.equals("Wednesday")) {
					dayID = Day.WEDNESDAY;
				}
				else if (date.equals("Thursday")) {
					dayID = Day.THURSDAY;
				}
				else if (date.equals("Friday")) {
					dayID = Day.FRIDAY;
				}
				else if (date.equals("Saturday")) {
					dayID = Day.SATURDAY;
				}
				else if (date.equals("Sunday")) {
					dayID = Day.SUNDAY;
				}
				System.out.println("Date set successfully!");
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
	public void setTypeComboBox(){
		
		ObservableList<String> type = FXCollections.observableArrayList();
		type.add("Lectuer/Tute");
		type.add("Lecture/Lab");
		
		
		typeDrp.setItems(null);
		typeDrp.setItems(type);
		
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
		lecDrp.setItems(null);
		lecDrp.setItems(list);
		consDrp.setItems(null);
		consDrp.setItems(list);
	
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
		subDrp.setItems(null);
		subDrp.setItems(list);
	
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
			gidDrp.setItems(null);
			gidDrp.setItems(list);
		
		}
	


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		setdaysComboBox();
		
	        
				lecComboBox();
			
				sessionComboBox();
			
				groupComboBox();
				setTypeComboBox();
				
				//create table 
				DatabaseHandler_consecutiveSessions.createConsecutiveTable();
			
	
		
	}
	
	

}
