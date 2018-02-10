package com.base.data;

import com.base.data.DairyFarmerClient;
import com.base.data.models.User;
import com.base.util.Time;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/*
  Contains a ton of test cases to make sure the functionality of the
  DairyFarmerClient works.
  //TODO represents ideas of what to test
*/
public class TestClient
{
  private DairyFarmerClient tester;

  public TestClient(){
    tester = new DairyFarmerClient();
    try {
      tester.initUsers();
    } catch (IOException e) {
      e.printStackTrace();
    }

    try {
      tester.initEvents();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

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
    //TODO make this function in util so that we remember to change key if we change username
//    User temp = tester.getUser("Leon Kline");
//    String name = "Not Leon";
//    temp.setName(name);
//    tester.getUsers().put(name, temp);
//    tester.getUsers().remove("Leon Kline");
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
    List<User> attendees = new ArrayList<>();
    User user = new User("Justin", "ELECTRIC BUGALOO", false);
    attendees.add(user);
    LocalDate date = LocalDate.of(1, 1, 1);
    List<Time> times = new ArrayList<>();
    LocalTime localTime = LocalTime.of(1, 1);
    Time time = new Time(localTime, attendees);
    times.add(time);

    tester.createUser(user.getName(), user.getPassword(), user.getAdmin());
    User user2 = new User("Leon Kline", "ELECTRIC BUGALOO", false);
    tester.createUser(user2.getName(), user2.getPassword(), user2.getAdmin());
    tester.createEvent("EVENT NAME", "CREATOR NAME", date, times);
    tester.createEvent("EVENT NAME2", "CREATOR NAME2", date, times);
    try {
      if(tester.deleteEvent(date, "EVENT NAME") == true){
        System.out.println("delete event works!");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
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

    try {
      tester.saveEvents();
    } catch (IOException e) {
      e.printStackTrace();
    }

    try {
      tester.saveUsers();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return(totalScore);
  }
}
