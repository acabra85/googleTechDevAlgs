package com.acabra.gtechdevalgs.litcode.dynamicprog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RussianDollEnvelopesTest {

    private RussianDollEnvelopes underTest;

    @BeforeEach
    void setUp() {
        this.underTest = new RussianDollEnvelopes();
    }

    @Test
    public void mustReturn3() {
        int[][] input = {{6, 5}, {7, 5}, {7, 8}, {3, 4}};
        Assertions.assertEquals(3, underTest.maxStackedEnvelopes(input));
    }

    @Test
    public void mustReturn1() {
        int[][] input = {{2, 2}, {2, 2}, {2, 2}, {2, 2}};
        Assertions.assertEquals(1, underTest.maxStackedEnvelopes(input));
    }
}