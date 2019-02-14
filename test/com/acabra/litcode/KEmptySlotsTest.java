package com.acabra.litcode;

import org.junit.Assert;
import org.junit.Test;

public class KEmptySlotsTest {

    @Test
    public void should_return_two() {
        int[] flowers = {1,3,2};
        int k = 1;
        Assert.assertEquals(2, new KEmptySlots().kEmptySlots(flowers, k));
    }
    @Test
    public void should_return_minus_one() {
        int[] flowers = {1,2,3};
        int k = 1;
        Assert.assertEquals(-1, new KEmptySlots().kEmptySlots(flowers, k));
    }

    @Test
    public void should_return_minus_one_invalid_input_k_greater_possible_flowers_length_1() {
        int[] flowers = {1,3};
        int k = 1;
        Assert.assertEquals(-1, new KEmptySlots().kEmptySlots(flowers, k));
    }

    @Test
    public void should_return_minus_one_invalid_input_k_greater_possible_flowers_length_2() {
        int[] flowers = {1,2,3};
        int k = 4;
        Assert.assertEquals(-1, new KEmptySlots().kEmptySlots(flowers, k));
    }

    @Test
    public void should_return_minus_one_invalid_input_k_greater_possible_flowers_length_3() {
        int[] flowers = {1,2,3};
        int k = 3;
        Assert.assertEquals(-1, new KEmptySlots().kEmptySlots(flowers, k));
    }

    @Test
    public void should_return_minus_one_invalid_input_k_greater_possible_flowers_length_4() {
        int[] flowers = {1,2,3};
        int k = 5;
        Assert.assertEquals(-1, new KEmptySlots().kEmptySlots(flowers, k));
    }

    @Test
    public void should_return_minus_one_invalid_input_k_less_than_zero() {
        int[] flowers = {1,2,3};
        int k = -1;
        Assert.assertEquals(-1, new KEmptySlots().kEmptySlots(flowers, k));
    }

    @Test
    public void should_return_minus_one_invalid_input_flowers_null() {
        int[] flowers = null;
        int k = 1;
        Assert.assertEquals(-1, new KEmptySlots().kEmptySlots(flowers, k));
    }

}
