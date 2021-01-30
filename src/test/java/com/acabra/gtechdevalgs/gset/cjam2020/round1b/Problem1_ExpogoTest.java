package com.acabra.gtechdevalgs.gset.cjam2020.round1b;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

public class Problem1_ExpogoTest {

    @Test
    public void test() {
        MatcherAssert.assertThat("SEN", Is.is(Problem1_Expogo.Solution.solution(2, 3)));
        MatcherAssert.assertThat("NWS", Is.is(Problem1_Expogo.Solution.solution(-2, -3)));
        MatcherAssert.assertThat("EE", Is.is(Problem1_Expogo.Solution.solution(3, 0)));
        MatcherAssert.assertThat("", Is.is(Problem1_Expogo.Solution.solution(0, 0)));
        MatcherAssert.assertThat("IMPOSSIBLE", Is.is(Problem1_Expogo.Solution.solution(-1, 1)));
        MatcherAssert.assertThat("IMPOSSIBLE", Is.is(Problem1_Expogo.Solution.solution(3, 7)));
        MatcherAssert.assertThat("IMPOSSIBLE", Is.is(Problem1_Expogo.Solution.solution(8, 20)));
    }

}