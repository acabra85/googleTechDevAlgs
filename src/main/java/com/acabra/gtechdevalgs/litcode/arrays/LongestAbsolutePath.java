package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.StringTokenizer;

class LongestAbsolutePath {

    public int lengthLongestPath(String input) {
        if (null == input || input.length() == 0) return 0;
        StringTokenizer comps = new StringTokenizer(input, "\n");
        int[] lengthMostRecentParent = new int[comps.countTokens()];
        if (input.indexOf(".") == -1) return 0; //does not contain files
        int maxLength = Integer.MIN_VALUE;
        while (comps.hasMoreTokens()) {
            String part = comps.nextToken();
            int idxOfLastT = part.lastIndexOf('\t');
            int level = 1 + idxOfLastT;
            int lenParent = level == 0 ? 0 : lengthMostRecentParent[level - 1] + 1;
            int lenName = part.length() - idxOfLastT - 1;
            lengthMostRecentParent[level] = lenName + lenParent;
            if (part.indexOf(".") >= 0) {//is a filename
                maxLength = Math.max(lengthMostRecentParent[level], maxLength);
            }
        }
        return maxLength;
    }
}
