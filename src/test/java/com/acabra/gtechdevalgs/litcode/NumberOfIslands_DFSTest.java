package com.acabra.gtechdevalgs.litcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

public class NumberOfIslands_DFSTest  {

    @Test
    public void should_find_four_islands_test() {
        char[][] grid = {
                {'1', '0', '1', '1'},
                {'0', '1', '0', '1'},
                {'0', '0', '1', '0'},
                {'0', '1', '1', '0'}
        };

        MatcherAssert.assertThat(4, Is.is(new NumberOfIslands_DFS().numIslands(grid)));
    }

    @Test
    public void should_find_one_island_test() {
        char[][] grid2 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        };
        MatcherAssert.assertThat(1, Is.is(new NumberOfIslands_DFS().numIslands(grid2)));
    }

    @Test
    public void should_find_three_island_test() {
        char[][] grid3 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        MatcherAssert.assertThat(3, Is.is(new NumberOfIslands_DFS().numIslands(grid3)));
    }
}
