package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TrappingRainWater {
    /**
     * Given an array of columns with elevation [i] indicate the amount of water that can be trapped
     * between them.
     * e.g.
     * 1. given [1,0,2] the amount of water that can be trapped is 1 see the image below b represents the
     * columns and 'w' the water.
     * b
     * b w b
     * <p>
     * 2. [2, 0, 1, 3] return 3
     * <p>
     * b
     * b w w b
     * b w b b
     *
     * @param elevation an int array indicating the height of each column
     * @return the amount of water that can be traped (cells o width 1 and height 1 containing water)
     */
    public int trappedWater(int[] elevation) {
        if (null == elevation) throw new NullPointerException("Given elevation must not be null");
        if (elevation.length <= 2) return 0;
        List<Elevations> elevations = processElevations(elevation);
        AtomicInteger water = new AtomicInteger(0);
        for (int i = 1; i < elevation.length - 1; i++) {
            Elevations iElevations = elevations.get(i-1);
            water.addAndGet(getWater(elevation[i], elevation[iElevations.leftIndex], elevation[iElevations.rightIndex]));
        }
        return water.get();
    }

    private int getWater(int elevation, int maxLeft, int maxRight) {
        if (elevation < maxLeft && elevation < maxRight) {
            if (maxLeft == maxRight) return maxRight - elevation;
            return Math.min(maxRight, maxLeft) - elevation;
        }
        return 0;
    }

    private List<Elevations> processElevations(int[] elevation) {
        List<Elevations> elevationList = new ArrayList<>(elevation.length-2);

        int idx = 0;
        int val = elevation[idx];
        for (int i = 1; i < elevation.length - 1; i++) {
            elevationList.add(new Elevations(idx, -1));
            if (elevation[i] >= val) {
                val = elevation[i];
                idx = i;
            }
        }

        idx = elevation.length - 1;
        val = elevation[idx];
        for (int i = elevation.length - 2; i > 0; i--) {
            elevationList.set(i - 1, elevationList.get(i-1).completeRight(idx));
            if (elevation[i] >= val) {
                val = elevation[i];
                idx = i;
            }
        }
        return elevationList;
    }

    public class Elevations {
        final int leftIndex;
        final int rightIndex;

        public Elevations(int leftIndex, int rightIndex) {
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
        }

        @Override
        public String toString() {
            return "{" + leftIndex+ "," + rightIndex + "}";
        }

        public Elevations completeRight(int idx) {
            return new Elevations(this.leftIndex, idx);
        }
    }
}
