package views.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import database.QueriesOfWorkingDays;
import enums.Program;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class WorkingDaysTimeSlotsController implements Initializable
{
	@FXML
	private ImageView backbutton;
	@FXML
	private ComboBox<Object> combo_working_days_type;
	
	@FXML
	private RadioButton oneHourRadio,thirtyMinutesradio;
	
	@FXML
	private TextField startHoursText,startMinutesText;
	
	
	private int programType = -99;
	
	public void onBackButtonPressed(MouseEvent event)
	{
		Scene scene = backbutton.getScene();
		AnchorPane pane = (AnchorPane) scene.lookup("#controllerPane");
		changeCenterContent(pane,"../WorkingDaysMain.fxml");
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
	public void onAddSlotButtonClicked(ActionEvent event)
	{
		if(programType != -99)
		{
			try
			{
				String hours = startHoursText.getText();
				String minutes = startMinutesText.getText();
				int intHours = Integer.parseInt(hours);
				int intMinutes = Integer.parseInt(minutes);
				
				
				boolean isOneHour = oneHourRadio.isSelected();
				boolean isThirty = thirtyMinutesradio.isSelected();
				
				if(isOneHour || isThirty)
				{
					if(isOneHour)
					{
						boolean res = QueriesOfWorkingDays.createNewSlot(programType, "1 Hour", intHours, intMinutes);
						if(res)
						{
							showAlert("Created");
						}
						else
						{
							showAlert("Failed to create");
						}
					}
					else
					{
						boolean res = QueriesOfWorkingDays.createNewSlot(programType, "30 Minutes", intHours, intMinutes);
						if(res)
						{
							showAlert("Created");
						}
						else
						{
							showAlert("Failed to create");
						}
					}
				}
				else
				{
					showAlert("Please select the duration");
				}
				
			}
			catch(Exception e)
			{
				showAlert("Please specify only numbers");
			}
			
			
			
		}
		else
		{
			showAlert("Please select Program Type");
		}
	}
	public void showAlert(String message)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(message);
		alert.show();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		// TODO Auto-generated method stub
		
		initializeWorkingDaysTypeCombo();
		
		//listeners
		combo_working_days_type.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) -> {
	         
			if(newValue.equals("Weekend"))
			{
				programType = Program.WEEK_END;
			}
			else if(newValue.equals("Weekday"))
			{
				programType = Program.WEEK_DAY;
			}
	    }
	    ); 
		
		oneHourRadio.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected)
		    {
		        if(isNowSelected && thirtyMinutesradio.isSelected())
		        {
		        	thirtyMinutesradio.setSelected(false);
		        }
		    }
		});
		
		thirtyMinutesradio.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected)
		    {
		    	if(isNowSelected && oneHourRadio.isSelected())
		        {
		    		oneHourRadio.setSelected(false);
		        }
		    }
		});
		
	}
	private void initializeWorkingDaysTypeCombo()
	{
		ObservableList<Object> data = FXCollections.observableArrayList();
		data.add("Weekday");
		data.add("Weekend");
		combo_working_days_type.setItems(null);
		combo_working_days_type.setItems(data);
		
//		combo_working_days_type.getSelectionModel().selectFirst();
		
	
	}

}
