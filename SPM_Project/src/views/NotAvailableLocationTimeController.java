package views;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import database.DatabaseHandler_Connections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;

public class NotAvailableLocationTimeController implements Initializable{

	@FXML
	private ComboBox<String> roomIdComboBox;
	@FXML
	private ComboBox<String> dayComboBox;
	@FXML
	private ComboBox<String> timeSlotComboBox;
	
	
	public void onNotAvailableButtonClicked(){
		System.out.println("Not Available button clicked");
		
		String roomId = roomIdComboBox.getValue();
		String day = dayComboBox.getValue();
		String timeSlot = timeSlotComboBox.getValue();
		
		
		if(roomId == null || day == null || timeSlot == null) {
			showAlert("Please fill the empty feilds!");
		}
		else {
			try {
				boolean result= DatabaseHandler_Connections.addNotAvailability(roomId, day, timeSlot);
				if(result== true) {
					showAlert("A record is successfully added");
				}
				else {
					showAlert("Unsuccessful");
				}
			
			}catch(Exception e) {
			    showAlert("Please enter details correctly");
			}
		}
	}

	public void showAlert(String message)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(message);
		alert.show();
	}
	
	public void setComboBoxes()
	{

		
		//roomId combo box
		ObservableList<String> room_id = FXCollections.observableArrayList();
		
		try {
			ResultSet rs= DatabaseHandler_Connections.getPrefferedRooms();
					
			while(rs.next()){
				
				room_id.add(rs.getString("roomId"));
				
			}
					
			roomIdComboBox.setItems(null);
			roomIdComboBox.setItems(room_id);
					
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		//day combo box
		ObservableList<String> day = FXCollections.observableArrayList();
		day.add("Monday");
		day.add("Tuesday");
		day.add("Wednesday");
		day.add("Thursday");
		day.add("Friday");
		day.add("Saturday");
		day.add("Sunday");
	
		dayComboBox.setItems(null);
		dayComboBox.setItems(day);
	
		//Time slot combo box
		ObservableList<String> time_slot = FXCollections.observableArrayList();
		time_slot.add("8.30-9.30");		
		time_slot.add("9.30-10.30");
		time_slot.add("10.30-11.30");
		time_slot.add("11.30-12.30");
		time_slot.add("12.30-1.30");
		time_slot.add("1.30-2.30");
		time_slot.add("2.30-3.30");
		time_slot.add("3.30-4.30");
		time_slot.add("4.30-5.30");
		time_slot.add("5.30-6.30");
		time_slot.add("6.30-7.30");
		
		time_slot.add("8.30-10.30");
		time_slot.add("10.30-12.30");
		time_slot.add("1.30-3.30");
		time_slot.add("3.30-5.30");
		time_slot.add("5.30-7.30");
		
		time_slot.add("9.30-11.30");
		time_slot.add("11.30-1.30");
		time_slot.add("2.30-4.30");
		time_slot.add("4.30-6.30");
		time_slot.add("6.30-8.30");
		
		timeSlotComboBox.setItems(null);
		timeSlotComboBox.setItems(time_slot);
		
	}

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		setComboBoxes();
	}
}
