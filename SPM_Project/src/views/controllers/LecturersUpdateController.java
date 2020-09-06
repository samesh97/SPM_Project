package views.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class LecturersUpdateController implements Initializable{

@FXML
private Button btn_UpdateLecturer;

@FXML
private ComboBox<String> update_Faculty;
@FXML
private ComboBox<String> update_Department;
@FXML
private ComboBox<String> update_Center;
@FXML
private ComboBox<String> update_Building;
@FXML
private ComboBox<String> update_Level;


	
	public void onUpdateLecturerClicked(){
		System.out.println("Update the lecturer details");
	}
	
	public void setComboBoxes() {

		//faculty combo box
		ObservableList<String> faculty_data = FXCollections.observableArrayList();
		
		faculty_data.add("Computing");
		faculty_data.add("Engineering");
		faculty_data.add("Business");
		faculty_data.add("Humanities & Sciences");
		faculty_data.add("School of Architecture");
		faculty_data.add("School of Law");
		faculty_data.add("School of Hospitality & Culinary");
		faculty_data.add("Graduate Studies & Reearch ");
		
		update_Faculty.setItems(null);
		update_Faculty.setItems(faculty_data);
		
		//department combo box
		ObservableList<String> department_data = FXCollections.observableArrayList();
				
		department_data.add("Computer Science& Software Engineering");
		department_data.add("Cyber Security");			
		department_data.add("Information Technology");			
		department_data.add("Information Systems Engineering");
		department_data.add("Interactive Media");
		department_data.add("Data Science");
		department_data.add("Computer Systems & Network Engineering");
				
				
		update_Department.setItems(null);
		update_Department.setItems(department_data);
				
	
		//Center combo box
		ObservableList<String> center_data = FXCollections.observableArrayList();
				
		center_data.add("Malabe");
		center_data.add("Kollupitiya");
		center_data.add("Kandy");
		center_data.add("Matara");
		center_data.add("Kurunegala");
		center_data.add("Jaffna");
		
				
		update_Center.setItems(null);
		update_Center.setItems(center_data);
				
		//Building combo box
		ObservableList<String> building_data = FXCollections.observableArrayList();
			
		building_data.add("Main Building");
		building_data.add("New Building");
		building_data.add("Engineering Building");
		building_data.add("Business school");
		
				
		update_Building.setItems(null);
		update_Building.setItems(building_data);
				
		//Level combo box
		ObservableList<String> level_data = FXCollections.observableArrayList();
				
		level_data.add("Professor");
		level_data.add("Assistant Professor");
		level_data.add("Senior Lecturer(HG)");
		level_data.add("Senior Lecturer");
		level_data.add("Lecturer");
		level_data.add("Assistant Lecturer");
		level_data.add("Instructors");
		
				
		update_Level.setItems(null);
		update_Level.setItems(level_data);
	
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		setComboBoxes();
		
	}
	
	
}
