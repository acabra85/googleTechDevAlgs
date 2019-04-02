package com.acabra.gtechdevalgs;

import org.junit.Assert;
import org.junit.Test;

/**
 * Describe your class
 */
public class MyHashTableTest {

    @Test
    public void test_api_01() {
        MyHashTable h = new MyHashTable();

        Assert.assertTrue(h.put("key","value"));
        Assert.assertEquals("value", h.get("key"));

        Assert.assertFalse(h.put("key","value1"));
        Assert.assertEquals("value1", h.get("key"));

        Assert.assertTrue(h.put("key2","value2"));
        Assert.assertEquals("value2", h.get("key2"));
    }
}
