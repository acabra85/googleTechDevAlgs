package com.acabra.gtechdevalgs.litcode.arrays;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

public class SubsequenceTargetDestinationTest {

    @Test
    public void shortestWay() {
        MatcherAssert.assertThat(2, Is.is(new SubsequenceTargetDestination().shortestWay("abc", "abcbc")));
    }
}