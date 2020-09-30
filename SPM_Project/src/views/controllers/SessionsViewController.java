package views.controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import database.DatabaseHandler_Lecturers;
import enums.Lecturer;
import enums.Session;
import enums.Subject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class SessionsViewController implements Initializable{

@FXML
private ComboBox search_Lecturer;
@FXML
private ComboBox search_Subject;
@FXML
private ComboBox search_Group;
@FXML
private Button btn_CreateASession;
@FXML
private TableView<Session> table_ViewSession;
 
@FXML
private TableColumn<Session,String> column_Lec;
@FXML
private TableColumn<Session,String> column_Sub;
@FXML
private TableColumn<Session,String> column_Tag;
@FXML
private TableColumn<Session,String> column_Group;
@FXML
private TableColumn<Session,Integer> column_coun;
@FXML
private TableColumn<Session,Integer> column_dura;



public void onCreateASessionClicked(ActionEvent event) {
	System.out.println("Create a session button clicked");
	Scene scene = btn_CreateASession.getScene();
	AnchorPane pane = (AnchorPane) scene.lookup("#controllerPane");
	changeCenterContent(pane,"../SessionsMain.fxml");
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


public void mapFields()
{
	column_Lec.setCellValueFactory(new PropertyValueFactory<Session,String>("Lecturer"));
	column_Sub.setCellValueFactory(new PropertyValueFactory<Session,String>("Subject"));
	column_Tag.setCellValueFactory(new PropertyValueFactory<Session,String>("Tag"));
	column_Group.setCellValueFactory(new PropertyValueFactory<Session,String>("Group"));
	column_coun.setCellValueFactory(new PropertyValueFactory<Session,Integer>("Count"));
	column_dura.setCellValueFactory(new PropertyValueFactory<Session,Integer>("Duration"));
	
	
}




private void setTableView() 
{
	
	ObservableList<Session> list = FXCollections.observableArrayList();
	ResultSet set = DatabaseHandler_Lecturers.getAllSessions();
	if(set != null)
	{
		try 
		{
			while(set.next())
			{
				Session sess = new Session();
				sess.setLecturer(set.getString(2));
				sess.setSubject(set.getString(3));
				sess.setTag(set.getString(4));
				sess.setGroup(set.getString(5));
				sess.setCount(set.getInt(6));
				sess.setDuration(set.getInt(7));
				
				
				
				
				list.add(sess);
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	table_ViewSession.setItems(null);
	table_ViewSession.setItems(list);
	
}




public void onFilterByLecturerClicked(ActionEvent event)
{
	String key = (String) search_Lecturer.getValue();
	if(key == null || key.equals(""))
	{
		showAlert("Please enter a valid Lecturer");
	}
	else
	{
		ObservableList<Session> list = FXCollections.observableArrayList();
		ResultSet set = DatabaseHandler_Lecturers.getAllSessionsFilterByLecturer(key);
		if(set != null)
		{
			try 
			{
				while(set.next())
				{
					Session sess = new Session();
					sess.setLecturer(set.getString(2));
					sess.setSubject(set.getString(3));
					sess.setTag(set.getString(4));
					sess.setGroup(set.getString(5));
					sess.setCount(set.getInt(6));
					sess.setDuration(set.getInt(7));
					
					
					
					
					list.add(sess);
				}
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		table_ViewSession.setItems(null);
		table_ViewSession.setItems(list);
		
	}
}

/*
public void onViewAllEnteredSubjects(ActionEvent event) {
	setTableView();
}

public String getSelectedRecord() {
	Subject record = table_ViewSubjects.getSelectionModel().getSelectedItem();
	if(record==null) {
		System.out.println("No record is selected");
		return null;
	}
	else {
		System.out.println("A record is selected");
		System.out.println("id is "+ record.getSubjectCode());
		return record.getSubjectCode();
	}
	
}

public void onDeleteRecord(ActionEvent event) {
	
	String Subjectid = getSelectedRecord();
	
	if(Subjectid==null) {
		System.out.println("No record is selected");
		showAlert("Please select a record first");
	}
	else {
		boolean result =DatabaseHandler_Lecturers.deleteSubjects(Subjectid);
		
		try {
		if(result==true) {
			showAlert("Successfully deleted");
		}
		else {
			showAlert("unsuccessful deletion");
		}
		}
		catch(Exception e) {
			showAlert("error");
		}
			
		//to refresh the data grid
		setTableView();
	}
	
	
}
*/



public void onFilterBySubjectClicked() {
	
	String key = (String) search_Subject.getValue();
	if(key == null || key.equals(""))
	{
		showAlert("Please enter a valid Subject");
	}
	else
	{
		ObservableList<Session> list = FXCollections.observableArrayList();
		ResultSet set = DatabaseHandler_Lecturers.getAllSessionsFilterBySubject(key);
		if(set != null)
		{
			try 
			{
				while(set.next())
				{
					Session sess = new Session();
					sess.setLecturer(set.getString(2));
					sess.setSubject(set.getString(3));
					sess.setTag(set.getString(4));
					sess.setGroup(set.getString(5));
					sess.setCount(set.getInt(6));
					sess.setDuration(set.getInt(7));
					
					
					
					
					list.add(sess);
				}
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		table_ViewSession.setItems(null);
		table_ViewSession.setItems(list);
		
	}
	
}

public void onFilterByGroupClicked() {

	String key = (String) search_Group.getValue();
	if(key == null || key.equals(""))
	{
		showAlert("Please enter a valid Student Group");
	}
	else
	{
		ObservableList<Session> list = FXCollections.observableArrayList();
		ResultSet set = DatabaseHandler_Lecturers.getAllSessionsFilterByGroup(key);
		if(set != null)
		{
			try 
			{
				while(set.next())
				{
					Session sess = new Session();
					sess.setLecturer(set.getString(2));
					sess.setSubject(set.getString(3));
					sess.setTag(set.getString(4));
					sess.setGroup(set.getString(5));
					sess.setCount(set.getInt(6));
					sess.setDuration(set.getInt(7));
					
					
					
					
					list.add(sess);
				}
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		table_ViewSession.setItems(null);
		table_ViewSession.setItems(list);
		
	}
	
}



public void setComboBoxes()
{
	//Lecturer name combo box
	ObservableList<String> lecturer_data = FXCollections.observableArrayList();

	try {
	ResultSet rs= DatabaseHandler_Lecturers.getDropDownLecturers();
	
	while(rs.next()){
		
	lecturer_data.add(rs.getString("LecturerName"));
	}
	
	search_Lecturer.setItems(null);
	search_Lecturer.setItems(lecturer_data);
	
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	
	//Subject name combo box
	ObservableList<String> subject_data = FXCollections.observableArrayList();
	
	try {
	ResultSet rs= DatabaseHandler_Lecturers.getDropDownSubjects();
	
	while(rs.next()){

	subject_data.add(rs.getString("SubjectName"));
	}
	
	search_Subject.setItems(null);
	search_Subject.setItems(subject_data);
	
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	

	//Student group combo box
	ObservableList<String> group_data = FXCollections.observableArrayList();
	
	try {
	ResultSet rs= DatabaseHandler_Lecturers.getDropDownGroups();
			
	while(rs.next()){
		
		group_data.add(rs.getString("groupId"));
		group_data.add(rs.getString("subGroupId"));
		
	}
			
	search_Group.setItems(null);
	search_Group.setItems(group_data);
			
	}
	catch(Exception e) {
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
public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	mapFields();
	setTableView();
	setComboBoxes();
	
}


//end bracket
}
