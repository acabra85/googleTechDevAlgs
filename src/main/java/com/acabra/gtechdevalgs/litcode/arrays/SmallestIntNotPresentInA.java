package com.acabra.gtechdevalgs.litcode.arrays;

/**
 * Find the smallest integer Greater than 0 not present in A
 */
public class SmallestIntNotPresentInA {
    public int solution(int[] A) {
        boolean[] seen =  new boolean[1000001];
        seen[0] = true;
        for(int i : A) {
            if (i > 0  && i<seen.length && !seen[i]) {
                seen[i] = true;
            }
        }
        int i = 0;
        for (; i < seen.length; ++i) {
            if(!seen[i]) {
                return i;
            }
        }
        return i;
    }
}
