package com.acabra.gtechdevalgs.litcode.dynamicprog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PaintingHousesTest {

    @Test
    public void mustReturn10(){
        int[][] costs = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        Assertions.assertEquals(10, new PaintingHouses().minCost(costs));
    }

    @Test
    public void mustReturn0() {
        int[][] costs = {{19, 0, 17}};
        Assertions.assertEquals(0, new PaintingHouses().minCost(costs));
    }

}