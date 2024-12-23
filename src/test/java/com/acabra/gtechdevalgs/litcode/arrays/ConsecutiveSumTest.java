package com.acabra.gtechdevalgs.litcode.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Describe your class
 */
class ConsecutiveSumTest {

    private ConsecutiveSum underTest;

    @BeforeEach
    void setUp() {
        this.underTest = new ConsecutiveSum();
    }

    @Test
    public void must_return_3072() {
        int[] arr =  new int[]{1, 5, 3, 0, 7, 2, 4};
        int sum = 12;
        int[] expected = new int[]{3, 0, 7, 2};
        Assertions.assertArrayEquals(expected, underTest.consecutiveSum(arr, sum));
    }

    @Test
    public void must_return_153() {
        int[] arr =  new int[]{1, 5, 3, 0, 7, 2, 4};
        int sum = 9;
        int[] expected = new int[]{1,5,3};
        Assertions.assertArrayEquals(expected, underTest.consecutiveSum(arr, sum));
    }

    @Test
    public void must_return_1() {
        int[] arr =  new int[]{1, 5, 3, 0, 7, 2, 4};
        int sum = 1;
        int[] expected = new int[]{1};
        Assertions.assertArrayEquals(expected, underTest.consecutiveSum(arr, sum));
    }

    @Test
    public void must_return_empty() {
        int[] arr =  new int[]{1, 5, 3, 0, 7, 2, 4};
        int sum = 23;
        int[] expected = new int[]{};
        Assertions.assertArrayEquals(expected, underTest.consecutiveSum(arr, sum));
    }

    @Test
    public void must_return_33() {
        int[] arr =  new int[]{1, 5, 3, 0, 7, 2, 4};
        int sum = 0;
        int[] expected = new int[]{0};
        Assertions.assertArrayEquals(expected, underTest.consecutiveSum(arr, sum));
    }

    @Test
    public void must_return_25_index() {
        int[] arr =  new int[]{1, 5, 3, 0, 7, 2, 4};
        int sum = 12;
        int[] expected = new int[]{2,5};
        Assertions.assertArrayEquals(expected, underTest.consecutiveSumIndex(arr, sum));
    }

    @Test
    public void must_return_02_index() {
        int[] arr =  new int[]{1, 5, 3, 0, 7, 2, 4};
        int sum = 9;
        int[] expected = new int[]{0, 2};
        Assertions.assertArrayEquals(expected, underTest.consecutiveSumIndex(arr, sum));
    }

    @Test
    public void must_return_00_index() {
        int[] arr =  new int[]{1, 5, 3, 0, 7, 2, 4};
        int sum = 1;
        int[] expected = new int[]{0, 0};
        Assertions.assertArrayEquals(expected, underTest.consecutiveSumIndex(arr, sum));
    }

    @Test
    public void must_return_empty_index() {
        int[] arr =  new int[]{1, 5, 3, 0, 7, 2, 4};
        int sum = 23;
        int[] expected = new int[]{};
        Assertions.assertArrayEquals(expected, underTest.consecutiveSumIndex(arr, sum));
    }

    @Test
    public void must_return_33_index() {
        int[] arr =  new int[]{1, 5, 3, 0, 7, 2, 4};
        int sum = 0;
        int[] expected = new int[]{3, 3};
        Assertions.assertArrayEquals(expected, underTest.consecutiveSumIndex(arr, sum));
    }

    @Test
    public void must_return_12_index() {
        int[] arr =  new int[]{3, 2, 4};
        int sum = 6;
        int[] expected = new int[]{1, 2};
        Assertions.assertArrayEquals(expected, underTest.consecutiveSumIndex(arr, sum));
    }

    @Test
    public void must_return_24_index() {
        int[] arr =  new int[]{1, 1, 3, 0, 3, 2, 4};
        int sum = 6;
        int[] expected = new int[]{2, 4};
        Assertions.assertArrayEquals(expected, underTest.consecutiveSumIndex(arr, sum));
    }

    @Test
    public void must_return_22_index() {
        int[] arr =  new int[]{5, 1, 0, 0, 0, 0, 4};
        int sum = 0;
        int[] expected = new int[]{2, 2};
        Assertions.assertArrayEquals(expected, underTest.consecutiveSumIndex(arr, sum));
    }
}