package com.acabra.gtechdevalgs.google;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PathWithMaximumGold2DTest {

    private PathWithMaximumGold2D underTest;

    @BeforeEach
    void setUp() {
        this.underTest = new PathWithMaximumGold2D();
    }

    @Test
    public void mustReturn24() {
        int[][] mine = {
                {1, 0, 0, 1},
                {2, 0, 0, 2},
                {3, 4, 5, 6},
                {0, 0, 0, 0},
                {1, 9, 0, 20},
        };
        int expected = 24;
        Assertions.assertEquals(expected, underTest.findPathWithMaxGold(mine));
    }

    @Test
    public void mustReturn20() {
        int[][] mine = {
                {1, 0, 0, 1},
                {2, 0, 0, 2},
                {3, 4, 2, 1},
                {0, 0, 0, 0},
                {1, 9, 0, 20},
        };
        int expected = 20;
        Assertions.assertEquals(expected, underTest.findPathWithMaxGold(mine));
    }
}