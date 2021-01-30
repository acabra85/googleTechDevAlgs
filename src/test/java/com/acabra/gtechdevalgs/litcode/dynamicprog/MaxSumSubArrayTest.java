package com.acabra.gtechdevalgs.litcode.dynamicprog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MaxSumSubArrayTest {
    private MaxSumSubArray underTest;

    @BeforeEach
    public void setup() {
        underTest = new MaxSumSubArray();
    }

    @Test
    public void must_return_minus_1() {
        int[] nums = {-3, -4, -5, -1};
        Assertions.assertEquals(-1, underTest.maxSumOfConsecutiveSubArrays(nums));
    }

    @Test
    public void must_return_6() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        Assertions.assertEquals(6, underTest.maxSumOfConsecutiveSubArrays(nums));
    }

    @Test
    public void must_return_0() {
        int[] nums = {-1,0,-2};
        Assertions.assertEquals(0, underTest.maxSumOfConsecutiveSubArrays(nums));
    }
}
