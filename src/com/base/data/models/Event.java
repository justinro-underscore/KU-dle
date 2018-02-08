package com.base.data.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Event
{
  private String m_eventName;
  private String m_creatorName;
  private List<User> m_attendees;
  //TODO: replace with Alex's  Time class
  private LocalDate m_date;
  private List<LocalTime> m_times;

//  Event(name, date, a list of valid times);

  public Event(String eventName, String creatorName, LocalDate date, List<LocalTime> times, List<User> attendees) {
    this.m_eventName = eventName;
    this.m_creatorName = creatorName;
    this.m_attendees = attendees;
    this.m_date = date;
    this.m_times = times;
  }

  /*
    @pre: A valid string
    @post: re-assgins the member variable m_name
    @return: none
    */
  public void setEventName(String eventName)
  {
    m_eventName = eventName;
  }

  /*
  @pre: none
  @post: none
  @return: returns the events name
  */
  public String getEventName()
  {
    return(m_eventName);
  }


  public String getM_creatorName() {
    return m_creatorName;
  }

  public void setM_creatorName(String m_creatorName) {
    this.m_creatorName = m_creatorName;
  }

  public List<User> getM_attendees() {
    return m_attendees;
  }

  public void setM_attendees(List<User> m_attendees) {
    this.m_attendees = m_attendees;
  }
}
