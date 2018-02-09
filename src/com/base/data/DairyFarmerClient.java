package com.base.data;

import com.base.data.interfaces.Events;
import com.base.data.interfaces.Users;
import com.base.data.models.Event;
import com.base.data.models.User;
import com.base.util.Time;
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
    private HashMap<String, User> users;

    /*
    * @pre: nothing
    * @post: initializes gson object
    * @return: nothing
     */
    public DairyFarmerClient() {
        gson = new Gson();
    }

    /*
    * @pre: requires a date to get specific events for that day
    * @post: nothing
    * @return: list of events for the provided date
     */
    public List<Event> getEvents(LocalDate date) throws IOException {
        //TODO: not sure if we need to check containsKey if event list does not exist

        return events.get(date);
    }

    /*
    * @pre: requires an eventName, creatorName, date and a list of times
    * @post: creates event and adds to hashmap of events
    * @return: nothing
     */
    public void createEvent(String eventName, String creatorName, LocalDate date, List<Time> times) throws IOException {
        //TODO: maybe have list of times with their own list of attendees (that way we know who is available at what time)?
        //TODO: maybe add to list -> have list of events for each day and get specific by creator
        //TODO: only if date exists in hashmap add event -> else add date and list with event to hashmap
        Event event = new Event(eventName, creatorName, date, times);

        if (events.containsKey(date)) {
            events.get(date).add(event);
        } else {
            List<Event> tempEvents = new ArrayList<>();
            tempEvents.add(event);

            events.put(date, tempEvents);
        }
    }

    /*
    * @pre: requires a date, and event name
    * @post: if events exists, delete event from hashmap
    * @return: nothing
     */
    public void deleteEvent(LocalDate date, String eventName) throws IOException {
        List<Event> events = getEvents(date);
        for(Event event : events){
            if(event.getEventName().equals(eventName)){
                events.remove(event);
            }
        }

    }

    /*
    * @pre: requires a username, and password, and if the user is an admin
    * @post: checks if user exits, then adds it to the user hashmap if it doesnt
    * @return: nothing (may change to a bool)
     */
    public void createUser(User user)
    {
        //TODO Throw error stating that username is taken

    }

    /*
    * @pre: requires a username
    * @post: finds and removes a user from the know user list
    * @return: //TODO I think this should be a bool to see if a user was deleted or not.
     */
    public void deleteUser(User user)
    {
      //TODO make sure this doesnt break

    }

    /*
    * @pre: nothing
    * @post: nothing
    * @return: returns hashmap of users
     */
    public List<User> getUsers() {
        return null;
    }

    /*
    * @pre: String of json data and file name
    * @post: writes json data to file
    * @return: nothing
     */
    public void createFile(String json, String fileName) throws IOException {
        writer = new FileWriter(fileName);
        writer.write(json);
        writer.close();
    }

    /*
    * @pre: Requires the filename containing user information
    * @post: creates a hashmap of users
    * @return: nothing
    */
    public void initUsers() throws IOException {
        File userFile = new File("res/users.txt");
        if (!userFile.exists()) {
            users = new HashMap<>();
            return;
        }

        reader = new BufferedReader(new FileReader("res/users.txt"));

        String json = reader.readLine();
        Users tempUsers = gson.fromJson(json, Users.class);

        users = tempUsers.getUsers();
    }

    /*
    * @pre: nothing
    * @post: creates a hashmap of events
    * @return: nothing
    */
    public void initEvents() throws IOException {
        //TODO: maybe change path to a constant?
        File eventsFile = new File("res/events.txt");
        if (!eventsFile.exists()) {
            events = new HashMap<>();
            return;
        }

        reader = new BufferedReader(new FileReader("res/events.txt"));

        String json = reader.readLine();
        Events tempEvents = gson.fromJson(json, Events.class);

        events = tempEvents.getEvents();
    }

    /*
    * @pre: nothing
    * @post: converts events to json and saves to file
    * @return: nothing
    */
    public void saveEvents() throws IOException {
        String eventJson = gson.toJson(events);

        createFile(eventJson, "res/events.txt");
    }

    /*
    * @pre: nothing
    * @post: converts user data to json and save to file
    * @return: nothing
    */
    public void saveUsers() throws IOException {
        String userJson = gson.toJson(users);

        createFile(userJson, "res/users.txt");
    }
}
