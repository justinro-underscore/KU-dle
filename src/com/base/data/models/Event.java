package com.base.data.models;

import com.base.util.Time;

import java.time.LocalDate;
import java.util.List;

public class Event
{
  private String eventName;
  private String creatorName;
  private LocalDate date;
  private List<Time> times;

  /*
  @pre: String representing eventName, creator name, date, and a list of times
  @post: assign local variables to passed in values
  @return: none
  */
  public Event(String eventName, String creatorName, LocalDate date, List<Time> times) {
    this.eventName = eventName;
    this.creatorName = creatorName;
    this.date = date;
    this.times = times;
  }

/*
  @pre: A valid string
  @post: re-assgins the member variable m_name
  @return: none
  */
  public void setEventName(String eventName)
  {
    eventName = eventName;
  }

  /*
  @pre: none
  @post: none
  @return: returns the events name
  */
  public String getEventName()
  {
    return(eventName);
  }

  public String getCreatorName() {
    return creatorName;
  }

  public void setCreatorName(String creatorName) {
    this.creatorName = creatorName;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public List<Time> getTimes() {
    return times;
  }

  public void setTimes(List<Time> times) {
    this.times = times;
  }
}
