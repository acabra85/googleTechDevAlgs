package com.acabra.gtechdevalgs.litcode.arrays;

public class BinarySearch {

    /**
     * Returns the index of the position of the target value in the given array
     *
     * @param nums   sorted array of integers
     * @param target the value to look for within the array
     * @return -1 if target value not present in the array or the index if present
     */
    public int binarySearch(int[] nums, int target) {
        if (null == nums || nums.length == 0) return -1; //target not present
        int lo = 0, hi = nums.length - 1;
        int mid;
        while (lo <= hi) {
            mid = (hi + lo) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
}
