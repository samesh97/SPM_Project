package views;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import database.DatabaseHandler_Lecturers;
import enums.Building;
import enums.Center;
import enums.Department;
import enums.Faculty;
import enums.Level;
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

public class LecturersUpdateController implements Initializable{

@FXML
private Button btn_UpdateLecturer;

@FXML
private TextField update_LecturerName;
@FXML
private TextField update_EmployeeID;

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


	
	public void onUpdateLecturerClicked(ActionEvent event){
		System.out.println("Update the lecturer details");
		
		
	
		String LecturerName = update_LecturerName.getText();
		String EmployeeID = update_EmployeeID.getText();
	   
	    String FacultyStr= update_Faculty.getValue();
	    String DepartmentStr = update_Department.getValue();
	    String CenterStr= update_Center.getValue();
	    String BuildingStr = update_Building.getValue();
	    String LevelStr = update_Level.getValue();
	   
	    if(LecturerName.equals("") ||EmployeeID.equals("")|| FacultyStr.equals("")|| DepartmentStr.equals("")|| CenterStr.equals("")|| BuildingStr.equals("")|| LevelStr.equals(""))
	  	{
	  			showAlert("Please fill the empty fields");
	  	}
	    
	    else {
	    	  int FacultyId = Faculty.getType(FacultyStr);
	      	int DepartmentId = Department.getType(DepartmentStr);
	      	int CenterId = Center.getType(CenterStr);
	      	int BuildingId = Building.getType(BuildingStr);
	      	int LevelId = Level.getType(LevelStr);
	      	String Rank = LevelId + "." + EmployeeID;
	      	
	  		
	  		
	  		 try {
	  			    boolean result= DatabaseHandler_Lecturers.updateLecturers(LecturerName, EmployeeID, FacultyStr, DepartmentStr, CenterStr, BuildingStr, LevelStr,Rank,FacultyId,DepartmentId,CenterId,BuildingId,LevelId);
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
	  				
	    }
	    
	  
	
			Scene scene = btn_UpdateLecturer.getScene();
			AnchorPane pane = (AnchorPane) scene.lookup("#controllerPane");
			changeCenterContents(pane,"LecturersView.fxml");
		
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
				
		department_data.add("Computer Science & Software Engineering");
		department_data.add("Cyber Security");
		department_data.add("Information Technology");
		department_data.add("Information Systems Engineering");
		department_data.add("Interactive Media");
		department_data.add("Data Science");
		department_data.add("Computer Systems & Network Engineering");
		
		department_data.add("Civil Engineering");
		department_data.add("Electrical & Electronic Engineering");
		department_data.add("Materials Engineering");
		department_data.add("Mechanical Engineering");
		department_data.add("Mechatronics Engineering");
		department_data.add("Quantity Serveying");
		
		department_data.add("Business Analytics");
		department_data.add("Accounting & Finance");
		department_data.add("Human Capital Mangement");
		department_data.add("Quality Management");
		department_data.add("Logistics & Supply Chain Management");
		department_data.add("Management Information Systems");
	
		
		department_data.add("Architecture");
				
				
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
	
	

 public void loadDetails() {
 
		
		ResultSet set = DatabaseHandler_Lecturers.getAllLecturers(LecturersViewController.id);
		if(set != null)
		{
			try 
			{
				while(set.next())
				{
					
					
					update_LecturerName.setText(set.getString(1));
					update_EmployeeID.setText(set.getString(2));
					update_Faculty.setValue(set.getString(3));
					update_Department.setValue(set.getString(4));
					update_Center.setValue(set.getString(5));
					update_Building.setValue(set.getString(6));
					update_Level.setValue(set.getString(7));		
					
	
				}
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
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
	

	public void showAlert(String message)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(message);
		alert.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		setComboBoxes();
		loadDetails();
	}
	
	
}
