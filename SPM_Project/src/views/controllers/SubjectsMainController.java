 package views.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import database.DatabaseHandler_Lecturers;
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


public class SubjectsMainController implements Initializable  {
	
	
	@FXML
	private Button btn_ViewAllSubjectsAdd;
	@FXML
	private Button btn_AddSubject;
	
	@FXML
	private TextField add_SubjectCode;
	@FXML
	private TextField add_SubjectName;
	@FXML
	private ComboBox<Integer> add_OfferedYear;
	@FXML
	private ComboBox<Integer> add_OfferedSemester;
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
		System.out.println("View all Subjects clicked");
		Scene scene = btn_ViewAllSubjectsAdd.getScene();
		AnchorPane pane = (AnchorPane) scene.lookup("#controllerPane");
		changeCenterContent(pane,"../SubjectsView.fxml");
	}
	
	
	public void onAddSubjectClicked(ActionEvent event) {
		System.out.println("Add Subjects clicked");
		
		
		
		
		String SubjectCode = add_SubjectCode.getText();
		String SubjectName = add_SubjectName.getText();
	    int OfferedYear = (int) add_OfferedYear.getSelectionModel().getSelectedIndex();
	    OfferedYear++;
	    int OfferedSem = (int) add_OfferedSemester.getSelectionModel().getSelectedIndex();
	    OfferedSem++;
	    String LectureHours= add_LectureHrs.getText();
	    String TutorialHours = add_TutorialHrs.getText();
	    String LabHours= add_LabHrs.getText();
	    String EvaluationHours = add_EvaluationHrs.getText();
	    
	    if(SubjectCode.equals("") ||SubjectName.equals("")|| OfferedYear <=0 || OfferedSem <=0|| LectureHours.equals("")||TutorialHours.equals("")||LabHours.equals("")||EvaluationHours.equals(""))
		{
			showAlert("Please fill the empty fields");
		}
	    
	    else {
	    
	    int LectureHrs = Integer.parseInt(LectureHours);
	    int TutorialHrs = Integer.parseInt(TutorialHours);
	    int LabHrs = Integer.parseInt(LabHours);
	    int EvaluationHrs = Integer.parseInt(EvaluationHours);
	    
	    
	    try {
	    boolean result= DatabaseHandler_Lecturers.addSubjects(SubjectCode, SubjectName, OfferedYear, OfferedSem, LectureHrs, TutorialHrs, LabHrs, EvaluationHrs);
		if(result== true) {
			showAlert("Successfully added");
		}
		else {
			showAlert("Unsuccessful");
		}
		
	    }
	    catch(Exception e) {
	    	showAlert("Please enter details correctly");
	    }
		
	    }
	}
	
	
	public void showAlert(String message)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(message);
		alert.show();
	}
	
	public void setComboBoxes()
	{
		//offered year combo box
		ObservableList<Integer> year_data = FXCollections.observableArrayList();
	
		year_data.add(1);
		year_data.add(2);
		year_data.add(3);
		year_data.add(4);
		
		add_OfferedYear.setItems(null);
		add_OfferedYear.setItems(year_data);
		
		//offered semester combo box
		ObservableList<Integer> sem_data = FXCollections.observableArrayList();
	
		
		sem_data.add(1);
		sem_data.add(2);
			
		add_OfferedSemester.setItems(null);
		add_OfferedSemester.setItems(sem_data);
		
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
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		DatabaseHandler_Lecturers.createSubjectTable();
		setComboBoxes();
		
	}
}
