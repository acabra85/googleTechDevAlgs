package com.acabra.gtechdevalgs.google;

public class MaximumSquareOf1AreaSize {

    static boolean bruteForce = true;

    public int maximalSquare(char[][] matrix) {
        if(null == matrix || matrix.length == 0) return 0;
        return bruteForce ? calcMaxSideBruteForce(matrix) : calcMaxSideDP(matrix);
    }

    private int calcMaxSideDP(char[][] matrix) {
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        int maxSide = 0;
        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[0].length; ++j) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j-1],dp[i-1][j-1]), dp[i-1][j]) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }

    private int calcMaxSideBruteForce(char[][] matrix) {
        int maxSide = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length ; ++j) {
                if (matrix[i][j] == '1' && matrix.length - i > maxSide && matrix[0].length - j > maxSide) {
                    //look only if its possible to fit a larger square from the current point onwards
                    maxSide = Math.max(maxSide, largestSideSquare(matrix, i + 1, j + 1, maxSide));
                }
            }
        }
        return maxSide * maxSide;
    }

    private int largestSideSquare(char[][] matrix, int fixI, int fixJ, int maxSide) {
        int maxDiag = 1;
        for (int i = fixI, j = fixJ; i < matrix.length
                && j < matrix[0].length
                && matrix[i][j] == '1'
                && matrix[i-1][j] == '1'
                && matrix[i][j-1] == '1'; ++i, ++j, ++maxDiag);
        if (maxDiag <= maxSide) return 0; //its not worth to try
        int side = 1; //current i,j are 1
        for (int i = fixI, j = fixJ; i < matrix.length
                && j < matrix[0].length
                && matrix[i][j] == '1'; ++i, ++j) {
            if (columnOnes(matrix, i-1, j, side) && rowOnes(matrix, i, j-1, side)) {
                ++side;
            } else {
                return side;
            }
        }
        return side;
    }

    private boolean rowOnes(char[][] matrix, int i, int j, int side) {
        for (int k = j, l = 0; l < side; --k, ++l) {
            if (matrix[i][k] != '1') {
                return false;
            }
        }
        return true;
    }

    private boolean columnOnes(char[][] matrix, int i, int j, int side) {
        for (int k = i, l = 0; l < side; --k, ++l) {
            if (matrix[k][j] != '1') {
                return false;
            }
        }
        return true;
    }
}
