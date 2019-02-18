package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class FindIndexFirstUniqueChar {

    /**
     * Find the index of the first unique character
     * @param s string to look into
     * @return int representing the index of the first unique character from left-right found
     *         or -1 if non-existent
     */
    public int findIndexFirstUnique(String s) {
        if(null == s || s.length() == 0) return -1;
        HashMap<Character, AtomicInteger> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            AtomicInteger counter = freq.get(curr);
            if (counter == null) {
                freq.put(curr, new AtomicInteger(1));
            } else {
                counter.incrementAndGet();
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq.get(s.charAt(i)).get() == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Fast implementation taking advantage of indexOf and lastIndexOf and assuming a dictionary using only
     * english letters.
     * @param s
     * @return
     */
    public int findIndexFirstUnique_fast(String s) {
        if(null == s || s.length() == 0) return -1;
        int minIndex = s.length(); //initialize in the maximum index which is +1 outside of the array
        for (char c = 'a'; c <= 'z'; c++) {
            int idx = s.indexOf(c);
            if (idx != -1 && s.lastIndexOf(c) == idx) { //character is present
                minIndex = Math.min(minIndex, idx);
            }
        }
        return minIndex != s.length() ? minIndex : -1;
    }

}
