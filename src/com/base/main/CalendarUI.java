package com.base.main;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class CalendarUI extends Application
{
	@FXML private Label lblCurrentMonth;
	@FXML private Label lblCurrentDate;
	@FXML private Label btnMonthLeft;
	@FXML private Label btnMonthRight;
	@FXML private Label lblDay47;
	@FXML private Label lblDay46;
	@FXML private Label lblDay45;
	@FXML private Label lblDay44;
	@FXML private Label lblDay43;
	@FXML private Label lblDay42;
	@FXML private Label lblDay41;
	@FXML private Label lblDay40;
	@FXML private Label lblDay36;
	@FXML private Label lblDay35;
	@FXML private Label lblDay34;
	@FXML private Label lblDay33;
	@FXML private Label lblDay32;
	@FXML private Label lblDay31;
	@FXML private Label lblDay30;
	@FXML private Label lblDay26;
	@FXML private Label lblDay25;
	@FXML private Label lblDay24;
	@FXML private Label lblDay23;
	@FXML private Label lblDay22;
	@FXML private Label lblDay21;
	@FXML private Label lblDay20;
	@FXML private Label lblDay16;
	@FXML private Label lblDay15;
	@FXML private Label lblDay14;
	@FXML private Label lblDay13;
	@FXML private Label lblDay12;
	@FXML private Label lblDay11;
	@FXML private Label lblDay10;
	@FXML private Label lblDay06;
	@FXML private Label lblDay05;
	@FXML private Label lblDay04;
	@FXML private Label lblDay03;
	@FXML private Label lblDay02;
	@FXML private Label lblDay01;
	@FXML private Label lblDay00;


	@FXML private Label boxDay47;
	@FXML private Label boxDay46;
	@FXML private Label boxDay45;
	@FXML private Label boxDay44;
	@FXML private Label boxDay43;
	@FXML private Label boxDay42;
	@FXML private Label boxDay41;
	@FXML private Label boxDay40;
	@FXML private Label boxDay36;
	@FXML private Label boxDay35;
	@FXML private Label boxDay34;
	@FXML private Label boxDay33;
	@FXML private Label boxDay32;
	@FXML private Label boxDay31;
	@FXML private Label boxDay30;
	@FXML private Label boxDay26;
	@FXML private Label boxDay25;
	@FXML private Label boxDay24;
	@FXML private Label boxDay23;
	@FXML private Label boxDay22;
	@FXML private Label boxDay21;
	@FXML private Label boxDay20;
	@FXML private Label boxDay16;
	@FXML private Label boxDay15;
	@FXML private Label boxDay14;
	@FXML private Label boxDay13;
	@FXML private Label boxDay12;
	@FXML private Label boxDay11;
	@FXML private Label boxDay10;
	@FXML private Label boxDay06;
	@FXML private Label boxDay05;
	@FXML private Label boxDay04;
	@FXML private Label boxDay03;
	@FXML private Label boxDay02;
	@FXML private Label boxDay01;
	@FXML private Label boxDay00;

	@FXML private ListView<String> listView;

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("CalendarUI.fxml")); // You might have to change this to "\\Calendar.fxml"
		Scene scene = new Scene(root);
		stage.setTitle("Calendar");
		stage.setScene(scene);
		stage.show();
	}
}
