package com.acabra.gtechdevalgs.litcode;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class ClosestTime {

    public String closestTime(String time) {
        LocalTime localTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
        Set<Character> valid = getValidUnits(time);
        while(true) {
            localTime = localTime.plusMinutes(1);
            if (valid(localTime.toString(), valid)) {
                return localTime.toString();
            }
        }
    }

    private boolean valid(String time, Set<Character> valid) {
        for (int i = 0; i < time.length(); i++) {
            if (!valid.contains(time.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private Set<Character> getValidUnits(String time) {
        Set<Character> valid = new HashSet<>();
        for (int i = 0; i < time.length(); i++) {
            valid.add(time.charAt(i));
        }
        return valid;
    }
}
