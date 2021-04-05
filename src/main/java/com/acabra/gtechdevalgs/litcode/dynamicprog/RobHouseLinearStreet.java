package com.acabra.gtechdevalgs.litcode.dynamicprog;

public class RobHouseLinearStreet {

    /**
     * N consecutive houses are located on one side of a street,
     * given the money inside each house, return the maximum amount of money
     * that a thief can take by breaking into the houses without triggering the
     * neighbor alarm (Neighbor alarm is triggered when two consecutive houses
     * are broken into).
     */
    public int rob(int[] houses) {
        if(null == houses || houses.length == 0) return 0;
        switch (houses.length) {
            case 1: return houses[0];
            case 2: return Math.max(houses[0], houses[1]);
            case 3: return Math.max(houses[1], houses[0] + houses[2]);
            default:
                return solve(houses, 0, houses.length);
        }
    }

    static int solve(int[] houses, int start, int end) {
        int t0 = 0;
        int t1 = 0;
        for (int i = start; i < end; ++i) {
            int tmp = t0;
            t0 = Math.max(houses[i] + t1, t0);
            t1 = tmp;
        }
        return t0;
    }
}
