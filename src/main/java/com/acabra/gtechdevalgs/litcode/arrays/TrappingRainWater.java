package com.acabra.gtechdevalgs.litcode.arrays;

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
        int[] left = getLeft(elevation);
        int[] right = getRight(elevation);
        int water = 0;
        for (int i = 1; i < elevation.length - 1; i++) {
            water += getWater(left[i-1], right[i-1], elevation[i]);
        }
        return water;
    }

    private int getWater(int maxLeft, int maxRight, int elevation) {
        return Math.max(0, Math.min(maxRight, maxLeft) - elevation);
    }

    private int[] getRight(int[] elevation) {
        int[] right = new int[elevation.length - 2];
        int val = elevation[elevation.length - 1];
        for (int i = elevation.length - 2; i > 0; i--) {
            right[i-1] = val;
            val = Math.max(val, elevation[i]);
        }
        return right;
    }

    private int[] getLeft(int[] elevation) {
        int[] left = new int[elevation.length - 2];
        int val = elevation[0];
        for (int i = 1; i < elevation.length - 1; i++) {
            left[i-1] = val;
            val = Math.max(val, elevation[i]);
        }
        return left;
    }
}
