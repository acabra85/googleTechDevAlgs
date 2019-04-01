package com.acabra.gtechdevalgs.litcode.arrays;

import org.junit.Assert;
import org.junit.Test;

public class TwoSumTest {

    // Test input array nor particularly ordered
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


    //Api Test

    @Test
    public void api_test01() {
        TwoSum twoSum = new TwoSum();
        twoSum.add(0);
        Assert.assertFalse(twoSum.find(0));
    }

    @Test
    public void api_test02() {
        TwoSum twoSum = new TwoSum();
        twoSum.add(3);
        twoSum.add(2);
        twoSum.add(1);
        Assert.assertFalse(twoSum.find(2));
        Assert.assertTrue(twoSum.find(3));
        Assert.assertTrue(twoSum.find(4));
        Assert.assertTrue(twoSum.find(5));
        Assert.assertFalse(twoSum.find(6));
    }

    @Test
    public void api_test03() {
        TwoSum twoSum = new TwoSum();
        twoSum.add(0);
        twoSum.add(0);
        Assert.assertTrue(twoSum.find(0));
    }



    //Test sumTwo input in ascending order

    @Test
    public void should_return_2_3_ordered_test_01() {
        int[] nums = {1,2,3,4,8,9};
        int target = 7;
        int[] expected = {3,4};
        Assert.assertArrayEquals(expected, new TwoSum().twoSumInputAscendingOrder(nums, target));
    }

    @Test
    public void should_return_1_2_ordered_test_02() {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] expected = {1, 2};
        Assert.assertArrayEquals(expected, new TwoSum().twoSumInputAscendingOrder(nums, target));
    }
}