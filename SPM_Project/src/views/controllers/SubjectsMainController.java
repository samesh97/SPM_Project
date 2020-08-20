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


public class SubjectsMainController  {
	
	
	@FXML
	private Button btn_ViewAllSubjectsAdd;
	@FXML
	private Button btn_AddSubject;
	
	@FXML
	private TextField add_SubjectCode;
	@FXML
	private TextField add_SubjectName;
	@FXML
	private ComboBox add_OfferedYear;
	@FXML
	private ComboBox add_OfferedSemester;
	@FXML
	private TextField add_LectureHrs;
	@FXML
	private TextField add_TutorialHrs;
	@FXML
	private TextField add_LabHrs;
	@FXML
	private TextField add_EvaluationHrs;
	
	

	public void  onViewAllSubjectsAddClicked(ActionEvent event) 
	{
		System.out.println("Vuew all Subjects clicked");
		Scene scene = btn_ViewAllSubjectsAdd.getScene();
		AnchorPane pane = (AnchorPane) scene.lookup("#controllerPane");
		changeCenterContent(pane,"../SubjectsView.fxml");
	}
	
	
	public void onAddSubjectClicked(ActionEvent event) {
		System.out.println("Add Subjects clicked");
		String SubjectCode = add_SubjectCode.getText();
		String SubjectName = add_SubjectName.getText();
	    String OfferedYear = (String) add_OfferedYear.getValue();
	    String OfferedSem = (String) add_OfferedSemester.getValue();
	    String LectureHrs= add_LectureHrs.getText();
	    String TutorialHrs = add_TutorialHrs.getText();
	    String LabHrs= add_LabHrs.getText();
	    String EvauationHrs = add_EvaluationHrs.getText();
		
		
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
		
		
		
		
		
		
		
//		
//		Parent root;
//		try
//		{
//			root = FXMLLoader.load(getClass().getResource(fxmlFileName));
//			controllerPane.getChildren().clear();
//			controllerPane.getChildren().add(root);
//		} 
//		catch (IOException e)
//		{
//			e.printStackTrace();
//		}
	}
}
