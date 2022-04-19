package com.acabra.gtechdevalgs.social;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SmallestArrayInKSwapsTest {
    private SmallestArrayInKSwaps underTest;

    @BeforeEach
    public void setup() {
        underTest = new SmallestArrayInKSwaps();
    }

    @Test
    public void test1() {
        //given
        int[] input = {5, 3, 1};
        int k = 2;
        int[] expected = {1, 5, 3};
        //when
        int[] actual = underTest.findMinArray(input, k);
        //then
        Assertions.assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    public void test2() {
        //given
        int[] input = {8, 9, 11, 2, 1};
        int k = 3;
        int[] expected = {2, 8, 9, 11, 1};
        //when
        int[] actual = underTest.findMinArray(input, k);
        //then
        Assertions.assertThat(actual)
                .isEqualTo(expected);
    }

}