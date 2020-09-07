package views.controllers;

import database.DatabaseHandler_Students;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class StudentsUpdateController {
	@FXML
	private TextField yearSemText;
	@FXML
	private TextField programText;
	@FXML
	private TextField GroupNoText;
	@FXML
	private TextField SubNoText;
	@FXML
	private TextField groupIDText;
	@FXML
	private TextField subIDText;

	
public void UpdateStudentSet(String yearSem,String program,String groupNo,String subGroupNo,String groupId,String subGroupId) {
		
	yearSemText.setText(yearSem);
	programText.setText(program);
	GroupNoText.setText(groupNo);
	SubNoText.setText(subGroupNo);
	groupIDText.setText(groupId);
	subIDText.setText(subGroupId);

}


}