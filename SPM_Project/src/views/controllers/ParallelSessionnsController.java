package views.controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import database.DatabaseHandler_Parallel_Sessions;
import database.DatabaseHandler_Students;
import enums.Day;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;



public class ParallelSessionnsController implements Initializable{

	
	@FXML
	private ComboBox<String> startingTimeDrp;
	@FXML
	private ComboBox<String> dayDrp;
	@FXML
	private TextField add_duration;
	@FXML 
	private Button btn_CreateSession;
	static int dayID;
	
	
	public void createSessionClicked() {
		
		String startingTime = startingTimeDrp.getValue();
		String day = dayDrp.getValue();
		String duration = add_duration.getText();
		
		if(startingTime == null ||duration.equals("") || day == null) {
			
			showAlert("Please enter details correctly");
		}
		else {
			int slotID = getSlotID(startingTime);
			
			initDate(day);
		
			try {
			    boolean result= DatabaseHandler_Parallel_Sessions.addParallelSessione(slotID, duration, dayID);
//				boolean result= DatabaseHandler_Students.createStudentTable();
				if(result== true) {
					System.out.println("Vuew all Subjects clicked");
					Scene scene = btn_CreateSession.getScene();
					AnchorPane pane = (AnchorPane) scene.lookup("#controllerPane");
					changeCenterContent(pane,"../AddParallelSessions.fxml");
				}
				else {
					showAlert("Unsuccessful");
				}
		
				}catch(Exception e) {
					showAlert("Please enter details correctly");
				}
	}
		
		
		
		
	}
	public void changeCenterContent(AnchorPane controllerPane,String fxmlFileName)
	{
		
		try
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
			Node _node = loader.load();
			AnchorPane.setTopAnchor(_node, 0.0);
			AnchorPane.setRightAnchor(_node, 0.0);
			AnchorPane.setLeftAnchor(_node, 0.0);
			AnchorPane.setBottomAnchor(_node, 0.0);
			// container child clear
			controllerPane.getChildren().clear();

			// new container add
			controllerPane.getChildren().add(_node);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void showAlert(String message)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(message);
		alert.show();
		
	}
	//get slot id
	public int getSlotID(String Time) {
		
		int id;
		ResultSet set = DatabaseHandler_Students.getAllSlots();
		if(set != null)
		{
			try 
			{
				while(set.next())
				{
					if(Time.equals(set.getString(4).toString() +"."+set.getString(5).toString())) {
						
						id = set.getInt(1);
						return id;
						
					}
					else {}
			
				}
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return 0;
		
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
				else {
					
				}
				System.out.println("Date set successfully!");
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
		startingTimeDrp.setItems(null);
		startingTimeDrp.setItems(list);
		
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
