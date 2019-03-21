package com.acabra.gtechdevalgs.litcode.arrays;

import com.acabra.gtechdevalgs.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class TwoSum {

    private Map<Integer, Pair<Integer, Integer>> nums;
    private Map<Integer, Integer> freqMap;
    private int count;
    private boolean firstCall;
    private final BiFunction<Integer, Integer, Integer> ADD_FUNCTION = new BiFunction<Integer, Integer, Integer>() {
        @Override
        public Integer apply(Integer a, Integer b) {
            return a + b;
        }
    };

    /**
     * Given an array of numbers return the indexes of the elements that sum equals target
     * @param nums array of numbers
     * @param target the target sum
     * @return index of the elements that sum up to target or -1,-1 if none exist.
     */
    public int[] twoSum(int[] nums, int target) {
        int[] ans = {-1, -1};
        if (null == nums || nums.length < 2) return ans;
        Map<Integer, Integer> itemToIndexMap = new HashMap<>();
        itemToIndexMap.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            Integer otherIndex = itemToIndexMap.get(target - nums[i]);
            itemToIndexMap.put(nums[i], i);
            if (null != otherIndex) {
                ans[0] = otherIndex;
                ans[1] = i;
                return ans;
            }
        }
        return ans;
    }

    /** Initialize your data structure here. */
    public TwoSum() {
        this.count = 0;
        this.firstCall = true;
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(this.firstCall) lazyInitialize();
        this.nums.put(number, new Pair<>(number, this.count++));
        this.freqMap.merge(number, 1, ADD_FUNCTION);
    }

    private void lazyInitialize() {
        this.firstCall = false;
        this.freqMap = new HashMap<>();
        this.nums = new HashMap<>();
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        if(firstCall) return false;
        for (Map.Entry<Integer, Pair<Integer, Integer>> sum : this.nums.entrySet()) {
            Pair<Integer, Integer> complement = this.nums.get(value - sum.getKey());
            //if we contain the complement and is in a different position or if is the same position but the number
            //is present in the structure more than once
            if (null != complement && (!complement.right.equals(sum.getValue().right) ||
                    this.freqMap.get(sum.getValue().left)>1)) {
                return true;
            }
        }
        return false;
    }
}
