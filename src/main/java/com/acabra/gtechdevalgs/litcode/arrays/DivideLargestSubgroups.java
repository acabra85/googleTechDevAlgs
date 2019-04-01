package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.*;

public class DivideLargestSubgroups {

    /**
     * Given an array of identifiers find the sizes of the smallest subgroups of consecutive ids. No subgroups share
     * ids with each other.
     * e.g :
     * in:  {a, b, c}
     * out: {1, 1, 1}
     * Explanation: since no characters repeat the smallest size for each group is 1.
     *
     * in:  {a, b, a, c}
     * out: {3, 1}
     * Explanation: since the first 3 characters form a group containing all the distinct characters
     *              the group is 3 and then for the left character the group size is 1.
     *
     * @param ids the ids to search for
     * @return the sizes of the largest smallest containing all characters
     */
    public int[] findSubgroups(char[] ids) {
        if (null == ids || ids.length == 0) return new int[0];
        if (ids.length == 1) {
            int[] result = {1};
            return result;
        }
        Map<Character, Integer> lastOccurrenceIndex = new HashMap<>();
        for (int i = 0; i < ids.length; i++) {
            lastOccurrenceIndex.put(ids[i], i);
        }
        int idx = 0;
        List<Integer> answer = new ArrayList<>();
        int cumulative = 0;
        while(idx < ids.length) {
            char id = ids[idx];
            int max = lastOccurrenceIndex.get(id);
            for (int i = idx; i <= lastOccurrenceIndex.get(id); i++) {
                if (id != ids[i]) {
                    max = Math.max(max, lastOccurrenceIndex.get(ids[i]));
                }
            }
            idx = max + 1;
            if (answer.isEmpty())  {
                answer.add(idx);
                cumulative = idx;
            } else {
                answer.add(idx - cumulative);
                cumulative += answer.get(answer.size() - 1);
            }
        }
        return toArray(answer);
    }

    private int[] toArray(List<Integer> answer) {
        int[] asArray = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            asArray[i] = answer.get(i);
        }
        return asArray;
    }
}
