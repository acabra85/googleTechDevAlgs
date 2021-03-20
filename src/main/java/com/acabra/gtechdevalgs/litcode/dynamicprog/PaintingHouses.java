package com.acabra.gtechdevalgs.litcode.dynamicprog;

import java.util.HashMap;

public class PaintingHouses {

    private int[][] costs;
    private HashMap<String, Integer> memo;
    private int totalHouses;

    /**
     * Given the costs of painting a house with a particular color int[house][color]
     * return the minimum cost of painting all consecutive houses given that no 2 consecutive
     * houses have the same color.
     * @param costs
     * @return int minimum total cost of painting all houses
     */
    public int minCost(int[][] costs) {
        this.costs = costs;
        this.totalHouses = costs.length;
        this.memo = new HashMap<>();
        return Math.min(paint(0, 0), Math.min(paint(0, 1), paint(0, 2)));
    }

    private int paint(int house, int color) {
        String key = house +"-"+color;
        Integer memVal = memo.get(key);
        if (memVal != null) {
            return memVal;
        }
        int val = costs[house][color];
        if (house < totalHouses - 1) {
            if(color == 0) {
                val += Math.min(paint(house+1, 1), paint(house+1, 2));
            } else if(color == 1) {
                val += Math.min(paint(house+1, 0), paint(house+1, 2));
            } else {
                val += Math.min(paint(house+1, 0), paint(house+1, 1));
            }
        }
        memo.put(key, val);
        return val;
    }
}
