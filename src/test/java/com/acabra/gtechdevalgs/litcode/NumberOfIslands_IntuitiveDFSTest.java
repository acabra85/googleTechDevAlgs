package com.acabra.gtechdevalgs.litcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

/**
 * Created by Agustin on 2/11/2019.
 */
public class NumberOfIslands_IntuitiveDFSTest {

    @Test
    public void should_find_four_islands_test() {
        char[][] grid = {
                {'1', '0', '1', '1'},
                {'0', '1', '0', '1'},
                {'0', '0', '1', '0'},
                {'0', '1', '1', '0'}
        };

        MatcherAssert.assertThat(4, Is.is(new NumberOfIslands_IntuitiveDFS().numIslands(grid)));
    }

    @Test
    public void should_find_one_island_test() {
        char[][] grid2 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        };
        MatcherAssert.assertThat(1, Is.is(new NumberOfIslands_IntuitiveDFS().numIslands(grid2)));
    }

    @Test
    public void should_find_three_island_test() {
        char[][] grid3 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        MatcherAssert.assertThat(3, Is.is(new NumberOfIslands_IntuitiveDFS().numIslands(grid3)));
    }

    @Test(expected = NullPointerException.class)
    public void should_fail() {
        new NumberOfIslands_IntuitiveDFS().numIslands(null);
    }
}
