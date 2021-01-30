package com.acabra.gtechdevalgs.litcode;

import com.acabra.gtechdevalgs.TestUtils;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

public class MyCalendarTest {

    @Test
    public void test_1() {
        MyCalendar myCalendar = new MyCalendar();
        TestUtils.iAssertTrue(myCalendar.book(10, 20)); // returns true
        TestUtils.iAssertFalse(myCalendar.book(15, 25)); // returns false
        TestUtils.iAssertTrue(myCalendar.book(20, 30)); // returns true
    }
    @Test
    public void test_2() {
        MyCalendar myCalendar = new MyCalendar();
        TestUtils.iAssertTrue(myCalendar.book(6, 9));
        TestUtils.iAssertTrue(myCalendar.book(1, 4));
        TestUtils.iAssertFalse(myCalendar.book(7, 8));
        TestUtils.iAssertFalse(myCalendar.book(8, 10));
        TestUtils.iAssertTrue(myCalendar.book(9, 11));
        TestUtils.iAssertFalse(myCalendar.book(2, 5));
        TestUtils.iAssertFalse(myCalendar.book(2, 5));
        TestUtils.iAssertFalse(myCalendar.book(0, 3));
    }
}
