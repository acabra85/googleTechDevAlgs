package com.acabra.gtechdevalgs.litcode.arrays;

public class LongestSubstringWithoutRepetitions {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        boolean[] chars = new boolean[256];
        int distinctChars = 0;
        int lengthLongestSubstr = -1;
        int i = 0;
        int j = 0;
        while(i < s.length()) {
            if (!chars[s.charAt(i)]){
                chars[s.charAt(i++)] = true;
                ++distinctChars;
            } else {
                lengthLongestSubstr = Math.max(lengthLongestSubstr, distinctChars--);
                chars[s.charAt(j++)] = false;
            }
        }
        return Math.max(lengthLongestSubstr, distinctChars);
    }
}
