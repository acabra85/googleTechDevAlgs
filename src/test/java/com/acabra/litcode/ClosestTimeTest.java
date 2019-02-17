package com.acabra.litcode;

import org.junit.Assert;
import org.junit.Test;

public class ClosestTimeTest {

    @Test
    public void should_return_19_39_brute() {
        Assert.assertEquals("19:39", new ClosestTime().closestTime("19:34"));
    }

    @Test
    public void should_return_22_22_brute() {
        Assert.assertEquals("22:22", new ClosestTime().closestTime("23:59"));
    }
}
