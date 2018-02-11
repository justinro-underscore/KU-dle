package com.base.main;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateEventUI
{
	@FXML private Label lblEventDate;
	@FXML private Label lblEventName;
	@FXML private TextField txtEventName;
	@FXML private TextArea txtEventDesc;
	@FXML private Label lblEventDesc;

	@FXML private ListView<String> lstPossibleTimes;
	@FXML private ListView<String> lstChosenTimes;

	@FXML private Button btnAddTime;
	@FXML private Button btnDelTime;
	@FXML private Button btnCreate;

	private boolean eventCreated = false; // Will tell whether or not the event is created

	/**
	 * Where the application launches from
	 * @throws IOException
	 */
	public CreateEventUI() throws IOException
	{
		FXMLLoader load = new FXMLLoader(getClass().getResource("/CreateEvent.fxml")); // You may have to change the path in order to access CalendarUI.fxml TODO make sure this works
		load.setController(this); // Makes it so that you can control the UI using this class

		Parent root = (Parent) load.load();
		Scene scene = new Scene(root);

		lstPossibleTimes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		lstChosenTimes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		lstPossibleTimes.getItems().addAll(getPossibleTimes());

		// Start the application
		Stage stage = new Stage();
		stage.setTitle("Create Event");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		initializeListeners(stage);
		stage.setOnCloseRequest(e ->
		{
			eventCreated = true;
		});
	}

	/**
	 * Sets the functions that run when the user clicks on certain objects
	 */
	private void initializeListeners(Stage stage)
	{
		btnAddTime.setOnAction(e ->
		{
			ObservableList<String> temp = lstPossibleTimes.getSelectionModel().getSelectedItems();
			String[] selectedTimes = temp.toArray(new String[0]);

            for(String time : selectedTimes)
            {
            	lstChosenTimes.getItems().add(time);
            	lstPossibleTimes.getItems().remove(time);
            }
        	lstChosenTimes.getItems().sort((String s1, String s2) -> s1.compareTo(s2));
		});

		btnDelTime.setOnAction(e ->
		{
			ObservableList<String> temp = lstChosenTimes.getSelectionModel().getSelectedItems();
			String[] selectedTimes = temp.toArray(new String[0]);

            for(String time : selectedTimes)
            {
            	lstPossibleTimes.getItems().add(time);
            	lstChosenTimes.getItems().remove(time);
            }
        	lstPossibleTimes.getItems().sort((String s1, String s2) -> s1.compareTo(s2));
		});

		btnCreate.setOnAction(e ->
		{
			if(checkInputs())
			{
				// TODO Create event
				showDialogBox("Event Created", "Event Created!", "Event \"" + txtEventName.getText() + "\" was successfully created!", AlertType.INFORMATION);
				eventCreated = true;
				stage.close();
			}
		});
	}

	private boolean checkInputs()
	{
		if(txtEventName.getText().isEmpty())
		{
			showDialogBox("Empty Field", "Event Name Empty", "Please enter an event name", AlertType.ERROR);
			txtEventName.requestFocus();
			return false;
		}
		if(txtEventDesc.getText().isEmpty())
		{
			showDialogBox("Empty Field", "Event Description Empty", "Please enter an event description", AlertType.ERROR);
			txtEventDesc.requestFocus();
			return false;
		}
		if(lstChosenTimes.getItems().isEmpty())
		{
			showDialogBox("Empty Field", "Chosen Times Empty", "Please select time(s) available for the event", AlertType.ERROR);
			lstPossibleTimes.requestFocus();
			return false;
		}
		// TODO check for repeat names
		return true;
	}

	/**
	 *
	 * http://code.makery.ch/blog/javafx-dialogs-official/
	 * @param title
	 * @param header
	 * @param content
	 * @param type
	 */
	public void showDialogBox(String title, String header, String content, AlertType type)
	{
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);

		alert.showAndWait();
	}

	private ArrayList<String> getPossibleTimes()
	{
		ArrayList<String> times = new ArrayList<String>();
		times.add("5:00");
		times.add("5:20");
		times.add("5:40");
		times.add("6:00");
		times.add("6:20");
		times.add("6:40");
		times.add("7:00");
		times.add("7:20");
		times.add("7:40");
//        "8:00", "8:20", "8:40", "9:00", "9:20", "9:40", "10:00", "10:20", "10:40",
//        "11:00", "11:20", "11:40", "13:00", "13:20", "13:40", "14:00", "14:20", "14:40",
//        "15:00", "15:20", "15:40", "16:00", "16:20", "16:40", "17:00", "17:20", "17:40",
//        "18:00", "18:20", "18:40", "19:00", "19:20", "19:40", "20:00", "20:20", "20:40",
//        "21:00", "21:20", "21:40", "22:00", "22:20", "22:40", "23:00", "23:20", "23:40"
		return times;
	}

	public boolean getEventFinished()
	{
		return eventCreated;
	}
}
