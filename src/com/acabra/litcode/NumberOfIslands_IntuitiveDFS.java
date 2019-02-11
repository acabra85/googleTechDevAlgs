package com.acabra.litcode;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Agustin on 2/10/2019.
 */
public class NumberOfIslands_IntuitiveDFS {

    static final char LAND = '1';

    public int numIslands(char[][] grid) {

        final int MAX_ROWS = grid.length;
        final int MAX_COLS = MAX_ROWS > 0 ? grid[0].length : 0;

        AtomicInteger islandCount = new AtomicInteger(0);
        Map<String, LandCell> landMap = new HashMap<>();
        Stack<LandCell> landStack = new Stack<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == LAND) {
                    LandCell iLand = new LandCell(i, j);
                    landMap.put(makeCellId(i,j), iLand);
                    landStack.push(iLand);
                }
            }
        }
        //DFS
        while (landStack.size() > 0) {
            LandCell land = landStack.pop();
            if (land.islandName == -1) {
                land.islandName = islandCount.getAndIncrement();
                exploreIsland(land, landMap, MAX_ROWS, MAX_COLS);
            }
        }
        return islandCount.get();
    }

    private String makeCellId(final int x, final int y) {
        return x + "," + y;
    }

    private void appendValidKey(int x, int y, int MAX_ROWS, int MAX_COLS, List<String> keys) {
        if (x < MAX_ROWS && y < MAX_COLS) {
            keys.add(makeCellId(x, y));
        }
    }

    private List<String> getAdjacentLandKeys(LandCell landCell, int MAX_ROWS, int MAX_COLS) {
        List<String> list = new ArrayList<>();
        appendValidKey(landCell.x, landCell.y - 1, MAX_ROWS, MAX_COLS, list);
        appendValidKey(landCell.x + 1, landCell.y, MAX_ROWS, MAX_COLS, list);
        appendValidKey(landCell.x, landCell.y + 1, MAX_ROWS, MAX_COLS, list);
        appendValidKey(landCell.x - 1, landCell.y, MAX_ROWS, MAX_COLS, list);
        return list;
    }

    private void exploreIsland(LandCell rootLand, Map<String, LandCell> landMap, int MAX_ROWS, int MAX_COLS) {
        Stack<String> visited = new Stack<>();
        visited.push(rootLand.cellId);
        while (visited.size() > 0) {
            LandCell iLand = null;
            List<String> adjacentLandKeys = getAdjacentLandKeys(landMap.get(visited.pop()), MAX_ROWS, MAX_COLS);
            for (String key: adjacentLandKeys) {
                if (!visited.contains(key)) {
                    iLand = landMap.get(key);
                    if(iLand != null && iLand.islandName == -1) {
                        visited.push(key);
                        iLand.islandName = rootLand.islandName;
                    }
                }
            }
        }

    }

    private class LandCell {
        final int x;
        final int y;
        final String cellId;
        int islandName;

        LandCell(int x, int y) {
            this.x = x;
            this.y = y;
            this.cellId = makeCellId(x, y);
            this.islandName = -1;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        public boolean equals(Object other) {
            if (null == other || other.getClass() != LandCell.class) {
                return false;
            }
            LandCell otherLandCell = (LandCell) other;
            return this.x == otherLandCell.x && this.y == otherLandCell.y;
        }
    }
}
