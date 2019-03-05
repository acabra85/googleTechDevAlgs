package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class MedianTwoSortedArrays {

    /**
     * Find the median value of two sorted arrays using a min_heap to retrieve the next
     * values until reaching half of them, if the total count is even return the sum of (last + next )/2
     * or else return next
     * @param arr1 the first sorted array
     * @param arr2 second sorted array
     * @return the median
     */
    public double median(int[] arr1, int[] arr2) {
        if (null == arr1 || null == arr2) throw new NullPointerException("input must be non-null");
        if (arr1.length == 0) return medianSingle(arr2);
        if (arr2.length == 0) return medianSingle(arr1);
        PriorityQueue<Data> pq = new PriorityQueue<>();
        pq.offer(new Data(arr1));
        pq.offer(new Data(arr2));
        int totalCount = arr1.length + arr2.length;
        int mid = totalCount / 2;
        int last = 0;
        for (int i = 0; i < mid; i++) {
            Data remove = pq.remove();
            last = remove.next();
            if (remove.hasNext()) pq.offer(remove);
        }
        return (totalCount %2 == 0) ? (last + pq.remove().next()) / 2.0d : pq.remove().next();
    }

    private double medianSingle(int[] arr1) {
        if (arr1.length%2==0) {
            int mid = arr1.length/2;
            return (arr1[mid]+arr1[mid-1])/2.0d;
        }
        return arr1[arr1.length/2];
    }

    private class Data implements Comparable<Data> {
        final int[] arr;
        int idx = 0;

        private Data(int[] arr) {
            this.arr = arr;
        }

        public boolean hasNext() {
            return idx < arr.length;
        }

        public int peek() {
            return arr[idx];
        }

        public int next() {
            if (!hasNext()) throw new NoSuchElementException("no more elements");
            return arr[idx++];
        }


        @Override
        public int compareTo(Data o) {
            return Integer.compare(peek(), o.peek());
        }

        public int size() {
            return arr.length;
        }
    }
}
