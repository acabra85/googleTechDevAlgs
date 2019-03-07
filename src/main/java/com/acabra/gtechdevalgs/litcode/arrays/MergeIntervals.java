package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.*;

public class MergeIntervals {


    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null) throw new NullPointerException("intervals is null");
        if (intervals.isEmpty()) return Collections.EMPTY_LIST;
        PriorityQueue<Interval> pq = new PriorityQueue<>(Comparator.comparingInt(a->a.start));
        for (Interval interval: intervals) {
            pq.offer(interval);
        }
        LinkedList<Interval> merged = new LinkedList<>();
        while(pq.size()>0) {
            if (merged.isEmpty() || merged.getLast().end < pq.peek().start) {
                merged.addLast(pq.remove());
            } else {
                merged.getLast().end = Math.max(merged.getLast().end, pq.remove().end);
            }
        }
        return merged;
    }

    public static class Interval {

        final int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return start + "=>" + end;
        }
    }
}
