package com.acabra.gtechdevalgs.litcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovingAverageTest {

    private static final double delta = 0.0001;

    @Test
    public void test_moving_average() {
        MovingAverage ma = new MovingAverage(3);
        assertNotNull(ma);
        Assert.assertEquals(1.0, ma.next(1), delta);
        Assert.assertEquals(5.5, ma.next(10), delta);
        Assert.assertEquals(5.33333, ma.next(5), delta);
        Assert.assertEquals(6.0, ma.next(3), delta);
    }
}