package views.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class SubjectsMainController {
	
	@FXML
	private Button btn_button1;
	@FXML
	private Button btn_ViewAllSubjects1;
	@FXML
	private Button btn_Add;

	public void onButton1Selected(ActionEvent event) {
		System.out.println("Button 1 selected");
	}
	
	public void onViewAllSubjectsClicked(ActionEvent event) {
		System.out.println("View All Subjects clicked");
	}
	
	public void onAddClicked(ActionEvent event) {
		System.out.println("Add Subjects clicked");
	}
}
