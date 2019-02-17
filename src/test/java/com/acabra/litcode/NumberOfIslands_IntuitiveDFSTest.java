package com.acabra.litcode;

import org.junit.Assert;
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

        Assert.assertEquals(4, new NumberOfIslands_IntuitiveDFS().numIslands(grid));
    }

    @Test
    public void should_find_one_island_test() {
        char[][] grid2 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        };
        Assert.assertEquals(1, new NumberOfIslands_IntuitiveDFS().numIslands(grid2));
    }

    @Test
    public void should_find_three_island_test() {
        char[][] grid3 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        Assert.assertEquals(3, new NumberOfIslands_IntuitiveDFS().numIslands(grid3));
    }
}
