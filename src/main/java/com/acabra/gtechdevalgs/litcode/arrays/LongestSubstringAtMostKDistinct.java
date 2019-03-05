package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.*;

public class LongestSubstringAtMostKDistinct {

    /**
     * Use a moving window across the given string to find the best candidate
     * @param s string to look into for the longest substring
     * @param k in representing the maximum amount of distinct characters in the substring
     * @return length of the longest substring with at most k characters within s
     */
    @SuppressWarnings("Duplicates")
    public int sizeLongestSubstringAtMostKDistinct(String s, int k) {
        if (null == s) throw new NullPointerException("invalid input: s is null");
        if (s.length() == 0 || k <= 0) return 0;
        if (distinctChars(s) <= k) return s.length();

        int max = Integer.MIN_VALUE;
        int windStart = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freqMap.merge(s.charAt(i), 1, Integer::sum);
            if (freqMap.size() > k) { //we surpassed the amount of distinct keys
                max = Math.max(max, i-windStart);
                windStart = reduceTheMap(freqMap, s, windStart, k);
            }
        }
        max = Math.max(max, s.length()-windStart);
        return max;
    }

    @SuppressWarnings("Duplicates")
    private int reduceTheMap(Map<Character, Integer> freqMap, String s, int windStart, int targetK) {
        int newIndex = windStart;
        while (freqMap.size() > targetK) {
            Character charAt = s.charAt(newIndex++);
            if (freqMap.get(charAt) > 1) {
                freqMap.put(charAt, freqMap.get(charAt) - 1);
            } else {
                freqMap.remove(charAt);
            }
        }
        return newIndex;
    }

    @SuppressWarnings("Duplicates")
    private int distinctChars(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return set.size();
    }
}
