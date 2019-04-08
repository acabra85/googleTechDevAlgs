package com.acabra.gtechdevalgs.litcode.graphs;

import org.junit.Assert;
import org.junit.Test;

public class FindCelebrityTest {

    @Test
    public void should_return_1_test_01() {
        int peopleCount = 3;
        int expected = 1;
        boolean[][] graph = {{true,true,false}, {false,true,false}, {true,true,true}};
        Assert.assertEquals(expected, new FindCelebrity(graph).findCelebrity(peopleCount));
    }

    @Test
    public void should_return_minus_1_test_01() {
        int peopleCount = 2;
        int expected = -1;
        boolean[][] graph = {{true,false}, {false,true}};
        Assert.assertEquals(expected, new FindCelebrity(graph).findCelebrity(peopleCount));
    }

    @Test
    public void should_return_minus_1_test_02() {
        int peopleCount = 2;
        int expected = -1;
        boolean[][] graph = {{true,true}, {true,true}};
        Assert.assertEquals(expected, new FindCelebrity(graph).findCelebrity(peopleCount));
    }
}
