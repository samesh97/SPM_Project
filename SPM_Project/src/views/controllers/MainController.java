package views.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MainController 
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
	private Button btn_lectures;
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
	
	
	
	public void onStudentButtonClicked(ActionEvent event)
	{
		highlightClickedButton(btn_students);
		changeCenterContent("../StudentsMain.fxml");
	}
	public void onTagButtonClicked(ActionEvent event)
	{
		highlightClickedButton(btn_tags);
		changeCenterContent("../TagsMain.fxml");
	}
	
	public void onSubjectsButtonClicked(ActionEvent event) {
		highlightClickedButton(btn_subjects);
		changeCenterContent("../SubjectsMain.fxml");
	}
	public void changeCenterContent(String fxmlFileName)
	{
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource(fxmlFileName));
			controllerPane.getChildren().clear();
			controllerPane.getChildren().add(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void highlightClickedButton(Button button)
	{
		btn_students.setDefaultButton(false);
		btn_tags.setDefaultButton(false);
		btn_subjects.setDefaultButton(false);
		btn_lectures.setDefaultButton(false);
		btn_working_days.setDefaultButton(false);
		btn_locations.setDefaultButton(false);
		btn_connections.setDefaultButton(false);
		btn_statistics.setDefaultButton(false);
		btn_sessions.setDefaultButton(false);
		btn_time_table.setDefaultButton(false);
		
		
		button.setDefaultButton(true);
	}
}

