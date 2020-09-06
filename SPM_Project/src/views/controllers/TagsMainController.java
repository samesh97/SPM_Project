package views.controllers;

import database.DatabaseHandler_Tags;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class TagsMainController
{
	@FXML
	private TextField tagText;
	@FXML
	private TextField NameText;
	@FXML
	private TextField yearSemText;
	@FXML
	private TextField DiscriptionText;
	
	
	@FXML
	private Button addTagButton;
//	@FXML
//	private Button viewStudentButton;
	
	public void AddNewTagClicked(ActionEvent event) {
		
		String tag = tagText.getText();
		String name = NameText.getText();
		String yearSem = yearSemText.getText();
		String dis = DiscriptionText.getText();
		
		
		try {
		    boolean result= DatabaseHandler_Tags.addTags(tag, name, yearSem, dis);
			if(result== true) {
				showAlert("Successfully added");
			}
			else {
				showAlert("Unsuccessful");
			}
	
	}catch(Exception e) {
    	showAlert("Please enter details correctly");
    }
	
	}

	
	public void showAlert(String message)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(message);
		alert.show();
	}
}
