package views.controllers;

import java.net.URL;
import java.sql.DriverManager;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

public class WorkingDaysMainController implements Initializable
{
	
	@FXML
	private ComboBox<Object> combo_working_days_type,combo_number_of_working_days,combo_working_days;
	
	@FXML
	private Button addTimeSlotButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		
		initializeWorkingDaysTypeCombo();
		initializeNumberOfWorkingDaysCombo();
		initializeWorkingDaysCombo();
	
		
	}
	private void initializeWorkingDaysTypeCombo()
	{
		ObservableList<Object> data = FXCollections.observableArrayList();
		data.add("Weekday");
		data.add("Weekend");
		combo_working_days_type.setItems(null);
		combo_working_days_type.setItems(data);
		
		combo_working_days_type.getSelectionModel().selectFirst();
	
	}
	private void initializeNumberOfWorkingDaysCombo()
	{
		ObservableList<Object> data = FXCollections.observableArrayList();
		data.add("1");
		data.add("2");
		data.add("3");
		data.add("4");
		data.add("5");
		data.add("6");
		data.add("7");
		combo_number_of_working_days.setItems(null);
		combo_number_of_working_days.setItems(data);
		
		combo_number_of_working_days.getSelectionModel().clearAndSelect(4);
	}

	private void initializeWorkingDaysCombo()
	{
		ObservableList<Object> data = FXCollections.observableArrayList();
	
		
		data.add("Monday");
		data.add("Tuesday");
		data.add("Wednesday");
		data.add("Thursday");
		data.add("Friday");
		data.add("Saturday");
		data.add("Sunday");
		combo_working_days.setItems(null);
		combo_working_days.setItems(data);
		
	}
	public void onAddTimeSlotButtonClicked(ActionEvent event)
	{
		Scene scene = addTimeSlotButton.getScene();
		AnchorPane pane = (AnchorPane) scene.lookup("#controllerPane");
		changeCenterContent(pane,"../WorkingDaysTimeSlots.fxml");
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
