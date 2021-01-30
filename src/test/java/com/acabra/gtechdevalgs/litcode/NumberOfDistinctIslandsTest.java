package com.acabra.gtechdevalgs.litcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

public class NumberOfDistinctIslandsTest {

    @Test
    public void should_find_two_types_test_1() {
        char[][] grid = {
                {'1', '0', '1', '1'},
                {'0', '1', '0', '1'},
                {'0', '0', '1', '0'},
                {'0', '1', '1', '0'}
        };

        char[][] expected = {
                {'0', '4'},
                {'1', '4'}
        };
        MatcherAssert.assertThat(expected, Is.is(new NumberOfDistinctIslands().numIslands(grid)));
    }
    @Test
    public void should_find_4_types_test_3() {
        char[][] grid = {
                {'0', '3', '3', '1'},
                {'0', '1', '0', '1'},
                {'0', '1', '1', '0'},
                {'1', '2', '2', '0'}
        };

        char[][] expected = {
                {'0', '3'},
                {'1', '3'},
                {'2', '1'},
                {'3', '1'},
        };
        MatcherAssert.assertThat(expected, Is.is(new NumberOfDistinctIslands().numIslands(grid)));
    }
}
