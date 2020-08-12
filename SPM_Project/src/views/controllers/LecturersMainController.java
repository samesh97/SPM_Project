package views.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LecturersMainController {

	@FXML
	private Button btn_ViewAllLeturersAdd;
	
	@FXML
	private Button btn_AddLecturer;
	
	public void onViewAllLeturersAddClicked(ActionEvent event) {
		System.out.println("View All lecturers clicked");
	}
	
	public void onAddLecturerClicked(ActionEvent event) {
		System.out.println("Add lecturer clicked");
	}
}
