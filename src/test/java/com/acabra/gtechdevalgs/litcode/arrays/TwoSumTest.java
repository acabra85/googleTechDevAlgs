package com.acabra.gtechdevalgs.litcode.arrays;

import com.acabra.gtechdevalgs.TestUtils;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

public class TwoSumTest {

    // Test input array nor particularly ordered
    @Test
    public void should_return_0_4_test_01() {
        int target = 5;
        int[] input = {2, 1, 6, 5, 3};
        int[] expected = {0, 4};
        MatcherAssert.assertThat(expected, Is.is(new TwoSum().twoSum(input, target)));
    }
    @Test
    public void should_return_true_test_01() {
        int target = 6;
        int[] input = {3, 2, 4};
        int[] expected = {1, 2};
        MatcherAssert.assertThat(expected, Is.is(new TwoSum().twoSum(input, target)));
    }


    @Test
    public void should_return_false_test_01() {
        int target = 10;
        int[] input = {2, 1, 6, 5, 3};
        int[] expected = {-1, -1};
        MatcherAssert.assertThat(expected, Is.is(new TwoSum().twoSum(input, target)));
    }


    //Api Test

    @Test
    public void api_test01() {
        TwoSum twoSum = new TwoSum();
        twoSum.add(0);
        TestUtils.iAssertFalse(twoSum.find(0));
    }

    @Test
    public void api_test02() {
        TwoSum twoSum = new TwoSum();
        twoSum.add(3);
        twoSum.add(2);
        twoSum.add(1);
        TestUtils.iAssertFalse(twoSum.find(2));
        TestUtils.iAssertTrue(twoSum.find(3));
        TestUtils.iAssertTrue(twoSum.find(4));
        TestUtils.iAssertTrue(twoSum.find(5));
        TestUtils.iAssertFalse(twoSum.find(6));
    }

    @Test
    public void api_test03() {
        TwoSum twoSum = new TwoSum();
        twoSum.add(0);
        twoSum.add(0);
        TestUtils.iAssertTrue(twoSum.find(0));
    }



    //Test sumTwo input in ascending order

    @Test
    public void should_return_2_3_ordered_test_01() {
        int[] nums = {1,2,3,4,8,9};
        int target = 7;
        int[] expected = {3,4};
        MatcherAssert.assertThat(expected, Is.is(new TwoSum().twoSumInputAscendingOrder(nums, target)));
    }

    @Test
    public void should_return_1_2_ordered_test_02() {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] expected = {1, 2};
        MatcherAssert.assertThat(expected, Is.is(new TwoSum().twoSumInputAscendingOrder(nums, target)));
    }
}
