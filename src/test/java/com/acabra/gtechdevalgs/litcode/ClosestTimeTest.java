package com.acabra.gtechdevalgs.litcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

public class ClosestTimeTest {

    @Test
    public void should_return_19_39_brute() {
        MatcherAssert.assertThat("19:39", Is.is(new ClosestTime().closestTime("19:34")));
    }

    @Test
    public void should_return_22_22_brute() {
        MatcherAssert.assertThat("22:22", Is.is(new ClosestTime().closestTime("23:59")));
    }
}
