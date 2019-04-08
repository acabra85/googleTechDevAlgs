package com.acabra.gtechdevalgs.litcode.graphs;

public class Relation {
    private final boolean[][] graph;

    public Relation(boolean[][] graph) {
        this.graph = graph;
    }

    boolean knows(int a, int b) {
        return graph[a][b];
    }
}
