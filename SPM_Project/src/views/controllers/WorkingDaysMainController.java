package views.controllers;

import java.net.URL;
import java.sql.DriverManager;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class WorkingDaysMainController implements Initializable
{
	
	@FXML
	private ComboBox<Object> combo_working_days_type,combo_number_of_working_days,combo_working_days;

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
	
}
