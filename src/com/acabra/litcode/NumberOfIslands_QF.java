package com.acabra.litcode;

/**
 * Created by Agustin on 2/11/2019.
 */
public class NumberOfIslands_QF {

    private class QuickFindNI {
        private final char[][] grid;
        private int count;

        public QuickFindNI(char[][] grid) {
            this.grid = grid.clone();
            this.count = grid.length * grid[0].length;
        }

        public int size() {
            return count;
        }
    }

    public int numIslands(char[][] grid) {
        if (null == grid || grid.length == 0 ) return 0;

        QuickFindNI qf = new QuickFindNI(grid);
        final int MAX_ROWS = grid.length;
        final int MAX_COLS = MAX_ROWS > 0 ? grid[0].length : 0;
        return qf.size();
    }
}
