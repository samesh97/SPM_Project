package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
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
			 primaryStage.setMinHeight(850);
			 primaryStage.setMinWidth(1100);
			 primaryStage.setMaxHeight(850);
			 primaryStage.setMaxWidth(1100);
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
