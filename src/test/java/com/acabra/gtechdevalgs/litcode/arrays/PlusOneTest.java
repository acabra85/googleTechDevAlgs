package com.acabra.gtechdevalgs.litcode.arrays;

import org.junit.Assert;
import org.junit.Test;

public class PlusOneTest {

    @Test
    public void should_return_124_test_1() {
        int[] input = {1,2,3};
        int[] expected = {1,2,4};
        Assert.assertArrayEquals(expected, new PlusOne().plusOne(input));
    }

    @Test
    public void should_return_1000_test_2() {
        int[] input = {9,9,9};
        int[] expected = {1,0,0,0};
        Assert.assertArrayEquals(expected, new PlusOne().plusOne(input));
    }

    @Test
    public void should_return_1_test_3() {
        int[] input = {0};
        int[] expected = {1};
        Assert.assertArrayEquals(expected, new PlusOne().plusOne(input));
    }

    @Test
    public void should_return_11_test_4() {
        int[] input = {1, 0};
        int[] expected = {1,1};
        Assert.assertArrayEquals(expected, new PlusOne().plusOne(input));
    }

    @Test
    public void should_return_990_test_5() {
        int[] input = {9, 8, 9};
        int[] expected = {9, 9, 0};
        Assert.assertArrayEquals(expected, new PlusOne().plusOne(input));
    }

    @Test
    public void should_return_9800_test_6() {
        int[] input = {9,7,9,9};
        int[] expected = {9,8,0,0};
        Assert.assertArrayEquals(expected, new PlusOne().plusOne(input));
    }
}
