package views.controllers;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import database.DatabaseHandler_Lecturers;
import database.DatabaseHandler_Students;
import enums.Student;
import enums.Subject;
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
	
	ObservableList<Student> subjectList = FXCollections.observableArrayList();
	
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
	
	private String program;
	private String yearSem;
	private String groupNo;
	private String subGroupNo;
	private String groupId;
	private String subGroupId;
	
	public void mapFields()
	{
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
	
	//mouse click
	public void tableMouseClicked() {
		Student st = table_ViewStudent.getSelectionModel().getSelectedItem();
		
		this.program = st.getProgram();
		this.yearSem = st.getYearSem();
		this.groupNo = st.getGroupNo();
		this.subGroupNo = st.getSubGroupNo();
		this.groupId = st.getGroupId();
		this.subGroupId = st.getSubGroupId();
		
		
	}
	public void deleteRecord() {
		
		try {
		    boolean result= DatabaseHandler_Students.deleteStudents(program);
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
	
	
	
	
	
	
	public void updateStudentClicked(ActionEvent event)
	{
//		StudentsUpdateController StudentsUpdateController = new StudentsUpdateController();
//		StudentsUpdateController.UpdateStudentSet(yearSem, program, groupNo, subGroupNo, groupId, subGroupId);
		Scene scene = updateButton.getScene();
		AnchorPane pane = (AnchorPane) scene.lookup("#controllerPane");
		changeCenterContent(pane,"../StudentsUpdate.fxml");
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
