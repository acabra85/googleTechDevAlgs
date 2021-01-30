package com.acabra.gtechdevalgs.litcode.dynamicprog;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.hamcrest.number.IsCloseTo;
import org.junit.Test;

public class HireWorkersTest {

    @Test
    public void should_return_105d_test() {
        int[] quality = {10,20,5};
        int[] wage = {70,50,30};
        int K = 2;
        double expected = 105.0d;
        MatcherAssert.assertThat(expected, Is.is(IsCloseTo.closeTo(new HireWorkers().mincostToHireWorkers(quality, wage, K), 0.00001)));
    }
    @Test
    public void should_return_25_2d_test() {
        int[] quality = {4,5};
        int[] wage = {8,14};
        int K = 2;
        double expected = 25.2d;
        MatcherAssert.assertThat(expected, Is.is(IsCloseTo.closeTo(new HireWorkers().mincostToHireWorkers(quality, wage, K), 0.00001)));
    }
}
