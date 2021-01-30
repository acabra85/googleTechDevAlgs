package com.acabra.gtechdevalgs.google;

import org.hamcrest.core.Is;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoggerRaterLimiterTest {
    LoggerRaterLimiter underTest;

    @Before
    public void setup() {
        underTest = new LoggerRaterLimiter();
    }
    @Test
    public void apiTest() {
        // logging string "foo" at timestamp 1
        MatcherAssert.assertThat(underTest.shouldPrintMessage(1, "foo"), Is.is(true));

        // logging string "bar" at timestamp 2
        MatcherAssert.assertThat(underTest.shouldPrintMessage(2,"bar"), Is.is(true));

        // logging string "foo" at timestamp 3
        MatcherAssert.assertThat(underTest.shouldPrintMessage(3,"foo"), Is.is(false));

        // logging string "bar" at timestamp 8
        MatcherAssert.assertThat(underTest.shouldPrintMessage(8,"bar"), Is.is(false));

        // logging string "foo" at timestamp 10
        MatcherAssert.assertThat(underTest.shouldPrintMessage(10,"foo"), Is.is(false));

        // logging string "foo" at timestamp 11
        MatcherAssert.assertThat(underTest.shouldPrintMessage(11,"foo"), Is.is(true));
    }

}