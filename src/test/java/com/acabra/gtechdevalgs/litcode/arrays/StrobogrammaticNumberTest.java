package com.acabra.gtechdevalgs.litcode.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StrobogrammaticNumberTest {

    private StrobogrammaticNumber underTest;

    @BeforeEach
    public void setup() {
        underTest = new StrobogrammaticNumber();
    }

    @Test
    public void mustReturnTrueFor69() {
        Assertions.assertTrue(underTest.isStrobogrammatic("69"));
    }

    @Test
    public void mustReturnTrueFor101() {
        Assertions.assertTrue(underTest.isStrobogrammatic("101"));
    }

    @Test
    public void mustReturnFalseFor68() {
        Assertions.assertFalse(underTest.isStrobogrammatic("68"));
    }

    @Test
    public void mustReturnFalseFor48() {
        Assertions.assertFalse(underTest.isStrobogrammatic("48"));
    }
}