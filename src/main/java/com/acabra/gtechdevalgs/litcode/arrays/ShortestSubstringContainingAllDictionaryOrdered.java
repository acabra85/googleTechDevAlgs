package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ShortestSubstringContainingAllDictionaryOrdered {

    /**
     * In linear time finds if there dictionary letters are contained in the proper order on the given string
     * @param str the string to look into
     * @param dict the dictionary of valid characters
     * @return true if the dictionary values are all present in the string (not necessary together )
     * e.g. dict = {a, b, c}
     *      str = "aabaac" valid since since a b c appear in the dict order
     */
    public boolean isOrderedDictionaryContained(String str, char[] dict) {
        if (str == null || dict == null || str.length() < dict.length) return false;
        if (str.length() == 0) return true;
        int idx = 0;
        for (int i = 0; i < str.length() && idx < dict.length; i++) {
            if (str.charAt(i) == dict[idx]) {
                idx++;
            }
        }
        return idx==dict.length;
    }

    /**
     * Find the minimal length string that contains all characters in the dictionary order using brute force
     * @param str the string to look into
     * @param dict the dictionary of valid characters
     * @return the minimal substring.
     */
    public String minimalLengthStringContainingAllCharactersInDictionary_bf(String str, char[] dict) {
        String minimal = str;
        String candidate = str;
        for (int i = 0; i < str.length() && isOrderedDictionaryContained(candidate, dict); i++) { //trim right
            if (candidate.length() < minimal.length()) {
                minimal = candidate;
            }
            candidate = str.substring(i);
        }
        String trimEnd = minimal.substring(0, minimal.length()-1);
        candidate = trimEnd;
        for (int i = trimEnd.length(); i >= 0 && isOrderedDictionaryContained(candidate, dict);i--) {
            if (candidate.length() < minimal.length()) {
                minimal = candidate;
            }
            candidate = trimEnd.substring(0, i);
        }

        String minimal2 = str;
        candidate = minimal2;
        for (int i = str.length(); i >= 0 && isOrderedDictionaryContained(candidate, dict); i--) { //trim left
            if (candidate.length() < minimal2.length()) {
                minimal2 = candidate;
            }
            candidate = str.substring(0, i);
        }

        String trimStart = minimal2.substring(1);
        candidate = minimal2;
        for (int i = 0; i < trimStart.length() && isOrderedDictionaryContained(candidate, dict); i++) {
            if (candidate.length() < minimal2.length()) {
                minimal2 = candidate;
            }
            candidate = trimStart.substring(i);
        }

        return minimal.length() < minimal2.length() ? minimal : minimal2;
    }

    private Map<Character, Integer> buildDictMap(char[] dict) {
        Map<Character, Integer> idxDictMap = new HashMap<>();
        for (int i = 0; i < dict.length; i++) {
            Character curr = dict[i];
            Integer idx = idxDictMap.get(curr);
            if (idx != null) {
                throw new IllegalArgumentException("Dictionary contains duplicates :" + curr);
            } else {
                idxDictMap.put(curr, i);
            }
        }
        return idxDictMap;
    }

    public String minimalLengthStringContainingAllCharactersInDictionary(String word, char[] dict) {
        if (null == word || dict == null) throw new IllegalArgumentException("Dictionary is null");
        if (word.length() == 0 && dict.length == 0) return "";
        Map<Character, Integer> dictIndexMap = buildDictMap(dict);
        Map<Integer, List<Integer>> sizeToIndexListMap = new HashMap<>();// map contains indexes of the dict characters found within word, stored by the size
        AtomicInteger trackIdx = new AtomicInteger(0);
        for (int i = 0; i < word.length(); i++) {
            Character curr = word.charAt(i);
            Integer indexOnDict = dictIndexMap.get(curr);
            if (indexOnDict == null) throw new IllegalArgumentException("Word contains invalid character not present in the dictionary : " + curr);
            if (indexOnDict == trackIdx.get()) {
                processNextDictionaryIndex(sizeToIndexListMap, trackIdx, i);
            } else if (indexOnDict < trackIdx.get()) {
                processNewSubWord(sizeToIndexListMap, indexOnDict, i);
            }
        }
        List<Integer> integers = sizeToIndexListMap.get(dict.length);
        return word.substring(integers.get(0), integers.get(integers.size()-1) + 1);
    }

    private void processNewSubWord(Map<Integer, List<Integer>> map, int indexOnDict, int wordIndex) {
        if (indexOnDict == 0) { //if is the first letter of the dictionary
            List<Integer> indexSet = new ArrayList<>(Collections.singleton(wordIndex));
            map.put(indexSet.size(), indexSet);
        } else {
            List<Integer> indexList = map.get(indexOnDict);
            if (null != indexList) {
                indexList.add(wordIndex);
                map.remove(indexOnDict);
                List<Integer> old = map.get(indexList.size());
                if (null == old || isSubWordShorter(old, indexList)) {
                    map.put(indexList.size(), indexList);
                }
            }
        }
    }

    private void processNextDictionaryIndex(Map<Integer, List<Integer>> sizeToIndexList, AtomicInteger trackIdx, int index) {
        List<Integer> indexes = sizeToIndexList.get(trackIdx.get());
        if (null == indexes) {
            List<Integer> indexSet = new ArrayList<>(Collections.singleton(index));
            sizeToIndexList.put(indexSet.size(), indexSet);
        } else {
            sizeToIndexList.remove(trackIdx.get());
            indexes.add(index);
            sizeToIndexList.put(indexes.size(), indexes);
        }
        trackIdx.incrementAndGet(); //advance the dictionary index tracker
    }

    private boolean isSubWordShorter(List<Integer> old, List<Integer> recent) {
        int word1Length = old.get(old.size()-1) - old.get(0);
        int word2Length= recent.get(recent.size()-1) - recent.get(0);
        return word2Length <= word1Length;
    }
}
