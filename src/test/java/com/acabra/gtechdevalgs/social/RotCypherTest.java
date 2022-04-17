package com.acabra.gtechdevalgs.social;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class RotCypherTest {

    private RotCypher underTest;
    @BeforeEach
    void setUp() {
        underTest = new RotCypher();
    }

    @Test
    void rotationalCipher() {
        String input = "AbC-967";
        int rotationFactor = 3;
        String expected = "DeF-290";

        Assertions.assertThat(underTest.rotationalCipher(input, rotationFactor)).isEqualTo(expected);
    }
}