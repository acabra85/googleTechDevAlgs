package com.acabra.gtechdevalgs.litcode;

import java.util.*;

class LRUCache {

    private final int capacity;
    private final Map<Integer, CacheValue> cache;
    private final boolean blocked;
    private final CacheValue head;
    private final CacheValue tail;

    public LRUCache(int capacity) {
        this.blocked = capacity <= 0;
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);

        this.head = new CacheValue(-1, -1);
        this.tail = new CacheValue(-1, -1);

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void put(int key, int value) {
        if (blocked) return;
        CacheValue cache = this.cache.get(key);
        if (null == cache) {
            evictLRU();
        } else {
            remove(cache);
        }

        CacheValue iCache = new CacheValue(key, value);
        this.cache.put(key, iCache);
        addToTail(iCache);
    }

    private void addToTail(CacheValue iCache) {
        CacheValue prev = tail.prev;
        prev.next = iCache;
        tail.prev = iCache;
        iCache.next = tail;
        iCache.prev = prev;

    }

    private void remove(CacheValue remove) {
        remove.next.prev = remove.prev;
        remove.prev.next = remove.next;
    }

    private void evictLRU() {
        if (this.capacity == this.cache.size()) { //evict
            Integer lru = this.head.next.key;
            if (null != lru) {
                this.cache.remove(lru);
                removeFromHead();
            }
        }
    }

    private void removeFromHead() {
        remove(this.head.next);
    }

    public int get(int key) {
        if (blocked) return - 1;
        CacheValue val = this.cache.get(key);
        if (null == val) return -1;
        remove(val);
        addToTail(val);
        return val.value;
    }

    private class CacheValue {
        final int value;
        final Integer key;
        CacheValue next = null;
        CacheValue prev = null;

        CacheValue(Integer key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CacheValue that = (CacheValue) o;
            return value == that.value &&
                    Objects.equals(key, that.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, key);
        }

    }
}
