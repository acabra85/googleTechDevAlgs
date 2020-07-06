package com.acabra.gtechdevalgs.google;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class CountGoodIndexes {

    // cache that tells me if being odd//even where to jump
    // an array of size 2 [oddJump, evenJump]
    // 0 represents unknown, -1 represents no, > 0 represents next index
    int[][] cache;

    /**
     * Find the total amount of indexes that are considered good.
     * An index is good if you start at that index and can make valid jump across until the end of array is reached.
     * Jumps (from i to j) [(classified as odd (1st jump, 3rd jump, ) or even (2nd Jump, 4th Jump)] and are valid if:
     *  1. i < j
     *  2. If jump is odd:  if A[i] <= A[j] and A[j] is minimal (if multiple choose smallest j)
     *  3. If jump is even: if A[i] >= A[j] and A[j] is maximal (if multiple choose smallest j)
     * @param A array to jump on
     * @return total count of good indexes in the given array A
     */
    public int oddEvenJumps(int[] A) {
        if (A == null || A.length == 0) return 0;
        if (A.length == 1) return 1;
        if (A.length == 2) return A[1] >= A[0] ? 2 : 1;

        // end of the array is always a good start
        cache = new int[A.length][2];
        cache[A.length - 1] = new int[]{A.length - 1, A.length - 1};

        // set as unknown the rest of the positions of the cache
        for (int i = 0; i < A.length - 1; i++) {
            cache[A.length - 1] = new int[]{0, 0};
        }

        // good starting indexes
        int goodIndexes = 0;
        for (int i = A.length - 1; i >= 0; --i) {
            if (canReachEnd(i, A)) {
                ++goodIndexes;
            }
        }
        return goodIndexes;
    }

    private boolean canReachEnd(int idx, int[] arr) {
        boolean oddJump = true;
        int nextJump = next(true, idx, arr);
        while (nextJump > 0 && nextJump < arr.length - 1) {
            oddJump = !oddJump;
            nextJump = next(oddJump, nextJump, arr);
        }
        return nextJump == arr.length - 1;
    }


    private static final Comparator<Map.Entry<Integer, Integer>> ODD_JUMP_COMP = new Comparator<Map.Entry<Integer, Integer>>() {
        @Override
        public int compare(Map.Entry<Integer, Integer> k, Map.Entry<Integer, Integer> v) {
            return !k.getValue().equals(v.getValue()) ?
                    Integer.compare(k.getValue(), v.getValue())
                    : Integer.compare(k.getKey(), v.getKey());
        }
    };
    private static final Comparator<Map.Entry<Integer, Integer>> EVEN_JUMP_COMP = new Comparator<Map.Entry<Integer, Integer>>() {
        @Override
        public int compare(Map.Entry<Integer, Integer> k, Map.Entry<Integer, Integer> v) {
            return !k.getValue().equals(v.getValue()) ?
                    Integer.compare(v.getValue(), k.getValue())
                    : Integer.compare(k.getKey(), v.getKey());
        }
    };

    private int next(boolean oddJump, int i, int[] arr) {
        if (i == arr.length - 1) {
            return arr.length - 1;
        }
        int cacheIdx = oddJump ? 0 : 1;
        if (cache[i][cacheIdx] == 0) {
            PriorityQueue<Map.Entry<Integer, Integer>> pq = null;
            for (int j = i + 1; j < arr.length; ++j) {
                if (oddJump && arr[i] <= arr[j]) {
                    if (pq == null) {
                        pq = new PriorityQueue<>(ODD_JUMP_COMP);
                    }
                    pq.offer(Map.entry(j, arr[j]));
                }
                if (!oddJump && arr[i] >= arr[j]) {
                    if (pq == null) {
                        pq = new PriorityQueue<>(EVEN_JUMP_COMP);
                    }
                    pq.offer(Map.entry(j, arr[j]));
                }
            }
            if (pq != null) {
                cache[i][cacheIdx] = pq.remove().getKey();
            } else {
                cache[i][cacheIdx] = -1;
            }
        } else {
            return cache[i][cacheIdx];
        }
        return cache[i][cacheIdx];
    }
}