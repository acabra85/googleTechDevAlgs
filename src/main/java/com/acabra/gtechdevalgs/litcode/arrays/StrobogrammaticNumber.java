package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.HashMap;

public class StrobogrammaticNumber {

    final static HashMap<Character, Character> rotable = new HashMap<Character, Character>() {{
        put('0', '0');
        put('1', '1');
        put('6', '9');
        put('8', '8');
        put('9', '6');
    }};

    /**
     * A number is strobogrammatic if the 180-rotated version is the same as the original version
     * @param num
     * @return
     */
    public boolean isStrobogrammatic(String num) {
        char[] reversed = new char[num.length()];
        char[] arr = num.toCharArray();
        for(int i= arr.length -1, r=0; i>=0; --i,++r) {
            Character rotated = rotable.get(arr[i]);
            if(null == rotated) {
                return false;
            }
            reversed[r] = rotated;
        }
        for(int i=0;i<arr.length;++i) {
            if(reversed[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }
}
