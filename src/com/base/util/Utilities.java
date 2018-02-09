package com.base.util;

import java.time.LocalTime;
import java.util.List;

public class Utilities {
    //TODO: maybe change 20 min to constant - do we want to allow less than 20min meeting times?
    static boolean isTimeValid(LocalTime timeToCompare, List<LocalTime> times) {
        int timeToCompareInMin = timeToCompare.getHour() * 60 + timeToCompare.getMinute();
        int timeFromListInMin = 0;

        for (LocalTime time : times) {
            timeFromListInMin = time.getHour() * 60 + time.getMinute();
            if (Math.abs(timeToCompareInMin - timeFromListInMin) < 20) {
                return false;
            }
        }

        return true;
    }
}
