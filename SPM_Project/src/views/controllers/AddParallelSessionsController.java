package views.controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import database.DatabaseHandler_Lecturers;
import database.DatabaseHandler_Parallel_Sessions;
import database.DatabaseHandler_Students;
import enums.Student;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class AddParallelSessionsController implements Initializable{

	@FXML
	private Button cancelBtn;
	@FXML
	private Button btn_CreateSession;
	
	@FXML
	private ComboBox<String> add_lecturer;
	@FXML
	private ComboBox<String> add_subject;
	@FXML
	private ComboBox<String> add_tag;
	@FXML 
	private ComboBox<String> add_group;
	@FXML
	private TextField add_studentCount;
	@FXML
	private TextField add_duration;
	
	public void cancelButtonClicked(ActionEvent event) {
		
		System.out.println("View All Sessions clicked");
		Scene scene =  cancelBtn.getScene();
		AnchorPane pane = (AnchorPane) scene.lookup("#controllerPane");
		changeCenterContent(pane,"../ParallelSessions.fxml");
	}
	
	
	public void onCreateSessionClicked() {
		
		System.out.println("View Create Sessions clicked");
		
		String LecturerName =add_lecturer.getValue();
		String SubjectName =add_subject.getValue();
		String TagName =add_tag.getValue();
		String GroupName=add_group.getValue();
		String studentCount =add_studentCount.getText();
		int catID = ParallelSessionnsController.category;
		
		
		
	
		if(LecturerName == null ||studentCount.equals("") || SubjectName == null|| TagName == null|| GroupName == null) {
			
			showAlert("Please enter details correctly");
		}
		
		else {
			int SlotID = getSlotID();
			try {
			    boolean result= DatabaseHandler_Parallel_Sessions.addSession(LecturerName, SubjectName, TagName, GroupName, studentCount, SlotID,catID);
//				boolean result= DatabaseHandler_Students.createStudentTable();
				if(result== true) {
					resetField() ;
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
	//check categories 

	//rest field
	public void resetField() {
		add_lecturer.setValue(null);
		add_subject.setValue(null);
		add_tag.setValue(null);
		add_group.setValue(null);
		add_studentCount.setText("");
	}
	//get slot id
	public int getSlotID() {
		int id = 0;
		ResultSet set = DatabaseHandler_Parallel_Sessions.getAllSessions();
		if(set != null)
		{
			try 
			{
				while(set.next())
				{
					id = set.getInt(2); 
					
				}
				return id;
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return -1;
		
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
		//Lecturer name combo box
		ObservableList<String> lecturer_data = FXCollections.observableArrayList();
	
		try {
		ResultSet rs= DatabaseHandler_Lecturers.getDropDownLecturers();
		
		while(rs.next()){
			
		lecturer_data.add(rs.getString("LecturerName"));
		}
		
		add_lecturer.setItems(null);
		add_lecturer.setItems(lecturer_data);
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		//Subject name combo box
		ObservableList<String> subject_data = FXCollections.observableArrayList();
		
		if(ParallelSessionnsController.category == 2) {
			subject_data.add("Deep Learning");
			subject_data.add("Image processing");
			add_subject.setItems(null);
			add_subject.setItems(subject_data);
		}
		else if(ParallelSessionnsController.category == 3) {
			subject_data.add("Machine Learning ");
			subject_data.add("Parallel Computing");
			add_subject.setItems(null);
			add_subject.setItems(subject_data);
		}
		else {
				try {
				ResultSet rs= DatabaseHandler_Lecturers.getDropDownSubjects();
				
				while(rs.next()){
			
				subject_data.add(rs.getString("SubjectName"));
				}
				
				add_subject.setItems(null);
				add_subject.setItems(subject_data);
				
				}
				catch(Exception e) {
					e.printStackTrace();
				}
		}
		
		//Tag name combo box
		ObservableList<String> tag_data = FXCollections.observableArrayList();
				
		try {
		ResultSet rs= DatabaseHandler_Lecturers.getDropDownTags();
				
		while(rs.next()){
			
			tag_data.add(rs.getString("name"));
		}
				
		add_tag.setItems(null);
		add_tag.setItems(tag_data);
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
				
		
		//Student group combo box
		ObservableList<String> group_data = FXCollections.observableArrayList();
		
		try {
		ResultSet rs= DatabaseHandler_Lecturers.getDropDownGroups();
				
		while(rs.next()){
			
			group_data.add(rs.getString("groupId"));
			group_data.add(rs.getString("subGroupId"));
			
		}
				
		add_group.setItems(null);
		add_group.setItems(group_data);
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		
	}
	
	
	public void showAlert(String message)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(message);
		alert.show();
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		DatabaseHandler_Parallel_Sessions.createParallelSessionListTable();
		setComboBoxes();
		
	}
}
