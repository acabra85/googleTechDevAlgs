package com.acabra.gtechdevalgs.litcode;

import org.junit.Assert;
import org.junit.Test;

public class MyCalendarTest {

    @Test
    public void test_1() {
        MyCalendar myCalendar = new MyCalendar();
        Assert.assertTrue(myCalendar.book(10, 20)); // returns true
        Assert.assertFalse(myCalendar.book(15, 25)); // returns false
        Assert.assertTrue(myCalendar.book(20, 30)); // returns true
    }
    @Test
    public void test_2() {
        MyCalendar myCalendar = new MyCalendar();
        Assert.assertTrue(myCalendar.book(6, 9));
        Assert.assertTrue(myCalendar.book(1, 4));
        Assert.assertFalse(myCalendar.book(7, 8));
        Assert.assertFalse(myCalendar.book(8, 10));
        Assert.assertTrue(myCalendar.book(9, 11));
        Assert.assertFalse(myCalendar.book(2, 5));
        Assert.assertFalse(myCalendar.book(2, 5));
        Assert.assertFalse(myCalendar.book(0, 3));
    }
}
