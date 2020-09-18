package views.controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SubjectsUpdateController implements Initializable  {

	@FXML
	private Button btn_UpdateSubject;
	
	@FXML
	private ComboBox<Integer> update_OfferedYear;
	@FXML
	private ComboBox<Integer> update_OfferedSemester;
	
	@FXML
	private TextField update_SubjectCode;
	@FXML
	private TextField update_SubjectName;
	@FXML
	private TextField update_LectureHrs;
	@FXML
	private TextField update_TutorialHrs;
	@FXML
	private TextField update_LabHrs;
	@FXML
	private TextField update_EvaluationHrs;
	
	
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
	
	public void loadDetails() {
		
		
		//ObservableList<Subject> list = FXCollections.observableArrayList();
		ResultSet set = DatabaseHandler_Lecturers.getAllSubjects(SubjectsViewController.id);
		if(set != null)
		{
			try 
			{
				while(set.next())
				{
					/*
					update_SubjectCode.setText(null);
					update_SubjectName.setText(null);
					update_OfferedYear.setValue(null);
					update_OfferedSemester.setValue(null);
					update_LectureHrs.setText(String.valueOf(null));
					update_TutorialHrs.setText(String.valueOf(null));
					update_LabHrs.setText(String.valueOf(null));
					update_EvaluationHrs.setText(String.valueOf(null));
					*/
					
					update_SubjectCode.setText(set.getString(1));
					update_SubjectName.setText(set.getString(2));
					update_OfferedYear.setValue(set.getInt(3));
					update_OfferedSemester.setValue(set.getInt(4));
					update_LectureHrs.setText(String.valueOf(set.getInt(5)));
					update_TutorialHrs.setText(String.valueOf(set.getInt(6)));
					update_LabHrs.setText(String.valueOf(set.getInt(7)));		
					update_EvaluationHrs.setText(String.valueOf(set.getInt(8)));
					
					System.out.println(set.getString(1));
					
					
					//String subjectCode =(set.getString(1));
					//sub.setName(set.getString(2));
					//sub.setOfferedYear(set.getInt(3));
					//sub.setOfferedSemester(set.getInt(4));
					//sub.setLectureHours(set.getInt(5));
					//sub.setTutorialHours(set.getInt(6));
					//sub.setLabHours(set.getInt(7));
					//sub.setEvaluationHours(set.getInt(8));
					
					//list.add(sub);
				}
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	
		System.out.println("");
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 setComboBoxes(); 
		loadDetails();
	}
	
}
