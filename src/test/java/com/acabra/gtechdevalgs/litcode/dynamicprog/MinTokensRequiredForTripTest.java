package com.acabra.gtechdevalgs.litcode.dynamicprog;

import com.acabra.gtechdevalgs.TestUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MinTokensRequiredForTripTest {
    private MinTokensRequiredForTrip underTest;

    @BeforeEach
    public void setup() {
        underTest = new MinTokensRequiredForTrip();
    }

    @Test
    public void mustReturn8() {
        //given
        int[][] input = {
                {-5, 3, -4},
                {-2, -6, 1},
                {1, 10, -4}
        };
        int expected = 8;
        //when
        int actual = underTest.minimalTokensToReachTarget(input);
        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void mustReturn6() {
        //given
        int[][] input = {
                {-5, 3, -4},
                {-2, 300, -299},
                {1, -298, -4}
        };
        int expected = 6;
        //when
        int actual = underTest.minimalTokensToReachTarget(input);
        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void mustReturn7() {
        //given
        int[][] input = TestUtils.parseStringToIntMatrix("[[-2,-3,3],[-5,-10,1],[10,30,-5]]", 3);
        int expected = 7;
        //when
        int actual = underTest.minimalTokensToReachTarget(input);
        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void mustReturn1_0() {
        //given
        int[][] input = {{0}};
        int expected = 1;
        //when
        int actual = underTest.minimalTokensToReachTarget(input);
        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void mustReturn1_1() {
        //given
        int[][] input = {{100}};
        int expected = 1;
        //when
        int actual = underTest.minimalTokensToReachTarget(input);
        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void mustReturn1_2() {
        //given
        int[][] input = {
                {1, -1, 5},
                {-3, -7, -5},
                {-2, 8, 0},
        };
        int expected = 1;
        //when
        int actual = underTest.minimalTokensToReachTarget(input);
        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void mustReturn1_3() {
        //given
        int[][] input = {
                {2},
                {1},
        };
        int expected = 1;
        //when
        int actual = underTest.minimalTokensToReachTarget(input);
        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

}