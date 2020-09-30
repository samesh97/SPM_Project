package views.controllers;


import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import database.DatabaseHandler_Students;
import enums.Student;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


public class StudentsViewController implements Initializable {
	static String id=null;
	ObservableList<Student> subjectList = FXCollections.observableArrayList();
	
	@FXML
	private TableColumn<Student,String> colum_id;
	@FXML
	private TableColumn<Student,String> column_yearSem;
	@FXML
	private TableColumn<Student,String> column_program;
	@FXML
	private TableColumn<Student,String> column_groupNo;
	@FXML
	private TableColumn<Student,String> column_subGroupNo;
	@FXML
	private TableColumn<Student,String> column_groupID;
	@FXML
	private TableColumn<Student,String> column_subGroupID;
	
	@FXML
	private TableView<Student> table_ViewStudent;
	
	@FXML
	private Button delete_button;
	
	@FXML
	private Button updateButton;
	
	@FXML
	private Button searchbtn;
	@FXML
	private Button exbtn1;
	@FXML
	private Button addNewBtn;

	public void mapFields()
	{
		colum_id.setCellValueFactory(new PropertyValueFactory<Student,String>("id"));
		column_yearSem.setCellValueFactory(new PropertyValueFactory<Student,String>("yearSem"));
		column_program.setCellValueFactory(new PropertyValueFactory<Student,String>("program"));
		column_groupNo.setCellValueFactory(new PropertyValueFactory<Student,String>("groupNo"));
		column_subGroupNo.setCellValueFactory(new PropertyValueFactory<Student,String>("subGroupNo"));
		column_groupID.setCellValueFactory(new PropertyValueFactory<Student,String>("groupId"));
		column_subGroupID.setCellValueFactory(new PropertyValueFactory<Student,String>("subGroupId"));

		
	}
	private void setTableView() 
	{
		
		ObservableList<Student> list = FXCollections.observableArrayList();
		ResultSet set = DatabaseHandler_Students.getAllStudents();
		if(set != null)
		{
			try 
			{
				while(set.next())
				{
					
					Student std = new Student();
					std.setId(set.getString(1));
					std.setYearSem(set.getString(2));
					std.setProgram(set.getString(3));
					std.setGroupNo(set.getString(4));
					std.setSubGroupNo(set.getString(5));
					std.setGroupId(set.getString(6));
					std.setSubGroupId(set.getString(7));
	
	
					list.add(std);
				}
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		table_ViewStudent.setItems(null);
		table_ViewStudent.setItems(list);
		
	}
	public void onViewAllEnteredSubjects(ActionEvent event) {
		setTableView();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		// TODO Auto-generated method stub
		mapFields();
		setTableView();
		
	}

	public void deleteRecord() {
		String studentID = getSelectedRecord();
		id= studentID;
		try {
		    boolean result= DatabaseHandler_Students.deleteStudents(id);
			if(result== true) {
				showAlert("Successfully Deleted");
			}
			else {
				showAlert("Unsuccessful");
			}
			mapFields();
			setTableView();
	
	}catch(Exception e) {
    	showAlert("Error!");
    }
		
	}
	public void showAlert(String message)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(message);
		alert.show();
	}
	
	public void updateStudentClicked(ActionEvent event) throws IOException
	{
		String studentID = getSelectedRecord();
		id= studentID;
		
		Scene scene = updateButton.getScene();
		AnchorPane pane = (AnchorPane) scene.lookup("#controllerPane");
		changeCenterContent(pane,"../StudentsUpdate.fxml");
		
	}
	public void addNewSubjectClicked(ActionEvent event) throws IOException
	{
		
		Scene scene = addNewBtn.getScene();
		AnchorPane pane = (AnchorPane) scene.lookup("#controllerPane");
		changeCenterContent(pane,"../StudentsMain.fxml");
		
	}
	public void allocateNotAvailbleClicked(ActionEvent event) throws IOException
	{
		
		
		Scene scene = exbtn1.getScene();
		AnchorPane pane = (AnchorPane) scene.lookup("#controllerPane");
		changeCenterContent(pane,"../AddNotAvailableTime.fxml");
		
	}
	public String getSelectedRecord() {
		Student record = table_ViewStudent.getSelectionModel().getSelectedItem();
		if(record==null) {
			return null;
		}
		else {		
			return record.getId();
		}
		
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


}
