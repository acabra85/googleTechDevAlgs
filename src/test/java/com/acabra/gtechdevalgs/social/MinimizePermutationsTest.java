package com.acabra.gtechdevalgs.social;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MinimizePermutationsTest {

    private MinimizePermutations underTest;

    @BeforeEach
    public void setup(){
        underTest = new MinimizePermutations();
    }
    @Test
    public void mustReturn1() {
        //given
        int[] input = {1, 2, 5, 4, 3};
        int expected = 1;

        //when
        int actual = underTest.minOperations(input);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void mustReturn2() {
        //given
        int[] input = {3, 1, 2};
        int expected = 2;

        //when
        int actual = underTest.minOperations(input);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}