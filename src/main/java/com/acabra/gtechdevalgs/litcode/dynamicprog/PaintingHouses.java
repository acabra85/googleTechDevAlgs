package com.acabra.gtechdevalgs.litcode.dynamicprog;

import java.util.HashMap;

public class PaintingHouses {

    private int[][] costs;
    private HashMap<String, Integer> memo;
    private int totalHouses;
    private int colors;

    /**
     * Given the costs of painting a house with a particular color int[house][color]
     * return the minimum cost of painting all consecutive houses given that no 2 consecutive
     * houses have the same color.
     * @param costs
     * @return int minimum total cost of painting all houses
     */
    public int minCost(int[][] costs) {if(null == costs || costs.length == 0) return -1;
        this.costs = costs;
        this.totalHouses = costs.length;
        this.colors = costs[0].length;
        this.memo = new HashMap<>();
        int cost = Integer.MAX_VALUE;
        for(int color=0; color<colors; ++color) {
            cost = Math.min(cost, paint(0, color));
        }
        return cost;
    }

    private int paint(int house, int color) {
        String key = house + "-" + color;
        Integer memVal = memo.get(key);
        if (null != memVal) return memVal;
        int val = costs[house][color];
        if (house < totalHouses - 1) {
            val += calculateNextVal(house + 1, color);
        }
        memo.put(key, val);
        return val;
    }

    private int calculateNextVal(int house, int color) {
        int val = Integer.MAX_VALUE;
        for(int diffColor=0;diffColor<colors;++diffColor) {
            if(diffColor!=color) {
                val = Math.min(val, paint(house, diffColor));
            }
        }
        return val;
    }
}
