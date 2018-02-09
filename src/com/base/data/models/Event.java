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
  * @pre: String representing eventName, creator name, date, and a list of times
  * @post: assign local variables to passed in values
  * @return: none
   */
  public Event(String eventName, String creatorName, LocalDate date, List<Time> times) {
    this.eventName = eventName;
    this.creatorName = creatorName;
    this.date = date;
    this.times = times;
  }

  /*
  * @pre: none
  * @post: none
  * @return: returns the events name
   */
  public String getEventName()
  {
    return(eventName);
  }

  /*
  * @pre: A valid string
  * @post: re-assgins the member variable eventName
  * @return: none
   */
  public void setEventName(String eventName)
  {
    eventName = eventName;
  }

  /*
  * @pre: none
  * @post: none
  * @return: returns the event creator name
   */
  public String getCreatorName() {
    return creatorName;
  }

  /*
  * @pre: A valid string
  * @post: re-assgins the member variable creatorName
  * @return: none
   */
  public void setCreatorName(String creatorName) {
    this.creatorName = creatorName;
  }

  /*
  * @pre: none
  * @post: none
  * @return: returns the date of the event
   */
  public LocalDate getDate() {
    return date;
  }

  /*
  * @pre: A valid date
  * @post: re-assgins the member variable date
  * @return: none
   */
  public void setDate(LocalDate date) {
    this.date = date;
  }

  /*
  * @pre: none
  * @post: none
  * @return: returns the list of times for the event
   */
  public List<Time> getTimes() {
    return times;
  }

  /*
  * @pre: A valid list of times
  * @post: re-assgins the member variable times
  * @return: none
   */
  public void setTimes(List<Time> times) {
    this.times = times;
  }
}
