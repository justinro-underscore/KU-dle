package com.base.util;

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

    //TODO: fix this lol
    static boolean userExists() {
        return false;
    }
}