package com.acabra.gtechdevalgs.litcode.arrays;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.List;

public class SumClosestToKTest {

    @Test
    public void should_return_5_6() {
        int[] a = {2,0,9,5,3};
        int[] b = {2,6,4,5,11};
        int k = 13;
        List<SumClosestToK.SumClosestToKResult> res = new SumClosestToK().solve(a, b, k);
        MatcherAssert.assertThat(2, Is.is(res.size()));

        for (SumClosestToK.SumClosestToKResult re : res) {
            MatcherAssert.assertThat(0,  Is.is(re.dist));
        }
    }
}