package com.acabra.gtechdevalgs.litcode.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecodeStringTest {

    DecodeString underTest;

    @BeforeEach
    public void setup() {
        underTest = new DecodeString();
    }

    @Test
    public void mustReturn_accaccacc() {
        Assertions.assertEquals("accaccacc", underTest.decodeString("3[a2[c]]"));
    }
}