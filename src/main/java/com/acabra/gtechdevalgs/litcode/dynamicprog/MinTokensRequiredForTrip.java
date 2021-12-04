package com.acabra.gtechdevalgs.litcode.dynamicprog;

public class MinTokensRequiredForTrip {


    public int minimalTokensToReachTarget(int[][] grid) {
        return minimalTokensToReachTarget(grid, grid.length - 1, grid[0].length - 1);
    }

    /**
     * Given a 2D grid where [i,j] represent a deduction(<0), income(>0) or nothing(0),
     * what is the minimal starting amount of tokens required so that at every point during
     * the journey from 0,0 to x,y the driver's balance is always above 0
     *
     * @param grid an int matrix representing the tokens (either positive negative or zero)
     * @param x destination x-coord assume dest[0] and dest[1] are valid positions within #grid
     * @param y destination y-coord assume dest[0] and dest[1] are valid positions within #grid
     * @return the tokens required before journey start so that at every point in the journey to destination
     * the balance is larger than 0.
     */
    public int minimalTokensToReachTarget(int[][] grid, int x, int y) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[x][y] = grid[x][y] < 0 ? 1 + Math.abs(grid[x][y]) : 1;
        solve(grid, dp, x, y);
        return dp[0][0];
    }


    private void solve(int[][] grid, int[][] dp, int x, int y) {
        if (x != 0 || y != 0) {
            explore(grid, dp, dp[x][y], x-1, y); //up
            explore(grid, dp, dp[x][y], x, y-1); //left
        }
    }

    private void explore(int[][] grid, int[][] dp, int start, int x, int y) {
        if (x >= 0 && y >= 0) {
            int expect = Math.max(1, start + grid[x][y] * -1);
            if (dp[x][y] == 0 ||  dp[x][y] > expect) {
                dp[x][y] = expect;
                solve(grid, dp, x, y);
            }
        }
    }
}
