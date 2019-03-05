package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class MedianTwoSortedArrays {

    /**
     * Runs in O(log(min_size_array)), partition in two groups first group with all smaller elements
     * and second group with overall larger elements, when partition completed the median is found
     * in either in the largest element of first group for odd count of total elements or the half
     * of the sum of the largest of first group and the smallest of second group for even count of
     * total elements.
     * @param arr1 the first sorted array of integers
     * @param arr2 second sorted array of integers
     * @return the median of the merged array on integers
     */
    public double median(int[] arr1, int[] arr2) {
        if (null == arr1 || null == arr2) throw new NullPointerException("input must be non-null");
        if (arr1.length == 0) return medianSingle(arr2);
        if (arr2.length == 0) return medianSingle(arr1);

        boolean isA1Larger = arr1.length > arr2.length;
        int[] shorter1 = isA1Larger ? arr2 : arr1; //shorter1 contains the shortest of the two
        int[] larger2 = isA1Larger ? arr1 : arr2; //larger2 contains the largest of the two

        int low = 0;
        int high = shorter1.length;

        int part1, part2, maxLeft1, minRight1, maxLeft2, minRight2;
        while (low <= high) {
            part1 = (low + high) / 2;
            part2 = (shorter1.length + larger2.length + 1) / 2 -part1;

            maxLeft1 = part1 > 0 ? shorter1[part1 - 1] : Integer.MIN_VALUE;
            minRight1 = part1 != shorter1.length ? shorter1[part1] : Integer.MAX_VALUE;

            maxLeft2 = part2 > 0 ? larger2[part2 - 1] : Integer.MIN_VALUE;
            minRight2= part2 != larger2.length ? larger2[part2] : Integer.MAX_VALUE;

            if (maxLeft1 > minRight2) {
                high = part1 - 1;
            } else if (minRight1 < maxLeft2) {
                low = part1 + 1;
            } else { //partition completed
                if ((shorter1.length + larger2.length) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                }
                return Math.max(maxLeft1, maxLeft2);
            }
        }
        return -1;
    }
    /**
     * Find the median value of two sorted arrays using a min_heap to retrieve the next
     * values until reaching half of them, if the total count is even return the sum of (last + next )/2
     * or else return next
     * @param arr1 the first sorted array
     * @param arr2 second sorted array
     * @return the median
     */
    public double median_n(int[] arr1, int[] arr2) {
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
