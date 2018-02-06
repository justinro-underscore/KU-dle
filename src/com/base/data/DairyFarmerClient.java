package com.base.data;

import com.base.data.interfaces.Events;
import com.base.data.models.Event;
import com.base.data.models.User;
import com.google.gson.Gson;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

//TODO: add tests
//TODO: load users on initialization
//TODO: Validate input (no duplicate named events on same day?)
//TODO: How are we handling user login? Delete/add options should only be available to admins.
public class DairyFarmerClient {
    private Gson gson;
    private FileWriter writer;
    private BufferedReader reader;

    public DairyFarmerClient() {
        gson = new Gson();
    }

    //TODO: Use apache fileUtil library?
    public List<Event> getEvents(LocalDate date) throws IOException {
        reader = new BufferedReader(new FileReader("res/events/" + date + ".txt"));

        String json = reader.readLine();
        Events events = gson.fromJson(json, Events.class);

        return events.getEvents();
    }

    public void createEvent(String eventName, String creatorName, LocalDate date, List<LocalTime> times, List<User> attendees) {
        //TODO: maybe have list of times with their own list of attendees (that way we know who is available at what time)?
        //TODO: maybe add to list -> have list of events for each day and get specific by creator
        Event event = new Event(eventName, creatorName, date, times, attendees);
        String eventJson = gson.toJson(event);
        //TODO: SAVE FILE
        //TODO: do we want to return the event too?
    }

    public void deleteEvent(String creatorName, List<LocalTime> times) {
        //TODO: search for event by getting file with specific date. Search through event for creator
        // and matching times (needed is user can create multiple events on same day)

    }

    //TODO: what to do with users (store data in res/users/)
    //@pre: requires a username, and password, and if the user is an admin
    //@post: creates a new user and adds it to the list of known users
    //@return: nothing
    public void createUser(String username, String password, boolean adminStatus)
    {
      User newUser = new User(username, password, adminStatus);
      String userJson = gson.toJson(newUser);
      //TODO save to file containing list of known users
    }

    //@pre: requires a username
    //@post: finds and removes a user from the know user list
    //@return: //TODO I think this should be a bool to see if a user was deleted or not.
    public void deleteUser(user)
    {
      //delete (<- lol what a command) getUser(user);
    }

    //Is this supposed to search for and return some user?
    public List<User> getUsers() {
        return null;
    }

    //TODO: create file writer
    //TODO: change file name to date (requires from createEvent)
    public void createFile(String json, String fileName) throws IOException {
        writer = new FileWriter("res/events/" + fileName + ".txt");
        writer.write(json);
        writer.close();
    }
}
