package views.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MainController implements Initializable
{
	@FXML
	private AnchorPane controllerPane;
	@FXML
	private Button btn_students;
	@FXML
	private Button btn_tags;
	@FXML
	private Button btn_subjects;
	@FXML
	private Button btn_lecturers;
	@FXML
	private Button btn_working_days;
	@FXML
	private Button btn_locations;
	@FXML
	private Button btn_connections;
	@FXML
	private Button btn_statistics;
	@FXML
	private Button btn_sessions;
	@FXML
	private Button btn_time_table;
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		//start default when load the FXML
		highlightClickedButton(btn_students);
		changeCenterContent("../StudentsMain.fxml");
	}
	
	public void onStudentButtonClicked(ActionEvent event)
	{
		highlightClickedButton(btn_students);
		changeCenterContent("../StudentsMain.fxml");
	}
	public void onSessionsButtonClicked(ActionEvent event)
	{
		highlightClickedButton(btn_sessions);
		changeCenterContent("../SessionsMain.fxml");
	}
	public void onTagButtonClicked(ActionEvent event)
	{
		highlightClickedButton(btn_tags);
		changeCenterContent("../TagsMain.fxml");
	}
	public void onSubjectsButtonClicked(ActionEvent event) 
	{
		highlightClickedButton(btn_subjects);
		changeCenterContent("../SubjectsMain.fxml");
	}
	
	
	public void onLecturersButtonClicked(ActionEvent event) 
	{
		highlightClickedButton(btn_lecturers);
		changeCenterContent("../LecturersMain.fxml");
		DatabaseHandler.addSampledata();
	}
	public void onWorkingDaysButtonClicked(ActionEvent event) 
	{
		highlightClickedButton(btn_working_days);
		changeCenterContent("../WorkingDaysMain.fxml");
	}
	public void changeCenterContent(String fxmlFileName)
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
		
		
		
		
		
		
		
//		
//		Parent root;
//		try
//		{
//			root = FXMLLoader.load(getClass().getResource(fxmlFileName));
//			controllerPane.getChildren().clear();
//			controllerPane.getChildren().add(root);
//		} 
//		catch (IOException e)
//		{
//			e.printStackTrace();
//		}
	}
	public void highlightClickedButton(Button button)
	{
		btn_students.setDefaultButton(false);
		btn_tags.setDefaultButton(false);
		btn_subjects.setDefaultButton(false);
		btn_lecturers.setDefaultButton(false);
		btn_working_days.setDefaultButton(false);
		btn_locations.setDefaultButton(false);
		btn_connections.setDefaultButton(false);
		btn_statistics.setDefaultButton(false);
		btn_sessions.setDefaultButton(false);
		btn_time_table.setDefaultButton(false);
		
		
		button.setDefaultButton(true);
	}


}

