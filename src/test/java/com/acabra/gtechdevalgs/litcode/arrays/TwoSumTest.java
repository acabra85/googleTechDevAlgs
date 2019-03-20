package com.acabra.gtechdevalgs.litcode.arrays;

import org.junit.Assert;
import org.junit.Test;

public class TwoSumTest {

    @Test
    public void should_return_0_4_test_01() {
        int target = 5;
        int[] input = {2, 1, 6, 5, 3};
        int[] expected = {0, 4};
        Assert.assertArrayEquals(expected, new TwoSum().twoSum(input, target));
    }
    @Test
    public void should_return_true_test_01() {
        int target = 6;
        int[] input = {3, 2, 4};
        int[] expected = {1, 2};
        Assert.assertArrayEquals(expected, new TwoSum().twoSum(input, target));
    }


    @Test
    public void should_return_false_test_01() {
        int target = 10;
        int[] input = {2, 1, 6, 5, 3};
        int[] expected = {-1, -1};
        Assert.assertArrayEquals(expected, new TwoSum().twoSum(input, target));
    }
}
