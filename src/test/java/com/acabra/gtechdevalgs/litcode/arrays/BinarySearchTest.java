package com.acabra.gtechdevalgs.litcode.arrays;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void should_return_4_test_1() {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        int expected = 4;
        MatcherAssert.assertThat(expected, Is.is(new BinarySearch().binarySearch(nums, target)));
    }

    @Test
    public void should_return_zero_test_1() {
        int[] nums = {-1,0,3,5,9,12};
        int target = -1;
        int expected = 0;
        MatcherAssert.assertThat(expected, Is.is(new BinarySearch().binarySearch(nums, target)));
    }

    @Test
    public void should_return_minus_1_test_1() {
        int[] nums = {-1,0,3,5,9,12};
        int target = 1;
        int expected = -1;
        MatcherAssert.assertThat(expected, Is.is(new BinarySearch().binarySearch(nums, target)));
    }

    @Test
    public void should_return_minus_1_test_2() {
        int[] nums = {-1,0,3,5,9,12};
        int target = 11;
        int expected = -1;
        MatcherAssert.assertThat(expected, Is.is(new BinarySearch().binarySearch(nums, target)));
    }
}
