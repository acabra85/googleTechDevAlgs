package com.acabra.gtechdevalgs.litcode.arrays;

import org.junit.Assert;
import org.junit.Test;

public class SearchSortedArrayUnknownSizeTest {

    @Test
    public void should_return_4_test_1() {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        int expected = 4;
        Assert.assertEquals(expected, new SearchSortedArrayUnknownSize()
                .binarySearch(SearchSortedArrayUnknownSize.ArrayReader.of(nums), target));
    }

    @Test
    public void should_return_zero_test_1() {
        int[] nums = {-1,0,3,5,9,12};
        int target = -1;
        int expected = 0;
        Assert.assertEquals(expected, new SearchSortedArrayUnknownSize()
                .binarySearch(SearchSortedArrayUnknownSize.ArrayReader.of(nums), target));
    }

    @Test
    public void should_return_minus_1_test_1() {
        int[] nums = {-1,0,3,5,9,12};
        int target = 1;
        int expected = -1;
        Assert.assertEquals(expected, new SearchSortedArrayUnknownSize()
                .binarySearch(SearchSortedArrayUnknownSize.ArrayReader.of(nums), target));
    }

    @Test
    public void should_return_minus_1_test_2() {
        int[] nums = {-1,0,3,5,9,12};
        int target = 11;
        int expected = -1;
        Assert.assertEquals(expected, new SearchSortedArrayUnknownSize()
                .binarySearch(SearchSortedArrayUnknownSize.ArrayReader.of(nums), target));
    }
}
