package com.acabra.gtechdevalgs.litcode.arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubsequenceTargetDestinationTest {

    @Test
    public void shortestWay() {
        Assert.assertEquals(2, new SubsequenceTargetDestination().shortestWay("abc", "abcbc"));
    }
}