package com.acabra.gtechdevalgs.google;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MinimumCostTypingWordTest {

    private MinimumCostTypingWord underTest;

    @BeforeEach
    void setUp() {
        this.underTest = new MinimumCostTypingWord();
    }

    @Test
    void mustReturn3() {
        String word = "CAKE";
        int expected = 3;
        Assertions.assertEquals(expected, underTest.minimalCostToType(word));
    }

    @Test
    void mustReturn6() {
        String word = "HAPPY";
        int expected = 6;
        Assertions.assertEquals(expected, underTest.minimalCostToType(word));
    }

    @Test
    void mustReturn0_a() {
        String word = "AAAZZZ";
        int expected = 0;
        Assertions.assertEquals(expected, underTest.minimalCostToType(word));
    }

    @Test
    void mustReturn0_b() {
        String word = "AZAZAZ";
        int expected = 0;
        Assertions.assertEquals(expected, underTest.minimalCostToType(word));
    }

    @Test
    void mustReturn1_a() {
        String word = "AZAZAZYYYYYYYYYYYYYYYYYYYYYYYY";
        int expected = 1;
        Assertions.assertEquals(expected, underTest.minimalCostToType(word));
    }
}