package com.base.data.interfaces;

import com.base.data.models.Event;

import java.util.HashMap;

public class Events {
    private HashMap<String, Event> events;

    public Events(HashMap<String, Event> events) {
        this.events = events;
    }

    public HashMap<String, Event> getEvents() {
        return events;
    }

    public void setEvents(HashMap<String, Event> events) {
        this.events = events;
    }
}