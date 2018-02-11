package test;

import com.base.data.DairyFarmerClient;
import com.base.data.models.Event;
import com.base.data.models.User;
import com.base.util.Time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

class DairyFarmerClientTest {

    @org.junit.jupiter.api.Test
    void addUser() {
        DairyFarmerClient testClient = new DairyFarmerClient();
        User user = new User("John Appleseed", "boogaloo", false);

        assert testClient.createUser(user.getName(), user.getPassword(), user.getAdmin());
    }

    @org.junit.jupiter.api.Test
    void addMultipleUsers() {
        DairyFarmerClient testClient = new DairyFarmerClient();
        User user1 = new User("John Appleseed", "boogaloo", false);
        User user2 = new User("Justin Lizhouler", "pawrd", false);

        assert testClient.createUser(user1.getName(), user1.getPassword(), user1.getAdmin()) &&
                testClient.createUser(user2.getName(), user2.getPassword(), user2.getAdmin());
    }

    @org.junit.jupiter.api.Test
    void addDuplicateUser() {
        DairyFarmerClient testClient = new DairyFarmerClient();
        User user1 = new User("John Appleseed", "boogaloo", false);
        User user2 = new User("John Appleseed", "boogaloo", false);

        testClient.createUser(user1.getName(), user1.getPassword(), user1.getAdmin());
        assert !(testClient.createUser(user2.getName(), user2.getPassword(), user2.getAdmin()));

    }

    @org.junit.jupiter.api.Test
    void deleteExistingUser() {
        DairyFarmerClient testClient = new DairyFarmerClient();
        User user = new User("John Appleseed", "boogaloo", false);

        testClient.createUser(user.getName(), user.getPassword(), user.getAdmin());
        assert testClient.deleteUser(user.getName());
    }

    @org.junit.jupiter.api.Test
    void deleteNonexistentUser() {
        DairyFarmerClient testClient = new DairyFarmerClient();
        User user = new User("John Appleseed", "boogaloo", false);

        assert !testClient.deleteUser(user.getName());
    }

    @org.junit.jupiter.api.Test
    void createEvent() {
        DairyFarmerClient testClient = new DairyFarmerClient();
        LocalDate date = LocalDate.of(2018, 02, 11);

        List<Time> times = new ArrayList<>();

        LocalTime localTime1 = LocalTime.of(13, 20);
        List<User> attendees1 = new ArrayList<>();

        User user1 = new User("John Appleseed", "boogaloo", false);
        User user2 = new User("Justin Lizhouler", "pawrd", false);
        attendees1.add(user1);
        attendees1.add(user2);

        LocalTime localTime2 = LocalTime.of(13, 40);
        List<User> attendees2 = new ArrayList<>();

        User user3 = new User("Jo", "boogaloo", true);
        User user4 = new User( "Lizhouler", "pawrd", true);
        attendees2.add(user3);
        attendees2.add(user4);

        Time time1 = new Time(localTime1, attendees1);
        Time time2 =  new Time(localTime2, attendees2);

        times.add(time1);
        times.add(time2);

        Event event = new Event("Cookie Party", "Alex Kunz", date, times);

        assert testClient.createEvent(event.getEventName(), event.getCreatorName(), event.getDate(), event.getTimes());
    }

    @org.junit.jupiter.api.Test
    void createDuplicateEvent() {
        DairyFarmerClient testClient = new DairyFarmerClient();
        LocalDate date = LocalDate.of(2018, 02, 11);

        List<Time> times = new ArrayList<>();

        LocalTime localTime1 = LocalTime.of(13, 20);
        List<User> attendees = new ArrayList<>();

        User user = new User("John Appleseed", "boogaloo", false);
        attendees.add(user);

        Time time = new Time(localTime1, attendees);

        times.add(time);

        Event event1 = new Event("Cookie Party", "Alex Kunz", date, times);
        Event event2 = new Event("Cookie Party", "Joe Barns", date, times);

        testClient.createEvent(event1.getEventName(), event1.getCreatorName(), event1.getDate(), event1.getTimes());

        //TODO: do we want clientClass to check if duplicate event or is that in UI?
//        assert !testClient.createEvent(event2.getEventName(), event2.getCreatorName(), event2.getDate(), event2.getTimes());
    }

    @org.junit.jupiter.api.Test
    void deleteEvent() {
        //TODO: do we want clientClass to check if event exists or is that in UI?
    }

    @org.junit.jupiter.api.Test
    void deleteNonexistentEvent() {
    }
}