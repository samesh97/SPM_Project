package views.controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import database.DatabaseHandler_Lecturers;
import enums.Lecturer;
import enums.Subject;
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

public class LecturersViewController implements Initializable {

	@FXML 
	private Button btn_AddNewLecturer;
	
    @FXML 
	private Button btn_ViewAllLecturersUpdate;
    
	
	@FXML
	private TableView<Lecturer> tbl_Lecturer;
	
	@FXML
	private Button btn_UpdateLecturerRecord;
	
	@FXML
	private Button btn_DeleteLecturerRecord;
	
	
	

	
	@FXML
	private TableColumn<Subject,String> column_LecturerName;
	@FXML
	private TableColumn<Subject,String> column_EmployeeID;
	@FXML
	private TableColumn<Subject,String>  column_Faculty;
	@FXML
	private TableColumn<Subject,String> column_Department;
	@FXML
	private TableColumn<Subject,String> column_Center;
	@FXML
	private TableColumn<Subject,String>  column_Building;
	@FXML
	private TableColumn<Subject,String>  column_Level;
	@FXML
	private TableColumn<Subject,String> column_Rank;
	@FXML
	private TableColumn  column_Update2;
	@FXML
	private TableColumn column_Delete2;
	
	@FXML
	private TextField search_Lecturer;
	@FXML
	private Button btn_SearchLecturer;
	
	
	public void onAddNewLecturerClicked(ActionEvent event) {
		System.out.println("Vuew all Subjects clicked");
		Scene scene = btn_AddNewLecturer.getScene();
		AnchorPane pane = (AnchorPane) scene.lookup("#controllerPane");
		changeCenterContent(pane,"../LecturersMain.fxml");
		
	}
	
	public void onUpdateLecturerRecord(ActionEvent event){
		System.out.println("Update the lecturer details");
		String Lecturerid = getSelectedRecord();
		
		if(Lecturerid==null) {
			System.out.println("No record is selected");
			showAlert("Please select a record first"); 
			
		}
		else {
			Scene scene = btn_UpdateLecturerRecord.getScene();
			AnchorPane pane = (AnchorPane) scene.lookup("#controllerPane");
			changeCenterContent(pane,"../LecturersUpdate.fxml");
			
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
	
	
	
	private void showAlert(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(message);
		alert.show();
		
	}

	

	public void mapFields()
	{
		column_LecturerName.setCellValueFactory(new PropertyValueFactory<Subject,String>("LecturerName"));
		column_EmployeeID.setCellValueFactory(new PropertyValueFactory<Subject,String>("EmployeeID"));
		column_Faculty.setCellValueFactory(new PropertyValueFactory<Subject,String>("Faculty"));
		column_Department.setCellValueFactory(new PropertyValueFactory<Subject,String>("Department"));
		column_Center.setCellValueFactory(new PropertyValueFactory<Subject,String>("Center"));
		column_Building.setCellValueFactory(new PropertyValueFactory<Subject,String>("Building"));
		column_Level.setCellValueFactory(new PropertyValueFactory<Subject,String>("Level"));
		column_Rank.setCellValueFactory(new PropertyValueFactory<Subject,String>("Rank"));
	}

	private void setTableView() 
	{
		
		ObservableList<Lecturer> Lecturerlist = FXCollections.observableArrayList();
		ResultSet Lecturers_set = DatabaseHandler_Lecturers.getAllLecturers();
		if(Lecturers_set != null)
		{
			try 
			{
				while(Lecturers_set.next())
				{
					Lecturer lec = new Lecturer();
					lec.setLecturerName(Lecturers_set.getString(1));
					lec.setEmployeeID(Lecturers_set.getString(2));
					lec.setFaculty(Lecturers_set.getString(3));
					lec.setDepartment(Lecturers_set.getString(4));
					lec.setCenter(Lecturers_set.getString(5));
					lec.setBuilding(Lecturers_set.getString(6));
					lec.setLevel(Lecturers_set.getString(7));
					lec.setRank(Lecturers_set.getString(8));
					
					
					
					Lecturerlist.add(lec);
				}
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		tbl_Lecturer.setItems(null);
		tbl_Lecturer.setItems(Lecturerlist);
		
	}
	
	public void onSearchedLecturer(ActionEvent event) {
		String searchId = search_Lecturer.getText();
		if(searchId ==null||searchId.equals("")) {
			showAlert("Enter a valid lecturer ID");
		}
		else 
		{
			ObservableList<Lecturer> Lecturerlist = FXCollections.observableArrayList();
			ResultSet Lecturers_set = DatabaseHandler_Lecturers.getAllLecturers(searchId);
			if(Lecturers_set != null)
			{
				try 
				{
					while(Lecturers_set.next())
					{
						Lecturer lec = new Lecturer();
						lec.setLecturerName(Lecturers_set.getString(1));
						lec.setEmployeeID(Lecturers_set.getString(2));
						lec.setFaculty(Lecturers_set.getString(3));
						lec.setDepartment(Lecturers_set.getString(4));
						lec.setCenter(Lecturers_set.getString(5));
						lec.setBuilding(Lecturers_set.getString(6));
						lec.setLevel(Lecturers_set.getString(7));
						lec.setRank(Lecturers_set.getString(8));
					
						
						Lecturerlist.add(lec);
					}
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			tbl_Lecturer.setItems(null);
			tbl_Lecturer.setItems(Lecturerlist);
		}
			
	}
	
	
	public void onViewAllEnteredLecturersClicked(ActionEvent action) {
		setTableView();
	}
	
	
	public String getSelectedRecord() {
		Lecturer record = tbl_Lecturer.getSelectionModel().getSelectedItem();
		if(record==null) {
			System.out.println("No record is selected");
			return null;
		}
		else {
			System.out.println("A redord is selected");
			return record.getEmployeeID();
		}
		
	}
	
	public void onDeleteLecturerRecord(ActionEvent event) {
		String Lecturerid = getSelectedRecord();
		
	
		if(Lecturerid==null) {
			System.out.println("No record is selected");
			showAlert("Please select a record first");
			
		}
		else {
		DatabaseHandler_Lecturers.deleteLecturers(Lecturerid);
		
		//to refresh the data grid
		setTableView();
		}
	}
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mapFields();
		setTableView();
		
		
	}
	
	
}
