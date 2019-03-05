package com.acabra.gtechdevalgs.litcode.arrays;

public class SearchSortedArrayUnknownSize {

    public int binarySearch(ArrayReader reader, int target) {
        return this.binarySearch(reader, target, findArraySize(reader));
    }

    /**
     * Use binary search to find the size of the array
     * @param reader
     * @return
     */
    private int findArraySize(ArrayReader reader) {
        //now lets go to smaller sizes
        int hi = Integer.MAX_VALUE;
        int lo = 0;
        int mid;
        while (lo <= hi) {
            mid = (hi + lo) / 2;
            if (reader.get(mid) == Integer.MAX_VALUE) { //we look to the left
                hi = mid - 1;
            } else { //is a valid value look to the right
                lo = mid + 1;
            }
        }
        return hi + 1;
    }

    private int binarySearch(ArrayReader arrayReader, int target, int size) {
        int lo = 0, hi = size - 1;
        int mid;
        while (lo <= hi) {
            mid = (hi + lo) / 2;
            if (arrayReader.get(mid) == target) return mid;
            if (arrayReader.get(mid) > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static class ArrayReader {
        final int[] array;

        private ArrayReader(int[] array) {
            this.array = array;
        }

        static public ArrayReader of(int[] array) {
            if (null == array) throw new NullPointerException("given array is null");
            return new ArrayReader(array);
        }

        public int get(int k) {
            if (k >= array.length)
                return Integer.MAX_VALUE;
            return array[k];
        }
    }
}
