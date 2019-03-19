package com.acabra.gtechdevalgs.litcode.arrays;

import com.acabra.gtechdevalgs.QuickUnion;

import java.util.HashMap;
import java.util.Map;

public class SimilarSentencesQuickUnion {

    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (null == words1 || null == words2 || words1.length != words2.length) return false;
        Map<String, Integer> index = new HashMap<>();
        int count = 0;
        QuickUnion qu = new QuickUnion(pairs.length * 2);
        for (String[] pair : pairs) {
            if (!index.containsKey(pair[0])) {
                index.put(pair[0], count++);
            }
            if (!index.containsKey(pair[1])) {
                index.put(pair[1], count++);
            }
            qu.unite(index.get(pair[0]), index.get(pair[1]));
        }
        for (int i = 0; i < words1.length; i++) {
            String w1 = words1[i];
            String w2 = words2[i];
            if (w1.equals(w2)) continue;
            if (!index.containsKey(w1) || !index.containsKey(w2) ||
                !qu.find(index.get(w1), index.get(w2))) {
                return false;
            }
        }
        return true;
    }
}
