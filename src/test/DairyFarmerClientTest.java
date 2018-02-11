package test;

import com.base.data.DairyFarmerClient;
import com.base.data.models.User;

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
    }

    @org.junit.jupiter.api.Test
    void deleteEvent() {
    }
}