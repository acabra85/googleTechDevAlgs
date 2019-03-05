package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class SubstringAtMostKDistinct {

    @SuppressWarnings("Duplicates")
    public String substringAtMostKDistinct(String s, int k) {
        if (null == s) throw new NullPointerException("invalid input: s is null");
        if (s.length() == 0 || k <= 0) return "";
        if (distinctChars(s) <= k) return s;

        Candidate candidate = null;
        Candidate max = null;
        int windStart = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freqMap.merge(s.charAt(i), 1, Integer::sum);
            if (freqMap.size() > k) { //we surpassed the amount of distinct keys
                candidate = Candidate.of(windStart, i);
                max = (null == max) ? candidate : max.max(candidate); // record a candidate if needed
                windStart = reduceTheMap(freqMap, s, windStart, k);
            }
        }
        max = max.max(Candidate.of(windStart, s.length()));
        return s.substring(max.start, max.end);
    }

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

    private static class Candidate {
        final int start;
        final int end;
        private final int size;

        private Candidate(int start, int end) {
            this.start = start;
            this.end = end;
            this.size = end-start;
        }

        static Candidate of(int start, int end) {
            //if (start > end || start < 0) throw new IllegalArgumentException("Creating invalid start:" + start + " must be less than end:" + end);
            return new Candidate(start, end);
        }

        Candidate max(Candidate other) {
            return size > other.size ? this : other;
        }
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
