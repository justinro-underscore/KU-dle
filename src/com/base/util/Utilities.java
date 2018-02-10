package com.base.util;

import com.base.data.models.User;

import java.util.HashMap;
import java.util.List;

public class Utilities {
    //TODO: maybe change 20 min to constant - do we want to allow less than 20min meeting times?
    /*
    * @pre: Takes in a time and list of times to compare to
    * @post: nothing
    * @return: true if time is valid (does not overlap with other times) else false
     */
    static boolean isTimeValid(Time timeToCompare, List<Time> times) {
        int timeToCompareInMin = timeToCompare.getTime().getHour() * 60 + timeToCompare.getTime().getMinute();
        int timeFromListInMin = 0;

        for (Time time : times) {
            timeFromListInMin = time.getTime().getHour() * 60 + time.getTime().getMinute();
            if (Math.abs(timeToCompareInMin - timeFromListInMin) < 20) {
                return false;
            }
        }

        return true;
    }

    /**
     * Signify if the username is taken or not
     * @param existingUsers a hashmap of existing users with taken usernames
     * @param username the username the user wants to use with their new account
     * @return true if the username is not taken
     */
    static boolean userExists(HashMap<String, User> existingUsers, String username) {
        return (existingUsers.containsKey(username));
    }
}