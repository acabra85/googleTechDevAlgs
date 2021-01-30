package com.acabra.gtechdevalgs.litcode.graphs;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

public class FindCelebrityTest {

    @Test
    public void should_return_1_test_01() {
        int peopleCount = 3;
        int expected = 1;
        boolean[][] graph = {{true,true,false}, {false,true,false}, {true,true,true}};
        MatcherAssert.assertThat(expected, Is.is(new FindCelebrity(graph).findCelebrity(peopleCount)));
    }

    @Test
    public void should_return_minus_1_test_01() {
        int peopleCount = 2;
        int expected = -1;
        boolean[][] graph = {{true,false}, {false,true}};
        MatcherAssert.assertThat(expected, Is.is(new FindCelebrity(graph).findCelebrity(peopleCount)));
    }

    @Test
    public void should_return_minus_1_test_02() {
        int peopleCount = 2;
        int expected = -1;
        boolean[][] graph = {{true,true}, {true,true}};
        MatcherAssert.assertThat(expected, Is.is(new FindCelebrity(graph).findCelebrity(peopleCount)));
    }
}
