package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.Arrays;

public class LargestTime {

    //Given an array arr of 4 digits, find the latest 24-hour time that can be made using each digit exactly once.
    public String findMaxTime(int[] arr) {
        return bruteForce(arr);
    }

    private String bruteForce(int[] arr) {
        MyClock clock = MyClock.midnight();
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

        private MyClock() {
            this.h  = 23;
            this.m = 59;
        }

        private void aMinuteEarlier() {
            if (this.h + this.m == 0) {
                throw new RuntimeException("we can't go back one day!!");
            }
            if(this.m ==  0) {
                --this.h;
                this.m = 59;
            } else {
                --this.m;
            }
        }

        public boolean canGoBack() {
            return h+m>0;
        }

        public String toString() {
            return (this.h < 10 ? "0" + h : h) + ":" + (this.m < 10 ? "0" + m : m);
        }

        static MyClock midnight() {
            return new MyClock();
        }

        public boolean isMadeExactlyWith(int[] arr) {
            int[] copy = Arrays.copyOf(arr, arr.length);
            for(int digit: asDigits()) {
                if(!in(copy, digit)) {
                    return false;
                }
            }
            return true;
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

        private int[] asDigits() {
            return new int[]{(h / 10), (h % 10), (m / 10), (m % 10)};
        }
    }
}
