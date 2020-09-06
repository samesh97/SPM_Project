package views.controllers;

import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import database.QueriesOfWorkingDays;
import enums.ProgramType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class WorkingDaysMainController implements Initializable
{
	
	@FXML
	private ComboBox<Object> combo_working_days_type;
//	@FXML
//	private ComboBox<Integer> combo_working_days;

	
	@FXML
	private ComboBox<Integer> combo_number_of_working_days;
	@FXML
	private Button addTimeSlotButton;
	@FXML
	private Button numberOfWorkingDaysAddBtn,workingTimeDurationAddBtn;
	@FXML
	private TextField hoursTextFiled,minutesTextFiled;
	
	
	@FXML
	private CheckBox MondayCombo,TuesdayCombo,WednesdayCombo,ThursdayCombo,FridayCombo,SaturdayCombo,SundayCombo;
	
	private int programType = ProgramType.WEEK_DAY;


	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		
		initializeWorkingDaysTypeCombo();
		//initializeWorkingDaysCombo();
		setupNumberOfWorkingDaysRow();
		setCheckBoxes();
		
		

		//listeners
		combo_working_days_type.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) -> {
	         
			if(newValue.equals("Weekend"))
			{
				programType = ProgramType.WEEK_END;
			}
			else if(newValue.equals("Weekday"))
			{
				programType = ProgramType.WEEK_DAY;
			}
			
			setupNumberOfWorkingDaysRow();
			setCheckBoxes();
	    }
	    ); 
	
		
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
	private void initializeNumberOfWorkingDaysCombo(int value)
	{
		ObservableList<Integer> data = FXCollections.observableArrayList();
		data.add(1);
		data.add(2);
		data.add(3);
		data.add(4);
		data.add(5);
		data.add(6);
		data.add(7);
		combo_number_of_working_days.setItems(null);
		combo_number_of_working_days.setItems(data);
		
		if(value != -99)
		{
			combo_number_of_working_days.getSelectionModel().clearAndSelect(value - 1);
		}
		
	}
