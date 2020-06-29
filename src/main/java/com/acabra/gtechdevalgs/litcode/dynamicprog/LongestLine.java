package com.acabra.gtechdevalgs.litcode.dynamicprog;

public class LongestLine {
    public int longestLine(int[][] M) {
        if (null == M || M.length == 0) return 0;
        int max = 0;
        int dp[][] = new int[M[0].length][4];
        for(int i = 0; i < M.length; ++i) {
            int old = 0;
            for(int j = 0; j < M[0].length; ++j) {
                if (M[i][j] == 1) {
                    dp[j][0] = j > 0 ? dp[j-1][0] + 1 : 1;
                    dp[j][1] = i > 0 ? dp[j][1] + 1 : 1;
                    int prev = dp[j][2];
                    dp[j][2] = (i>0 && j>0) ? old+1: 1;
                    old = prev;
                    dp[j][3] = (i>0&&j<M[0].length-1) ? dp[j+1][3] + 1 : 1;
                    max = maxOf(max, dp[j][0], dp[j][1], dp[j][2], dp[j][3]);
                } else {
                    old = dp[j][2];
                    dp[j][0] = dp[j][1] = dp[j][2] = dp[j][3] = 0;
                }
            }
        }
        return max;
    }

    private int maxOf(int a, int b, int c, int d, int max) {
        return Math.max(a, Math.max(b, Math.max(c, Math.max(d, max))));
    }
}
