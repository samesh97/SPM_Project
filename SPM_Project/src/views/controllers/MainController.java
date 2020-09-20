package views.controllers;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import listeners.OnTaskCompleteListener;

public class MainController implements Initializable,OnTaskCompleteListener
{
	@FXML
	private AnchorPane controllerPane;
	@FXML
	private Button btn_students;
	@FXML
	private Button btn_tags;
	@FXML
	private Button btn_subjects;
	@FXML
	private Button btn_lecturers;
	@FXML
	private Button btn_working_days;
	@FXML
	private Button btn_locations;
	@FXML
	private Button btn_connections;
	@FXML
	private Button btn_statistics;
	@FXML
	private Button btn_sessions;
	@FXML
	private Button btn_time_table;
	@FXML
	private VBox allButtonVBox;
	
	private VBox progressDialogVBox;
	
	@FXML
	private ImageView successFailedIcon;
	@FXML
	private Text successFailedText;
	@FXML
	private AnchorPane mainAnchorPane;

	
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		//start default when load the FXML
		highlightClickedButton(btn_students);
		changeCenterContent("../StudentsMain.fxml");
		
		
		 showProgressDialog(mainAnchorPane);
		 
		 //connect to the database
		 
		 Runnable r = new Runnable() 
		 {
	         public void run()
	         {
	        	 DatabaseHandler.makeConnection(MainController.this);
	         }
	     };
	     new Thread(r).start();
	}
	
	public void onStudentButtonClicked(ActionEvent event)
	{
		highlightClickedButton(btn_students);
		changeCenterContent("../StudentsMain.fxml");
	}
	public void onSessionsButtonClicked(ActionEvent event)
	{
		highlightClickedButton(btn_sessions);
		changeCenterContent("../SessionsMain.fxml");
	}
	public void onTagButtonClicked(ActionEvent event)
	{
		highlightClickedButton(btn_tags);
		changeCenterContent("../TagsMain.fxml");
	}
	public void onSubjectsButtonClicked(ActionEvent event) 
	{
		highlightClickedButton(btn_subjects);
		changeCenterContent("../SubjectsMain.fxml");
	}
	
	
	public void onLecturersButtonClicked(ActionEvent event) 
	{
		highlightClickedButton(btn_lecturers);
		changeCenterContent("../LecturersMain.fxml");
	}
	public void onWorkingDaysButtonClicked(ActionEvent event) 
	{
		highlightClickedButton(btn_working_days);
		changeCenterContent("../WorkingDaysMain.fxml");
	}
	public void onLocationsButtonClicked(ActionEvent event) 
	{
		highlightClickedButton(btn_locations);
		changeCenterContent("../LocationsMain.fxml");
	}
	public void onStatisticsButtonClicked(ActionEvent event) 
	{
		System.out.println("Statistics button clicked");
		highlightClickedButton(btn_statistics);
		changeCenterContent("../StatisticsMain.fxml");
	}
	
	public void changeCenterContent(String fxmlFileName)
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
	public void highlightClickedButton(Button button)
	{
		btn_students.setDefaultButton(false);
		btn_tags.setDefaultButton(false);
		btn_subjects.setDefaultButton(false);
		btn_lecturers.setDefaultButton(false);
		btn_working_days.setDefaultButton(false);
		btn_locations.setDefaultButton(false);
		btn_connections.setDefaultButton(false);
		btn_statistics.setDefaultButton(false);
		btn_sessions.setDefaultButton(false);
		btn_time_table.setDefaultButton(false);
		
		
		button.setDefaultButton(true);
	}
	public void showProgressDialog(AnchorPane pane)
	{
		disableOrEnableBackground(true);
		
		
		 ProgressIndicator pi = new ProgressIndicator();
		 progressDialogVBox = new VBox(pi);
		 progressDialogVBox.setAlignment(Pos.CENTER);
         
		 AnchorPane.setTopAnchor(progressDialogVBox, 0.0);
		 AnchorPane.setRightAnchor(progressDialogVBox, 0.0);
		 AnchorPane.setLeftAnchor(progressDialogVBox, 0.0);
		 AnchorPane.setBottomAnchor(progressDialogVBox, 0.0);
         pane.getChildren().add(progressDialogVBox);
	}

	@Override
	public void onFinished(boolean isSuccess)
	{
		progressDialogVBox.setVisible(false);
		disableOrEnableBackground(false);
		if(isSuccess)
		{
			File file = new File("src/media/success.png");
		    Image image = new Image(file.toURI().toString());
			successFailedIcon.setImage(image);
			successFailedText.setText("Connected");
		
		}
		else
		{
			File file = new File("src/media/failed.png");
		    Image image = new Image(file.toURI().toString());
			successFailedText.setText("No Internet");
		}
		
	}
	public void disableOrEnableBackground(boolean value)
	{
		if(value)
		{
			controllerPane.setDisable(true);
			allButtonVBox.setDisable(true);
		}
		else
		{
			controllerPane.setDisable(false);
			allButtonVBox.setDisable(false);
		}
	}


}

