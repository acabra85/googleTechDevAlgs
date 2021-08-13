package com.acabra.gtechdevalgs.litcode.dynamicprog;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int optimalLIS(int[] nums) {
        return longestIncreasingSubsequence(nums, false);
    }

    public int dpLIS(int[] nums) {
        return longestIncreasingSubsequence(nums, true);
    }

    private int longestIncreasingSubsequence(int[] nums, boolean dp) {
        if(null == nums || nums.length == 0) return 0;
        int N = nums.length;
        if(nums.length == 1) return 1;
        if(nums.length == 2) return nums[0] < nums[1] ? 2 : 1;
        return dp ? solveDP(nums, N) : solveOptimal(nums, N);
    }

    /**
     * Uses dynamic programming additional O(N) memory to calculate incrementally the length of LIS
     */
    private int solveDP(int[] nums, int N) {
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

    /**
     * Builds a subsequence (not necessarily ordered) of equal size to the longest increasing subsequence.
     * Leverages the use of binary search to achieve runtime complexity of O(N*Log(N))
     */
    private int solveOptimal(int[] nums, int N) {
        ArrayList<Integer> set = new ArrayList<>() {{
            add(nums[0]);
        }};
        for (int i = 1; i < N; i++) {
            if(nums[i] > set.get(set.size() - 1)) {
                set.add(nums[i]);
            } else {
                indexOfSmallestElementGreaterOrEqual(set, nums[i]);
            }
        }
        return set.size();
    }

    private void indexOfSmallestElementGreaterOrEqual(ArrayList<Integer> set, int num) {
        int start = 0, end = set.size()-1;
        int mid;
        while (end > start) {
            mid = (end + start) / 2;
            if(set.get(mid) == num) {
                return;
            }
            if (set.get(mid) > num) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        set.set(start, num);
    }
}
