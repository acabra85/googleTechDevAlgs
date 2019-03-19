package com.acabra.gtechdevalgs.litcode.arrays;

import com.acabra.gtechdevalgs.Pair;

import java.util.ArrayList;
import java.util.List;

public class Toeplitz {

    public boolean isToeplitz(int[][] matrix) {
        if(matrix == null) return false;
        int ROWS = matrix.length;
        if (ROWS == 0) return false;
        int COLS = matrix[0].length;
        //horizontal
        int value;
        for (Pair<Integer, Integer> coord : getHorizontalStart(COLS)) {
            value = matrix[coord.left][coord.right];
            for (int i=coord.left,j=coord.right;i<ROWS && j<COLS ; i++, j++) {
                if (matrix[i][j] != value) return false;
            }
        }
        for (Pair<Integer, Integer> coord : getVerticalStart(ROWS)) {
            value = matrix[coord.left][coord.right];
            for (int i=coord.left,j=coord.right;i<ROWS && j<COLS ; i++,j++) {
                if (matrix[i][j] != value) return false;
            }
        }
        return true;
    }

    private List<Pair<Integer, Integer>> getHorizontalStart(int cols) {
        List<Pair<Integer, Integer>> list = new ArrayList<>(cols);
        for (int i = 0; i < cols; i++) {
            list.add(new Pair<>(0, i));
        }
        return list;
    }

    private List<Pair<Integer, Integer>> getVerticalStart(int rows) {
        List<Pair<Integer, Integer>> list = new ArrayList<>(rows);
        for (int i = 0; i < rows; i++) {
            list.add(new Pair<>(i, 0));
        }
        return list;
    }
}
