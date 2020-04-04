package com.acabra.gtechdevalgs.litcode.arrays;

public class BurstBalloons {

    public int maxCoins(int[] nums) {
        int[] extNums = new int[nums.length+2];
        int x = 1;
        int[][] memo = new int[nums.length+2][nums.length+2];
        for (int num : nums) {
            if (num != 0) {
                memo[x][x] = num;
                extNums[x++] = num;
            }
        }
        extNums[0] = 1;
        extNums[x++] = 1;


        for (int j = 1; j <= x-1; j++){
            for (int i = 0; i+j < x; i++){
                for (int k = i+1; k < i+j; k++) {
                    memo[i][i+j] = Math.max(memo[i][i+j], extNums[k]*extNums[i]*extNums[i+j] + memo[i][k] + memo[k][i+j]);
                }
            }
        }

        return memo[0][x-1];
    }
}
