package views;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import database.DatabaseHandler_Lecturers;
import database.DatabaseHandler_Students;
import enums.Subject;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class SubjectsViewController implements Initializable  {
	
	

	static String id=null;

	ObservableList<Subject> subjectList = FXCollections.observableArrayList();
	
	@FXML 
	private Button btn_AddNewSubject;
	@FXML
	private Button btn_UpdateRecord;
	
	@FXML
	private Button buttonUpdate;
	@FXML
	private Button buttonDelete;
	
	@FXML
	private TableView<Subject> table_ViewSubjects;
	 
	@FXML
	private TableColumn<Subject,String> column_SubjectCode;
	@FXML
	private TableColumn<Subject,String>  column_SubjectName;
	@FXML
	private TableColumn<Subject,Integer>  column_OfferedYear;
	@FXML
	private TableColumn<Subject,Integer>  column_OfferedSemester;
	@FXML
	private TableColumn<Subject,Integer>  column_LectureHrs;
	@FXML
	private TableColumn<Subject,Integer>  column_TutorialHrs;
	@FXML
	private TableColumn<Subject,Integer>  column_LabHrs;
	@FXML
	private TableColumn<Subject,Integer>  column_EvaluationHrs;
	
	
	@FXML
	private TextField search_Subject;
	@FXML
	private Button btn_SearchSubject;
	
	
	
	
	
	public void onAddNewSubjectClicked(ActionEvent event) {
		System.out.println("Vuew all Subjects clicked");
		Scene scene = btn_AddNewSubject.getScene();
		AnchorPane pane = (AnchorPane) scene.lookup("#controllerPane");
		changeCenterContents(pane,"SubjectsMain.fxml");
		
	}
	
	public void onUpdateRecord(ActionEvent event) {
		System.out.println("Upate a record clicked");
		String Subjectid = getSelectedRecord();
		id= Subjectid;
		
		if(Subjectid==null) {
			System.out.println("No record is selected");
			showAlert("Please select a record first"); 
		}
		
		else {

			Scene scene = btn_UpdateRecord.getScene();
			AnchorPane pane = (AnchorPane) scene.lookup("#controllerPane");
			changeCenterContents(pane,"SubjectsUpdate.fxml");
			
		}
		
		
		
		
		
		
		
	/*	String Subjectid = getSelectedRecord();
		
		Subject sub = table_ViewSubjects.getSelectionModel().getSelectedItem();
		System.out.println(sub.getName()); 
		String subjectCode= sub.getSubjectCode();
		String name =sub.getName();
		int offeredYear=sub.getOfferedYear();
		int offeredSemester =sub.getOfferedSemester();
		int lectureHours=sub.getLectureHours();
		int tutorialHours=sub.getTutorialHours();
		int labHours=sub.getLabHours();
		int evaluationHours=sub.getEvaluationHours();
		
		sendDetails(subjectCode,name,offeredYear,offeredSemester,lectureHours,tutorialHours,labHours,evaluationHours);
		*/
		
	
	}
	
	/*public void sendDetails(String subjectCode,String name,int offeredYear,int offeredSemester,int lectureHours,int tutorialHours,int labHours,int evaluationHours) {
		Subject sub = table_ViewSubjects.getSelectionModel().getSelectedItem();

	     subjectCode= sub.getSubjectCode();
		 name =sub.getName();
		 offeredYear=sub.getOfferedYear();
		 offeredSemester =sub.getOfferedSemester();
		 lectureHours=sub.getLectureHours();
		 tutorialHours=sub.getTutorialHours();
		 labHours=sub.getLabHours();
		 evaluationHours=sub.getEvaluationHours();
		
	}
*/
	
	
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
	

	



	/*public static class SubjectData {
		private final SimpleStringProperty subjectCode;
		private final SimpleStringProperty subjectName;
		private final SimpleIntegerProperty offYr;
		private final SimpleIntegerProperty offSem;
		private final SimpleIntegerProperty lecHrs;
		private final SimpleIntegerProperty TutoHrs;
		private final SimpleIntegerProperty labHrs;
		private final SimpleIntegerProperty evalHrs;
		
	SubjectData(String subjectCode,String subjectName, int offYr,int offSem,int lecHrs,int TutoHrs,int labHrs,int evalHrs  ){
		this.subjectCode= new SimpleStringProperty(subjectCode);
		this.subjectName= new SimpleStringProperty(subjectName);
		this.offYr= new SimpleIntegerProperty(offYr);
		this.offSem= new SimpleIntegerProperty(offSem);
		this.lecHrs= new SimpleIntegerProperty(lecHrs);
		this.TutoHrs= new SimpleIntegerProperty(TutoHrs);
		this.labHrs= new SimpleIntegerProperty(labHrs);
		this.evalHrs= new SimpleIntegerProperty(evalHrs);
		
		
	}

		public String getSubjectCode() {
			return subjectCode.get();
		}
	
		public String getSubjectName() {
			return subjectName.get();
		}
	
		public Integer getOffYr() {
			return offYr.get();
		}
	
		public Integer getOffSem() {
			return offSem.get();
		}
	
		public Integer getLecHrs() {
			return lecHrs.get();
		}
	
		public Integer getTutoHrs() {
			return TutoHrs.get();
		}
	
		public Integer getLabHrs() {
			return labHrs.get();
		}
	
		public Integer getEvalHrs() {
			return evalHrs.get();
		}
	}
*/
	public void mapFields()
	{
		column_SubjectCode.setCellValueFactory(new PropertyValueFactory<Subject,String>("subjectCode"));
		column_SubjectName.setCellValueFactory(new PropertyValueFactory<Subject,String>("name"));
		column_OfferedYear.setCellValueFactory(new PropertyValueFactory<Subject,Integer>("offeredYear"));
		column_OfferedSemester.setCellValueFactory(new PropertyValueFactory<Subject,Integer>("offeredSemester"));
		column_LectureHrs.setCellValueFactory(new PropertyValueFactory<Subject,Integer>("lectureHours"));
		column_TutorialHrs.setCellValueFactory(new PropertyValueFactory<Subject,Integer>("tutorialHours"));
		column_LabHrs.setCellValueFactory(new PropertyValueFactory<Subject,Integer>("labHours"));
		column_EvaluationHrs.setCellValueFactory(new PropertyValueFactory<Subject,Integer>("evaluationHours"));
		//column_Update.setCellValueFactory(new PropertyValueFactory<Subject,Button>("buttonUpdate"));
		//column_Delete.setCellValueFactory(new PropertyValueFactory<Subject,Button>("buttonDelete"));
		
		
	}

	
	
	
	private void setTableView() 
	{
		
		ObservableList<Subject> list = FXCollections.observableArrayList();
		ResultSet set = DatabaseHandler_Lecturers.getAllSubjects();
		if(set != null)
		{
			try 
			{
				while(set.next())
				{
					Subject sub = new Subject();
					sub.setSubjectCode(set.getString(1));
					sub.setName(set.getString(2));
					sub.setOfferedYear(set.getInt(3));
					sub.setOfferedSemester(set.getInt(4));
					sub.setLectureHours(set.getInt(5));
					sub.setTutorialHours(set.getInt(6));
					sub.setLabHours(set.getInt(7));
					sub.setEvaluationHours(set.getInt(8));
					
					
					
					list.add(sub);
				}
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		table_ViewSubjects.setItems(null);
		table_ViewSubjects.setItems(list);
		
	}
	
	
	public void onSearched(ActionEvent event)
	{
		String key = search_Subject.getText();
		if(key == null || key.equals(""))
		{
			showAlert("Please enter a valid subject code");
		}
		else
		{
			ObservableList<Subject> list = FXCollections.observableArrayList();
			ResultSet set = DatabaseHandler_Lecturers.getAllSubjects(key);
			if(set != null)
			{
				try 
				{
					while(set.next())
					{
						Subject sub = new Subject();
						sub.setSubjectCode(set.getString(1));
						sub.setName(set.getString(2));
						sub.setOfferedYear(set.getInt(3));
						sub.setOfferedSemester(set.getInt(4));
						sub.setLectureHours(set.getInt(5));
						sub.setTutorialHours(set.getInt(6));
						sub.setLabHours(set.getInt(7));
						sub.setEvaluationHours(set.getInt(8));
						
						list.add(sub);
					}
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			table_ViewSubjects.setItems(null);
			table_ViewSubjects.setItems(list);
		}
	}
	
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
	
	
	
	public void showAlert(String message)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(message);
		alert.show();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		// TODO Auto-generated method stub
		mapFields();
		setTableView();
		
	}
	
}
