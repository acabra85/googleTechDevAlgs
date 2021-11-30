package com.acabra.gtechdevalgs.litcode.dynamicprog;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LongSummaryStatistics;
import java.util.concurrent.TimeUnit;

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
        Assertions.assertThat(underTest.optimalLIS(nums))
                .isEqualTo(underTest.   dpLIS(nums))
                .isEqualTo(expected);
    }

    @Test
    public void shouldReturn4_() {
        int[] nums = {0, 1, 0, 3, 2, 3};
        int expected = 4;
        Assertions.assertThat(underTest.optimalLIS(nums))
                .isEqualTo(underTest.dpLIS(nums))
                .isEqualTo(expected);
    }

    @Test
    public void shouldReturn4_2() {
        int[] nums = {10,9,2,5,3,7,101,18};
        int expected = 4;
        Assertions.assertThat(underTest.optimalLIS(nums))
                .isEqualTo(underTest.dpLIS(nums))
                .isEqualTo(expected);
    }

    @Test
    public void shouldReturn0() {
        int[] nums = null;
        int expected = 0;
        Assertions.assertThat(underTest.optimalLIS(nums))
                .isEqualTo(underTest.dpLIS(nums))
                .isEqualTo(expected);
    }

    @Test
    public void shouldReturn0_1() {
        int[] nums = {};
        int expected = 0;
        Assertions.assertThat(underTest.optimalLIS(nums))
                .isEqualTo(underTest.dpLIS(nums))
                .isEqualTo(expected);
    }

    @Test
    public void shouldReturn1() {
        int[] nums = {0,0,0,0,0,0,0};
        int expected = 1;
        Assertions.assertThat(underTest.optimalLIS(nums))
                .isEqualTo(underTest.dpLIS(nums))
                .isEqualTo(expected);
    }

    @Test
    public void shouldReturn1_2() {
        int[] nums = {5,0};
        int expected = 1;
        Assertions.assertThat(underTest.optimalLIS(nums))
                .isEqualTo(underTest.dpLIS(nums))
                .isEqualTo(expected);
    }

    @Test
    public void shouldReturn2() {
        int[] nums = {0,1};
        int expected = 2;
        Assertions.assertThat(underTest.optimalLIS(nums))
                .isEqualTo(underTest.dpLIS(nums))
                .isEqualTo(expected);
    }

    @Test
    public void shouldReturn3() {
        int[] nums = {3, 4, 5, 1};
        int expected = 3;
        Assertions.assertThat(underTest.optimalLIS(nums))
                .isEqualTo(underTest.dpLIS(nums))
                .isEqualTo(expected);
    }

    @Test
    public void shouldReturn4() {
        int[] nums = {5,2,8,6,3,6,9,5};
        int expected = 4;
        int sampleSize = 100;
        int optimal = 0;
        int dp = 0;
        long start = 0L;
        LongSummaryStatistics lssOptimal = new LongSummaryStatistics();
        LongSummaryStatistics lssDP = new LongSummaryStatistics();
        for (int i = 0; i < sampleSize; i++) {
            start = System.nanoTime();
            optimal = underTest.optimalLIS(nums);
            lssOptimal.accept(System.nanoTime() - start);
        }
        for (int i = 0; i < sampleSize; i++) {
            start = System.nanoTime();
            dp = underTest.dpLIS(nums);
            lssDP.accept(System.nanoTime() - start);
        }
        System.out.printf("Optimal avg: %s, DP avg: %s, Faster: <<<%s>>>%n",
                TimeUnit.NANOSECONDS.convert(lssOptimal.getSum()/lssOptimal.getCount(), TimeUnit.MILLISECONDS),
                TimeUnit.NANOSECONDS.convert(lssDP.getSum()/lssDP.getCount(), TimeUnit.MILLISECONDS),
                        lssOptimal.getAverage() < lssDP.getAverage() ? "Optimal" : "DP");
        Assertions.assertThat(optimal)
                .isEqualTo(dp)
                .isEqualTo(expected);
    }
}
