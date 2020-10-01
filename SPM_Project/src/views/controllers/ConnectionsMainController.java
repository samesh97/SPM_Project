package views.controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import database.DatabaseHandler_Connections;
import enums.Connection;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class ConnectionsMainController implements Initializable{
	
	@FXML
	private AnchorPane controllerPane;
	@FXML
	private Button btnViewAllDetails; 
	@FXML
	private Button btnGenerateRoom;
	@FXML
	private Button btnAdd;
	
	
	@FXML
	private ComboBox<String> tagComboBox;
	@FXML
	private ComboBox<String> subjectCodeComboBox;
	@FXML
	private ComboBox<String> groupIdComboBox;
	@FXML
	private ComboBox<String> lecturerComboBox;
	@FXML
	private ComboBox<String> prefferedRoomComboBox;
	
	@FXML
	private TextField roomIdGenerateText;
	
	@FXML
	private TableView<Connection> tblConnectionsView;
	@FXML
	private TableColumn<Connection, String> subjectCode;
	@FXML
	private TableColumn<Connection, String> tag;
	@FXML
	private TableColumn<Connection, String> lecturer;
	@FXML
	private TableColumn<Connection, String> groupId;
	@FXML
	private TableColumn<Connection, String> location;
	
	
	public void onViewAllDetailsButtonClicked() {
		System.out.println("View all details button clicked");
		Scene scene = btnViewAllDetails.getScene();
		AnchorPane pane = (AnchorPane) scene.lookup("#controllerPane");
		changeCenterContent(pane, "../ConnectionsView.fxml");
	}
	
	public void onGenerateRoomButtonClicked() {
		System.out.println("Generate Room button clicked");
		
		String tag = tagComboBox.getValue();
		
		if(tag == "lecture" || tag == "Lecture") {
			try {
				ResultSet result = DatabaseHandler_Connections.getRoomAccordingToTag(tag);
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	
	public void onAddButtonClicked(){
		System.out.println("Add button clicked");
		
		String subjectCode = subjectCodeComboBox.getValue();
		String tag = tagComboBox.getValue();
		String lecturer = lecturerComboBox.getValue();
		String groupId = groupIdComboBox.getValue();
		String location = roomIdGenerateText.getText();
		
		
		try {
			boolean result= DatabaseHandler_Connections.addConnections(subjectCode, tag, lecturer, groupId, location);
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
	
	
	public void showAlert(String message)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(message);
		alert.show();
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
	
	public void setComboBoxes()
	{
		//offered year combo box
		ObservableList<String> tag_data = FXCollections.observableArrayList();
		
		try {
			ResultSet rs = DatabaseHandler_Connections.getTagDetails();
			
			//tag_data.addAll(rs);
			
			while (rs.next()) {
	            //get string from db 
				tag_data.add(rs.getString("name")); 
	        }
			
			tagComboBox.setItems(null);
			tagComboBox.setItems(tag_data);
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
		
		
		//Preffered room combo box
		ObservableList<String> room_id = FXCollections.observableArrayList();
		
		try {
			ResultSet rs= DatabaseHandler_Connections.getPrefferedRooms();
					
			while(rs.next()){
				
				room_id.add(rs.getString("roomId"));
				
			}
					
			prefferedRoomComboBox.setItems(null);
			prefferedRoomComboBox.setItems(room_id);
					
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		DatabaseHandler_Connections.createConnectionTable();
		setComboBoxes();
		
	}
}
