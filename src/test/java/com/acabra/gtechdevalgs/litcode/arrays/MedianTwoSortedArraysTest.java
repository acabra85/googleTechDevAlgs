package com.acabra.gtechdevalgs.litcode.arrays;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.hamcrest.number.IsCloseTo;
import org.junit.Test;

public class MedianTwoSortedArraysTest {

    @Test
    public void should_return_2_test_1() {
        int[] arr1 = {1,3};
        int[] arr2 = {2};
        MatcherAssert.assertThat(2.0, Is.is(Is.is(IsCloseTo.closeTo(new MedianTwoSortedArrays().median(arr1, arr2), 0.000001d))));
    }
    @Test
    public void should_return_2f5_test_2() {
        int[] arr1 = {1,2};
        int[] arr2 = {3,4};
        MatcherAssert.assertThat(2.5, Is.is(IsCloseTo.closeTo(new MedianTwoSortedArrays().median(arr1, arr2), 0.000001d)));
    }

    @Test
    public void should_return_0f5_test_3() {
        int[] arr1 = {1,1,1,1,1};
        int[] arr2 = {1};
        MatcherAssert.assertThat(1.0, Is.is(IsCloseTo.closeTo(new MedianTwoSortedArrays().median(arr1, arr2), 0.000001d)));
    }

    @Test
    public void should_return_1_test_2() {
        int[] arr1 = {1,1,1,1,1};
        int[] arr2 = {1,1};
        MatcherAssert.assertThat(1.0, Is.is(IsCloseTo.closeTo(new MedianTwoSortedArrays().median_n(arr1, arr2), 0.000001d)));
    }

    @Test
    public void should_return_2_test_1_O_n() {
        int[] arr1 = {1,3};
        int[] arr2 = {2};
        MatcherAssert.assertThat(2.0, Is.is(IsCloseTo.closeTo(new MedianTwoSortedArrays().median_n(arr1, arr2), 0.000001d)));
    }
    @Test
    public void should_return_2f5_test_2_O_n() {
        int[] arr1 = {1,2};
        int[] arr2 = {3,4};
        MatcherAssert.assertThat(2.5, Is.is(IsCloseTo.closeTo(new MedianTwoSortedArrays().median_n(arr1, arr2), 0.000001d)));
    }

    @Test
    public void should_return_0f5_test_3_O_n() {
        int[] arr1 = {1,1,1,1,1};
        int[] arr2 = {1};
        MatcherAssert.assertThat(1.0, Is.is(IsCloseTo.closeTo(new MedianTwoSortedArrays().median_n(arr1, arr2), 0.000001d)));
    }

    @Test
    public void should_return_1_test_2_O_n() {
        int[] arr1 = {1,1,1,1,1};
        int[] arr2 = {1,1};
        MatcherAssert.assertThat(1.0, Is.is(IsCloseTo.closeTo(new MedianTwoSortedArrays().median(arr1, arr2), 0.000001d)));
    }
}
