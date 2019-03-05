package com.acabra.gtechdevalgs.litcode.arrays;

import org.junit.Assert;
import org.junit.Test;

public class TrappingRainWaterTest {

    @Test
    public void should_return_6_test_1() {
        int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
        int expected = 6;
        Assert.assertEquals(expected, new TrappingRainWater().trappedWater(input));
    }

    @Test
    public void should_return_3_test_2() {
        int[] input = {2, 0, 1, 3};
        int expected = 3;
        Assert.assertEquals(expected, new TrappingRainWater().trappedWater(input));
    }

    @Test
    public void should_return_1_test_3() {
        int[] input = {1,0,2};
        int expected = 1;
        Assert.assertEquals(expected, new TrappingRainWater().trappedWater(input));
    }

    @Test
    public void should_return_0_test_4() {
        int[] input = {1,2,1};
        int expected = 0;
        Assert.assertEquals(expected, new TrappingRainWater().trappedWater(input));
    }

    @Test
    public void should_return_16_test_5() {
        int[] input = {3,0,2,0,1,0,2,0,3};
        int expected = 16;
        Assert.assertEquals(expected, new TrappingRainWater().trappedWater(input));
    }

    @Test
    public void should_return_16_test_6() {
        int[] input = {3,0,2,0,1,0,2,0,3};
        int expected = 16;
        Assert.assertEquals(expected, new TrappingRainWater().trappedWater(input));
    }

    @Test
    public void should_return_0_test_7() {
        int[] input = {};
        int expected = 0;
        Assert.assertEquals(expected, new TrappingRainWater().trappedWater(input));
    }

    @Test(expected = NullPointerException.class)
    public void should_fail_8() {
        new TrappingRainWater().trappedWater(null);
    }

    @Test
    public void should_return_7_test_9() {
        int[] input = {2,0,3,0,3,0,2};
        int expected = 7;
        Assert.assertEquals(expected, new TrappingRainWater().trappedWater(input));
    }

    @Test
    public void should_return_0_test_10() {
        int[] input = {1,2};
        int expected = 0;
        Assert.assertEquals(expected, new TrappingRainWater().trappedWater(input));
    }

    @Test
    public void should_return_0_test_11() {
        int[] input = {0,0,0,0,0,0};
        int expected = 0;
        Assert.assertEquals(expected, new TrappingRainWater().trappedWater(input));
    }

    @Test
    public void should_return_0_test_12() {
        int[] input = {0,0,1,1,1,0};
        int expected = 0;
        Assert.assertEquals(expected, new TrappingRainWater().trappedWater(input));
    }

    @Test
    public void should_return_3_test_13() {
        int[] input = {3,0,2,0,1,0};
        int expected = 3;
        Assert.assertEquals(expected, new TrappingRainWater().trappedWater(input));
    }
}
