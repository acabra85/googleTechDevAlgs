package com.acabra.gtechdevalgs.litcode.arrays;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public class SpiralMatrixTest {

    @Test
    public void test_1() {
        int[][] input = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        Integer[] expected = {1,2,3,6,9,8,7,4,5};
        MatcherAssert.assertThat(expected, Matchers.arrayContaining(new SpiralMatrix().spiralMatrix(input).toArray()));
    }

    @Test
    public void test_2() {
        int[][] input = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12}
        };
        Integer[] expected = {1,2,3,4,8,12,11,10,9,5,6,7};
        MatcherAssert.assertThat(expected, Matchers.arrayContaining(new SpiralMatrix().spiralMatrix(input).toArray()));
    }

    @Test
    public void test_3() {
        int[][] input = {};
        MatcherAssert.assertThat(new SpiralMatrix().spiralMatrix(input), Matchers.empty());
    }
}
