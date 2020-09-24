package views.controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import database.DatabaseHandler_Lecturers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SessionsMainController implements Initializable{

	@FXML
	private Button btn_ViewAllSessions;
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
	
	public void onViewAllSessionsClicked(ActionEvent event) {
		
		System.out.println("View All Sessions clicked");
		Scene scene =  btn_ViewAllSessions.getScene();
		AnchorPane pane = (AnchorPane) scene.lookup("#controllerPane");
		changeCenterContent(pane,"../SessionsView.fxml");
	}
	
	
	public void onCreateSessionClicked() {
		
		System.out.println("View Create Sessions clicked");
		
		String LecturerName =add_lecturer.getValue();
		String SubjectName =add_subject.getValue();
		String TagName =add_tag.getValue();
		String GroupName=add_group.getValue();
		String studentCount =add_studentCount.getText();
		String duration=add_duration.getText();
		
		int StudentCount= Integer.parseInt(studentCount);
		int Duration =Integer.parseInt(duration);
		
		
		
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
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		DatabaseHandler_Lecturers.createSessionTable();
		setComboBoxes();
		
	}
	
}
