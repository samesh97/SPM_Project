package views;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class StatisticsLoadController implements Initializable{

	public void onLoadStatisticsButtonClicked(){
		System.out.println("Lecturer Load statistics button clicked");
	}

	public void onLoadStatisticsStudentButtonClicked(){
		System.out.println("Student Load statistics button clicked");
	}
	
	public void onLoadStatisticsSubjectButtonClicked(){
		System.out.println("Student Load statistics button clicked");
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
