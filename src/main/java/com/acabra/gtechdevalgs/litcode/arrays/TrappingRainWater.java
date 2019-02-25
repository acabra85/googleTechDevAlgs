package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.concurrent.atomic.AtomicInteger;

public class TrappingRainWater {
    /**
     * Given an array of columns with elevation [i] indicate the amount of water that can be trapped
     * between them.
     * e.g.
     * 1. given [1,0,2] the amount of water that can be trapped is 1 see the image below b represents the
     * columns and 'w' the water.
     *        b
     *    b w b
     *
     * 2. [2, 0, 1, 3] return 3
     *
     *          b
     *    b w w b
     *    b w b b
     * @param elevation an int array indicating the height of each column
     * @return the amount of water that can be traped (cells o width 1 and height 1 containing water)
     */
    public int trappedWater(int[] elevation) {
        if (null == elevation) throw new NullPointerException("Given elevation must not be null");
        if (elevation.length <= 2) return 0;
        AtomicInteger trapped = new AtomicInteger();
        int iElev = getNextColumnHigherThan(elevation, 0, 0, 0, false);
        if (iElev == -1) return 0; //no elevated columns
        int jElev = getNextColumnHigherThan(elevation, iElev, 1, elevation[iElev], true);
        if (jElev > 0) {
            while (jElev > 0) {
                waterBetween(iElev, jElev, elevation, trapped);
                iElev = jElev;
                jElev = getNextColumnHigherThan(elevation, iElev, 1, 0, false);
            }
        } else {
            jElev = getNextColumnHigherThan(elevation, iElev, 1, 0, false);
            while (jElev > 0) {
                waterBetween(iElev, jElev, elevation, trapped);
                iElev = jElev;
                jElev = getNextColumnHigherThan(elevation, iElev, 1, 0, false);
            }
        }
        return trapped.get();
    }

    private void waterBetween(int iElev, int jElev, int[] elevation, AtomicInteger trapped) {
        if (jElev - iElev > 1) {
            for (int i = iElev + 1; i < jElev; i++) {
                trapped.addAndGet(Math.min(elevation[jElev], elevation[iElev]) - elevation[i]);
            }
        }
    }

    private int getNextColumnHigherThan(int[] elevation, int start, int offset, int higher, boolean inclusive) {
        for (int i = start + offset; i < elevation.length; i++) {
            if(inclusive ? elevation[i] >= higher : elevation[i] > higher) {
                if(i-start > 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}
