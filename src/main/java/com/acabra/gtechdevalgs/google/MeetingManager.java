package com.acabra.gtechdevalgs.google;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;

/**
 * This class allows a method to
 */
public class MeetingManager {

    public static void main(String [] args) {
        // you can write to stdout for debugging purposes, e.g.
        System.out.println("This is a debug message");
    }

    int START_WORKING_DAY = 9;
    int END_WORKING_DAY = 17;

    public static class Interval implements Comparable<Interval> {
        final int start;
        final int end;
        final int duration;
        final String asString;

        /**
         * s < e
         */
        Interval(int s, int e) {
            this.start = s;
            this.end = e;
            this.asString = s + "" + e;
            this.duration = e - s;
        }

        public int hashcode(){
            return Objects.hash(start, end);
        }

        public boolean equals(Object other) {
            if (other!=null && (other.getClass().equals(Interval.class))) {
                Interval o = (Interval) other;
                return this.start == o.start && this.end == o.end;
            }
            return false;
        }

        @Override
        public int compareTo(Interval o) {
            return this.start - o.start;
        }
    }

    /**
     *
     * @param userMeetings meetings of each user as intervals
     * @param durationMinutes desired meeting length in minutes
     * @param attendanceTarget number between 0 and 100
     * @return an interval list where the attendanceTarget can be part of the meeting
     */
    public List<Interval> findAvailability(Map<String, List<Interval>> userMeetings, int durationMinutes, double attendanceTarget) {
        Map<Interval, LongAdder> frequency = new HashMap<>();
        final int totalParticipants = userMeetings.keySet().size();
        final int totalTargetParticipants = Double.valueOf(Math.floor(totalParticipants * attendanceTarget)).intValue();

        for(Map.Entry<String, List<Interval>> entry: userMeetings.entrySet()) {
            getAvailabilityUser(entry.getValue(), frequency);
        }
        return frequency.entrySet().stream()
                .filter(entry -> entry.getValue().intValue() >= totalTargetParticipants
                            && entry.getKey().duration >= durationMinutes
                )
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private void getAvailabilityUser(List<Interval> meetings, Map<Interval, LongAdder> frequency) {
        int prevStart = START_WORKING_DAY;
        Interval newAvailable = null;
        for(Interval meeting: meetings) {
            int start = meeting.start;
            if (prevStart < start) {
                newAvailable = new Interval(prevStart, start);
                frequency.computeIfAbsent(newAvailable, x -> new LongAdder()).increment();
            }
            prevStart = meeting.end;
        }
        if (prevStart < END_WORKING_DAY) {
            newAvailable = new Interval(prevStart, END_WORKING_DAY);
            frequency.computeIfAbsent(newAvailable, x->new LongAdder()).increment();
        }
    }

}

