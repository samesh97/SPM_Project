package views.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class StatisticsMainController implements Initializable{
	
	@FXML
	private Button btnLeturersStat; 
	@FXML
	private Button btnStudentsStat;
	@FXML
	private Button btnSubjectsStat;
	
	public void onLecturersStatisticsButtonClicked(ActionEvent event) {
		System.out.println("Hello from Lecturers Statistics Button");
		Scene scene = btnLeturersStat.getScene();
		AnchorPane pane = (AnchorPane) scene.lookup("#controllerPane");
		changeCenterContent(pane, "../StatisticsLecturer.fxml");
	}

	public void onStudentsStatisticsButtonClicked(ActionEvent event) {
		System.out.println("Hello from Students Statistics Button");
		Scene scene = btnStudentsStat.getScene();
		AnchorPane pane = (AnchorPane) scene.lookup("#controllerPane");
		changeCenterContent(pane, "../StatisticsStudent.fxml");
	}
	
	public void onSubjectsStatisticsButtonClicked(ActionEvent event) {
		System.out.println("Hello from Subjects Statistics Button");
		Scene scene = btnSubjectsStat.getScene();
		AnchorPane pane = (AnchorPane) scene.lookup("#controllerPane");
		changeCenterContent(pane, "../StatisticsSubject.fxml");
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
		// TODO Auto-generated method stub
		
	}
}
