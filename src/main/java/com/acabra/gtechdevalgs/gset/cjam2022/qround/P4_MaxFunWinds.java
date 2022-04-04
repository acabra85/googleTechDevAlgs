package com.acabra.gtechdevalgs.gset.cjam2022.qround;

import java.io.*;
import java.util.*;

public class P4_MaxFunWinds {
    public static class Solution {
        private final Help help;
        static class Help {
            final BufferedReader bf;
            final PrintWriter out;
            StringTokenizer tokenizer;

            public Help(BufferedReader bf, PrintWriter out) {
                this.bf = bf;
                this.out = out;
            }

            public int nInt() throws IOException {
                return Integer.parseInt(next());
            }

            public long nLong() throws IOException {
                return Long.parseLong(next());
            }

            public double nDouble() throws IOException {
                return Double.parseDouble(next());
            }

            String next() throws IOException {
                while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                    tokenizer = new StringTokenizer(bf.readLine());
                }
                return tokenizer.nextToken();
            }

            public void close() throws IOException {
                bf.close();
                out.flush();
            }

            public List<Integer> readArray(int n) throws IOException {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    list.add(nInt());
                }
                return list;
            }
        }
        public static Solution ofConsole() {
            return new Solution(System.in, new OutputStreamWriter(System.out));
        }
        public static Solution ofTestFile(String fileName) {
            InputStream resourceAsStream = Solution.class.getClassLoader().getResourceAsStream(fileName);
            return new Solution(resourceAsStream, new OutputStreamWriter(System.out));
        }
        public Solution(InputStream in, OutputStreamWriter iOut) {
            this.help = new Solution.Help(new BufferedReader(new InputStreamReader(in)), new PrintWriter(iOut));
        }
        public static void main(String... args) throws Exception {
            new Solution(System.in, new OutputStreamWriter(System.out)).read();
        }
        private final static String RESULT = "%sCase #%d: %s";


        void read() throws Exception {
            int testCases = help.nInt();
            for (int i = 1; i <= testCases; ++i) {
                int N = help.nInt();
                List<Integer> funValues = help.readArray(N);
                List<Integer> points = help.readArray(N);
                int fun = new Solver(N, funValues, points).dfs();
                help.out.printf(RESULT, i == 1 ? "" : "\n", i, fun);
                help.out.flush();
            }
            help.out.print("\n");
            help.close();
        }
    }

    static class Solver {
        private static final Node ABYSS = Node.abyss().asTriggered();
        Map<Integer, Node> map = new HashMap<>();
        Set<Integer> initiators = new HashSet<>();

        public Solver(int N, List<Integer> funValues, List<Integer> pointsTo) {
            map.put(0, ABYSS);
            for (int i = 1; i <= N; ++i) {
                Integer target = pointsTo.get(i-1);
                initiators.add(i);
                map.put(i, new Node(i, funValues.get(i-1), target));
            }
            for (int i = 0; i < N; i++) {
                initiators.remove(pointsTo.get(i));
            }
        }

        public int dfs() {
            int sumOfMax = 0;
            for (Integer initiator : initiators) {
                Node node = map.get(initiator);
                sumOfMax += initiate(node, node.fun);
            }
            return sumOfMax;
        }

        private int initiate(Node node, int fun) {
            if (node == ABYSS || node.triggered) {
                return fun;
            }
            node.triggered = true;
            return initiate(map.get(node.target), Math.max(fun, node.fun));
        }

        static class Node {
            final int id;
            final int fun;
            volatile boolean triggered;
            final int target;

            Node(int id, int fun, int target) {
                this.id = id;
                this.fun = fun;
                this.triggered = false;
                this.target = target;
            }

            public static Node abyss() {
                return new Node(-1, -1, -1);
            }

            public Node asTriggered() {
                triggered = true;
                return this;
            }
        }
    }
}
