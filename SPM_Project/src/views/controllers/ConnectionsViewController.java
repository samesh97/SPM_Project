package views.controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import database.DatabaseHandler_Connections;
import enums.Connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class ConnectionsViewController implements Initializable {
	
	@FXML
	private AnchorPane controllerPane;
	@FXML
	private Button btnUpdateRecord;
	
	@FXML
	private TableView<Connection> tblConnectionsView;
	@FXML
	private TableColumn<Connection, String> subjectCode;
	@FXML
	private TableColumn<Connection, String> tag;
	@FXML
	private TableColumn<Connection, String> lecturer;
	@FXML
	private TableColumn<Connection, String> groupId;
	@FXML
	private TableColumn<Connection, String> location;
	
	public void onAddNewRecordButtonClicked(){
		System.out.println("Add new record button clicked");
	}

	public void onUpdateRecordButtonClicked(){
		System.out.println("Update record button clicked");
		Scene scene = btnUpdateRecord.getScene();
		AnchorPane pane = (AnchorPane) scene.lookup("#controllerPane");
		changeCenterContent(pane, "../ConnectionsUpdate.fxml");
	}
	
	public void onDeleteRecordButtonClicked(){
		System.out.println("Delete record button clicked");
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
	
	public void mapFields() {
		subjectCode.setCellValueFactory(new PropertyValueFactory<>("subjectCode"));
		tag.setCellValueFactory(new PropertyValueFactory<>("tag"));
		lecturer.setCellValueFactory(new PropertyValueFactory<>("lecturer"));
		groupId.setCellValueFactory(new PropertyValueFactory<>("groupId"));
		location.setCellValueFactory(new PropertyValueFactory<>("location"));
	}
	
	
	private void setTableView() 
	{
		
		ObservableList<Connection> connectionsList = FXCollections.observableArrayList();
		ResultSet Connections_set = DatabaseHandler_Connections.getAllConnections();
		if(Connections_set != null)
		{
			try 
			{
				while(Connections_set.next())
				{
					Connection con = new Connection();
					con.setSubjectCode(Connections_set.getString(1));
					con.setTag(Connections_set.getString(2));
					con.setLecturer(Connections_set.getString(3));
					con.setGroupId(Connections_set.getString(4));
					con.setLocation(Connections_set.getString(5));
					
					
					
					connectionsList.add(con);
				}
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		tblConnectionsView.setItems(null);
		tblConnectionsView.setItems(connectionsList);
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mapFields();
		setTableView();
	}
}
