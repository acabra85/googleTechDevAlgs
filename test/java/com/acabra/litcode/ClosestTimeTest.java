package com.acabra.litcode;

import org.junit.Assert;
import org.junit.Test;

public class ClosestTimeTest {

    @Test
    public void should_return_19_39() {
        Assert.assertEquals("19:39", new ClosestTime().closestTime("19:34"));
    }
}
