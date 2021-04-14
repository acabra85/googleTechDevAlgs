package com.acabra.gtechdevalgs.litcode.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JustifyTextTest {

    private JustifyText underTest;

    @BeforeEach
    void setUp() {
        this.underTest = new JustifyText();
    }

    @Test
    public void test1() {
        String[] words = {"xxxx", "hh", "nn", "jjjjjjj", "pp", "oooo", "kkkkkkkkkkkkk."};
        int maxWidth = 16;
        String[] expected = {"xxxx    hh    nn",
                "jjjjjjj  pp oooo",
                "kkkkkkkkkkkkk.  "};
        Assertions.assertArrayEquals(expected, underTest.justifyText(words, maxWidth).toArray());
    }

    @Test
    public void test2() {
        String[] words = {"xxxx"};
        int maxWidth = 16;
        String[] expected = {"xxxx            "};
        Assertions.assertArrayEquals(expected, underTest.justifyText(words, maxWidth).toArray());
    }
}