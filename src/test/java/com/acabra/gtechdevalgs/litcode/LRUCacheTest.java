package com.acabra.gtechdevalgs.litcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

public class LRUCacheTest {

    @Test
    public void test_1() {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        MatcherAssert.assertThat(1, Is.is(cache.get(1)));       // returns 1
        cache.put(3, 3);    // evicts key 2
        MatcherAssert.assertThat(-1, Is.is(cache.get(2)));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        MatcherAssert.assertThat(-1, Is.is(cache.get(1)));       // returns -1 (not found)
        MatcherAssert.assertThat(3, Is.is(cache.get(3)));       // returns 3
        MatcherAssert.assertThat(4, Is.is(cache.get(4)));       // returns 4
    }

    @Test
    public void test_2() {
        /**
         *["LRUCache","put","put","put","put","get","get"]
         * [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
         */
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        MatcherAssert.assertThat(-1, Is.is(cache.get(1)));       // returns 1
        MatcherAssert.assertThat(3, Is.is(cache.get(2)));       // returns -1 (not found)
    }
}
