package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.*;

public class SimilarSentences {

    /**
     *
     * @param words1
     * @param words2
     * @param pairs
     * @return
     */
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs, boolean transitivity) {
        if (null == words1 || null == words2 || words1.length != words2.length) return false;
        Map<String, Set<String>> symmetryMap = buildSimilarityMap(pairs);
        for (int i = 0; i < words1.length; i++) {
            if (!areSimilar(words1[i], words2[i], symmetryMap, transitivity)) {
                return false;
            }
        }
        return true;
    }

    private Map<String, Set<String>> buildSimilarityMap(String[][] pairs) {
        Map<String, Set<String>> map = new HashMap<>();
        for (String[] pair : pairs) {
            addToSet(pair[0], pair[1], map);
        }
        return map;
    }

    private void addToSet(String w1, String w2, Map<String, Set<String>> map) {
        if (w1.equals(w2)) return; //we don't store equal words
        map.putIfAbsent(w1, new HashSet<>());
        map.putIfAbsent(w2, new HashSet<>());
        map.get(w1).add(w2);
        map.get(w2).add(w1);
    }

    private boolean areSimilar(String w1, String w2, Map<String, Set<String>> symmetryMap, boolean transitivity) {
        return w1.equals(w2) ||
                (symmetryMap.get(w1) != null && symmetryMap.get(w1).contains(w2)) ||
                (symmetryMap.get(w2) != null && symmetryMap.get(w2).contains(w1)) ||
                (transitivity && transitivityLookUp(w1, w2, symmetryMap));
    }

    private boolean transitivityLookUp(String source, String target, Map<String, Set<String>> map) {
        Stack<String> q = new Stack<>();
        Set<String> seen = new HashSet<>();
        seen.add(source);
        q.push(source);
        String parentKey;
        while (q.size() > 0) {
            parentKey = q.pop();
            if (parentKey.equals(target)) {
                addToSet(source, target, map);
                return true;
            }
            if (map.containsKey(parentKey)) {
                for (String iWord : map.get(parentKey)) {
                    if (!seen.contains(iWord)) {
                        seen.add(iWord);
                        q.push(iWord);
                    }
                }
            }
        }
        return false;
    }
}
