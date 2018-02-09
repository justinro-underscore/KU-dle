package com.base.data.interfaces;

import com.base.data.models.Event;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class Events {
    private HashMap<LocalDate, List<Event>> events;

    /*
    * @pre: Takes in a hashmap of events with date as key
    * @post: assign local variable to passed in value
    * @return: nothing
     */
    public Events(HashMap<LocalDate, List<Event>> events) {
        this.events = events;
    }

    /*
    * @pre: nothing
    * @post: nothing
    * @return: events
     */
    public HashMap<LocalDate, List<Event>> getEvents() {
        return events;
    }

    /*
    * @pre: takes in a hashmap of events with date as key
    * @post: re-assigns the member variable events
    * @return: nothing
     */
    public void setEvents(HashMap<LocalDate, List<Event>> events) {
        this.events = events;
    }
}