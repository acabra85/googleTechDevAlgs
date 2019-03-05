package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class MedianTwoSortedArrays {
    public double median(int[] arr1, int[] arr2) {
        if (null == arr1 || null == arr2) throw new NullPointerException("input must be non-null");
        if (arr1.length == 0) return medianSingle(arr2);
        if (arr2.length == 0) return medianSingle(arr1);
        Data data1 = new Data(arr1);
        Data data2 = new Data(arr2);
        PriorityQueue<Data> pq = new PriorityQueue<>();
        if (data1.hasNext()) pq.offer(data1);
        if (data2.hasNext()) pq.offer(data2);
        int mid = (data1.size() + data2.size()) / 2;
        if ((arr1.length + arr2.length )%2 == 0) {
            int last = 0;
            for (int i = 0; i < mid; i++) {
                Data remove = pq.remove();
                last = remove.next();
                if (remove.hasNext()) pq.offer(remove);
            }
            return (last + pq.remove().next()) / 2.0d;
        }
        for (int j = 0; j < mid; j++) {
            Data remove = pq.remove();
            remove.next();
            if (remove.hasNext()) pq.offer(remove);
        }
        return pq.remove().next();
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
        int idx;

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