//
//	private void initializeWorkingDaysCombo()
//	{
//		ObservableList<Object> data = FXCollections.observableArrayList();
//	
//		
//		data.add("Monday");
//		data.add("Tuesday");
//		data.add("Wednesday");
//		data.add("Thursday");
//		data.add("Friday");
//		data.add("Saturday");
//		data.add("Sunday");
//		combo_working_days.setItems(null);
//		combo_working_days.setItems(data);
//		
//	}
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
	public void setupNumberOfWorkingDaysRow()
	{
		ResultSet set = QueriesOfWorkingDays.sync(programType);
		if(set != null)
		{
			try
			{
				set.next();
				int workingDays = set.getInt(2);
				if(workingDays != -99)
				{
					initializeNumberOfWorkingDaysCombo(workingDays);
					numberOfWorkingDaysAddBtn.setText("Update");
				}
				else
				{
					numberOfWorkingDaysAddBtn.setText("Add");
					initializeNumberOfWorkingDaysCombo(-99);
				}
				
			} 
			catch (SQLException e)
			{
				numberOfWorkingDaysAddBtn.setText("Add");
				initializeNumberOfWorkingDaysCombo(-99);
			}
			
			setupWorkingTimeDuration(set);
		}
	}
	public void setupWorkingTimeDuration(ResultSet set)
	{
		try
		{
			int hours = set.getInt(3);
			int minutes = set.getInt(4);
			
			if(hours != -99 && minutes != -99)
			{
				hoursTextFiled.setText("" + hours);
				minutesTextFiled.setText("" + minutes);
				workingTimeDurationAddBtn.setText("Update");
			}
			else
			{
				hoursTextFiled.setText("");
				minutesTextFiled.setText("");
			}
		} 
		catch (SQLException e)
		{
			workingTimeDurationAddBtn.setText("Add");
			hoursTextFiled.setText("");
			minutesTextFiled.setText("");
		}
	}
	public void addNumberOfWorkingDays(ActionEvent event)
	{
		
		try
		{
			int item = combo_number_of_working_days.getSelectionModel().getSelectedItem();
			boolean res = QueriesOfWorkingDays.addNumberOfWorkingDays(programType,item);
		
			if(res)
				showAlert("Successfull");
			else
				showAlert("Unsuccessfull");
			
			setupNumberOfWorkingDaysRow();
		}
		catch(Exception e)
		{
			showAlert("Please choose a number first");
			
		}
		
	}
	public void deleteNumberOfWorkingDays(ActionEvent event)
	{
		boolean res = QueriesOfWorkingDays.deleteNumberOfWorkingDays(programType);
		if(res)
		{
			showAlert("Success");
			setupNumberOfWorkingDaysRow();
		}
		else
		{
			showAlert("Failed");
		}
	}
	public void addWorkingTimeDuration(ActionEvent event)
	{
		try
		{
			String hours = hoursTextFiled.getText().toString();
			String minutes = minutesTextFiled.getText().toString();
			
			int hoursInt = Integer.parseInt(hours);
			int minutesInt = Integer.parseInt(minutes);
			
			boolean res = QueriesOfWorkingDays.addWorkingTimeDuration(programType,hoursInt, minutesInt);
			if(res)
			{
				showAlert("Successfull");
			}
			else
			{
				showAlert("Unsuccessfull");
			}
			
			setupNumberOfWorkingDaysRow();
		}
		catch(Exception e)
		{
			showAlert("Please enter only Integers");
		}
	
	}
	public void deleteWorkingTimeDuration(ActionEvent event)
	{
		boolean res = QueriesOfWorkingDays.deleteWorkingTimeDuration(programType);
		if(res)
		{
			showAlert("Success");
			setupNumberOfWorkingDaysRow();
		}
		else
		{
			showAlert("Failed");
		}
	}
	public void showAlert(String message)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(message);
		alert.show();
	}
	public void setCheckBoxes()
	{
		ResultSet set = QueriesOfWorkingDays.getWorkingDays(programType);
		if(set != null)
		{
			try
			{
				while(set.next())
				{
					String text = set.getString(3);
					String isSelected = set.getString(4);
					
					boolean isSelect = Boolean.parseBoolean(isSelected);
					if(text != null)
					{
						
						if(text.equals("Monday"))
						{
							if(isSelect)
								MondayCombo.setSelected(true);
							else
								MondayCombo.setSelected(false);
						}
						else if(isSelect && text.equals("Tuesday"))
						{
							if(isSelect)
								TuesdayCombo.setSelected(true);
							else
								TuesdayCombo.setSelected(false);
							
						}
						else if(isSelect && text.equals("Wednesday"))
						{
							if(isSelect)
								WednesdayCombo.setSelected(true);
							else
								WednesdayCombo.setSelected(false);
							
						}
						else if(isSelect && text.equals("Thursday"))
						{
							if(isSelect)
								ThursdayCombo.setSelected(true);
							else
								ThursdayCombo.setSelected(false);
							
						}
						else if(isSelect && text.equals("Friday"))
						{
							if(isSelect)
								FridayCombo.setSelected(true);
							else
								FridayCombo.setSelected(false);
							
						}
						else if(isSelect && text.equals("Saturday"))
						{
							if(isSelect)
								SaturdayCombo.setSelected(true);
							else
								SaturdayCombo.setSelected(false);
							
						}
						else if(isSelect && text.equals("Sunday"))
						{
							if(isSelect)
								SundayCombo.setSelected(true);
							else
								SundayCombo.setSelected(false);
							
						}
					}
					
				}
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			
		}
	}
	public void onWorkingDaysUpdateButtonClicked(ActionEvent event)
	{
		if(programType == ProgramType.WEEK_DAY)
		{
			boolean res = QueriesOfWorkingDays.updateWorkingDays(1, MondayCombo.isSelected());
			if(res)
			{
				showAlert("Success");
				setCheckBoxes();
			}
			else
			{
				showAlert("Failed");
			}
		}
		else
		{
			boolean res = QueriesOfWorkingDays.updateWorkingDays(8, MondayCombo.isSelected());
			if(res)
			{
				showAlert("Success");
				setCheckBoxes();
			}
			else
			{
				showAlert("Failed");
			}
		}
		
	}
	
}
