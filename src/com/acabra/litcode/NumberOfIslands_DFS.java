package com.acabra.litcode;

/**
 * Created by Agustin on 2/11/2019.
 * In a grid in 2D where '1' represents land and '0' represents water
 * find the amount of islands.
 *
 * Note that islands are formed by adjacent vertically or horizontally pieces of land.
 */
public class NumberOfIslands_DFS {

    public int numIslands(char[][] grid) {
        if (null == grid || grid.length == 0 ) return 0;

        final int MAX_ROWS = grid.length;
        final int MAX_COLS = grid[0].length;
        int count = 0;
        for (int r = 0; r < MAX_ROWS; r++) {
            for (int c = 0; c < MAX_COLS; c++) {
                if(grid[r][c] == '1') {
                    count++;
                    exploreAdjacentLand(grid, r, c, MAX_ROWS, MAX_COLS);
                }
            }
        }
        return count;
    }

    private void exploreAdjacentLand(char[][] grid, int r, int c, int MAX_ROWS, int MAX_COLS) {
        if (r < MAX_ROWS && c < MAX_COLS && r >= 0 && c >= 0 && grid[r][c] == '1') {
            grid[r][c] = '0'; //visit the current node
            exploreAdjacentLand(grid, r, c-1, MAX_ROWS, MAX_COLS); //up
            exploreAdjacentLand(grid, r+1, c, MAX_ROWS, MAX_COLS); //right
            exploreAdjacentLand(grid, r, c+1, MAX_ROWS, MAX_COLS); //down
            exploreAdjacentLand(grid, r-1, c, MAX_ROWS, MAX_COLS); //left
        }
    }
}
