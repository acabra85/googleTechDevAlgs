package com.acabra.gtechdevalgs.google;

import java.util.*;

public class NumberOfIslands2 {
    int M;
    int N;
    static final int LEFT = 0;
    static final int RIGHT = 1;
    static final int UP = 2;
    static final int DOWN = 3;

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        if (positions == null || positions.length == 0) return Collections.emptyList();
        this.M = m;
        this.N = n;

        List<Integer> totalIslandsAt = new ArrayList<>();
        Set<Integer> islandIds = new HashSet<>();
        Map<Integer, Map<Integer, Node>> nodes = new HashMap<>();

        boolean[][] exist = new boolean[m][n];
        for (int i = 0; i<m; ++i) {
            exist[i] = new boolean[n];
        }

        int[] id = {0};
        for (int[] pos : positions) {
            totalIslandsAt.add(addLand(nodes, pos, islandIds, exist, id));
        }
        return totalIslandsAt;
    }

    private int addLand(Map<Integer, Map<Integer, Node>> nodes, int[] pos, Set<Integer> islandIds, boolean[][] exist, int[] nextId) {
        int i = pos[0];
        int j = pos[1];
        Node node = null;
        Node tmp = null;
        if (validPos(pos) && !exist[i][j]) {
            exist[i][j] = true;
            node = Node.of(i, j);
            nodes.computeIfAbsent(i, k -> new HashMap<>()).put(j, node);
            if (validRow(i-1) && exist[i-1][j]) {
                tmp = nodes.get(i - 1).get(j);
                tmp.setRight(node);
                assignGroupId(node, islandIds, tmp);
                node.setLeft(tmp);
            }
            if (validRow(i+1) && exist[i+1][j]) {
                tmp = nodes.get(i + 1).get(j);
                tmp.setLeft(node);
                assignGroupId(node, islandIds, tmp);
                node.setRight(tmp);
            }
            if (validCol(j-1) && exist[i][j-1]) {
                tmp = nodes.get(i).get(j - 1);
                tmp.setDown(node);
                assignGroupId(node, islandIds, tmp);
                node.setUp(tmp);
            }
            if (validCol(j+1) && exist[i][j+1]) {
                tmp = nodes.get(i).get(j + 1);
                tmp.setUp(node);
                assignGroupId(node, islandIds, tmp);
                node.setDown(tmp);
            }
            if (node.group == -1) {
                node.group = nextId[0]++;
                islandIds.add(node.group);
            }
        }
        return islandIds.size();
    }

    private void assignGroupId(Node root, Set<Integer> islandIds, Node neighbor) {
        if (root.group == -1) {
            root.group = neighbor.group;
        } else if (neighbor.group != root.group) {
            islandIds.remove(neighbor.group);
            exploreNodes(neighbor, root.group);
        }
    }

    private void exploreNodes(Node node, int group) {
        if (node.group == group)
            return;
        node.group = group;
        if (node.neighbors[LEFT] != null) {
            exploreNodes(node.neighbors[LEFT], group);
        }
        if (node.neighbors[RIGHT] != null) {
            exploreNodes(node.neighbors[RIGHT], group);
        }
        if (node.neighbors[UP] != null) {
            exploreNodes(node.neighbors[UP], group);
        }
        if (node.neighbors[DOWN] != null) {
            exploreNodes(node.neighbors[DOWN], group);
        }
    }

    private boolean validPos(int[] pos) {
        return validRow(pos[0]) && validCol(pos[1]);
    }

    private boolean validRow(int row) {
        return row >= 0 && row < this.M;
    }

    private boolean validCol(int col) {
        return col >= 0 && col < this.N;
    }



    private void printGroups(Map<Integer, Map<Integer, Node>> nodes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                sb.append(buildGroupId(i, j, nodes)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private String buildGroupId(int i, int j, Map<Integer, Map<Integer, Node>> nodes) {
        try {
            int groupId = nodes.get(i).get(j).group;
            if (groupId<10) {
                return "__"+groupId;
            } else if (groupId <100) {
                return "_" + groupId;
            }
            return ""+groupId;
        } catch (Exception e) {

        }
        return "___";
    }

    private static class Node {
        final int i;
        final int j;
        final private int hashId;
        int group = -1;

        //left, right, up, down
        Node[] neighbors = new Node[4];

        private Node(int i, int j) {
            this.i = i;
            this.j = j;
            this.hashId = Objects.hash(i, j);
        }

        void setLeft(Node n) {
            this.neighbors[0] = n;
        }

        void setRight(Node n) {
            this.neighbors[1] = n;
        }

        void setUp(Node n) {
            this.neighbors[2] = n;
        }

        void setDown(Node n) {
            this.neighbors[3] = n;
        }
        public static Node of(int[] pos) {
            return new Node(pos[0], pos[1]);
        }

        public static Node of(int i, int j) {
            return new Node(i, j);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return i == node.i && j == node.j;
        }

        @Override
        public int hashCode() {
            return this.hashId;
        }

        @Override
        public String toString() {
            return String.format("[%d, %d] g:%d", i, j, group);
        }
    }
}
