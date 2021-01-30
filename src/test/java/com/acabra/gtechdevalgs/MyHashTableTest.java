package com.acabra.gtechdevalgs;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

/**
 * Describe your class
 */
public class MyHashTableTest {

    @Test
    public void test_api_01() {
        MyHashTable h = new MyHashTable();

        TestUtils.iAssertTrue(h.put("key","value"));
        MatcherAssert.assertThat("value", Is.is(h.get("key")));

        TestUtils.iAssertFalse(h.put("key","value1"));
        MatcherAssert.assertThat("value1", Is.is(h.get("key")));

        TestUtils.iAssertTrue(h.put("key2","value2"));
        MatcherAssert.assertThat("value2", Is.is(h.get("key2")));
    }
}
