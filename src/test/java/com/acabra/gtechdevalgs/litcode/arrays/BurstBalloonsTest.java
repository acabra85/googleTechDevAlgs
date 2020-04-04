package com.acabra.gtechdevalgs.litcode.arrays;

import org.junit.Assert;
import org.junit.Test;

public class BurstBalloonsTest {

    @Test
    public void should_return_167_test_01() {
        int expected = 167;
        int[] balloons = {3,1,5,8};
        Assert.assertEquals(expected, new BurstBalloons().maxCoins(balloons));
    }
    @Test
    public void should_return_167_test_02() {
        int expected = 1849648;
        int[] balloons = {35,16,83,87,84,59,48,41,20,54};
        Assert.assertEquals(expected, new BurstBalloons().maxCoins(balloons));
    }

    @Test
    public void should_return_10_test_03() {
        int expected = 10;
        int[] balloons = {1, 5};
        Assert.assertEquals(expected, new BurstBalloons().maxCoins(balloons));
    }

    @Test
    public void should_return_10_test_04() {
        int expected = 1086136;
        int[] balloons = {9,76,64,21,97,60};
        Assert.assertEquals(expected, new BurstBalloons().maxCoins(balloons));
    }

    @Test
    public void should_return_10_test_05() {
        int expected = 1092908;
        int[] balloons = {76, 9,64,21,97,60};
        Assert.assertEquals(expected, new BurstBalloons().maxCoins(balloons));
    }
}
