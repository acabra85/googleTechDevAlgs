package com.acabra.gtechdevalgs.litcode.dynamicprog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RobHouseLinearStreetTest {

    private RobHouseLinearStreet underTest;

    @BeforeEach
    public void setup() {
        underTest = new RobHouseLinearStreet();
    }

    @Test
    public void mustReturn4() {
        int[] houses = {2, 3, 2};
        int expected = 4;
        Assertions.assertEquals(expected, underTest.rob(houses));
    }

    @Test
    public void mustReturn5() {
        int[] houses = {2, 5, 2};
        int expected = 5;
        Assertions.assertEquals(expected, underTest.rob(houses));
    }

    @Test
    public void mustReturn16() {
        int[] houses = {2, 5, 2, 3, 6, 8};
        int expected = 16;
        Assertions.assertEquals(expected, underTest.rob(houses));
    }

    @Test
    public void mustReturn17() {
        int[] houses = {2, 5, 2, 3, 12, 8};
        int expected = 17;
        Assertions.assertEquals(expected, underTest.rob(houses));
    }

    @Test
    public void mustReturn0() {
        int expected = 0;
        Assertions.assertEquals(expected, underTest.rob(null));
    }

    @Test
    public void mustReturn0_a() {
        int[] houses = {};
        int expected = 0;
        Assertions.assertEquals(expected, underTest.rob(houses));
    }


}