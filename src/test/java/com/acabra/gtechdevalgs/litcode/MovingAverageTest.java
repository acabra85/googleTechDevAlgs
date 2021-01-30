package com.acabra.gtechdevalgs.litcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.hamcrest.number.IsCloseTo;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MovingAverageTest {

    private static final double delta = 0.0001;

    @Test
    public void test_moving_average() {
        MovingAverage ma = new MovingAverage(3);
        assertNotNull(ma);
        MatcherAssert.assertThat(1.0, Is.is(IsCloseTo.closeTo(ma.next(1), delta)));
        MatcherAssert.assertThat(5.5, Is.is(IsCloseTo.closeTo(ma.next(10), delta)));
        MatcherAssert.assertThat(5.33333, Is.is(IsCloseTo.closeTo(ma.next(5), delta)));
        MatcherAssert.assertThat(6.0, Is.is(IsCloseTo.closeTo(ma.next(3), delta)));
    }
}