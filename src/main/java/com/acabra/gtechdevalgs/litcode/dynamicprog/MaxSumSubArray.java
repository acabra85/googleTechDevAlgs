package com.acabra.gtechdevalgs.litcode.dynamicprog;

/**
 * Given an array find the maximum sum of all consecutive sub-arrays of size > 0
 * e.g [-3, -2, -1] -> -1
 */
public class MaxSumSubArray {

    /**
     * O(n) implementation taking by discarding negative numbers and using dynammic programming
     * @param nums input array
     * @return max sum of any subarray made of consecutive numbers
     */
    int maxSumOfConsecutiveSubArrays(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            dp[i] = nums[i] + Math.max(dp[i - 1], 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * O(n^2) Implementation by keeping track of array positions of the winning sub-array
     *
     */
    public int maxSubArray2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], Math.max(nums[1], nums[0]+nums[1]));
        int[] prev = new int[nums.length];
        int start = 0;
        int i = 0;
        int max = nums[start];
        while(start < nums.length) {
            prev[start] = nums[start];
            for(i=++start; i<nums.length; ++i) {
                prev[i] = prev[i-1] + nums[i];
                max = java.lang.Math.max(max, Math.max(nums[i], prev[i]));
            }
        }
        return max;
    }
}
