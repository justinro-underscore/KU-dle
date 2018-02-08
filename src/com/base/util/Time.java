package com.base.util;

import com.base.data.models.User;

import java.time.LocalTime;
import java.util.List;

public class Time {
    private LocalTime time;
    private List<User> atendees;

    public Time(LocalTime time, List<User> atendees){
        this.time = time;
        this.atendees = atendees;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public List<User> getAtendees() {
        return atendees;
    }

    public void setAtendees(List<User> atendees) {
        this.atendees = atendees;
    }
}
