package views.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import database.DatabaseHandler_Lecturers;
import enums.Subject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

public class SubjectsUpdateController implements Initializable  {

	
	@FXML
	private Button btn_UpdateSubject;
	
	@FXML
	private ComboBox<Integer> update_OfferedYear;
	@FXML
	private ComboBox<Integer> update_OfferedSemester;
	
	public void setComboBoxes()
	{
		//offered year combo box
		ObservableList<Integer> year_data = FXCollections.observableArrayList();
	
		year_data.add(1);
		year_data.add(2);
		year_data.add(3);
		year_data.add(4);
		
		update_OfferedYear.setItems(null);
		update_OfferedYear.setItems(year_data);
		
		//offered semester combo box
		ObservableList<Integer> sem_data = FXCollections.observableArrayList();
	
		
		sem_data.add(1);
		sem_data.add(2);
			
		update_OfferedSemester.setItems(null);
		update_OfferedSemester.setItems(sem_data);
		
	}
	
	/*public void receiveData() {
		
	}
	*/
	
	
	public void onUpdateSubjectClicked(ActionEvent event) {
		System.out.println("Update this record");
		 
		//DatabaseHandler_Lecturers.updateSubjects(subjectCode, name, offeredYear, offeredSemester, lectureHours, tutorialHours, labHours, evaluationHours);
	
		System.out.println("Update button clicked");
		Scene scene = btn_UpdateSubject.getScene();
		AnchorPane pane = (AnchorPane) scene.lookup("#controllerPane");
		changeCenterContent(pane,"../SubjectsView.fxml");
	
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
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 setComboBoxes(); 
		
	}
	
}
