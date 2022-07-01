package com.acabra.gtechdevalgs.google;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinDominoRotations {

    private static final int BFS_LIMIT_LENGTH = 20;
    private final boolean bfs;

    public MinDominoRotations(boolean bfs) {
        this.bfs = bfs;
    }

    public int minDominoRotations(int[] tops, int[] bottoms) {
        return bfs ? bfs(tops, bottoms) : linear(tops, bottoms);
    }

    private int linear(int[] tops, int[] bottoms) {
        int N = tops.length;
        int c = check(tops[0], N, tops, bottoms);
        if(c != -1 || tops[0] == bottoms[0]) return c;
        return check(bottoms[0], N, tops, bottoms);
    }

    //Only supports less than 20 elements
    private int bfs(int[] tops, int[] bott) {
        if(tops.length > BFS_LIMIT_LENGTH) return linear(tops, bott);
        List<Piece> pieces = IntStream.range(0, tops.length)
                .mapToObj(e -> Piece.of(tops[e], bott[e]))
                .collect(Collectors.toList());
        if(!pieces.stream().allMatch(e -> (e.t == tops[0] || e.t == bott[0]) || (e.b == tops[0] || e.b == bott[0]))) {
            return -1;
        }
        ArrayDeque<Node> q = new ArrayDeque<>(){{add(new Node(pieces, 0));}};
        while(!q.isEmpty()) {
            Node n = q.remove();
            if(n.complete) {
                return n.turn;
            }
            if(n.addChildren(q)) {
                return n.turn + 1;
            }
        }
        return -1;
    }

    private int check(int k, int n, int[] tops, int[] bott) {
        int countT = 0;
        int countB = 0;
        for (int i=0; i< n;++i) {
            if(tops[i] != k && bott[i] != k) return -1;
            else if(k != tops[i]) ++countT;
            else if(k != bott[i]) ++countB;
        }
        return Math.min(countT, countB);
    }

    private static class Piece {
        private final int t;
        private final int b;
        private final boolean eq;
        private final boolean rotated;

        private Piece(int top, int bott, boolean rot) {
            this.t = top;
            this.b = bott;
            this.eq = t == b;
            this.rotated = rot;
        }

        public static Piece of(int t, int b) {
            return new Piece(t, b, false);
        }

        public Piece rotate() {
            return new Piece(this.b, this.t, true);
        }

        public String toString() {
            return String.format("%d/%d", t, b);
        }
    }

    private static class Node {
        final List<Piece> pieces;
        final int turn;
        final boolean complete;

        private Node(List<Piece> pieces, int turn) {
            this.pieces = pieces;
            this.turn = turn;
            this.complete = complete(pieces);
        }

        private static boolean complete(List<Piece> pieces) {
            final Piece k = pieces.get(0);
            return pieces.stream().allMatch(e -> e.t == k.t) || pieces.stream().allMatch(e -> e.b == k.b);
        }

        public boolean addChildren(ArrayDeque<Node> q) {
            for (int i = 0; i < pieces.size(); ++i) {
                if(!pieces.get(i).rotated) {
                    Node rotated = rotated(i);
                    if(rotated.complete) return true;
                    q.add(rotated);
                }
            }
            return false;
        }

        private Node rotated(int idxRot) {
            List<Piece> nPieces = new ArrayList<>(this.pieces.size());
            for (int i = 0; i < pieces.size(); ++i) {
                nPieces.add(i == idxRot ? this.pieces.get(i).rotate() : this.pieces.get(i));
            }
            return new Node(nPieces, turn + 1);
        }
    }
}
