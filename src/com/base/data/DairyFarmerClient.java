package com.base.data;

import com.base.data.interfaces.Events;
import com.base.data.interfaces.Users;
import com.base.data.models.Event;
import com.base.data.models.User;
import com.google.gson.Gson;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

//TODO: load users and events on initialization
public class DairyFarmerClient {
    private Gson gson;
    private FileWriter writer;
    private BufferedReader reader;

    private HashMap<LocalDate, List<Event>> events;

    public DairyFarmerClient() {
        gson = new Gson();
    }

    public List<Event> getEvents(LocalDate date) throws IOException {
        //TODO: not sure if we need a try catch if event list does not exist
        return events.get(date);
    }

    public void createEvent(String eventName, String creatorName, LocalDate date, List<LocalTime> times, List<User> attendees) throws IOException {
        //TODO: maybe have list of times with their own list of attendees (that way we know who is available at what time)?
        //TODO: maybe add to list -> have list of events for each day and get specific by creator
        Event event = new Event(eventName, creatorName, date, times, attendees);
        getEvents(date).add(event);
    }

    public void deleteEvent(String creatorName, List<LocalTime> times) {
        //TODO: search for event by getting file with specific date. Search through event for creator
        // and matching times (needed is user can create multiple events on same day)

    }

    //@pre: requires a username, and password, and if the user is an admin
    //@post: checks if user exits, then adds it to the user hashmap if it doesnt
    //@return: nothing (may change to a bool)
    public void createUser(User user)
    {
        //TODO Throw error stating that username is taken

    }

    //@pre: requires a username
    //@post: finds and removes a user from the know user list
    //@return: //TODO I think this should be a bool to see if a user was deleted or not.
    public void deleteUser(User user)
    {
      //TODO make sure this doesnt break

    }

    //Is this supposed to search for and return some user?
    public List<User> getUsers() {
        return null;
    }

    //TODO: write user and events hashmap to file
    public void createFile(String json, String fileName) throws IOException {
        writer = new FileWriter(fileName);
        writer.write(json);
        writer.close();
    }

    //@pre: Requires the filename containing user information
    //@post: initializes a file scanner that seperates terms by ",". Adds user information to Hashaps
    //@return: nothing
    public HashMap<String, User> initUsers(String userFile) throws IOException {
        reader = new BufferedReader(new FileReader("res//" + userFile + ".txt"));

        String json = reader.readLine();
        Users users = gson.fromJson(json, Users.class);

        return users.getUsers();
    }

    public void initEvents() throws IOException {
        reader = new BufferedReader(new FileReader("res/events/events.txt"));

        String json = reader.readLine();
        Events tempEvents = gson.fromJson(json, Events.class);

        events = tempEvents.getEvents();
    }

}
