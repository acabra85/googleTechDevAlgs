package com.acabra.gtechdevalgs.litcode.dynamicprog;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int longestIncreasingSubsequence(int[] nums) {
        if(null == nums || nums.length == 0) return 0;
        int N = nums.length;
        if(nums.length == 1) return 1;
        if(nums.length == 2) return nums[0] < nums[1] ? 2 : 1;
        int[] memo =  new int[N];
        Arrays.fill(memo, 1);
        int max = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    memo[i] = Math.max(memo[j] + 1, memo[i]);
                }
            }
            max = Math.max(memo[i], max);
        }
        return max;
    }
}
