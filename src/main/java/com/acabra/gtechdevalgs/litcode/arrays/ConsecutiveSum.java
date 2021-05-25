package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.ArrayDeque;

public class ConsecutiveSum {

    // input: unsorted array of nonnegative integers, integer representing sum.
// output: continuous subarray with elements adding to the given sum.

    // example:
    // 	input: arr = (1, 5, 3, 0, 7, 2, 4), sum = 12
    // 	output: (3, 0, 7, 2)
    public int[] consecutiveSum(int[] arr, int sum) {
        if(null == arr || arr.length == 0) return new int[]{};
        if(arr.length == 1 && arr[0] == sum) return arr;

        int start = 0;
        int end = 0;
        int actualSum  = 0;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        while (end < arr.length && sum != actualSum) {
            if(actualSum < sum) {
                actualSum += arr[end];
                dq.addLast(arr[end]);
                ++end;
            } else if(actualSum > sum) {
                actualSum -= arr[start];
                ++start;
                dq.removeFirst();
            }
            if(actualSum == sum) {
                return toIntArray(dq);
            }
        }
        return new int[]{};
    }

    private int[] toIntArray(ArrayDeque<Integer> dq) {
        int[] ints = new int[dq.size()];
        for (int i = 0; i < ints.length; ++i) {
            ints[i] = dq.removeFirst();
        }
        return ints;
    }
}
