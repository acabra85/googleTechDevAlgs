package com.acabra.gtechdevalgs.litcode;

import com.acabra.gtechdevalgs.TestUtils;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Arrays;

public class ArrayIntersectionTest {

    @Test
    public void should_return_list_size_2() {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        int[] expected = {2,2};

        MatcherAssert.assertThat(expected, Is.is(new ArrayIntersection().intersectOld(nums1, nums2)));
    }

    @Test
    public void should_return_list_size_3() {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};

        int[] expected1 = {4,9};
        int[] expected2 = {9,4};

        TestUtils.iAssertTrue(
            Arrays.equals(expected1, new ArrayIntersection().intersectOld(nums1, nums2))
            || Arrays.equals(expected2, new ArrayIntersection().intersectOld(nums1, nums2))
        );
    }

    @Test
    public void should_return_empty_list() {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {4,7};

        int[] expected = {};

        MatcherAssert.assertThat(expected, Is.is(new ArrayIntersection().intersectOld(nums1, nums2)));
    }

    @Test
    public void should_return_list_size_1() {
        int[] nums1 = {7,2,2,4,7,0,3,4,5};
        int[] nums2 = {3,9,8,6,1,9};

        int[] expected = {3};

        MatcherAssert.assertThat(expected, Is.is(new ArrayIntersection().intersectOld(nums1, nums2)));
    }


    @Test
    public void should_return_list_size_2_freqMap() {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        int[] expected = {2,2};

        MatcherAssert.assertThat(expected, Is.is(new ArrayIntersection().intersect(nums1, nums2)));
    }

    @Test
    public void should_return_list_size_3_freqMap() {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};

        int[] expected1 = {4,9};
        int[] expected2 = {9,4};

        TestUtils.iAssertTrue(
                Arrays.equals(expected1, new ArrayIntersection().intersect(nums1, nums2))
                        || Arrays.equals(expected2, new ArrayIntersection().intersect(nums1, nums2))
        );
    }

    @Test
    public void should_return_empty_list_freqMap() {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {4,7};

        int[] expected = {};

        MatcherAssert.assertThat(expected, Is.is(new ArrayIntersection().intersect(nums1, nums2)));
    }

    @Test
    public void should_return_list_size_1_freqMap() {
        int[] nums1 = {7,2,2,4,7,0,3,4,5};
        int[] nums2 = {3,9,8,6,1,9};

        int[] expected = {3};

        MatcherAssert.assertThat(expected, Is.is(new ArrayIntersection().intersect(nums1, nums2)));
    }
}
