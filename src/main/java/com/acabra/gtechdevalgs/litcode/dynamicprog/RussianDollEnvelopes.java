package com.acabra.gtechdevalgs.litcode.dynamicprog;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {

    static Comparator<int[]> COMP = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return Integer.compare(o1[0], o2[0]);
        }
    };


    /**
     * Given the width x height of a list of envelopes, find the maximum number of envelopes that can be
     * stacked inside together (much like russian dolls). One envelope can be stacked inside another if their
     * width and height are less than the other.
     */
    public int maxStackedEnvelopes(int[][] envelopes) {
        if(envelopes == null) return 0;
        if(envelopes.length <= 1) return envelopes.length;
        Arrays.sort(envelopes, COMP);
        int N = envelopes.length;
        int max = 1;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        for(int i=0;i<N;++i) {
            for(int j=0;j<i;++j) {
                if(fits(i, j, envelopes)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static boolean fits(int i, int j, int[][] envelopes) {
        int[] eI = envelopes[i];
        int[] eJ = envelopes[j];
        return eI[0] > eJ[0] && eI[1] > eJ[1];
    }
}
