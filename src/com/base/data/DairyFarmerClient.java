package com.base.data;

import com.base.data.models.Event;
import com.base.data.models.User;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

//TODO: add tests
public class DairyFarmerClient {
    private Gson gson;
    private FileWriter writer;

    public DairyFarmerClient() {
        gson = new Gson();
    }

    public List<Event> getEvents() {
        return null;
    }

    public void createEvent(String eventName, String creatorName, List<User> attendees) {
        //TODO: add date time obj
        //TODO: maybe add to list -> have list of events for each day
        Event event = new Event(eventName, creatorName, attendees);
        String eventJson = gson.toJson(event);
    }

    public void deleteEvent() {

    }

    //TODO: create file writer
    public void createFile(String json, String fileName) throws IOException {
        writer = new FileWriter(fileName);
        writer.write(json);
        writer.close();
    }
}
