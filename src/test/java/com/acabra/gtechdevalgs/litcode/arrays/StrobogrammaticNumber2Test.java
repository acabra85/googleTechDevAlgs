package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StrobogrammaticNumber2Test {

    private StrobogrammaticNumber2 underTest;

    @BeforeEach
    public void setup() {
        underTest = new StrobogrammaticNumber2();
    }

    @Test
    public void test() {
        List<String> actual = underTest.findStrobogrammatic(3);
        Set<String> expected = new HashSet<>(
                Arrays.asList("101", "111", "181", "609", "619", "689", "808", "818", "888", "906", "916", "986"));
        Assertions.assertEquals(expected.size(), actual.size());
        for (String s : actual) {
            Assertions.assertTrue(expected.contains(s));
        }
    }

}