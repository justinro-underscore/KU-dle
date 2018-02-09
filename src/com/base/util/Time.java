package com.base.util;

import com.base.data.models.User;

import java.time.LocalTime;
import java.util.List;

public class Time {
    private LocalTime time;
    private List<User> attendees;

    /*
    * @pre: Takes in a time and list of users
    * @post: assign local variables to passed in values
    * @return: nothing
     */
    public Time(LocalTime time, List<User> attendees){
        this.time = time;
        this.attendees = attendees;
    }

    /*
    * @pre: nothing
    * @post: nothing
    * @return: time
     */
    public LocalTime getTime() {
        return time;
    }

    /*
    * @pre: takes in a time
    * @post: re-assigns the member variable time
    * @return: nothing
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }

    /*
    * @pre: nothing
    * @post: nothing
    * @return: list of users
     */
    public List<User> getAttendees() {
        return attendees;
    }

    /*
    * @pre: takes in a list of users
    * @post: re-assigns the member variable attendees
    * @return: nothing
     */
    public void setAttendees(List<User> attendees) {
        this.attendees = attendees;
    }
}
