package com.acabra.gtechdevalgs.litcode.arrays;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

public class TrappingRainWaterTest {

    @Test
    public void should_return_6_test_1() {
        int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
        int expected = 6;
        MatcherAssert.assertThat(expected, Is.is(new TrappingRainWater().trappedWater(input)));
    }

    @Test
    public void should_return_3_test_2() {
        int[] input = {2, 0, 1, 3};
        int expected = 3;
        MatcherAssert.assertThat(expected, Is.is(new TrappingRainWater().trappedWater(input)));
    }

    @Test
    public void should_return_1_test_3() {
        int[] input = {1,0,2};
        int expected = 1;
        MatcherAssert.assertThat(expected, Is.is(new TrappingRainWater().trappedWater(input)));
    }

    @Test
    public void should_return_0_test_4() {
        int[] input = {1,2,1};
        int expected = 0;
        MatcherAssert.assertThat(expected, Is.is(new TrappingRainWater().trappedWater(input)));
    }

    @Test
    public void should_return_16_test_5() {
        int[] input = {3,0,2,0,1,0,2,0,3};
        int expected = 16;
        MatcherAssert.assertThat(expected, Is.is(new TrappingRainWater().trappedWater(input)));
    }

    @Test
    public void should_return_1_test_6() {
        int[] input = {1,0,1};
        int expected = 1;
        MatcherAssert.assertThat(expected, Is.is(new TrappingRainWater().trappedWater(input)));
    }

    @Test
    public void should_return_0_test_7() {
        int[] input = {};
        int expected = 0;
        MatcherAssert.assertThat(expected, Is.is(new TrappingRainWater().trappedWater(input)));
    }

    @Test(expected = NullPointerException.class)
    public void should_fail_8() {
        new TrappingRainWater().trappedWater(null);
    }

    @Test
    public void should_return_7_test_9() {
        int[] input = {2,0,3,0,3,0,2};
        int expected = 7;
        MatcherAssert.assertThat(expected, Is.is(new TrappingRainWater().trappedWater(input)));
    }

    @Test
    public void should_return_0_test_10() {
        int[] input = {1,2};
        int expected = 0;
        MatcherAssert.assertThat(expected, Is.is(new TrappingRainWater().trappedWater(input)));
    }

    @Test
    public void should_return_0_test_11() {
        int[] input = {0,0,0,0,0,0};
        int expected = 0;
        MatcherAssert.assertThat(expected, Is.is(new TrappingRainWater().trappedWater(input)));
    }

    @Test
    public void should_return_0_test_12() {
        int[] input = {0,0,1,1,1,0};
        int expected = 0;
        MatcherAssert.assertThat(expected, Is.is(new TrappingRainWater().trappedWater(input)));
    }

    @Test
    public void should_return_3_test_13() {
        int[] input = {3,0,2,0,1,0};
        int expected = 3;
        MatcherAssert.assertThat(expected, Is.is(new TrappingRainWater().trappedWater(input)));
    }

    @Test
    public void should_return_0_test_14() {
        int[] input = {0,0,2,4,1,0};
        int expected = 0;
        MatcherAssert.assertThat(expected, Is.is(new TrappingRainWater().trappedWater(input)));
    }

    @Test
    public void should_return_5_test_15() {
        int[] input = {2,1,0,0,3};
        int expected = 5;
        MatcherAssert.assertThat(expected, Is.is(new TrappingRainWater().trappedWater(input)));
    }

    @Test
    public void should_return_6_test_16() {
        int[] input = {1,0,2,0,3,0,2,0,1};
        int expected = 6;
        MatcherAssert.assertThat(expected, Is.is(new TrappingRainWater().trappedWater(input)));
    }

    @Test
    public void should_return_5_test_17() {
        int[] input = {2,0,1,0,2};
        int expected = 5;
        MatcherAssert.assertThat(expected, Is.is(new TrappingRainWater().trappedWater(input)));
    }

    @Test
    public void should_return_0_test_18() {
        int[] input = {0,2,0};
        int expected = 0;
        MatcherAssert.assertThat(expected, Is.is(new TrappingRainWater().trappedWater(input)));
    }

    @Test
    public void should_return_1_test_19() {
        int[] input = {5,4,1,2};
        int expected = 1;
        MatcherAssert.assertThat(expected, Is.is(new TrappingRainWater().trappedWater(input)));
    }

    @Test
    public void should_return_6_test_20() {
        int[] input = {3,2,0,1,3,6};
        int expected = 6;
        MatcherAssert.assertThat(expected, Is.is(new TrappingRainWater().trappedWater(input)));
    }

    @Test
    public void should_return_1_test_21() {
        int[] input = {2,3,4,5,4,5,3,2};
        int expected = 1;
        MatcherAssert.assertThat(expected, Is.is(new TrappingRainWater().trappedWater(input)));
    }

    @Test
    public void should_return_1_test_22() {
        int[] input = {4,2,3};
        int expected = 1;
        MatcherAssert.assertThat(expected, Is.is(new TrappingRainWater().trappedWater(input)));
    }

    @Test
    public void should_return_1_test_23() {
        int[] input = {4,3,3,9,3,0,9,2,8,3};
        int expected = 23;
        MatcherAssert.assertThat(expected, Is.is(new TrappingRainWater().trappedWater(input)));
    }

    @Test
    public void should_return_7_test_24() {
        int[] input = {0,7,1,4,6};
        int expected = 7;
        MatcherAssert.assertThat(expected, Is.is(new TrappingRainWater().trappedWater(input)));
    }

    @Test
    public void should_return_35_test_25() {
        int[] input = {9,2,9,3,2,2,1,4,8};
        int expected = 35;
        MatcherAssert.assertThat(expected, Is.is(new TrappingRainWater().trappedWater(input)));
    }
}
