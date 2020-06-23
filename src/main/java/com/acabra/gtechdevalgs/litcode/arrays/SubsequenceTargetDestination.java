package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SubsequenceTargetDestination {
    /**
     * From any string, we can form a subsequence of that string by deleting some number of characters (possibly no deletions).
     *
     * Given two strings source and target, return the minimum number of subsequences of source such that their concatenation equals target. If the task is impossible, return -1.
     */
    public int shortestWay(String source, String target) {
        int subSeqCount = 0;
        String remaining = target;
        StringBuilder sb = new StringBuilder();
        while(remaining.length() > 0) {
            sb.setLength(0);
            int i = 0;
            int j = 0;
            while(i < source.length() && j < remaining.length()) {
                if (source.charAt(i++) == remaining.charAt(j)) {
                    sb.append(remaining.charAt(j++));
                }
            }
            if(sb.length() == 0) {
                return -1;
            }
            remaining = remaining.substring(sb.length());
            ++subSeqCount;
        }
        return subSeqCount;
    }
}
