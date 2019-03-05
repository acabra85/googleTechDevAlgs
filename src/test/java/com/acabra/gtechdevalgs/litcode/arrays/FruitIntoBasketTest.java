package com.acabra.gtechdevalgs.litcode.arrays;

import org.junit.Assert;
import org.junit.Test;

public class FruitIntoBasketTest {

    @Test
    public void should_return_3_test_1() {
        int[] input = {1,2,1};
        int expected = 3;
        Assert.assertEquals(expected, new FruitIntoBasket().totalFruit(input));
    }

    @Test
    public void should_return_3_test_2() {
        int[] input = {0,1,2,2};
        int expected = 3;
        Assert.assertEquals(expected, new FruitIntoBasket().totalFruit(input));
    }

    @Test
    public void should_return_4_test_3() {
        int[] input = {1,2,3,2,2};
        int expected = 4;
        Assert.assertEquals(expected, new FruitIntoBasket().totalFruit(input));
    }

    @Test
    public void should_return_5_test_4() {
        int[] input = {3,3,3,1,2,1,1,2,3,3,4};
        int expected = 5;
        Assert.assertEquals(expected, new FruitIntoBasket().totalFruit(input));
    }

    @Test
    public void should_return_5_test_5() {
        int[] input = {1,9,1,8,22,0,22,19,19,2,19,6,6,19,2,20,2,9,9,9,9,16,19,16,19,11,19,0,19,19};
        int expected = 5;
        Assert.assertEquals(expected, new FruitIntoBasket().totalFruit(input));
    }
}
