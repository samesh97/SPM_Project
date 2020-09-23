package views.controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import database.DatabaseHandler_Locations;
import database.DatabaseHandler_Students;
import enums.Location;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class LocationsMainController implements Initializable {
	
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
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		buildingId.setCellValueFactory(new PropertyValueFactory<>("buildingId"));
		blockId.setCellValueFactory(new PropertyValueFactory<>("blockId"));
		roomId.setCellValueFactory(new PropertyValueFactory<>("roomId"));
		roomType.setCellValueFactory(new PropertyValueFactory<>("roomType"));
		
		tblLocationsView.setItems(locations);
		
	}
	
	private ObservableList<Location> locations = FXCollections.observableArrayList(
            new Location("NewBuilding", "E-Block", "LE1", "Lab"),
            new Location("MainBuilding", "C-Block", "A501", "Lecture"),
            new Location("MainBuilding", "F-Block", "401", "Lecture")
            
    );
	
	
	public void onAddNewLocationButtonClicked(ActionEvent event) {
		System.out.println("Hello From Add New Location");
		Location location = new Location(buildingIdText.getText(), blockIdText.getText(), roomIdText.getText(), roomTypeText.getText());
		tblLocationsView.getItems().add(location);
		
		buildingIdText.setText("");
		blockIdText.setText("");
		roomIdText.setText("");
		roomTypeText.setText("");
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
	
	public void onDeleteAllLocationsButtonClicked(ActionEvent event) {
		System.out.println("Hello From Delete All Locations");
		
		for ( int i = 0; i<tblLocationsView.getItems().size(); i++) {
			tblLocationsView.getItems().clear();
		}
		
	}
	
	public void onUpdateLocationButtonClicked(ActionEvent event) {
		System.out.println("Hello From Update Locations");
		lct.setBuildingId(buildingIdText.getText());
		lct.setBlockId(blockIdText.getText());
		lct.setRoomId(roomIdText.getText());
		lct.setRoomType(roomTypeText.getText());
		
		int selectedItem = tblLocationsView.getSelectionModel().getSelectedIndex();
		tblLocationsView.getItems().remove(selectedItem);
		
		Location location = new Location(buildingIdText.getText(), blockIdText.getText(), roomIdText.getText(), roomTypeText.getText());
		tblLocationsView.getItems().add(location);
		
		buildingIdText.setText("");
		blockIdText.setText("");
		roomIdText.setText("");
		roomTypeText.setText("");
	}
	
	public void onDeleteLocationButtonClicked(ActionEvent event) {
		System.out.println("Hello From Delete Location");
		int selectedItem = tblLocationsView.getSelectionModel().getSelectedIndex();
		tblLocationsView.getItems().remove(selectedItem);
		
		buildingIdText.setText("");
		blockIdText.setText("");
		roomIdText.setText("");
		roomTypeText.setText("");
	}
	



	
	

}
