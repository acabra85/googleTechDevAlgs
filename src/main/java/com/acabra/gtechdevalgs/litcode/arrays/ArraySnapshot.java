package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class ArraySnapshot {
    final private Items[] snaps;
    private int snap_id = 0;

    public ArraySnapshot(int length) {
        this.snaps = new Items[length];
        for(int i=0; i< length; ++i) {
            this.snaps[i] = new Items();
        }
    }

    public void set(int index, int val) {
        this.snaps[index].set(val, this.snap_id);
    }

    public int snap() {
        ++this.snap_id;
        return this.snap_id - 1;
    }

    public int get(int index, int snap_id) {
        return this.snaps[index].largestSnapLessThan(snap_id);
    }

    static class Items {
        final private List<Entry> entries;
        private int lastId;
        Items() {
            this.entries = new ArrayList<Entry>();
            lastId = -1;
            ++this.lastId;
            this.entries.add(Entry.of(0, 0));
        }

        private int largestSnapLessThan(int snap_id) {
            return this.binarySearch(0, this.lastId, snap_id, this.entries.getFirst());
        }

        private void set(int val, int snapId) {
            Entry last = this.entries.getLast();
            if (last.snap != snapId) {
                ++this.lastId;
                this.entries.add(Entry.of(snapId, val));
            } else {
                last.val = val;
            }
        }

        private int binarySearch(int lo, int hi, int target, Entry best) {
            int mid = lo + (hi - lo ) / 2;
            Entry entry;
            while(lo <= hi) {
                entry = this.entries.get(mid);
                if (entry.snap == target) {
                    return entry.val;
                }
                if (entry.snap < target && entry.snap > best.snap) {
                    best = entry;
                }
                if (entry.snap > target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
                mid = lo + (hi - lo ) / 2;
            }
            return best.val;
        }
    }

    static class Entry {
        int val, snap;
        Entry(int val, int snap) {
            this.val = val;
            this.snap = snap;
        }
        static Entry of(int snap, int val) {
            return new Entry(val, snap);
        }
    }
}