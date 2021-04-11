package com.acabra.gtechdevalgs.litcode.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SumKToNumArrayTest {

    private SumKToNumArray underTest;

    @BeforeEach
    void setUp() {
        this.underTest = new SumKToNumArray();
    }

    @Test
    public void mustReturn1234() {
        int k = 34;
        int[] num = {1, 2, 0, 0};
        Integer[] expected = {1,2,3,4};
        Assertions.assertArrayEquals(expected, underTest.sumKToArray(num, k).toArray());
    }

    @Test
    public void mustReturn10000_a() {
        int k = 1;
        int[] num = {9,9,9,9};
        Integer[] expected = {1, 0, 0, 0, 0};
        Assertions.assertArrayEquals(expected, underTest.sumKToArray(num, k).toArray());
    }

    @Test
    public void mustReturn10000_b() {
        int k = 9999;
        int[] num = {1};
        Integer[] expected = {1, 0, 0, 0, 0};
        Assertions.assertArrayEquals(expected, underTest.sumKToArray(num, k).toArray());
    }
}