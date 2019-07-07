package com.acabra.gtechdevalgs.google.wheretomove;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Building {

    private final Set<Interest> availableInterests;
    final private String str;

    public Building(List<Interest> availableInterests) {
        this.availableInterests = Collections.unmodifiableSet(new HashSet<>(availableInterests));
        this.str = Building.stringInterests(this.availableInterests);
    }

    private static String stringInterests(Set<Interest> availableInterests) {
        StringBuilder sb = new StringBuilder();
        for (Interest availableInterest : availableInterests) {
            sb.append(availableInterest).append(",");
        }
        return sb.toString();
    }

    public boolean hasInterest(Interest interest) {
        return this.availableInterests.contains(interest);
    }

    public Set<Interest> availableInterests() {
        return availableInterests;
    }

    @Override
    public String toString() {
        return str;
    }

    public int countSharedInterests(List<Interest> interests) {
        int count = 0;
        for (Interest interest : interests) {
            if (availableInterests.contains(interest)) {
                count++;
            }
        }
        return count;
    }
}
