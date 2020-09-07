package views.controllers;

import database.DatabaseHandler_Tags;
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
	@FXML
	private Button viewTagsButton;
	
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
	
	public void viewAllTagsClicked(ActionEvent event)
	{
		
		Scene scene = viewTagsButton.getScene();
		AnchorPane pane = (AnchorPane) scene.lookup("#controllerPane");
		changeCenterContent(pane,"../TagsView.fxml");
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
