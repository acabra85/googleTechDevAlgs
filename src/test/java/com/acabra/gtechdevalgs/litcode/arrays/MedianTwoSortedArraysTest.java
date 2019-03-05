package com.acabra.gtechdevalgs.litcode.arrays;

import org.junit.Assert;
import org.junit.Test;

public class MedianTwoSortedArraysTest {

    @Test
    public void should_return_2_test_1() {
        int[] arr1 = {1,3};
        int[] arr2 = {2};
        Assert.assertEquals(2, new MedianTwoSortedArrays().median(arr1, arr2), 0.000001d);
    }
    @Test
    public void should_return_2f5_test_2() {
        int[] arr1 = {1,2};
        int[] arr2 = {3,4};
        Assert.assertEquals(2.5, new MedianTwoSortedArrays().median(arr1, arr2), 0.000001d);
    }

    @Test
    public void should_return_0f5_test_3() {
        int[] arr1 = {1,1,1,1,1};
        int[] arr2 = {1};
        Assert.assertEquals(1, new MedianTwoSortedArrays().median(arr1, arr2), 0.000001d);
    }

    @Test
    public void should_return_1_test_2() {
        int[] arr1 = {1,1,1,1,1};
        int[] arr2 = {1,1};
        Assert.assertEquals(1, new MedianTwoSortedArrays().median_n(arr1, arr2), 0.000001d);
    }

    @Test
    public void should_return_2_test_1_O_n() {
        int[] arr1 = {1,3};
        int[] arr2 = {2};
        Assert.assertEquals(2, new MedianTwoSortedArrays().median_n(arr1, arr2), 0.000001d);
    }
    @Test
    public void should_return_2f5_test_2_O_n() {
        int[] arr1 = {1,2};
        int[] arr2 = {3,4};
        Assert.assertEquals(2.5, new MedianTwoSortedArrays().median_n(arr1, arr2), 0.000001d);
    }

    @Test
    public void should_return_0f5_test_3_O_n() {
        int[] arr1 = {1,1,1,1,1};
        int[] arr2 = {1};
        Assert.assertEquals(1, new MedianTwoSortedArrays().median_n(arr1, arr2), 0.000001d);
    }

    @Test
    public void should_return_1_test_2_O_n() {
        int[] arr1 = {1,1,1,1,1};
        int[] arr2 = {1,1};
        Assert.assertEquals(1, new MedianTwoSortedArrays().median(arr1, arr2), 0.000001d);
    }
}
