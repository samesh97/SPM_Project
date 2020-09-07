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

public class LecturersMainController implements Initializable{

	@FXML
	private Button btn_ViewAllLecturersAdd;
	
	@FXML
	private Button btn_AddLecturer;

	@FXML
	private ComboBox<String>update_Faculty; 
	
	@FXML
	private TextField add_LecturerName;
	@FXML
	private TextField add_EmployeeID;
	@FXML
	private ComboBox<String> add_Faculty;
	@FXML
	private ComboBox<String> add_Department;
	@FXML
	private ComboBox<String> add_Center;
	@FXML
	private ComboBox<String> add_Building;
	@FXML
	private ComboBox<String> add_Level;
	@FXML
	private TextField add_Rank;
	
	
	public void onViewAllLecturersClicked(ActionEvent event) {
		System.out.println("View All lecturers clicked");
		
		Scene scene = btn_ViewAllLecturersAdd.getScene();
		AnchorPane pane = (AnchorPane) scene.lookup("#controllerPane");
		changeCenterContent(pane,"../LecturersView.fxml");
	}
	
	public void onLecturerAddClicked(ActionEvent event) {
		System.out.println("Add lecturer clicked");
		
		String LecturerName = add_LecturerName.getText();
		String EmployeeID = add_EmployeeID.getText();
	    String Faculty = add_Faculty.getValue();
	    String Department =  add_Department.getValue();
	    String Center= add_Center.getValue();
	    String Building = add_Building.getValue();
	    String Level= add_Level.getValue();
	    String Rank = add_Rank.getText();
	   
	    if(LecturerName.equals("") ||EmployeeID.equals("")|| Faculty.equals("")||Department.equals("")||Center.equals("")||Building.equals("")||Level.equals("")||Rank.equals(""))
	  		{
	  			showAlert("Please fill the empty fields");
	  		}
	    
	    //theresanexception
	    /*
	    String Level="";
	    
	    switch(l){
	    	case "Professor":
	    		Level = "1";
	    		break;
	    	case "Assistant Professor":
	    		Level = "2";
	    		break;
	    	case "Senior Lecturer(HG)":
	    		Level = "3";
	    		break;
	    	case "Senior Lecturer":
	    		Level = "4";
	    		break;
	    	case "Lecturer":
	    		Level = "5";
	    		break;
	    	case "Assistant Lecturer":
	    		Level = "6";
	    		break;
	    	case "Instructors":
	    		Level = "7";
	    		break;
	    	default :
	    		System.out.println("error with the level");
	    	
	    }
	    */
	    
	    else {
	    try {
		    boolean result= DatabaseHandler_Lecturers.addLecturers(LecturerName, EmployeeID, Faculty, Department, Center, Building, Level, Rank);
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
	

	public void setComboBoxes() {
		
		
		//faculty combo box
		ObservableList<String> faculty_data = FXCollections.observableArrayList();
		
		faculty_data.add("Computing");
		faculty_data.add("Engineering");
		faculty_data.add("Business");
		faculty_data.add("Humanities & Sciences");
		faculty_data.add("School of Architecture");
		faculty_data.add("Graduate Studies & Reearch ");
		
		add_Faculty.setItems(null);
		add_Faculty.setItems(faculty_data);
		
		//if(add_Faculty.getPromptText()=="Computing") {
			//System.out.println("choose departments of Computing Faculty");
		//}
		
		//department combo box
	
			ObservableList<String> department_data = FXCollections.observableArrayList();
			
			department_data.add("none");
			department_data.add("Computer Science& Software Engineering");
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
			department_data.add("Quanity Serveying");
			
			department_data.add("Business Analytics");
			department_data.add("Accounting & Finance");
			department_data.add("Human Capital Mangement");
			department_data.add("Quality Management");
			department_data.add("Logistics & Supply Chain Management");
			department_data.add("Management Information Systems");
			
			department_data.add("Business Analytics");
			department_data.add("Accounting & Finance");
			department_data.add("Human Capital Mangement");
			department_data.add("Quality Management");
			department_data.add("Logistics & Supply Chain Management");
			department_data.add("Management Information Systems");
			
			department_data.add("Architecture");
			
			add_Department.setItems(null);
			add_Department.setItems(department_data);
	
		
	
		
		//Center combo box
		ObservableList<String> center_data = FXCollections.observableArrayList();
				
		center_data.add("Malabe");
		center_data.add("Kollupitiya");
		center_data.add("Kandy");
		center_data.add("Matara");
		center_data.add("Kurunegala");
		center_data.add("Jaffna");
		
				
		add_Center.setItems(null);
		add_Center.setItems(center_data);
				
		//Building combo box
		ObservableList<String> building_data = FXCollections.observableArrayList();
			
		building_data.add("Main Building");
		building_data.add("New Building");
		building_data.add("Engineering Building");
		building_data.add("Business school");
		
				
		add_Building.setItems(null);
		add_Building.setItems(building_data);
				
		//Level combo box
		ObservableList<String> level_data = FXCollections.observableArrayList();
				
		level_data.add("Professor");
		level_data.add("Assistant Professor");
		level_data.add("Senior Lecturer(HG)");
		level_data.add("Senior Lecturer");
		level_data.add("Lecturer");
		level_data.add("Assistant Lecturer");
		level_data.add("Instructors");
		
				
		add_Level.setItems(null);
		add_Level.setItems(level_data);
	
	}
	
	/*public void setDepartmentComboBoxes() {
	
		//department combo box
		
	    String Faculty = add_Faculty.getPromptText();
	    
	    
		if(Faculty.equals("Computing")) {
			ObservableList<String> department_data = FXCollections.observableArrayList();
			
			department_data.add("Computer Science& Software Engineering");
			department_data.add("Cyber Security");
			department_data.add("Information Technology");
			department_data.add("Information Systems Engineering");
			department_data.add("Interactive Media");
			department_data.add("Data Science");
			department_data.add("Computer Systems & Network Engineering");
			
			
			add_Department.setItems(null);
			add_Department.setItems(department_data);
		}
		
		else if(Faculty.equals("Engineering")){
			ObservableList<String> department_data = FXCollections.observableArrayList();
			
			department_data.add("Civil Engineering");
			department_data.add("Electrical & Electronic Engineering");
			department_data.add("Materials Engineering");
			department_data.add("Mechanical Engineering");
			department_data.add("Mechatronics Engineering");
			department_data.add("Quanity Serveying");
			
			
			add_Department.setItems(null);
			add_Department.setItems(department_data);
		}
		
		else if(Faculty.equals("Business")){
			ObservableList<String> department_data = FXCollections.observableArrayList();
			
			department_data.add("Business Analytics");
			department_data.add("Accounting & Finance");
			department_data.add("Human Capital Mangement");
			department_data.add("Quality Management");
			department_data.add("Logistics & Supply Chain Management");
			department_data.add("Management Information Systems");
			
			
			add_Department.setItems(null);
			add_Department.setItems(department_data);
		}
		
		else if(Faculty.equals("Humanities & Sciences")){
			ObservableList<String> department_data = FXCollections.observableArrayList();
			
			department_data.add("Biological Sciences");
			department_data.add("Biotechnology");
			department_data.add("English");
			department_data.add("Law");
			department_data.add("Nursing");
			department_data.add("Physical Sciences");
			department_data.add("Psycology");
			
			
			add_Department.setItems(null);
			add_Department.setItems(department_data);
		}
		
		else if(Faculty.equals("School of Architecture")){
			ObservableList<String> department_data = FXCollections.observableArrayList();
			
			department_data.add("Architecture");
			
			
			add_Department.setItems(null);
			add_Department.setItems(department_data);
		}
		
		
		else if(Faculty.equals("Graduate Studies & Reearch")){
			ObservableList<String> department_data = FXCollections.observableArrayList();
			
			department_data.add("Information Technology");
			department_data.add("Information Systems");
			department_data.add("Information Management");
			department_data.add("Enterprise Application Development");
			department_data.add("Cyber Security");
			
			add_Department.setItems(null);
			add_Department.setItems(department_data);
		}
		
		else {
			ObservableList<String> department_data = FXCollections.observableArrayList();
			
			department_data.add("select a faculty first");
			add_Department.setItems(null);
			add_Department.setItems(department_data);
		}
		
	}
	
	*/
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
	
	public void onChooseDepartmentClicked() {
		
		System.out.println("pamosha");
		 // String Faculty = add_Faculty.getPromptText();
		  
		//  if(Faculty.equals("Business")) {
		//	  System.out.println("the faculty is "+ Faculty);
		//  }
		 
		  
		  //setDepartmentComboBoxes();
		  
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
	   DatabaseHandler_Lecturers.createLecturersTable();
	   setComboBoxes();
	    	
	}



}
