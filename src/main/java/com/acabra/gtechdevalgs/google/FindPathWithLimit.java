package com.acabra.gtechdevalgs.google;

import java.util.Stack;

public class FindPathWithLimit {

    // up right left down
    private final static int[][] moves = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

    /**
     * given a NxN board of integer values >= 0
     * with available moves in 4 directions top left bottom right
     * start in top left and target to reach bottom right
     * <p>
     * Given a board and a limit , return whether or not there is a path to
     * reach destination without exceeding the limit.
     * <p>
     * The value of the path is the maximum of the absolute difference between all of its consecutive values.
     * 1 2
     * 3 4
     * 1->2 (1) 2->4 (2), path cost 2
     */
    public boolean hasAValidPathToTarget(int[][] board, int limit) {
        if (null != board && board.length > 0) {
            int N = board.length;
            return solve(board, limit, N);
        }
        throw new IllegalArgumentException("Given board is null or has no rows");
    }

    /**
     * Uses DFS to traverse the board, nodes are marked as visited as after poping from the stack
     */
    private boolean solve(int[][] board, int limit, int N) {
        boolean[][] seen = new boolean[N][N];
        BoardNode boardNode = null;
        Stack<BoardNode> stack = new Stack<>();
        stack.push(new BoardNode(0, 0, 0)); //add the starting point
        if (reachedEnd(stack.peek(), N - 1)) {
            if (stack.peek().maxAbsoluteDifference <= limit) {
                return true;
            }
        }

        while (stack.size() > 0) {
            boardNode = stack.pop();
            seen[boardNode.x][boardNode.y] = true;
            //add unseen children
            for (int[] move : moves) {
                int iMove = boardNode.x + move[0];
                int jMove = boardNode.y + move[1];
                if (validMove(iMove, jMove, N) && !seen[iMove][jMove]) {
                    int diff = Math.abs(board[boardNode.x][boardNode.y] - board[iMove][jMove]);
                    int newMax = Math.max(boardNode.maxAbsoluteDifference, diff);
                    if (newMax <= limit) {
                        stack.push(new BoardNode(iMove, jMove, newMax));
                        if (reachedEnd(stack.peek(), N - 1)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean reachedEnd(BoardNode boardNode, int end) {
        return boardNode.x == end && boardNode.y == end;
    }

    private boolean validMove(int i, int j, int N) {
        return i >= 0 && i < N && j >= 0 && j < N;
    }

    private static class BoardNode {
        final int x;
        final int y;
        final int maxAbsoluteDifference;

        BoardNode(int x, int y, int maxAbsoluteDifference) {
            this.x = x;
            this.y = y;
            this.maxAbsoluteDifference = maxAbsoluteDifference;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + maxAbsoluteDifference +
                    ", i=" + x +
                    ", j=" + y +
                    '}';
        }
    }
}
