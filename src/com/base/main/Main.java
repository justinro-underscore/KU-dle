package com.base.main;
import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;



public class Main extends Application
{
	public static void main(String[] args) {
		launch(args);
	}
		
	public void start(Stage stage) throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("\\CalendarUI.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Calendar");
		stage.setScene(scene);
		stage.show();
		
	}
	

	
}

