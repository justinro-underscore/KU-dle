package com.base.main;

import java.io.IOException;
import java.util.List;

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
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

public class AcceptEventUI
{
	@FXML private ListView<Time> lstAvailableTimes;
	@FXML private ListView<Time> lstChosenTimes;

	@FXML private Button btnAddTime;
	@FXML private Button btnRemTime;
	@FXML private Button btnApprove;
	@FXML private Button btnCancel;

	private User user;
	private Event event;

	private boolean done = false; // Will tell whether or not user is done

	/**
	 * Where the application launches from
	 * @throws IOException
	 */
	public AcceptEventUI(User userParam, Event eventParam) throws IOException
	{
		FXMLLoader load = new FXMLLoader(getClass().getResource("/AcceptEventUI.fxml")); // You may have to change the path in order to access CalendarUI.fxml TODO make sure this works
		load.setController(this); // Makes it so that you can control the UI using this class

		Parent root = (Parent) load.load();
		Scene scene = new Scene(root);

		lstAvailableTimes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		lstChosenTimes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		lstAvailableTimes.getItems().addAll(eventParam.getTimes());

		// Start the application
		user = userParam;
		event = eventParam;
		Stage stage = new Stage();
		stage.setTitle("Create Event");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		initializeListeners(stage);
		stage.setOnCloseRequest(e ->
		{
			done = true;
		});
	}

	/**
	 * Sets the functions that run when the user clicks on certain objects
	 */
	private void initializeListeners(Stage stage)
	{
		btnAddTime.setOnAction(e ->
		{
			ObservableList<Time> temp = lstAvailableTimes.getSelectionModel().getSelectedItems();
			Time[] selectedTimes = temp.toArray(new Time[0]);

            for(Time time : selectedTimes)
            {
            	lstChosenTimes.getItems().add(time);
            	lstAvailableTimes.getItems().remove(time);
            }
        	lstChosenTimes.getItems().sort((Time t1, Time t2) -> t1.getTime().compareTo(t2.getTime()));
		});

		btnRemTime.setOnAction(e ->
		{
			ObservableList<Time> temp = lstChosenTimes.getSelectionModel().getSelectedItems();
			Time[] selectedTimes = temp.toArray(new Time[0]);

            for(Time time : selectedTimes)
            {
            	lstAvailableTimes.getItems().add(time);
            	lstChosenTimes.getItems().remove(time);
            }
            lstAvailableTimes.getItems().sort((Time t1, Time t2) -> t1.getTime().compareTo(t2.getTime()));
		});

		btnApprove.setOnAction(e ->
		{
			if(!lstChosenTimes.getItems().isEmpty())
			{
				event.addAttendee(user);
				List<Time> times = lstChosenTimes.getItems();
				for(Time t : times)
				{
					t.addAttendee(user);
				}
				showDialogBox("Approved Event", "Approved Event!", "You have committed to going to \"" + event.getEventName() + "\"!", AlertType.INFORMATION);
				done = true;
				stage.close();
			}
			else
				showDialogBox("Empty Field", "No Chosen Times", "You must choose times that you are available", AlertType.ERROR);
		});

		btnCancel.setOnAction(e ->
		{
			done = true;
			stage.close();
		});
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

	public boolean getWindowFinished()
	{
		return done;
	}
}
