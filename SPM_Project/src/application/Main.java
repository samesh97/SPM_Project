package application;
	
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application{
	@Override
	public void start(Stage primaryStage)
	{
		try
		{
//			BorderPane root = new BorderPane();
//			Scene scene = new Scene(root,1000,700);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
			
			
			//load main fxml file
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/Main.fxml"));
			 AnchorPane root = (AnchorPane) loader.load();
			 Scene scene = new Scene(root);
			 primaryStage.setScene(scene);
			 
			 
			 GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
			 int width = (int) (gd.getDisplayMode().getWidth());
			 int height = (int) (gd.getDisplayMode().getHeight());
			 
			 
			 float heightSpace = 1.2f;
			 float widthSpace = 1.5f;
			 
			 primaryStage.setMinHeight(height / heightSpace);
			 primaryStage.setMinWidth(width / widthSpace);
			 primaryStage.setTitle("SLIIT Time Table Management");
			 primaryStage.setWidth(width / widthSpace);
			 primaryStage.setHeight(height / heightSpace);
			 primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../media/SLIIT_Logo_Crest.png")));
		
			 primaryStage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		launch(args);
	}
}
