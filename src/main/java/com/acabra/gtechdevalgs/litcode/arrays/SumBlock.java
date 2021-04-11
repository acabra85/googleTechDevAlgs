package com.acabra.gtechdevalgs.litcode.arrays;

public class SumBlock {

    /**
     * Given a matrix and an integer return a new matrix where each i,j position is the sum of every
     * r,c in the given matrix given i-k<=r<=i+k and j-k<=c<=j+k.
     * @param matrix a matrix of integers
     * @param k the k parameter denoting the box
     * @return a new matrix same size as input where each cell corresponds to the sum described
     */
    public int[][] matrixBlockSum(int[][] matrix, int k) {
        int R = matrix.length, C=matrix[0].length;
        int[][] res = new int[R][C];
        for(int i =0;i<R;++i) {
            for(int j=0;j<C;++j) {
                res[i][j] = sumOfAllRCs(matrix, i, j, k, R, C);
            }
        }
        return res;
    }

    int sumOfAllRCs(int[][] mat, int i, int j, int k, int R, int C) {
        int val = 0;
        int ipk = Math.min(R-1, i + k);
        int jpk = Math.min(C-1, j + k);
        int lpk = Math.max(0,i - k);
        int hpk =  Math.max(j - k, 0);
        for(int r = lpk; r <= ipk ; ++r) {
            for(int c = hpk; c <= jpk; ++c) {
                val += mat[r][c];
            }
        }
        return val;
    }
}
