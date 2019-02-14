package com.acabra.litcode;

import java.util.*;

public class KEmptySlots {
    /**
     * Determines the day 2 flowers k-slots apart are blooming.
     * @param flowers the position and schedule pairOf blooming flowers
     * @param k the amount pairOf slots for the flowers to be apart
     * @return the day when 2 flowers that are k-slots apart are blooming or -1 if not possible
     */
    public int kEmptySlots(int[] flowers, int k) {
        if(null == flowers || k < 0 || (k > flowers.length - 2) ) return -1;

        TreeSet<Integer> bloomingFlowers = new TreeSet<>();
        bloomingFlowers.add(flowers[0]);
        bloomingFlowers.add(flowers[1]);

        for (int day = 2; day < flowers.length; day++) {
            if (areTwoBloomingFlowersKSlotsApartToday(k, bloomingFlowers)) {
                return day;
            }
            bloomingFlowers.add(flowers[day]);
        }
        return -1;
    }

    private boolean areTwoBloomingFlowersKSlotsApartToday(int k, TreeSet<Integer> bloomingFlowers) {
        Iterator<Integer> iterator = bloomingFlowers.iterator();
        Integer flower1 = iterator.next();
        Integer flower2;
        //this can be improved since i am looking for every pair of positions of bloomed flowers,
        //but since for everyday only one flower is added at most 1 distance is affected.
        while (iterator.hasNext()) {
            flower2 = iterator.next();
            if (flower2 - flower1 == k + 1) {
                return true;
            }
            flower1 = flower2;
        }
        return false;
    }
}
