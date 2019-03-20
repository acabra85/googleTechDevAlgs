package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = {-1, -1};
        if (null == nums || nums.length < 2) return ans;
        Map<Integer, Integer> itemToIndexMap = new HashMap<>();
        itemToIndexMap.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            Integer otherIndex = itemToIndexMap.get(complement(target, nums[i]));
            itemToIndexMap.put(nums[i], i);
            if (null != otherIndex) {
                ans[0] = otherIndex;
                ans[1] = i;
                return ans;
            }
        }
        return ans;
    }

    private Integer complement(int target, int i) {
        return target - i;
    }
}
