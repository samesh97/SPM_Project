package views.controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import database.DatabaseHandler_Students;
import database.DatabaseHandler_Tags;
import enums.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class TagsUpdateController implements Initializable{
	
	@FXML
	private TextField tagText;
	@FXML
	private TextField nameText;
	@FXML
	private TextField yearSemText;
	@FXML
	private TextField DiscriptionText;
	
	
	@FXML
	private Button updateTagButton;
	@FXML
	private Button viewTagsButton;
	

	public void onUpdateTagsClicked(ActionEvent event) {
		System.out.println("Update this record");
		 
		String tag = tagText.getText();
		String name = nameText.getText();
		String YearSem = yearSemText.getText();
		String dis = DiscriptionText.getText();
		
	   
	    int id = Integer.parseInt(TagsViewController.id);
		
		
		
		 try {
			    boolean result= DatabaseHandler_Tags.updateTags(id, tag, name, YearSem, dis);
				if(result== true) {
					showAlert("Successfully updated");
				}
				else{
					showAlert("Unsuccessful update");
				}
				
			    }
			    catch(Exception e) {
			    	showAlert("Please enter details correctly");
			    }
				
			    
		
		
		Scene scene = updateTagButton.getScene();
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







	public void loadDetails() {
		System.out.println(TagsViewController.id + "id");
		
		ResultSet set = DatabaseHandler_Tags.getAllTags(TagsViewController.id);
		if(set != null)
		{
			try 
			{
				while(set.next())
				{
					System.out.println("comes here");
				
					tagText.setText(set.getString(2));
					nameText.setText(set.getString(3));
					yearSemText.setText(set.getString(4));
					DiscriptionText.setText(set.getString(5));
					
					System.out.println("sdfs");
						
					
				
				}
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		System.out.println("works");
		loadDetails();
		
	}
	public void showAlert(String message)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(message);
		alert.show();
	}


}
