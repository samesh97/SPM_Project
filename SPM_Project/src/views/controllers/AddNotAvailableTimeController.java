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
import javafx.scene.control.TextField;


public class AddNotAvailableTimeController implements Initializable {

	
	@FXML TextField timeTxt;
	@FXML TextField nameTxt;
	@FXML TextField disTxt;
	@FXML ComboBox<String> typeDrp;
	@FXML Button addBtn;
	
	public void addButtonClicked(ActionEvent event){
		
		
		
	}
	
	//Set combo boxes values
	public void setComboBox(){
		
		ObservableList<String> programType = FXCollections.observableArrayList();
		programType.add("lecturers");
		programType.add("sessions");
		programType.add("groups");
		programType.add("Sub-Groups");
		
		typeDrp.setItems(null);
		typeDrp.setItems(programType);
		
	}
	


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		setComboBox();
	}
	

	
	
}
