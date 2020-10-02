package views;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import database.DatabaseHandler_Students;
import database.DatabaseHandler_Tags;
import enums.Student;
import enums.Tag;
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

public class TagsViewController implements Initializable {
	static String id=null;
ObservableList<Tag> subjectList = FXCollections.observableArrayList();
	
@FXML
private TableColumn<Tag,String> column_id ;
	@FXML
	private TableColumn<Tag,String> column_tags;
	@FXML
	private TableColumn<Tag,String> column_name;
	@FXML
	private TableColumn<Tag,String> column_yearSem;
	@FXML
	private TableColumn<Tag,String> column_discription;
	@FXML
	private Button delete_button;
	
	@FXML
	private Button updateButton;
	
	@FXML
	private TableView<Tag> table_ViewTags;
	@FXML private TextField search_Subject;
	
	private String tag;
	
	public void onSearched(ActionEvent event)
	{
		String key = search_Subject.getText();
		if(key == null || key.equals(""))
		{
			showAlert("Please enter a valid Tag");
		}
		else
		{
			ObservableList<Tag> list = FXCollections.observableArrayList();
			ResultSet set = DatabaseHandler_Tags.searchTags(key);
			if(set != null)
			{
				try 
				{
					while(set.next())
					{
						Tag std = new Tag();
						std.setId(set.getString(1));
						std.setTag(set.getString(2));
						std.setName(set.getString(3));
						std.setYearSem(set.getString(4));
						std.setDiscription(set.getString(5));
					
		
		
						list.add(std);
					}
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			table_ViewTags.setItems(null);
			table_ViewTags.setItems(list);
		}
	}
	public void mapFields()
	{
		column_id.setCellValueFactory(new PropertyValueFactory<Tag,String>("id"));
		column_tags.setCellValueFactory(new PropertyValueFactory<Tag,String>("tag"));
		column_name.setCellValueFactory(new PropertyValueFactory<Tag,String>("name"));
		column_yearSem.setCellValueFactory(new PropertyValueFactory<Tag,String>("yearSem"));
		column_discription.setCellValueFactory(new PropertyValueFactory<Tag,String>("discription"));
	
		
	}

	private void setTableView() 
	{
		
		ObservableList<Tag> list = FXCollections.observableArrayList();
		ResultSet set = DatabaseHandler_Tags.getAllTags();
		if(set != null)
		{
			try 
			{
				while(set.next())
				{
					Tag std = new Tag();
					std.setId(set.getString(1));
					std.setTag(set.getString(2));
					std.setName(set.getString(3));
					std.setYearSem(set.getString(4));
					std.setDiscription(set.getString(5));
				
	
	
					list.add(std);
				}
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		table_ViewTags.setItems(null);
		table_ViewTags.setItems(list);
		
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
		Tag tag1 = table_ViewTags.getSelectionModel().getSelectedItem();
		
		this.tag = tag1.getTag();
	
	}
	public void deleteRecord() {
		if(tag==null) {
			System.out.println("No record is selected");
			showAlert("Please select a record first");
		}
		else {
		try {
		    boolean result= DatabaseHandler_Tags.deleteTags(tag);
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
}
public void showAlert(String message)
{
	Alert alert = new Alert(AlertType.INFORMATION);
	alert.setContentText(message);
	alert.show();
}



public void updateTagsClicked(ActionEvent event) throws IOException
{
	String TagsID = getSelectedRecord();
	id= TagsID;
	if(id==null) {
		System.out.println("No record is selected");
		showAlert("Please select a record first");
	}
	else {
	Scene scene = updateButton.getScene();
	AnchorPane pane = (AnchorPane) scene.lookup("#controllerPane");
	changeCenterContents(pane,"TagsUpdate.fxml");
	}
}
public String getSelectedRecord() {
	Tag record = table_ViewTags.getSelectionModel().getSelectedItem();
	if(record==null) {
		System.out.println("No record is selected");
		return null;
	}
	else {
		System.out.println("A record is selected");
		System.out.println("id is "+ record.getId());
		return record.getId();
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

}