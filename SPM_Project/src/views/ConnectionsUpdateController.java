package views;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import database.DatabaseHandler_Connections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class ConnectionsUpdateController implements Initializable {
	
	@FXML
	private ComboBox<String> tagUpdateComboBox;
	@FXML
	private ComboBox<String> subjectCodeUpdateComboBox;
	@FXML
	private ComboBox<String> lecturerUpdateComboBox;
	@FXML
	private ComboBox<String> groupIdUpdateComboBox;
	@FXML
	private ComboBox<String> locationUpdateComboBox;
	
	
	
	public void onupdateRecordBtnClicked() {
		System.out.println("Update clicked");
		
		
	}

	
	public void setComboBoxes()
	{
		//tag combo box
		ObservableList<String> tag_data = FXCollections.observableArrayList();
		
		try {
			ResultSet rs = DatabaseHandler_Connections.getTagDetails();
			
			//tag_data.addAll(rs);
			
			while (rs.next()) {
	            //get string from db 
				tag_data.add(rs.getString("name")); 
	        }
			
			tagUpdateComboBox.setItems(null);
			tagUpdateComboBox.setItems(tag_data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Subject Code combo box
		ObservableList<String> subjectCode_data = FXCollections.observableArrayList();
	
		try {
			ResultSet rs = DatabaseHandler_Connections.getSubjectCodes();
			
			
			while (rs.next()) {
	            //get string from db 
				subjectCode_data.add(rs.getString("SubjectCode")); 
	        }
			
			subjectCodeUpdateComboBox.setItems(null);
			subjectCodeUpdateComboBox.setItems(subjectCode_data);
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
				
			lecturerUpdateComboBox.setItems(null);
			lecturerUpdateComboBox.setItems(lecturer_data);
				
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
					
			groupIdUpdateComboBox.setItems(null);
			groupIdUpdateComboBox.setItems(group_id);
						
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		//Location combo box
		ObservableList<String> location = FXCollections.observableArrayList();
		
		try {
			ResultSet rs= DatabaseHandler_Connections.getAllLocations();
							
			while(rs.next())
			{
				location.add(rs.getString("roomId"));
						
			}
							
			locationUpdateComboBox.setItems(null);
			locationUpdateComboBox.setItems(location);
							
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
