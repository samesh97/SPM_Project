package views.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class ConnectionsViewController {
	
	@FXML
	private AnchorPane controllerPane;
	@FXML
	private Button btnUpdateRecord;
	
	public void onAddNewRecordButtonClicked(){
		System.out.println("Add new record button clicked");
	}

	public void onUpdateRecordButtonClicked(){
		System.out.println("Update record button clicked");
		Scene scene = btnUpdateRecord.getScene();
		AnchorPane pane = (AnchorPane) scene.lookup("#controllerPane");
		changeCenterContent(pane, "../ConnectionsUpdate.fxml");
	}
	
	public void onDeleteRecordButtonClicked(){
		System.out.println("Delete record button clicked");
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
