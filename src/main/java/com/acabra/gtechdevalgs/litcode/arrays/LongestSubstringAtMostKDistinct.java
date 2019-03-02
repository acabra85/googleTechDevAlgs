package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringAtMostKDistinct {

    public int sizeLongestSubstringAtMostKDistinct(String s, int k) {
        if(null == s) throw new NullPointerException("invalid input: s is null");
        if (s.length() == 0 || k <= 0) return 0;
        if (distinctChars(s) <= k) return s.length();
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int max = Integer.MIN_VALUE;
        Integer iCount;
        int start = 0;
        for (int i = 0; i < s.length() && (max < s.length() - i || freqMap.size() <= k); i++) {
            char key = s.charAt(i);
            iCount = freqMap.get(key);
            if (iCount == null) {
                freqMap.put(key, 1);
            } else {
                freqMap.put(key, freqMap.get(key) + 1);
            }
            if (freqMap.size() > k || (freqMap.size() == k && i == s.length()-1)) {
                int delta = freqMap.size() > k ? i : i + 1;
                max = Math.max(max, delta - start);
                freqMap = new HashMap<>();
                i = start;
                start++;
            }
        }
        return max >= 0 ? max : 0;
    }

    private int distinctChars(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return set.size();
    }
}
