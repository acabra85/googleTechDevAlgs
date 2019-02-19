package com.acabra.gtechdevalgs.litcode;

/**
 * Given two arrays find the intersection pairOf both (repeated elements are allowed)
 */
public class ArrayIntersection {

    private int[] removeOccurrence(int[] arr, int indexOccurrence) {
        int[] newArr = new int[arr.length - 1];
        for (int i = 0, j=0; i < arr.length; i++) {
            if (i != indexOccurrence) {
                newArr[j++] = arr[i];
            }
        }
        return newArr;
    }

    private int binarySearch(int x, int[] arr, int l, int r) {
        if(r >= l) {
            int mid = l + (r - l)/2;
            if (arr[mid] == x) return mid;
            if (x > arr[mid])
                return binarySearch(x, arr, mid + 1, r);
            return binarySearch(x, arr, l, mid - 1);
        }
        return -1;
    }

    public int[] intersectOld(int[] nums1, int[] nums2) {
        if (nums1==null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[]{};
        Nums nums = new Nums(nums1, nums2);
        int[] smaller = nums.smaller;
        int[] larger = nums.larger;

        java.util.Arrays.sort(smaller);
        int[] intersection = new int[smaller.length];
        int xIndex = 0;
        for (int i = 0; i < larger.length; i++) {
            int indexOccurrence = binarySearch(larger[i], smaller, 0, smaller.length - 1);
            if(indexOccurrence >= 0) {
                intersection[xIndex++] = larger[i];
                smaller = removeOccurrence(smaller, indexOccurrence);
            }
        }
        return java.util.Arrays.copyOfRange(intersection, 0, xIndex);
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1==null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[]{};
        Nums nums = new Nums(nums1, nums2);
        int[] smaller = nums.smaller;
        int[] larger = nums.larger;

        java.util.Map<Integer, java.util.concurrent.atomic.AtomicInteger> freqMap = buildFreqMap(smaller);

        java.util.LinkedList<Integer> intersection = new java.util.LinkedList<>();
        for (int i = 0; i < larger.length; i++) {
            java.util.concurrent.atomic.AtomicInteger atomicInteger = freqMap.get(larger[i]);
            if(null != atomicInteger && atomicInteger.get()>0) {
                intersection.add(larger[i]);
                atomicInteger.decrementAndGet();
            }
        }
        return toPrimitiveArray(intersection);
    }

    private int[] toPrimitiveArray(java.util.LinkedList<Integer> intersection) {
        int[] ints = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            ints[i] = intersection.get(i);
        }
        return ints;
    }

    private java.util.Map<Integer, java.util.concurrent.atomic.AtomicInteger> buildFreqMap(int[] smaller) {
        java.util.Map<Integer, java.util.concurrent.atomic.AtomicInteger> freqMap = new java.util.HashMap<>();
        for (int i = 0; i < smaller.length; i++) {
            java.util.concurrent.atomic.AtomicInteger item = freqMap.get(smaller[i]);
            if (null == item) {
                freqMap.put(smaller[i], new java.util.concurrent.atomic.AtomicInteger(1));
            } else {
                freqMap.get(smaller[i]).incrementAndGet();
            }
        }
        return freqMap;
    }

    private static class Nums {
        int[] smaller;
        int[] larger;

        public Nums(int[] nums1, int[] nums2) {
            if (nums1.length> nums2.length) {
                this.larger = nums1;
                this.smaller = nums2;
            } else {
                this.larger = nums2;
                this.smaller = nums1;
            }
        }
    }
}
