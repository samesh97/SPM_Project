package views;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import database.DatabaseHandler_Lecturers;
import database.DatabaseHandler_Locations;
import database.DatabaseHandler_Students;
import enums.Lecturer;
import enums.Location;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class LocationsMainController implements Initializable {
	static String id=null;
	
	@FXML
	private AnchorPane controllerPane;
	@FXML
	private Button btnAddNewLocation;
	@FXML
	private Button btnUpdateLocation;
	@FXML
	private Button btnDeleteAllLocations;
	
	
	@FXML
	private TableView<Location> tblLocationsView;
	@FXML
	private TableColumn<Location, String> locationId;
	@FXML
	private TableColumn<Location, String> buildingId;
	@FXML
	private TableColumn<Location, String> blockId;
	@FXML
	private TableColumn<Location, String> roomId;
	@FXML
	private TableColumn<Location, String> roomType;
	
	@FXML
	private TextField buildingIdText;
	@FXML
	private TextField blockIdText;
	@FXML
	private TextField roomIdText;
	@FXML
	private TextField roomTypeText;
	
	private String locationid;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		DatabaseHandler_Locations.createLocationTable();
		mapFields();
		setTableView();
		
	}
	
	
//	private ObservableList<Location> locations = FXCollections.observableArrayList(
//            new Location("NewBuilding", "E-Block", "LE1", "Lab"),
//            new Location("MainBuilding", "C-Block", "A501", "Lecture"),
//            new Location("MainBuilding", "F-Block", "401", "Lecture")
//            
//    );
	
	
	public void onAddNewLocationButtonClicked(ActionEvent event) {
		System.out.println("Hello From Add New Location");
//		Location location = new Location(buildingIdText.getText(), blockIdText.getText(), roomIdText.getText(), roomTypeText.getText());
//		tblLocationsView.getItems().add(location);
		
		String buildingId = buildingIdText.getText();
		String blockId = blockIdText.getText();
		String roomId = roomIdText.getText();
		String roomType = roomTypeText.getText();
		
		
		if(buildingId.equals("") || blockId.equals("") || roomId.equals("") || roomType.equals("")) {
			showAlert("Please fill the empty fields");
		}
		
		else {
			try {
			    boolean result= DatabaseHandler_Locations.addLocations(buildingId, blockId, roomId, roomType);
				if(result== true) {
					showAlert("A record is successfully added");
				}
				else {
					showAlert("Unsuccessful");
				}
		
			}catch(Exception e) {
		    	showAlert("Please enter details correctly");
		    }
			
			buildingIdText.setText("");
			blockIdText.setText("");
			roomIdText.setText("");
			roomTypeText.setText("");
			
			ResultSet res = DatabaseHandler_Locations.getAllLocations();
			setTableView();
		}
		
		
	}

	private Location lct;
	
	public void onTableItemSelect() {
		lct = tblLocationsView.getSelectionModel().getSelectedItem();
		
		if(lct != null) {
			buildingIdText.setText(lct.getBuildingId());
			blockIdText.setText(lct.getBlockId());
			roomIdText.setText(lct.getRoomId());
			roomTypeText.setText(lct.getRoomType());
		}
	}
	
	public void mapFields() {
		locationId.setCellValueFactory(new PropertyValueFactory<>("locationId"));
		buildingId.setCellValueFactory(new PropertyValueFactory<>("buildingId"));
		blockId.setCellValueFactory(new PropertyValueFactory<>("blockId"));
		roomId.setCellValueFactory(new PropertyValueFactory<>("roomId"));
		roomType.setCellValueFactory(new PropertyValueFactory<>("roomType"));
	}
	
	private void setTableView() 
	{
		
		ObservableList<Location> locationsList = FXCollections.observableArrayList();
		ResultSet Locations_set = DatabaseHandler_Locations.getAllLocations();
		if(Locations_set != null)
		{
			try 
			{
				while(Locations_set.next())
				{
					Location loc = new Location();
					loc.setLocationId(Locations_set.getString(1));
					loc.setBuildingId(Locations_set.getString(2));
					loc.setBlockId(Locations_set.getString(3));
					loc.setRoomId(Locations_set.getString(4));
					loc.setRoomType(Locations_set.getString(5));
					
					
					
					locationsList.add(loc);
				}
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		tblLocationsView.setItems(null);
		tblLocationsView.setItems(locationsList);
		
	}
	
	public void onDeleteAllLocationsButtonClicked(ActionEvent event) {
		System.out.println("Hello From Delete All Locations");
		
		for ( int i = 0; i<tblLocationsView.getItems().size(); i++) {
			tblLocationsView.getItems().clear();
		}
		
//		DatabaseHandler_Locations.deleteAllLocations();
		showAlert("All the records are deleted!");
//		
//		//to refresh the data grid
//		setTableView();
		
	}
	
	public void onUpdateLocationButtonClicked(ActionEvent event) {
//		System.out.println("Hello From Update Locations");
//		lct.setBuildingId(buildingIdText.getText());
//		lct.setBlockId(blockIdText.getText());
//		lct.setRoomId(roomIdText.getText());
//		lct.setRoomType(roomTypeText.getText());
//		
//		int selectedItem = tblLocationsView.getSelectionModel().getSelectedIndex();
//		tblLocationsView.getItems().remove(selectedItem);
//		
//		Location location = new Location(buildingIdText.getText(), blockIdText.getText(), roomIdText.getText(), roomTypeText.getText());
//		tblLocationsView.getItems().add(location);
//		
//		buildingIdText.setText("");
//		blockIdText.setText("");
//		roomIdText.setText("");
//		roomTypeText.setText("");
		
		System.out.println("Update this record");
		 
		String buildingid = buildingIdText.getText();
		String blockid = blockIdText.getText();
		String roomid = roomIdText.getText();
		String roomtype = roomTypeText.getText();
		
		String id = LocationsMainController.id;
		
		 try {
			boolean result= DatabaseHandler_Locations.updateLocation(id, buildingid, blockid, roomid, roomtype);
			if(result== true) {
				showAlert("Successfully updated");
			}
			else{
				showAlert("Unsuccessful update");
			}
				
		 }
		 catch(Exception e) {
			    showAlert("Please enter details correctly");
		 }
				
			    
		 
		
	}
	
	public void onDeleteLocationButtonClicked(ActionEvent event) {
		System.out.println("Hello From Delete Location");
//		int selectedItem = tblLocationsView.getSelectionModel().getSelectedIndex();
//		tblLocationsView.getItems().remove(selectedItem);
//		
//		buildingIdText.setText("");
//		blockIdText.setText("");
//		roomIdText.setText("");
//		roomTypeText.setText("");
		
//		try {
//		    boolean result= DatabaseHandler_Locations.deleteLocations(locationid);
//			if(result== true) {
//				showAlert("Successfully Deleted");
//			}
//			else {
//				showAlert("Unsuccessful");
//			}
//			mapFields();
//			setTableView();
//	
//		}catch(Exception e) {
//	    	showAlert("Error!");
//	    }
		
		
		String Locationid = getSelectedRecord();
		
		
		if(Locationid==null) {
			System.out.println("No record is selected");
			showAlert("Please select a record first");
			
		}
		else {
			DatabaseHandler_Locations.deleteLocations(Locationid);
			showAlert("A record is deleted!");
			
			//to refresh the data grid
			setTableView();
			
			buildingIdText.setText("");
			blockIdText.setText("");
			roomIdText.setText("");
			roomTypeText.setText("");
		}
	}
	

	public void showAlert(String message)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(message);
		alert.show();
	}

	
	
	public String getSelectedRecord() {
		Location record = tblLocationsView.getSelectionModel().getSelectedItem();
		if(record==null) {
			System.out.println("No record is selected");
			return null;
		}
		else {
			System.out.println("A redord is selected");
			return record.getLocationId();
		}
		
	}
	
	

}

//Done
//Done