package com.base.data.models;

import com.base.util.Time;

import java.time.LocalDate;
import java.util.List;

public class Event {
    private String eventName;
    private String creatorName;
    private LocalDate date;
    private List<Time> times;

    /**
     * Creates an event with the specified values
     *
     * @param eventName String representing event name
     * @param creatorName String representing creator name
     * @param date LocalDate representing event's date
     * @param times List of times for event
     * @see LocalDate
     * @see Time
     * @see List
     */
    public Event(String eventName, String creatorName, LocalDate date, List<Time> times) {
        this.eventName = eventName;
        this.creatorName = creatorName;
        this.date = date;
        this.times = times;
    }

    /**
     * Returns the event's name
     *
     * @return the event name
     */
    public String getEventName()
    {
        return(eventName);
    }

    /**
     * Re-assigns the member variable eventName
     *
     * @param eventName String representing the event name
     */
    public void setEventName(String eventName)
    {
        eventName = eventName;
    }

    /**
     * Returns the event creator name
     *
     * @return the creator's name
     */
    public String getCreatorName() {
        return creatorName;
    }

    /**
     * Re-assigns the member variable creatorName
     *
     * @param creatorName String representing event creator's name
     */
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    /**
     * Returns the date of the event
     *
     * @return event date
     * @see LocalDate
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Re-assigns the member variable date
     *
     * @param date A valid LocalDate for event
     * @see LocalDate
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Returns the list of times for the event
     *
     * @return list of Times
     * @see Time
     * @see List
     */
    public List<Time> getTimes() {
        return times;
    }

    /**
     * Re-assigns the member variable times
     *
     * @param times A valid list of times for an event
     * @see Time
     * @see List
     */
    public void setTimes(List<Time> times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return eventName + ", " + creatorName + ", " + date.toString() + ", # of Times: " + times.size();
    }
}
