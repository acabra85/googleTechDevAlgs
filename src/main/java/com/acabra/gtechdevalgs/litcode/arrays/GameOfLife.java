package com.acabra.gtechdevalgs.litcode.arrays;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        if (null == board) throw new IllegalArgumentException("Can't receive null board");
        if (board.length == 0) return;
        int ROWS = board.length;
        int COLS = board[0].length;
        int[][] sol = new int[ROWS][];
        for (int i = 0; i < ROWS; i++) {
            sol[i] = new int[COLS];
        }
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                sol[i][j] = processCell(board, getNeighbors(board, i, j, ROWS, COLS), i, j);
            }
        }
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = sol[i][j];
            }
        }
    }

    private int getNeighbors(int[][] board, int i, int j, int ROWS, int COLS) {
        int n = 0;
        if (valid(i-1, j-1, ROWS, COLS) && 1 == board[i-1][j-1]) {
            n++;
        }
        if (valid(i-1, j, ROWS, COLS)) {
            n+=board[i-1][j];
        }
        if (valid(i-1, j+1, ROWS, COLS)) {
            n+=board[i-1][j+1];
        }
        if (valid(i, j-1, ROWS, COLS)) {
            n+=board[i][j-1];
        }
        if (valid(i, j+1, ROWS, COLS)) {
            n+=board[i][j+1];
        }
        if (valid(i+1, j-1, ROWS, COLS)) {
            n+=board[i+1][j-1];
        }
        if (valid(i+1, j, ROWS, COLS)) {
            n+=board[i+1][j];
        }
        if (valid(i+1, j+1, ROWS, COLS)) {
            n+=board[i+1][j+1];
        }
        return n;
    }

    private boolean valid(int i, int j, int rows, int cols) {
        return i >= 0 && i<rows && j>=0 && j< cols;
    }

    private int processCell(int[][] board, int n, int i, int j) {
        if (board[i][j] == 1) {//cell alive
            if (n > 3 || n < 2) {
                return  0; //death by population crisis
            }
        } else if (n == 3) {
            return 1; //reproduction
        }
        return board[i][j]; //cell remains as it was
    }
}
