package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.ArrayDeque;

public class ConsecutiveSum {

    // input: unsorted array of non-negative integers, integer representing sum.
    // output: continuous subarray with elements adding to the given sum.

    // example:
    // 	input: arr = (1, 5, 3, 0, 7, 2, 4), sum = 12
    // 	output: (3, 0, 7, 2)
    public int[] consecutiveSum(int[] arr, int sum) {
        if(null == arr || arr.length == 0) return new int[]{};
        if(arr.length == 1 && arr[0] == sum) return arr;
        SumValue actualSum = getSumValue(arr, sum);
        if (actualSum.isTarget()) {
            return actualSum.resultAsSubsequence();
        }
        return new int[]{};
    }

    // returns the first occurrence in the array of the consecutive terms that add
    // to the target sum [start, end]
    // example:
    // 	input: arr = (1, 5, 3, 0, 7, 2, 4), sum = 12
    // 	output: [2, 5]
    public int[] consecutiveSumIndex(int[] arr, int sum) {
        if(null == arr || arr.length == 0) return new int[]{};
        if(arr.length == 1 && arr[0] == sum) return arr;
        SumValue actualSum = getSumValue(arr, sum);
        if (actualSum.isTarget()) {
            return actualSum.result();
        }
        return new int[]{};
    }

    private int[] toIntArray(ArrayDeque<Element> dq) {
        int[] ints = new int[dq.size()];
        for (int i = 0; i < ints.length; ++i) {
            ints[i] = dq.removeFirst().value;
        }
        return ints;
    }

    private SumValue getSumValue(int[] arr, int sum) {
        SumValue actualSum = new SumValue(sum);
        for (int i = 0; i < arr.length; ++i) {
            if (actualSum.bigger()) {
                actualSum.fix();
            }
            if (actualSum.isTarget()) {
                return actualSum;
            }
            actualSum.add(arr[i], i);
        }
        if (actualSum.bigger()) {
            actualSum.fix();
        }
        return actualSum;
    }

    private record Element(int value, int idx) {}

    private class SumValue {
        Integer val = null;
        ArrayDeque<Element> elements = new ArrayDeque<>();
        final int target;

        public SumValue(int target) {
            this.target = target;
        }

        public boolean isTarget() {
            return this.val != null && val == this.target;
        }

        public boolean bigger() {
            return val != null && val > this.target;
        }

        public void add(int toAdd, int idx) {
            elements.add(new Element(toAdd, idx));
            val = val == null ? toAdd : val + toAdd;
        }

        public int[] result() {
            return new int[]{elements.getFirst().idx, elements.getLast().idx};
        }

        public void fix() {
            while (val > target && !elements.isEmpty()) {
                val -= elements.removeFirst().value;
            }
            if (elements.isEmpty()) {
                val = null;
            }
        }

        public int[] resultAsSubsequence() {
            return toIntArray(this.elements);
        }
    }
}
