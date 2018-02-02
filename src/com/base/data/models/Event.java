package com.base.data.models;

public class Event
{
  private String m_name;
  private List<User> m_attendees;
  //TODO private List<datetime> validTimes;

  Event(name, date, a list of valid times);

  /*
  @pre: A valid string
  @post: re-assgins the member variable m_name
  @return: none
  */
  public void setName(String name)
  {
    m_name = name;
  }

  /*
  @pre: none
  @post: none
  @return: returns the events name
  */
  public String getName()
  {
    return(m_name);
  }

  


}
