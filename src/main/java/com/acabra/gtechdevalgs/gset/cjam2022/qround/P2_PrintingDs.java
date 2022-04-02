package com.acabra.gtechdevalgs.gset.cjam2022.qround;

import java.io.*;
import java.util.*;

public class P2_PrintingDs {
    public static class Solution {
        private final Help help;
        private static boolean DFS = false;
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
        }
        public static Solution ofConsole() {
            return new Solution(System.in, new OutputStreamWriter(System.out));
        }
        public static Solution ofTestFile(String fileName, boolean dfs) {
            DFS = dfs;
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
        private final static int INK_REQ = 1000000;

        public void read() throws Exception {
            int testCases = help.nInt();
            for(int i = 1; i <= testCases; ++i) {
                DColors colors = solveCase(help, DFS);
                String result = colors != null ? colors.toString() : "IMPOSSIBLE";
                help.out.printf(RESULT, i==1?"":"\n",  i, result);
                help.out.flush();
            }
            help.out.print("\n");
            help.close();
        }

        private DColors dfs(DPrinters prins) {
            final Stack<Node> dq = new Stack<>();
            dq.push(new Node(prins));
            while(dq.size() > 0) {
                Node node = dq.pop();
                if(node.color.valid()) {
                    return node.color;
                }
                node.children().forEach(dq::push);
            }
            return null;
        }

        private DColors solveCase(Help help, boolean dfs) throws IOException {
            DPrinter p1 = new DPrinter(help.nInt(), help.nInt(), help.nInt(), help.nInt());
            DPrinter p2 = new DPrinter(help.nInt(), help.nInt(), help.nInt(), help.nInt());
            DPrinter p3 = new DPrinter(help.nInt(), help.nInt(), help.nInt(), help.nInt());
            DPrinters prins = new DPrinters(p1, p2, p3);
            return dfs ? dfs(prins) : bfs(prins);
        }

        private DColors bfs(DPrinters prins) {
            ArrayDeque<Node> dq = new ArrayDeque<>();
            dq.add(new Node(prins));
            while(dq.size() > 0) {
                Node node = dq.remove();
                if(node.color.valid()) {
                    return node.color;
                }
                dq.addAll(node.children());
            }
            return null;
        }

        private static class Node {
            final DPrinters prins;
            final DColors color;
            final int depth;

            private Node(DPrinters prins) {
                this.prins = prins;
                this.color = new DColors();
                this.depth = 0;
            }

            public String toString() {
                return "ps:[" + prins.toString() + "]" + "c:[" + color.toString() +  "] d:" + depth;
            }

            private Node(int depth, DPrinters prins, DColors color){
                this.prins = prins;
                this.color = color;
                this.depth = depth;
            }

            public Collection<Node> children() {
                Collection<Node> list = new ArrayList<>();
                int newDepth = depth + 1;
                processC(list, newDepth);
                processM(list, newDepth);
                processY(list, newDepth);
                processK(list, newDepth);
                return list;
            }

            private void processC(Collection<Node> list, int newDepth) {
                int minC = Math.min(prins.p1.c, Math.min(prins.p2.c, prins.p3.c));
                if(minC > 0) {
                    minC = Math.min(color.missing, minC);
                    DPrinters prins = this.prins.minusC(minC);
                    Node child = new Node(newDepth, prins, color.addC(minC));
                    list.add(child);
                }
            }

            private void processM(Collection<Node> list, int newDepth) {
                int minM = Math.min(prins.p1.m, Math.min(prins.p2.m, prins.p3.m));
                if(minM > 0) {
                    minM = Math.min(color.missing, minM);
                    DPrinters prins = this.prins.minusM(minM);
                    Node child = new Node(newDepth, prins, color.addM(minM));
                    list.add(child);
                }
            }

            private void processY(Collection<Node> list, int newDepth) {
                int minY = Math.min(prins.p1.y, Math.min(prins.p2.y, prins.p3.y));
                if(minY > 0) {
                    minY = Math.min(color.missing, minY);
                    DPrinters prins = this.prins.minusY(minY);
                    Node child = new Node(newDepth, prins, color.addY(minY));
                    list.add(child);
                }
            }

            private void processK(Collection<Node> list, int newDepth) {
                int minK = Math.min(prins.p1.k, Math.min(prins.p2.k, prins.p3.k));
                if(minK > 0) {
                    minK = Math.min(color.missing, minK);
                    DPrinters prins = this.prins.minusK(minK);
                    Node child = new Node(newDepth, prins, color.addK(minK));
                    list.add(child);
                }
            }
        }

        private static class DPrinters {
            final DPrinter p1;
            final DPrinter p2;
            final DPrinter p3;

            private DPrinters(DPrinter p1, DPrinter p2, DPrinter p3) {
                this.p1 = p1;
                this.p2 = p2;
                this.p3 = p3;
            }

            public DPrinters minusC(int minC) {
                return new DPrinters(p1.cloneMinusC(minC), p2.cloneMinusC(minC), p3.cloneMinusC(minC));
            }

            public DPrinters minusM(int minM) {
                return new DPrinters(p1.cloneMinusM(minM), p2.cloneMinusM(minM), p3.cloneMinusM(minM));
            }

            public DPrinters minusY(int minY) {
                return new DPrinters(p1.cloneMinusY(minY), p2.cloneMinusY(minY), p3.cloneMinusY(minY));
            }

            public DPrinters minusK(int minK) {
                return new DPrinters(p1.cloneMinusK(minK), p2.cloneMinusK(minK), p3.cloneMinusK(minK));
            }
        }

        private static class DColors {
            final int c;
            final int m;
            final int y;
            final int k;
            final int missing;
            final int total;

            DColors() {
                this.c = 0;
                this.m = 0;
                this.y = 0;
                this.k = 0;
                this.total = 0;
                this.missing = INK_REQ;
            }

            DColors(int c, int m, int y, int k, int total) {
                this.c = c;
                this.m = m;
                this.y = y;
                this.k = k;
                this.total = total;
                this.missing = INK_REQ - total;
            }

            @Override
            public String toString() {
                return c + " " + m + " " + y + " " + k;
            }

            DColors addC(int plusC) {
                return new DColors(c + plusC, m, y, k, total + plusC);
            }

            DColors addM(int plusM) {
                return new DColors(c, m + plusM, y, k, total+plusM);
            }

            DColors addY(int plusY) {
                return new DColors(c , m, y + plusY, k, total+plusY);
            }

            DColors addK(int plusK) {
                return new DColors(c , m, y, k + plusK, total+plusK);
            }

            public boolean valid() {
                return total == INK_REQ;
            }
        }

        private static class DPrinter {
            private final int c;
            private final int m;
            private final int y;
            private final int k;

            private DPrinter(int c, int m, int y, int k) {
                this.c =c;
                this.m =m;
                this.y =y;
                this.k =k;
            }

            @Override
            public String toString() {
                return c + " " + m + " " + y + " " + k;
            }

            public DPrinter cloneMinusC(int minC) {
                return new DPrinter(c - minC, m, y, k);
            }

            public DPrinter cloneMinusM(int minusM) {
                return new DPrinter(c, m - minusM, y, k);
            }

            public DPrinter cloneMinusY(int minY) {
                return new DPrinter(c, m, y - minY, k);
            }

            public DPrinter cloneMinusK(int minK) {
                return new DPrinter(c, m, y, k - minK);
            }
        }
    }
}
