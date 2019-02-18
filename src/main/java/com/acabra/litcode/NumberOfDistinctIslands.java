package com.acabra.litcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class NumberOfDistinctIslands {

    char VISITED = '\0';

    /**
     * Given a 2D-grid identify the amount of islands by tape, islands are cells connected together up down left or right
     * @param grid a grid representing land
     * @return A char array containing pairs of the types of islands and the amount of islands present in the grid
     */
    public char[][] numIslands(char[][] grid) {
        if (null == grid || grid.length == 0 ) return null;

        final int MAX_ROWS = grid.length;
        final int MAX_COLS = grid[0].length;
        Map<Character, AtomicInteger> freqMap = new HashMap<>();
        PriorityQueue<Character> pq = new PriorityQueue<>(Character::compareTo);
        Character last = null;
        for (int r = 0; r < MAX_ROWS; r++) {
            for (int c = 0; c < MAX_COLS; c++) {
                if (grid[r][c] != VISITED) {
                    last = grid[r][c];
                    if (freqMap.get(last) == null) {
                        pq.offer(last);
                        freqMap.put(last, new AtomicInteger(1));
                    } else {
                        freqMap.get(last).incrementAndGet();
                    }
                    exploreAdjacentLand(grid, r, c, MAX_ROWS, MAX_COLS, last);
                }
            }
        }
        return freqMap.keySet().size() > 0 ? buildAnswer(freqMap, pq) : null ;
    }

    private char[][] buildAnswer(Map<Character, AtomicInteger> freqMap, PriorityQueue<Character> pq) {
        char[][] chars = new char[pq.size()][];
        for (int i= 0; !pq.isEmpty();i++ ) {
            Character key = pq.remove();
            chars[i] = new char[2];
            chars[i][0] = key;
            chars[i][1] = (char)(freqMap.get(key).get() + 48);
        }
        return chars;
    }

    private void exploreAdjacentLand(char[][] grid, int r, int c, int MAX_ROWS, int MAX_COLS, char last) {
        if (r < MAX_ROWS && c < MAX_COLS && r >= 0 && c >= 0 && grid[r][c] == last) {
            grid[r][c] = VISITED; //visit the current node
            exploreAdjacentLand(grid, r, c-1, MAX_ROWS, MAX_COLS, last); //up
            exploreAdjacentLand(grid, r+1, c, MAX_ROWS, MAX_COLS, last); //right
            exploreAdjacentLand(grid, r, c+1, MAX_ROWS, MAX_COLS, last); //down
            exploreAdjacentLand(grid, r-1, c, MAX_ROWS, MAX_COLS, last); //left
        }
    }
}
