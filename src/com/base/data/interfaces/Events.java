package com.base.data.interfaces;

import com.base.data.models.Event;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class Events {
    private HashMap<LocalDate, List<Event>> events;

    public Events(HashMap<LocalDate, List<Event>> events) {
        this.events = events;
    }

    public HashMap<LocalDate, List<Event>> getEvents() {
        return events;
    }

    public void setEvents(HashMap<LocalDate, List<Event>> events) {
        this.events = events;
    }
}