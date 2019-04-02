package com.acabra.gtechdevalgs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Implementation of HashTable
 */
public class MyHashTable {

    private static class Entry {
        public final String key;
        public final String value;
        public Entry(String k, String v) {
            this.key = k;
            this.value = v;
        }
    }

    private int INIT_SIZE = 100;
    List<List<Entry>> buckets = new ArrayList<>(INIT_SIZE);

    public MyHashTable() {
        for(int i =0; i< INIT_SIZE; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    public boolean put(String key, String value) {
        if(null == key) throw new NullPointerException("keys must be not null");
        int hashCode = getBucketPos(key);
        return attemptAdd(buckets.get(hashCode), new Entry(key, value));
    }

    private boolean attemptAdd(List<Entry> bucket, Entry newEntry) {
        if (get(newEntry.key) == null) {
            bucket.add(newEntry);
            return true;
        }
        Iterator<Entry> iterator = bucket.iterator();
        while (iterator.hasNext()) {
            if(iterator.next().key.compareTo(newEntry.key) == 0) {
                iterator.remove();
                break;
            }
        }
        bucket.add(newEntry);
        return false;
    }

    public String get(String key) {
        if(null == key) throw new NullPointerException("keys must be not null");
        int hashCode = getBucketPos(key);
        List<Entry> bucketContents = buckets.get(hashCode);
        if (bucketContents != null) {
            for (Entry entry: bucketContents) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    private int getBucketPos(String key){
        return key.hashCode() % INIT_SIZE;
    }
}

