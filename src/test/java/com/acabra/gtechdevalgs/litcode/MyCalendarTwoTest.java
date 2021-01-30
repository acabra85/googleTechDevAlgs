package com.acabra.gtechdevalgs.litcode;

import com.acabra.gtechdevalgs.TestUtils;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

public class MyCalendarTwoTest {

    @Test
    public void test_1() {
        MyCalendarTwo myCalendar2 = new MyCalendarTwo();
        TestUtils.iAssertTrue(myCalendar2.book(10, 20)); // returns true
        TestUtils.iAssertTrue(myCalendar2.book(50, 60)); // returns true
        TestUtils.iAssertTrue(myCalendar2.book(10, 40)); // returns true
        TestUtils.iAssertFalse(myCalendar2.book(5, 15)); // returns false
        TestUtils.iAssertTrue(myCalendar2.book(5, 10)); // returns true
        TestUtils.iAssertTrue(myCalendar2.book(25, 55)); // returns true
    }

    @Test
    public void test_2() {
        MyCalendarTwo myCalendar = new MyCalendarTwo();
        TestUtils.iAssertTrue(myCalendar.book(6, 9));
        TestUtils.iAssertTrue(myCalendar.book(6, 9));
        TestUtils.iAssertFalse(myCalendar.book(6, 9));
        TestUtils.iAssertFalse(myCalendar.book(6, 7));
        TestUtils.iAssertFalse(myCalendar.book(8, 9));
        TestUtils.iAssertTrue(myCalendar.book(4, 6));
    }

    @Test
    public void case_1_test_3() {
        MyCalendarTwo myCalendar = new MyCalendarTwo();
        TestUtils.iAssertTrue(myCalendar.book(6, 9));
        TestUtils.iAssertTrue(myCalendar.book(10, 13));
        TestUtils.iAssertTrue(myCalendar.book(5, 12));
        TestUtils.iAssertFalse(myCalendar.book(11, 15));
        TestUtils.iAssertFalse(myCalendar.book(6, 9));
        TestUtils.iAssertFalse(myCalendar.book(10, 12));
        TestUtils.iAssertTrue(myCalendar.book(9, 10));
        TestUtils.iAssertFalse(myCalendar.book(9, 10));
        TestUtils.iAssertTrue(myCalendar.book(5, 6));
        TestUtils.iAssertFalse(myCalendar.book(5, 6));
        TestUtils.iAssertTrue(myCalendar.book(12, 13));
        TestUtils.iAssertFalse(myCalendar.book(12, 13));

    }

    @Test
    public void case_2_test_4() {
        MyCalendarTwo myCalendar = new MyCalendarTwo();
        TestUtils.iAssertTrue(myCalendar.book(6, 9));
        TestUtils.iAssertTrue(myCalendar.book(10, 13));
        TestUtils.iAssertTrue(myCalendar.book(12, 15));
        TestUtils.iAssertTrue(myCalendar.book(2, 5));
        TestUtils.iAssertTrue(myCalendar.book(1, 10));
        TestUtils.iAssertFalse(myCalendar.book(4, 6));
        TestUtils.iAssertTrue(myCalendar.book(1, 2));
        TestUtils.iAssertFalse(myCalendar.book(1, 2));
        TestUtils.iAssertTrue(myCalendar.book(5,6));
        TestUtils.iAssertFalse(myCalendar.book(5,6));
        TestUtils.iAssertTrue(myCalendar.book(9,12));
        TestUtils.iAssertFalse(myCalendar.book(9, 12));
        TestUtils.iAssertFalse(myCalendar.book(12, 13));
        TestUtils.iAssertTrue(myCalendar.book(13,15));
        TestUtils.iAssertFalse(myCalendar.book(13, 15));
    }

    @Test
    public void case_3_test_5() {
        MyCalendarTwo myCalendar = new MyCalendarTwo();
        TestUtils.iAssertTrue(myCalendar.book(6, 9));
        TestUtils.iAssertTrue(myCalendar.book(10, 13));
        TestUtils.iAssertTrue(myCalendar.book(7, 11));
        TestUtils.iAssertFalse(myCalendar.book(8, 10));
    }

    @Test
    public void case_4_test_6() {
        MyCalendarTwo myCalendar = new MyCalendarTwo();
        TestUtils.iAssertTrue(myCalendar.book(6, 9));
        TestUtils.iAssertTrue(myCalendar.book(10, 13));
        TestUtils.iAssertTrue(myCalendar.book(7, 14));
        TestUtils.iAssertFalse(myCalendar.book(5, 8));
        TestUtils.iAssertFalse(myCalendar.book(10, 12));
}
}
