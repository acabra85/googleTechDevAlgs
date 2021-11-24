package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.Arrays;

public class LargestTime {

    //Given an array arr of 4 digits, find the latest 24-hour time that can be made using each digit exactly once.
    public String findMaxTime(int[] arr) {
        return bruteForce(arr);
    }
    private static final MyClock INSTANCE = new MyClock();

    private String bruteForce(int[] arr) {
        if(arr == null || arr.length == 0) return "";
        Arrays.sort(arr);
        if(arr[0] > 2) return "";
        MyClock clock = INSTANCE.toMidnight();
        while (!clock.isMadeExactlyWith(arr)) {
            if(!clock.canGoBack()) {
                return "";
            }
            clock.aMinuteEarlier();
        }
        return clock.toString();
    }

    public static class MyClock {
        private int m;
        private int h;
        private final int[] asDigits;

        private MyClock() {
            this.h = 23;
            this.m = 59;
            this.asDigits = new int[]{2,3,5,9};
        }

        private void aMinuteEarlier() {
            if(this.m ==  0) {
                adjustHour();
                resetToMaxMinutes();
            } else {
                adjustMinute();
            }
        }

        private void resetToMaxMinutes() {
            this.m = 59;
            asDigits[2] = 5;
            asDigits[3] = 9;
        }

        private void adjustHour() {
            adjustDigits(h, 0, 1);
            --this.h;
        }

        private void adjustMinute() {
            adjustDigits(m, 2, 3);
            --this.m;
        }

        private void adjustDigits(int current, int idxD, int idxU) {
            if(current % 10 == 0) {
                --asDigits[idxD];
                asDigits[idxU] = 9;
            } else {
                --asDigits[idxU];
            }
        }

        public boolean canGoBack() {
            return h+m>0;
        }

        public String toString() {
            return asDigits[0] + "" + asDigits[1] + ":" + asDigits[2] + "" + asDigits[3];
        }

        private MyClock toMidnight() {
            this.asDigits[0] = 2;
            this.asDigits[1] = 3;
            this.asDigits[2] = 5;
            this.asDigits[3] = 9;
            this.h = 23;
            this.m = 59;
            return this;
        }

        public boolean isMadeExactlyWith(int[] arr) {
            int[] copy = copy(arr);
            for(int digit: asDigits) {
                if(!in(copy, digit)) {
                    return false;
                }
            }
            return true;
        }

        private int[] copy(int[] arr) {
            return new int[]{arr[0], arr[1], arr[2], arr[3]};
        }

        private boolean in(int[] copy, int digit) {
            for (int i = 0; i < copy.length; i++) {
                if(copy[i] == digit) {
                    copy[i] = -1;
                    return true;
                }
            }
            return false;
        }
    }
}