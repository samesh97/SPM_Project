package views.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class SubjectsMainController {
	
	@FXML
	private Button btn_button1;
	@FXML
	private Button btn_ViewAllSubjectsAdd;
	@FXML
	private Button btn_AddSubject;

	public void onButton1Selected(ActionEvent event) {
		System.out.println("Button 1 selected");
	}
	
	public void onViewAllSubjectsAddClicked(ActionEvent event) {
		System.out.println("View All Subjects clicked");
	}
	
	public void onAddSubjectClicked(ActionEvent event) {
		System.out.println("Add Subjects clicked");
	}
}
