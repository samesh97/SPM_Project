package views.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class SessionsViewController implements Initializable{

	
@FXML
private Button btn_CreateASession;
@FXML
private TilePane tilePane;
@FXML
private Label lbl1;
@FXML
private Label lbl2;
@FXML
private Label lbl3;
@FXML
private Label lbl4;
@FXML
private Label lbl5;
@FXML
private Label lbl6;
@FXML
private Label lbl7;
@FXML
private Label lbl8;
@FXML
private Label lbl9;
@FXML
private Label lbl10;



public void buildUI() {
	
	tilePane.getChildren().add(0, lbl1);
	tilePane.getChildren().add(0, lbl2);
	tilePane.getChildren().add(0, lbl3);
	tilePane.getChildren().add(0, lbl4);
	tilePane.getChildren().add(0, lbl5);
	tilePane.getChildren().add(0, lbl6);
	tilePane.getChildren().add(0, lbl7);
	tilePane.getChildren().add(0, lbl8);
	tilePane.getChildren().add(0, lbl9);
	tilePane.getChildren().add(0, lbl10);
	
/*	buttons =new Button[51];
	for(int i=1;i<51;i++) {
		Button button=new Button(Integer.toString(i));
		button.setPrefWidth(50);
		button.setPrefHeight(50);
		tilePane.getChildren().add(button);
		buttons[i]=button;
		
		tilePane.setOrientation(Orientation.HORIZONTAL);
		//tilePane.setOrientation(Orientation.VERTICAL);
		
		tilePane.setHgap(5);
		tilePane.setVgap(5);
		
		tilePane.setPrefColumns(18);
		//tilePane.setPrefRows(18);
		
		scene = new Scene(tilePane);
		stage.setScene(scene);
		
	}
	*/
}

public void onCreateASessionClicked(ActionEvent event) {
	System.out.println("Create a session button clicked");
	Scene scene = btn_CreateASession.getScene();
	AnchorPane pane = (AnchorPane) scene.lookup("#controllerPane");
	changeCenterContent(pane,"../SessionsMain.fxml");
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




@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	
}


//end bracket
}
