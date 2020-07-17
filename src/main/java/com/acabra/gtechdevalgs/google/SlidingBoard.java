package com.acabra.gtechdevalgs.google;

import java.util.*;

public class SlidingBoard {

    /**
     * Given a matrix representing a puzzle with an empty box (0), indicate
     * the minimal amount of moves required to solve it, or -1 if impossible
     * @param board 2x3 int matrix of integers
     * @return -1 if impossible to solve or an int representing the minimal amount of moves required
     */
    public int slidingPuzzle(int[][] board) {
        Board b = new Board(board, 0);
        if(isSolution(b)) {
            return 0;
        }
        ArrayDeque<Board> q = new ArrayDeque<>();
        q.addLast(b);
        Set<Board> seen = new HashSet<>();
        seen.add(b);
        while(q.size() > 0) {
            b = q.removeFirst();
            for(Board child: b.getUnseenChildren(seen)) {
                if (isSolution(child)){
                    return child.moves;
                }
                seen.add(child);
                q.addLast(child);
            }

        }
        return- 1;
    }

    boolean isSolution(Board b) {
        return b.board[1][2] == 0
                && b.board[0][0] == 1 && b.board[0][1] == 2 && b.board[0][2] == 3
                && b.board[1][0] == 4 && b.board[1][1] == 5;
    }

    static class Board {

        final int[][] board;
        final int moves;
        final String id;
        final int zI;
        final int zJ;

        Board(int[][] board, int moves) {
            this.board = board;
            this.moves = moves;
            int[] zero = findZero(board);
            zI = zero[0];
            zJ = zero[1];
            this.id = buildId(board);
        }

        Board(int[][] board, int zI, int zJ, int moves) {
            this.board = board;
            this.moves = moves;
            this.zI = zI;
            this.zJ = zJ;
            this.id = buildId(board);
        }

        private static String buildId(int[][] board) {
            StringBuilder sb = new StringBuilder();
            return sb.append(board[0][0]).append(board[0][1]).append(board[0][2])
                    .append(board[1][0]).append(board[1][1]).append(board[1][2]).toString();
        }

        static int[] findZero(int[][] board) {
            for(int i=0;i<2;++i)  {
                for(int j=0;j<3;++j){
                    if(board[i][j] == 0){
                        int[] ans = new int[2];
                        ans[0] = i;
                        ans[1] = j;
                        return ans;
                    }

                }
            }
            throw new RuntimeException("Invalid input given does not contain zero in a 2x3 board");
        }

        List<Board> getUnseenChildren(Set<Board> seen) {
            List<Board> children = new ArrayList<>();
            int nMoves = this.moves+1;
            Board child = null;
            //move zero up
            if (zI > 0) {
                int[][] nBoard = new int[2][];
                nBoard[0] = Arrays.copyOf(board[0], 3);
                nBoard[1] = Arrays.copyOf(board[1], 3);
                int tmp = nBoard[0][zJ];
                nBoard[0][zJ] = 0;
                nBoard[zI][zJ] = tmp;
                child = new Board(nBoard, 0, zJ, nMoves);
                if (!seen.contains(child)) {
                    children.add(child);
                }
            }
            //move zero down
            if (zI == 0) {
                int[][] nBoard = new int[2][];
                nBoard[0] = Arrays.copyOf(board[0], 3);
                nBoard[1] = Arrays.copyOf(board[1], 3 );
                int tmp = nBoard[1][zJ];
                nBoard[1][zJ] = 0;
                nBoard[zI][zJ] = tmp;
                child = new Board(nBoard, 1, zJ, nMoves);
                if (!seen.contains(child)) {
                    children.add(child);
                }
            }
            //move zero left
            if (zJ > 0) {
                int[][] nBoard = new int[2][];
                nBoard[0] = Arrays.copyOf(board[0], 3);
                nBoard[1] = Arrays.copyOf(board[1], 3);
                int tmp = nBoard[zI][zJ-1];
                nBoard[zI][zJ-1] = 0;
                nBoard[zI][zJ] = tmp;
                child = new Board(nBoard, zI, zJ-1, nMoves);
                if (!seen.contains(child)) {
                    children.add(child);
                }
            }
            ///move zero right
            if (zJ < 2) {
                int[][] nBoard = new int[2][];
                nBoard[0] = Arrays.copyOf(board[0], 3);
                nBoard[1] = Arrays.copyOf(board[1], 3);
                int tmp = nBoard[zI][zJ+1];
                nBoard[zI][zJ+1] = 0;
                nBoard[zI][zJ] = tmp;
                child = new Board(nBoard, zI, zJ+1, nMoves);
                if (!seen.contains(child)) {
                    children.add(child);
                }
            }
            return children;
        }

        public boolean equals(Object other) {
            if (!(other instanceof Board)) return false;
            return this.id.equals(((Board)other).id);
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        @Override
        public String toString() {
            return Arrays.toString(board[0]) + "\n" + Arrays.toString(board[1]);
        }
    }
}
