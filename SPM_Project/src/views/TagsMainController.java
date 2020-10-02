package views;

import java.net.URL;
import java.util.ResourceBundle;

import database.DatabaseHandler_Tags;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class TagsMainController implements Initializable
{
	@FXML
	private TextField tagText;
	@FXML
	private TextField NameText;
	@FXML
	private ComboBox<String> yearSemText;
	@FXML
	private TextField DiscriptionText;
	
	
	@FXML
	private Button addTagButton;
	@FXML
	private Button viewTagsButton;
	
	public void AddNewTagClicked(ActionEvent event) {
		
		String tag = tagText.getText();
		String name = NameText.getText();
		String yearSem = yearSemText.getValue();
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
	public void setComboBoxes() {
		
		ObservableList<String> yearSemester = FXCollections.observableArrayList();
		
		yearSemester.add("Y1.S1");
		yearSemester.add("Y1.S2");
		yearSemester.add("Y2.S1");
		yearSemester.add("Y2.S2");
		yearSemester.add("Y3.S1");
		yearSemester.add("Y3.S2");
		yearSemester.add("Y4.S1");
		yearSemester.add("Y4.S2");
		
		yearSemText.setItems(null);
		yearSemText.setItems(yearSemester);
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
		changeCenterContents(pane,"TagsView.fxml");
	}
	public void changeCenterContents(AnchorPane controllerPane,String fxmlFileName)
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
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		setComboBoxes();
	}
}
