package com.acabra.gtechdevalgs.litcode;

import java.util.ArrayList;
import java.util.List;

class MyCalendarTwo {

    private List<Event> events = new ArrayList<>();
    private List<Event> overBookings = new ArrayList<>();

    public boolean book(int start, int end) {
        if (start < 0 || start > end) throw new IllegalArgumentException("invalid event start:" + start + " greater than end:" + end);
        Event iEvent = Event.of(start, end);
        for (Event overBooked : overBookings) { //review 3-overBooking
            if(overBooked.intersects(iEvent)) {
                return false;
            }
        }
        for (Event event : events) {
            if (event.intersects(iEvent)) {
                overBookings.add(Event.of(Math.max(event.start, iEvent.start), Math.min(event.end, iEvent.end)));
            }
        }
        this.events.add(iEvent);
        return true;
    }

    private static class Event {
        final int start;
        final int end;

        private Event(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public static Event of(int start, int end) {
            if(start == end) throw new IllegalArgumentException("Events must last at least 1 unit");
            return new Event(start, end);
        }

        public boolean intersects(Event iEvent) {
            return start < iEvent.end && end > iEvent.start;
        }

        @Override
        public String toString() {
            return "{" + start + "->" + end + '}';
        }
    }
}
