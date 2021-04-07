package com.acabra.gtechdevalgs.google;

public class PathWithMaximumGold2D {

    /**
     * You start at any cell within the mine containing gold, what is the maximum gold
     * with the following rules:
     * 0. Start and stop positions are not arbitrary as long as you start at a cell with gold in it.
     * 1. Valid moves include up down left right
     * 2. You are not allowed to go back to a cell you've been before
     * 3. YOu are only allowed to cells containing gold.
     * 4. Once you enter a cell with gold all must be taken
     * 5. Constraints at most 25 cells contain gold
     *
     * @return max gold possible to take
     */
    public int findPathWithMaxGold(int[][] mine) {
        if (mine == null || mine.length == 0) return 0;
        this.R = mine.length;
        this.C = mine[0].length;
        this.mine = mine;
        this.maxGold = 0;
        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                if(mine[i][j] != 0)
                    dfs(i, j, 0);
            }
        }
        return maxGold;
    }

    private void dfs(int i, int j, int collected) {
        int cellValue = mine[i][j];
        maxGold = Math.max(collected + cellValue, maxGold);

        mine[i][j] = 0; //take gold

        for (int[] availableMove : AVAILABLE_MOVES) {
            int nx = i + availableMove[0];
            int ny = j + availableMove[1];
            if(validMove(nx, ny)) {
                dfs(nx, ny, collected + cellValue);
            }
        }
        mine[i][j] = cellValue;
    }

    private boolean validMove(int nx, int ny) {
        return nx >= 0 && nx < R && ny>=0 && ny < C && mine[nx][ny] != 0;
    }

    static final int[][] AVAILABLE_MOVES = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int R;
    int maxGold;
    int C;
    int[][] mine;
}
