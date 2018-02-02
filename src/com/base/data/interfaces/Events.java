package com.base.data.interfaces;

import com.base.data.models.Event;

import java.util.List;

public class Events {
    private List<Event> events;

    public Events(List<Event> events) {
        this.events = events;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}