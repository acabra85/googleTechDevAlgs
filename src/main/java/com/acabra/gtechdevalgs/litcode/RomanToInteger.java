package com.acabra.gtechdevalgs.litcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    private static Map<Character, Integer> symbolToValue = new HashMap<Character, Integer>(){{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public static int fromWeirdObject(WeirdClassOutOfMyControl wcoomc) {
        return romanToInt(wcoomc.calculateRomanLetters());
    }

    public static int romanToInt(String s) {
        int total = 0;
        char[] arr =  s.toCharArray();
        int curr = 0;
        int next = 0;
        for(int i = 0; i < arr.length - 1; ++i) {
            curr = symbolToValue.get(arr[i]);
            next = symbolToValue.get(arr[i+1]);
            if (next > curr) {
                total += next - curr;
                ++i;
            } else {
                total += curr;
            }
        }
        next = symbolToValue.get(arr[arr.length - 1]);
        curr = symbolToValue.get(arr[arr.length - 2]);
        if (next <= curr) {
            total+=next;
        }
        return total;
    }

    public static class WeirdClassOutOfMyControl {

        private final String letters;

        public WeirdClassOutOfMyControl(String letters) {
            this.letters = letters;
        }

        public String calculateRomanLetters() {
            return letters;
        }
    }
}
