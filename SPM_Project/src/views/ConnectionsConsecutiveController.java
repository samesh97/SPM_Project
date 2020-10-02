package views;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import database.DatabaseHandler_Connections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;

public class ConnectionsConsecutiveController implements Initializable {
	

	@FXML
	private ComboBox<String> subjectCodeComboBox;
	@FXML
	private ComboBox<String> groupIdComboBox;
	@FXML
	private ComboBox<String> lecturerComboBox;
	@FXML
	private ComboBox<String> instructorComboBox;
	@FXML
	private ComboBox<String> locationComboBox;
	@FXML
	private ComboBox<String> sessionTypeComboBox;
	

	public void onAddConsecutiveButtonClicked(){
		System.out.println("Add consecutive button clicked");
		
		String lecturer = lecturerComboBox.getValue();
		String instructor = instructorComboBox.getValue();
		String subjectCode = subjectCodeComboBox.getValue();
		String groupId = groupIdComboBox.getValue();
		String sessionType = sessionTypeComboBox.getValue();
		String location = locationComboBox.getValue();
		
		if( lecturer == null || instructor == null || subjectCode == null || groupId == null || sessionType == null || location == null) {
			showAlert("Please fill the empty feilds!");
		}
		else {
			try {
				boolean result= DatabaseHandler_Connections.addConsecutiveSessionLocation(lecturer, instructor, subjectCode, groupId, sessionType, location);
				if(result== true) {
					showAlert("A record is successfully added");
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
	
	
	//Set combo boxes
	public void setComboBoxes()
	{
		
		
		//Subject Code combo box
		ObservableList<String> subjectCode_data = FXCollections.observableArrayList();
	
		try {
			ResultSet rs = DatabaseHandler_Connections.getSubjectCodes();
			
			
			while (rs.next()) {
	            //get string from db 
				subjectCode_data.add(rs.getString("SubjectCode")); 
	        }
			
			subjectCodeComboBox.setItems(null);
			subjectCodeComboBox.setItems(subjectCode_data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//Lecturer name combo box
		ObservableList<String> lecturer_data = FXCollections.observableArrayList();
			
		try {
			ResultSet rs= DatabaseHandler_Connections.getLecturerNames();
				
			while(rs.next()){
					
			lecturer_data.add(rs.getString("LecturerName"));
			}
				
			lecturerComboBox.setItems(null);
			lecturerComboBox.setItems(lecturer_data);
				
		}
		catch(Exception e) {
				e.printStackTrace();
		}
			
		
		//Instructor name combo box
		ObservableList<String> instructor_data = FXCollections.observableArrayList();
					
		try {
			ResultSet rs= DatabaseHandler_Connections.getLecturerNames();
						
			while(rs.next()){
							
				instructor_data.add(rs.getString("LecturerName"));
		}
						
			instructorComboBox.setItems(null);
			instructorComboBox.setItems(instructor_data);
						
		}
		catch(Exception e) {
			e.printStackTrace();
		}
				
		
		//GroupId combo box
		ObservableList<String> group_id = FXCollections.observableArrayList();
		
		try {
			ResultSet rs= DatabaseHandler_Connections.getGroupIds();
					
			while(rs.next()){
				
				group_id.add(rs.getString("groupId"));
				group_id.add(rs.getString("subGroupId"));
			}
					
			groupIdComboBox.setItems(null);
			groupIdComboBox.setItems(group_id);
						
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	
		//Session type combo box
		ObservableList<String> session_type = FXCollections.observableArrayList();
		session_type.add("Lectuer/Tute");
		session_type.add("Lecture/Lab");
	
		sessionTypeComboBox.setItems(null);
		sessionTypeComboBox.setItems(session_type);
		
		//Location combo box
		ObservableList<String> location = FXCollections.observableArrayList();
		
		try {
			ResultSet rs= DatabaseHandler_Connections.getAllLocations();
							
			while(rs.next())
			{
				location.add(rs.getString("roomId"));
						
			}
							
			locationComboBox.setItems(null);
			locationComboBox.setItems(location);
							
		}
		catch(Exception e) {
			e.printStackTrace();
		}
						
	}

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		setComboBoxes();
	}

}
