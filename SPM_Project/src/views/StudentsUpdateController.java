package views;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import database.DatabaseHandler_Students;
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

public class StudentsUpdateController implements Initializable{
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
	private Button updateButton;


public void onUpdateStudentsClicked(ActionEvent event) {
	System.out.println("Update this record");
	 
	String yearSem = yearSemText.getText();
	String program = programText.getText();
	String groupNo = GroupNoText.getText();
	String SubNo = SubNoText.getText();
	String groupId = groupIDText.getText();
	String SubId = subIDText.getText();
	
   
    int id = Integer.parseInt(StudentsViewController.id);
	
	
	
	 try {
		    boolean result= DatabaseHandler_Students.updateStudents(id,yearSem,program,groupNo,SubNo,groupId,SubId);
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
			
		    
	
	
	Scene scene = updateButton.getScene();
	AnchorPane pane = (AnchorPane) scene.lookup("#controllerPane");
	changeCenterContents(pane,"StudentsView.fxml");

}
public void viewStudentListClicked(ActionEvent event)
{
	System.out.println("Hello From Student");
	Scene scene = updateButton.getScene();
	AnchorPane pane = (AnchorPane) scene.lookup("#controllerPane");
	changeCenterContents(pane,"StudentsView.fxml");
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

public void loadDetails() {
	
	ResultSet set = DatabaseHandler_Students.getAllStudents(StudentsViewController.id);
	if(set != null)
	{
		try 
		{
			while(set.next())
			{
			
				yearSemText.setText(set.getString(2));
				programText.setText(set.getString(3));
				GroupNoText.setText(set.getString(4));
				SubNoText.setText(set.getString(5));
				groupIDText.setText(set.getString(6));
				subIDText.setText(set.getString(7));
				
		
				
			
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