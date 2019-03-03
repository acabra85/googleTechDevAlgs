package com.acabra.gtechdevalgs.litcode;

import org.junit.Assert;
import org.junit.Test;

public class MyCalendarTwoTest {

    @Test
    public void test_1() {
        MyCalendarTwo myCalendar2 = new MyCalendarTwo();
        Assert.assertTrue(myCalendar2.book(10, 20)); // returns true
        Assert.assertTrue(myCalendar2.book(50, 60)); // returns true
        Assert.assertTrue(myCalendar2.book(10, 40)); // returns true
        Assert.assertFalse(myCalendar2.book(5, 15)); // returns false
        Assert.assertTrue(myCalendar2.book(5, 10)); // returns true
        Assert.assertTrue(myCalendar2.book(25, 55)); // returns true
    }

    @Test
    public void test_2() {
        MyCalendarTwo myCalendar = new MyCalendarTwo();
        Assert.assertTrue(myCalendar.book(6, 9));
        Assert.assertTrue(myCalendar.book(6, 9));
        Assert.assertFalse(myCalendar.book(6, 9));
        Assert.assertFalse(myCalendar.book(6, 7));
        Assert.assertFalse(myCalendar.book(8, 9));
        Assert.assertTrue(myCalendar.book(4, 6));
    }

    @Test
    public void case_1_test_3() {
        MyCalendarTwo myCalendar = new MyCalendarTwo();
        Assert.assertTrue(myCalendar.book(6, 9));
        Assert.assertTrue(myCalendar.book(10, 13));
        Assert.assertTrue(myCalendar.book(5, 12));
        Assert.assertFalse(myCalendar.book(11, 15));
        Assert.assertFalse(myCalendar.book(6, 9));
        Assert.assertFalse(myCalendar.book(10, 12));
        Assert.assertTrue(myCalendar.book(9, 10));
        Assert.assertFalse(myCalendar.book(9, 10));
        Assert.assertTrue(myCalendar.book(5, 6));
        Assert.assertFalse(myCalendar.book(5, 6));
        Assert.assertTrue(myCalendar.book(12, 13));
        Assert.assertFalse(myCalendar.book(12, 13));

    }

    @Test
    public void case_2_test_4() {
        MyCalendarTwo myCalendar = new MyCalendarTwo();
        Assert.assertTrue(myCalendar.book(6, 9));
        Assert.assertTrue(myCalendar.book(10, 13));
        Assert.assertTrue(myCalendar.book(12, 15));
        Assert.assertTrue(myCalendar.book(2, 5));
        Assert.assertTrue(myCalendar.book(1, 10));
        Assert.assertFalse(myCalendar.book(4, 6));
        Assert.assertTrue(myCalendar.book(1, 2));
        Assert.assertFalse(myCalendar.book(1, 2));
        Assert.assertTrue(myCalendar.book(5,6));
        Assert.assertFalse(myCalendar.book(5,6));
        Assert.assertTrue(myCalendar.book(9,12));
        Assert.assertFalse(myCalendar.book(9, 12));
        Assert.assertFalse(myCalendar.book(12, 13));
        Assert.assertTrue(myCalendar.book(13,15));
        Assert.assertFalse(myCalendar.book(13, 15));
    }

    @Test
    public void case_3_test_5() {
        MyCalendarTwo myCalendar = new MyCalendarTwo();
        Assert.assertTrue(myCalendar.book(6, 9));
        Assert.assertTrue(myCalendar.book(10, 13));
        Assert.assertTrue(myCalendar.book(7, 11));
        Assert.assertFalse(myCalendar.book(8, 10));
    }

    @Test
    public void case_4_test_6() {
        MyCalendarTwo myCalendar = new MyCalendarTwo();
        Assert.assertTrue(myCalendar.book(6, 9));
        Assert.assertTrue(myCalendar.book(10, 13));
        Assert.assertTrue(myCalendar.book(7, 14));
        Assert.assertFalse(myCalendar.book(5, 8));
        Assert.assertFalse(myCalendar.book(10, 12));
}
}
