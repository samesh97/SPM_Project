package views.controllers;

import database.DatabaseHandler_Lecturers;
import database.DatabaseHandler_Students;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class StudentsMainController
{
	
	@FXML
	private TextField yearSemText;
	@FXML
	private TextField programText;
	@FXML
	private TextField GroupNoText;
	@FXML
	private TextField SubNoText;
	@FXML
	private TextField groupIDText;
	@FXML
	private TextField subIDText;
	
	@FXML
	private Button addStudentButton;
	@FXML
	private Button viewStudentButton;
	
	public void AddNewStudentClicked(ActionEvent event) {
		
		String yearSem = yearSemText.getText();
		String program = programText.getText();
		String gNo = GroupNoText.getText();
		String subNo = SubNoText.getText();
		String gId = groupIDText.getText();
		String subId = subIDText.getText();
		
		try {
		    boolean result= DatabaseHandler_Students.addStudents(yearSem, program, gNo, subNo, gId, subId);
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
	
	
	
	
	public void viewStudentListClicked(ActionEvent event)
	{
		System.out.println("Hello From Student");
		Scene scene = viewStudentButton.getScene();
		AnchorPane pane = (AnchorPane) scene.lookup("#controllerPane");
		changeCenterContent(pane,"../StudentsView.fxml");
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
}
