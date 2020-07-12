package com.acabra.gtechdevalgs.google;

import java.util.*;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class CountGoodIndexesTreeMap {

    private final TreeMap<Integer, Integer> tree = new TreeMap<>();
    boolean[] odd;

    final List<Integer> goodIndexes = new ArrayList<>();
    final IntConsumer intConsumer = new IntConsumer() {
        @Override
        public void accept(int idx) {
            if (odd[idx]) {
                goodIndexes.add(idx);
            }
        }
    };

    /**
     * Find the total amount of indexes that are considered good.
     * An index is good if you start at that index and can make valid jump across until the end of array is reached.
     * Jumps (from i to j) [(classified as odd (1st jump, 3rd jump, ) or even (2nd Jump, 4th Jump)] and are valid if:
     * 1. i < j
     * 2. If jump is odd:  if A[i] <= A[j] and A[j] is minimal (if multiple choose smallest j)
     * 3. If jump is even: if A[i] >= A[j] and A[j] is maximal (if multiple choose smallest j)
     *
     * @param A array to jump on
     * @return total count of good indexes in the given array A
     */
    public Collection<Integer> oddEvenJumps(int[] A) {
        if (A == null || A.length == 0) return Collections.emptyList();
        if (A.length == 1) return Collections.singletonList(0);
        if (A.length == 2) return A[1] >= A[0] ? Arrays.asList(0, 1) : Collections.singletonList(1);

        final int nMinusOne = A.length - 1;
        boolean[] even = new boolean[A.length];
        this.odd = new boolean[A.length];
        even[nMinusOne] = true;
        odd[nMinusOne] = true;
        tree.put(A[nMinusOne], nMinusOne);

        for (int i = A.length - 2; i >= 0; --i) {
            int val = A[i];
            if (tree.containsKey(val)) {
                odd[i] = even[tree.get(val)];
                even[i] = odd[tree.get(val)];
            } else {
                Integer lowerKey = tree.lowerKey(val);
                Integer higherKey = tree.higherKey(val);
                if (lowerKey != null) {
                    even[i] = odd[tree.get(lowerKey)];
                }
                if (higherKey != null) {
                    odd[i] = even[tree.get(higherKey)];
                }
            }
            tree.put(val, i);
        }
        IntStream.range(0, A.length).forEach(intConsumer);
        return goodIndexes;
    }
}
