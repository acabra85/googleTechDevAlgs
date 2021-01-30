package com.acabra.gtechdevalgs.litcode;

import com.acabra.gtechdevalgs.TestUtils;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

public class KEmptySlotsTest {

    public static class KEmptySlotsTestUnit {
        final int[] flowers;
        final int k;

        public KEmptySlotsTestUnit(int[] flowers, int k) {
            this.flowers = flowers.clone();
            this.k = k;
        }
    }

    @Test
    public void should_return_two() {
        int[] flowers = {1,3,2};
        int k = 1;
        MatcherAssert.assertThat(2, Is.is(new KEmptySlots().kEmptySlots(flowers, k)));
    }
    @Test
    public void should_return_eight() {
        int[] flowers = {6,5,8,9,7,1,10,2,3,4};
        int k = 2;
        MatcherAssert.assertThat(8, Is.is(new KEmptySlots().kEmptySlots(flowers, k)));
    }

    @Test
    public void should_return_minus_one_01() {
        KEmptySlotsTestUnit unit = TestUtils.readKEmptySlotsTestInput("kemptyslotstest_test_01.txt");
        MatcherAssert.assertThat(-1, Is.is(new KEmptySlots().kEmptySlots(unit.flowers, unit.k)));
    }
    @Test
    public void should_return_minus_one() {
        int[] flowers = {1,2,3};
        int k = 1;
        MatcherAssert.assertThat(-1, Is.is(new KEmptySlots().kEmptySlots(flowers, k)));
    }

    @Test
    public void should_return_minus_one_invalid_input_k_greater_possible_flowers_length_1() {
        int[] flowers = {1,3};
        int k = 1;
        MatcherAssert.assertThat(-1, Is.is(new KEmptySlots().kEmptySlots(flowers, k)));
    }

    @Test
    public void should_return_minus_one_invalid_input_k_greater_possible_flowers_length_2() {
        int[] flowers = {1,2,3};
        int k = 4;
        MatcherAssert.assertThat(-1, Is.is(new KEmptySlots().kEmptySlots(flowers, k)));
    }

    @Test
    public void should_return_minus_one_invalid_input_k_greater_possible_flowers_length_3() {
        int[] flowers = {1,2,3};
        int k = 3;
        MatcherAssert.assertThat(-1, Is.is(new KEmptySlots().kEmptySlots(flowers, k)));
    }

    @Test
    public void should_return_minus_one_invalid_input_k_greater_possible_flowers_length_4() {
        int[] flowers = {1,2,3};
        int k = 5;
        MatcherAssert.assertThat(-1, Is.is(new KEmptySlots().kEmptySlots(flowers, k)));
    }

    @Test
    public void should_return_minus_one_invalid_input_k_less_than_zero() {
        int[] flowers = {1,2,3};
        int k = -1;
        MatcherAssert.assertThat(-1, Is.is(new KEmptySlots().kEmptySlots(flowers, k)));
    }

    @Test
    public void should_return_minus_one_invalid_input_flowers_null() {
        int[] flowers = null;
        int k = 1;
        MatcherAssert.assertThat(-1, Is.is(new KEmptySlots().kEmptySlots(flowers, k)));
    }

}
