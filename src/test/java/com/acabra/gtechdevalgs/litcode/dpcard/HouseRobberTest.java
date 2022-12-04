package com.acabra.gtechdevalgs.litcode.dpcard;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HouseRobberTest {
    private HouseRobber underTest;

    @BeforeEach
    public void setup() {
        underTest = new HouseRobber();
    }

    @Test
    public void shouldReturn12() {
        //given
        int[] input = {2, 7, 9, 3, 1};
        int expected = 12;
        //when
        int actual = underTest.rob(input);
        //then
        Assertions.assertThat(actual)
                .isEqualTo(expected);
    }

}