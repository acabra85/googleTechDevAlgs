package com.acabra.gtechdevalgs.litcode.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumBlockTest {

    private SumBlock underTest;

    @BeforeEach
    void setUp() {
        this.underTest = new SumBlock();
    }

    @Test
    public void test1() {
        int[][] nums = {{1,2,3}, {4,5,6}, {7,8,9}};
        int k = 1;
        int[][] expected = {{12, 21, 16}, {27, 45, 33}, {24, 39, 28}};
        int[][] actual = underTest.matrixBlockSum(nums, k);
        Assertions.assertEquals(expected.length, actual.length);
        Assertions.assertEquals(expected[0].length, actual[0].length);
        for (int i = 0; i < expected.length; ++i) {
            Assertions.assertArrayEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void test2() {
        int[][] nums = {{1,2,3}, {4,5,6}, {7,8,9}};
        int k = 2;
        int[][] expected = {{45, 45, 45}, {45, 45, 45}, {45, 45, 45}};
        int[][] actual = underTest.matrixBlockSum(nums, k);
        Assertions.assertEquals(expected.length, actual.length);
        Assertions.assertEquals(expected[0].length, actual[0].length);
        for (int i = 0; i < expected.length; ++i) {
            Assertions.assertArrayEquals(expected[i], actual[i]);
        }
    }
}