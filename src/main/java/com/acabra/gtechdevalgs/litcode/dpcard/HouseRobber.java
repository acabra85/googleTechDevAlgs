package com.acabra.gtechdevalgs.litcode.dpcard;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {

    // Given the amount of money in each house find the maximum amount a thief can rob
    // with the restriction that no 2 consecutive houses can be robbed
    public int rob(int[] houseMoney) {
        if (null == houseMoney) return 0;
        return maxMoneyAtHouse(houseMoney.length-1, new Cache<Integer>(houseMoney));
    }

    int maxMoneyAtHouse(int n, Cache<Integer> cache) {
        if(n <= 0) return cache.arr[0];
        if(n == 1) return Math.max(cache.arr[0], cache.arr[1]);
        if(!cache.m.containsKey(n)) {
            // Don't steal from this house so the money is: the total money stolen up to the previous house
            int doNotSteal = maxMoneyAtHouse(n-1, cache);

            // Steal from this house so the money is: the money of the house plus the money two houses ago
            int steal = cache.arr[n] + maxMoneyAtHouse(n-2, cache);

            int maxMoney = Math.max(doNotSteal, steal);
            cache.m.put(n, maxMoney);
        }
        return cache.m.get(n);

    }
    private static class Cache<T> {
        final Map<Integer, T> m;
        final int[] arr;
        Cache(int[] arr) {
            this.arr = arr;
            this.m = new HashMap<>();
        }
    }
}
