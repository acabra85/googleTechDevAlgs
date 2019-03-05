package com.acabra.gtechdevalgs.litcode.arrays;

import org.junit.Assert;
import org.junit.Test;

public class GameOfLifeTest {

    @Test
    public void game_test_1() {
        int[][] input = {
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };
        int[][] expected = {
            {0,0,0},
            {1,0,1},
            {0,1,1},
            {0,1,0}
        };
        new GameOfLife().gameOfLife(input);
        Assert.assertArrayEquals(expected, input);
    }
}
