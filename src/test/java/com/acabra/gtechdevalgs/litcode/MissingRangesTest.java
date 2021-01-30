package com.acabra.gtechdevalgs.litcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MissingRangesTest {

    @Test
    public void findMissingRanges() {
        int[] nums = {Integer.MIN_VALUE, Integer.MAX_VALUE};
        List<String> missingRanges =  new MissingRanges().findMissingRanges(nums, Integer.MIN_VALUE, Integer.MAX_VALUE);
        MatcherAssert.assertThat(missingRanges, Matchers.notNullValue());
        MatcherAssert.assertThat(1, Is.is(missingRanges.size()));
        MatcherAssert.assertThat("-2147483647->2147483646",  Is.is(missingRanges.get(0)));
    }
}