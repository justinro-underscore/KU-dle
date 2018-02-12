package com.base.main;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.base.data.DairyFarmerClient;
import com.base.data.models.Event;
import com.base.data.models.User;
import com.base.util.Time;

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

	@FXML private ListView<Time> lstPossibleTimes;
	@FXML private ListView<Time> lstChosenTimes;

	@FXML private Button btnAddTime;
	@FXML private Button btnDelTime;
	@FXML private Button btnCreate;

	private DairyFarmerClient client;
	private User admin;
	private LocalDate currDate;

	private boolean eventCreated = false; // Will tell whether or not the event is created

	/**
	 * Where the application launches from
	 * @throws IOException
	 */
	public CreateEventUI(DairyFarmerClient clientParam, User adminParam, LocalDate currDateParam) throws IOException
	{
		FXMLLoader load = new FXMLLoader(getClass().getResource("/CreateEvent.fxml")); // You may have to change the path in order to access CalendarUI.fxml TODO make sure this works
		load.setController(this); // Makes it so that you can control the UI using this class

		Parent root = (Parent) load.load();
		Scene scene = new Scene(root);

		lstPossibleTimes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		lstChosenTimes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		lstPossibleTimes.getItems().addAll(getPossibleTimes());

		// Start the application
		client = clientParam;
		admin = adminParam;
		currDate = currDateParam;
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
			ObservableList<Time> temp = lstPossibleTimes.getSelectionModel().getSelectedItems();
			Time[] selectedTimes = temp.toArray(new Time[0]);

            for(Time time : selectedTimes)
            {
            	lstChosenTimes.getItems().add(time);
            	lstPossibleTimes.getItems().remove(time);
            }
        	lstChosenTimes.getItems().sort((Time t1, Time t2) -> t1.getTime().compareTo(t2.getTime()));
		});

		btnDelTime.setOnAction(e ->
		{
			ObservableList<Time> temp = lstChosenTimes.getSelectionModel().getSelectedItems();
			Time[] selectedTimes = temp.toArray(new Time[0]);

            for(Time time : selectedTimes)
            {
            	lstPossibleTimes.getItems().add(time);
            	lstChosenTimes.getItems().remove(time);
            }
        	lstPossibleTimes.getItems().sort((Time t1, Time t2) -> t1.getTime().compareTo(t2.getTime()));
		});

		btnCreate.setOnAction(e ->
		{
			if(checkInputs())
			{
				List<Time> tempTime = lstChosenTimes.getItems();
				for(Time t : tempTime)
				{
					t.addAttendee(admin);
				}
				List<User> tempUser = new ArrayList<User>();
				tempUser.add(admin);
				client.createEvent(txtEventName.getText(), txtEventDesc.getText(), admin.getName(), currDate, tempTime, tempUser);
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
		List<Event> temp = client.getEvents(currDate);
		if(temp != null)
		{
			for(Event e : temp)
			{
				if(txtEventName.getText().equals(e.getEventName()))
				{
					showDialogBox("Repeat Event Name", "Event Name Already Exists!", "Please change the event name", AlertType.ERROR);
					txtEventName.requestFocus();
					return false;
				}
			}
		}
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

	private ArrayList<Time> getPossibleTimes()
	{
		ArrayList<Time> times = new ArrayList<Time>();
		Time tempTime;
		ArrayList<User> tempUsers = new ArrayList<User>();
		for(int hour = 5; hour < 24; hour++)
		{
			if(hour != 12)
			{
				for(int min = 0; min < 60; min += 20)
				{
					tempTime = new Time(LocalTime.of(hour, min), tempUsers);
					times.add(tempTime);
				}
			}
		}
		return times;
	}

	public boolean getEventFinished()
	{
		return eventCreated;
	}
}
