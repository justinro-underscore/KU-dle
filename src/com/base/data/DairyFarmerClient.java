package com.base.data;

import com.base.data.interfaces.Events;
import com.base.data.models.Event;
import com.base.data.models.User;
import com.google.gson.Gson;

import java.io.*;
import java.util.List;

//TODO: add tests
//TODO: Validate input (no duplicate named events on same day?)
public class DairyFarmerClient {
    private Gson gson;
    private FileWriter writer;
    private BufferedReader reader;

    public DairyFarmerClient() {
        gson = new Gson();
    }

    //TODO: change to pass in date object?
    //TODO: Use fileUtil library?
    public List<Event> getEvents(String date) throws IOException {
        reader = new BufferedReader(new FileReader("res/events/" + date + ".txt"));

        String json = reader.readLine();
        Events events = gson.fromJson(json, Events.class);

        return events.getEvents();
    }

    public void createEvent(String eventName, String creatorName, List<User> attendees) {
        //TODO: add date time obj
        //TODO: maybe add to list -> have list of events for each day
        Event event = new Event(eventName, creatorName, attendees);
        String eventJson = gson.toJson(event);
    }

    public void deleteEvent() {

    }

    //TODO: what to do with users (store data in res/users/)

    //TODO: create file writer
    //TODO: change file name to date (requires from createEvent)
    public void createFile(String json, String fileName) throws IOException {
        writer = new FileWriter("res/events/" + fileName + ".txt");
        writer.write(json);
        writer.close();
    }
}
