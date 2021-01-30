package com.acabra.gtechdevalgs.litcode.arrays;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

public class BullsCowsTest {

    @Test
    public void should_return_1A3B_test() {
        String secret = "1807";
        String guess = "7810";
        String expected = "1A3B";
        MatcherAssert.assertThat(expected, Is.is(new BullsCows().getHint(secret, guess)));
    }

    @Test
    public void should_return_1A1B_test() {
        String secret = "1123";
        String guess = "0111";
        String expected = "1A1B";
        MatcherAssert.assertThat(expected, Is.is(new BullsCows().getHint(secret, guess)));
    }

    @Test
    public void should_return_3A0B_test() {
        String secret = "1122";
        String guess = "1222";
        String expected = "3A0B";
        MatcherAssert.assertThat(expected, Is.is(new BullsCows().getHint(secret, guess)));
    }


}
