package com.acabra.gtechdevalgs.litcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MissingRangesTest {

    @Test
    public void findMissingRanges() {
        int[] nums = {Integer.MIN_VALUE, Integer.MAX_VALUE};
        List<String> missingRanges =  new MissingRanges().findMissingRanges(nums, Integer.MIN_VALUE, Integer.MAX_VALUE);
        Assert.assertNotNull(missingRanges);
        Assert.assertEquals(1, missingRanges.size());
        Assert.assertEquals("-2147483647->2147483646", missingRanges.get(0));
    }
}