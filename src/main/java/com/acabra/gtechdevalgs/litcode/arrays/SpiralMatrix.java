package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.*;

public class SpiralMatrix {

    /**
     * Returns a string by iterating over the input grid in spiral form
     * starting at point 0,0 going over the walls and so on.
     * @param matrix 2d grid containing integers
     * @return a string representing the spiral traverse of the matrix
     */
    public List<Integer> spiralMatrix(int[][] matrix) {
        if (null == matrix) throw new NullPointerException("Given matrix is null or empty");
        int ROWS = matrix.length;
        int COLS = ROWS > 0 ? matrix[0].length : 0;
        Direction[] dir = new Direction[1];
        dir[0] = Direction.RIGHT;
        List<Integer> spiral = new ArrayList<>();
        Set<Pos> visited = new HashSet<>();
        Pos last = new Pos(0, 0);
        int totalCells = ROWS * COLS;
        for (int step = 0; step < totalCells && null != last; step++) {
            visited.add(last);
            spiral.add(matrix[last.row][last.col]);
            last = getNextDirection(ROWS, COLS, last, dir, visited);
        }
        return spiral;
    }

    private Pos getNextDirection(int MAX_ROWS, int MAX_COLS, Pos last, Direction[] dir, Set<Pos> visited) {
        int cont = 0;
        while (cont < 4) {
            Pos next = new Pos(last.col + dir[0].dr, last.row + dir[0].dc);
            if (next.col >= 0 && next.col < MAX_COLS && next.row >= 0 && next.row < MAX_ROWS && !visited.contains(next)) {
                return next;
            }
            cont++;
            dir[0] = Direction.FROM_TO.get(dir[0]);
        }
        return null;
    }

    static class Pos {
        final int col;
        final int row;

        public Pos(int col, int row) {
            this.col = col;
            this.row = row;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return col == pos.col &&
                    row == pos.row;
        }

        @Override
        public int hashCode() {
            return Objects.hash(col, row);
        }

        @Override
        public String toString() {
            return "{col=" + col +
                    ", row=" + row +
                    '}';
        }
    }

    enum Direction {

        RIGHT(1, 0), DOWN(0, 1), LEFT(-1, 0), UP(0, -1);

        final int dr;
        final int dc;

        Direction(int dr, int dc) {
            this.dr = dr;
            this.dc = dc;
        }

        static final Map<Direction, Direction> FROM_TO = new HashMap<Direction, Direction>(){{
            put(RIGHT, DOWN);
            put(DOWN, LEFT);
            put(LEFT, UP);
            put(UP, RIGHT);
        }};
    }
}
