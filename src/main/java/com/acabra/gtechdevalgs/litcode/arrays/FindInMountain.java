package com.acabra.gtechdevalgs.litcode.arrays;

public class FindInMountain {

    private Integer[] cache;
    private MountainArray mount;

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int N = mountainArr.length();
        if (N < 3) throw new IllegalArgumentException("invalid mountain");
        this.cache = new Integer[N];
        this.mount = mountainArr;
        int lo = 0;
        int hi = N;
        boolean peakFound = false;
        boolean up = false;
        int idx = 0;
        int curr = 0;
        int targetDownHill = -1;
        while (true) {
            if (lo > hi) {
                throw new IllegalArgumentException("the given mountain has no peak!!!!");
            }
            idx = (lo + hi) / 2;
            if (idx < 0 || idx >= N) return -1;
            curr = get(idx);
            peakFound = (idx - 1 >= 0) && curr > get(idx - 1) && curr > get(idx + 1);
            up = !peakFound && (idx - 1 < 0 || curr > get(idx - 1));
            if (peakFound) {
                break;
            }
            if (curr == target) {
                if (up) {
                    return idx;
                }
                targetDownHill = idx;
            }
            if (up) {
                lo = idx + 1;
            } else {
                hi = idx - 1;
            }
        }
        int peakId = idx;
        if (target == curr) {
            return peakId;
        }
        //----------------------
        int targetUphill = findTarget(0, peakId - 1, target, true, N);
        if (targetUphill >= 0) {
            return targetUphill;
        }
        if (targetDownHill >= 0) return targetDownHill;
        return findTarget(peakId + 1, N, target, false, N);
    }

    private int findTarget(int lo, int hi, int x, boolean up, int N) {
        int curr = 0;
        int idx = -1;
        while (lo <= hi) {
            idx = (lo + hi) / 2;
            if (idx < 0 || idx >= N) return -1;
            curr = get(idx);
            if (x == curr) {
                return idx;
            }
            if (curr > x) {
                if (up) hi = idx - 1;
                else lo = idx + 1;
            } else {
                if (up) lo = idx + 1;
                else hi = idx - 1;
            }
        }
        return -1;
    }

    private int get(int idx) {
        if (this.cache[idx] == null) {
            this.cache[idx] = this.mount.get(idx);
        }
        return this.cache[idx];
    }

    static class MountainArray {

        private static final int MAX_QUERIES = 100;
        private final int[] e;
        private int counter = 0;

        private MountainArray(int[] arr) {
            this.e = arr;
        }

        int get(int idx) {
            if (counter++ >= MAX_QUERIES) {
                throw new UnsupportedOperationException("you reached maximum queries");
            }
            return e[idx];
        }

        int length() {
            return this.e.length;
        }

        static MountainArray ofSize(int start, int size) {
            int[] arr = new int[size];
            int peakId = size / 4;
            int i = 0;
            for (int j = start; i <= peakId; ++i, ++j) {
                arr[i] = j;
            }
            for (int j = arr[peakId] - 1; i < size; ++i, --j) {
                arr[i] = j;
            }
            return new MountainArray(arr);
        }

        public static MountainArray ofSize(int size) {
            return ofSize(0, size);
        }

        public static MountainArray of(int[] ints) {
            return new MountainArray(ints);
        }
    }
}
