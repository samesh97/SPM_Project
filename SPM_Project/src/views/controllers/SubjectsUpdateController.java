package views.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

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
	
	public void onUpdateSubjectClicked(ActionEvent event) {
		System.out.println("Update this record");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 setComboBoxes();
		
	}
	
}
