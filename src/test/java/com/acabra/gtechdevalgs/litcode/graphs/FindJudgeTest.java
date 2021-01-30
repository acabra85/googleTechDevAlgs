package com.acabra.gtechdevalgs.litcode.graphs;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

public class FindJudgeTest {

    @Test
    public void should_return_3_test() {
        int[][] trust = {{1,3},{1,4},{2,3},{2,4}, {4,3}};
        int N = 4;
        int expected = 3;
        MatcherAssert.assertThat(expected, Is.is(new FindJudge().findJudge(N, trust)));
    }
}
