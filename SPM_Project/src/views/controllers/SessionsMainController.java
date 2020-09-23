package views.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SessionsMainController {

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
	
}
