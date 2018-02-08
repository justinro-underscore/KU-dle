package com.base.data;

import com.base.data.DairyFarmerClient;

/*
  Contains a ton of test cases to make sure the functionality of the
  DairyFarmerClient works.
  //TODO represents ideas of what to test
*/
public class TestClient
{
  private DairyFarmerClient tester;

  public boolean testAddUser()
  {
    //TODO add new user; add user that already exists.
    return(false);
  }

  public boolean testDeleteUser()
  {
    //TODO delete current user; delete user that doesnt exist
    return(false);
  }

  public boolean testEditUser()
  {
    //TODO I dont know if we need to edit users but: edit username, admin status, password?
    return(false);
  }

  public boolean testAddEvent()
  {
    //TODO add new event, add event with identical name
    return(false);
  }

  public boolean testRemoveEvent()
  {
    //TODO delete current event (will it delete everything if we allow identical names??)
    //TODO delete event that doesnt exist
    return(false);
  }

  public boolean testEditEvent()
  {
    //TODO edit current event time/people going/date (will it change everything if we allow identical names??)
    //TODO edit event that doesnt exist
    return(false);
  }
  //https://github.com/justinro-underscore/KU-dle.git
  public boolean testAdminStatus()
  {
    //TODO can admins actually do admin things?
    //TODO can normal user do admin things?
    return(false);
  }

  public int testScore()
  {
    int totalScore = 0;

    //TODO make a scoring guide for these test cases;
    //if true increment score by 1 maybe?

    testAddUser();
    testDeleteUser();
    testEditUser();
    testAddEvent();
    testRemoveEvent();
    testEditEvent();
    testAdminStatus();

    return(totalScore);
  }
}
