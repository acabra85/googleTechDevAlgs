package com.acabra.gtechdevalgs.litcode.arrays;

public class ShortestSubstringContainingAllDictionaryOrdered {

    /**
     * In linear time finds if there dictionary letters is contained in the proper order on the given string
     * @param str the string to look into
     * @param dict the dictionary of valid characters
     * @return true if the dictionary values are all present in the string (not necessary together )
     * e.g. dict = {a, b, c}
     *      str = "aabaac" valid since since a b c appear in the dict order
     */
    public boolean isOrderedDictionaryContained(String str, char[] dict) {
        if (str == null || dict == null || str.length() < dict.length) return false;
        if (str.length() == 0 && dict.length == 0) return true;
        int idx = 0;
        for (int i = 0; i < str.length() && idx < dict.length; i++) {
            if (str.charAt(i) == dict[idx]) {
                idx++;
            }
        }
        return idx==dict.length;
    }

    /**
     * Find the minimal length string that contains all characters in the dictionary order
     * @param str the string to look into
     * @param dict the dictionary of valid characters
     * @return the minimal substring.
     */
    public String minimalLengthStringContainingAllCharactersInDictionary_bf(String str, char[] dict) {
        String minimal = str;
        String candidate = null;
        for (int i = 0; i < str.length(); i++) { //trim right
            candidate = str.substring(i);
            if (!candidate.equals(minimal) && isOrderedDictionaryContained(candidate, dict) && candidate.length() < minimal.length()) {
                minimal = candidate;
            }
        }

        String strLeft = minimal;
        for (int i = strLeft.length(); i >= 0 ; i--) {
            candidate = strLeft.substring(0, i);
            if (!candidate.equals(minimal) && isOrderedDictionaryContained(candidate, dict) && candidate.length() < minimal.length()) {
                minimal = candidate;
            }
        }
        return minimal;
    }

    public String minimalLengthStringContainingAllCharactersInDictionary(String str, char[] dict) {
        //TODO Implement the optimal solution
        return "";
    }
}
