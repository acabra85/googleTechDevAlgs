package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitIntoBasket {

    private final static int BASKET_COUNT = 2;

    /**
     * In a row of trees the tree[i] type is produced by tree i.
     *  e.g. [1,2,3]  First tree contains fruit 1, second tree is of type 2, and third tree of type 3
     *       [1,2,1]  First and third trees are of type 1, and second tree is of type 2
     * Collector has 2 baskets
     * Starting at the tree of choice perform until stop the following steps:
     *  1.  Add one piece of fruit to one of the basket (basket only fruits of same type),
     *      if not possible (unavailable type for the given baskets) stop.
     *  2.  move to the next tree to the right of the current one, if no tree present to the right stop.
     * @param tree 1 <= tree.length <= 40000 and 0<= tree[i] < tree.length
     * @return int the total amount of fruit that can be collected following that procedure
     */
    public int totalFruit(int[] tree) {
        String str = buildString(tree);
        String substr = substringAtMostKDistinct(str, BASKET_COUNT);
        int startPoint = str.indexOf(substr);
        Set<Integer> baskets = new HashSet<>(2);
        int fruitsCollected = 0;
        for (int i = startPoint; i<tree.length; i++) {
            baskets.add(tree[i]);
            if (baskets.size() > BASKET_COUNT) break;
            fruitsCollected++;
        }
        return fruitsCollected;
    }

    private String buildString(int[] tree) {
        StringBuilder sb = new StringBuilder();
        for (int type : tree) {
            sb.append((char)type);
        }
        return sb.toString();
    }

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
