package com.acabra.gtechdevalgs.litcode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

class MyCalendar {

    TreeMap<Integer, Event> eventsStart = new TreeMap<>();
    TreeMap<Integer, Event> eventsEnd = new TreeMap<>();
    Set<Event> events = new HashSet<>();

    public boolean book(int start, int end) {
        if (end < start) return false;
        Event iEvent = new Event(start, end);
        if(events.contains(iEvent)) return false;
        if (null != eventsStart.get(iEvent.start)) return false;
        if (null != eventsEnd.get(iEvent.end)) return false;
        for (Event event : events) {
            if (iEvent.conflictsWith(event)) {
                return false;
            }
        }
        events.add(iEvent);
        eventsStart.put(iEvent.start, iEvent);
        eventsEnd.put(iEvent.end, iEvent);
        return true;
    }


    private class Event {
        final int start;
        final int end;

        private Event(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Event event = (Event) o;
            return start == event.start &&
                    end == event.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }


        @Override
        public String toString() {
            return "Event{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        public boolean conflictsWith(Event event) {
            return left(event) || contained(event) || right(event);
        }

        private boolean left(Event event) {
            return end > event.start && end < event.end;
        }

        private boolean contained(Event event) {
            return start > event.start && end < event.end;
        }

        private boolean right(Event event) {
            return start < event.end && end > event.end;
        }
    }
}
