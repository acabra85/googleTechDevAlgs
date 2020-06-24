package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.*;

public class SumClosestToK {

    public static class SumClosestToKResult {
        final int a;
        final int b;
        final int dist;
        final int sum;

        private SumClosestToKResult(int a, int b, int k) {
            this.a = a;
            this.b = b;
            this.sum = a+b;
            this.dist = Math.abs(k  - sum);
        }

        public static SumClosestToKResult of(int a, int b, int k) {
            return new SumClosestToKResult(a, b, k);
        }
    }

    /**
     * @param a first array from where one element of the resulting pair must be drawn
     * @param b second array from where one element of the resulting pair must be drawn
     * @param k target sum
     * @return pair of elements in each array such that their sum is closest to k
     */
    public List<SumClosestToKResult> solve(int[] a, int[] b, int k) {
        PriorityQueue<SumClosestToKResult> pq = new PriorityQueue<SumClosestToKResult>(new Comparator<SumClosestToKResult>() {
            @Override
            public int compare(SumClosestToKResult o1, SumClosestToKResult o2) {
                return Integer.compare(o1.dist, o2.dist);
            }
        });
        Arrays.sort(a);
        Arrays.sort(b);
        //n log n
        int aIdx = a.length - 1; //max index on a
        int bIdx = 0; //min index on b

        SumClosestToKResult pair = null;
        int cdist = Integer.MAX_VALUE;
        while (aIdx >=0 && bIdx < b.length) {
            pair = SumClosestToKResult.of(a[aIdx], b[bIdx], k);
            if (pair.sum <= k) {
                ++bIdx;
            } else {
                --aIdx;
            }
            pq.offer(pair);
        }
        if (pq.isEmpty()) return Collections.emptyList();
        List<SumClosestToKResult> res = new ArrayList<>();
        res.add(pq.remove());
        while (!pq.isEmpty()) {
            if (pq.peek().dist == res.get(res.size()-1).dist) {
                res.add(pq.remove());
            } else {
                return res;
            }
        }
        return res;
    }
}
