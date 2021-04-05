package com.acabra.gtechdevalgs.litcode.dynamicprog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RobHousesCircularStreetTest {

    RobHousesCircularStreet underTest;

    @BeforeEach
    public void setup() {
        underTest = new RobHousesCircularStreet();
    }

    @Test
    public void mustReturn3_a() {
        int[] money = {2, 3, 2};
        Assertions.assertEquals(3, underTest.rob(money));
    }

    @Test
    public void mustReturn4_a() {
        int[] money = {1,2,3,1};
        Assertions.assertEquals(4, underTest.rob(money));
    }

    @Test
    public void mustReturn11() {
        int[] money = {2,7,9,3,1};
        Assertions.assertEquals(11, underTest.rob(money));
    }

    @Test
    public void mustReturn16() {
        int[] money = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        Assertions.assertEquals(16, underTest.rob(money));
    }

    @Test
    public void mustReturn103() {
        int[] money = {1, 3, 1, 3, 100};
        Assertions.assertEquals(103, underTest.rob(money));
    }

    @Test
    public void mustReturn0_a() {
        Assertions.assertEquals(0, underTest.rob(null));
    }

    @Test
    public void mustReturn0_b() {
        int[] money = {};
        Assertions.assertEquals(0, underTest.rob(money));
    }
}