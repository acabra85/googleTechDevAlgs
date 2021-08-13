package com.acabra.gtechdevalgs.litcode.dynamicprog;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LongestIncreasingSubsequenceTest {
    private LongestIncreasingSubsequence underTest;

    @BeforeEach
    public void setUp() {
        underTest = new LongestIncreasingSubsequence();
    }

    @Test
    public void shouldReturn5() {
        int[] nums = {1, 2, 3, 4, 5};
        int expected = 5;
        Assertions.assertThat(underTest.longestIncreasingSubsequence(nums))
                .isEqualTo(expected);
    }

    @Test
    public void shouldReturn4_() {
        int[] nums = {0, 1, 0, 3, 2, 3};
        int expected = 4;
        Assertions.assertThat(underTest.longestIncreasingSubsequence(nums))
                .isEqualTo(expected);
    }

    @Test
    public void shouldReturn4_2() {
        int[] nums = {10,9,2,5,3,7,101,18};
        int expected = 4;
        Assertions.assertThat(underTest.longestIncreasingSubsequence(nums))
                .isEqualTo(expected);
    }

    @Test
    public void shouldReturn0() {
        int[] nums = null;
        int expected = 0;
        Assertions.assertThat(underTest.longestIncreasingSubsequence(nums))
                .isEqualTo(expected);
    }

    @Test
    public void shouldReturn0_1() {
        int[] nums = {};
        int expected = 0;
        Assertions.assertThat(underTest.longestIncreasingSubsequence(nums))
                .isEqualTo(expected);
    }

    @Test
    public void shouldReturn1() {
        int[] nums = {0,0,0,0,0,0,0};
        int expected = 1;
        Assertions.assertThat(underTest.longestIncreasingSubsequence(nums))
                .isEqualTo(expected);
    }
}
