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
        public final static int INK_REQ = 1_000_000;
        private static final DColors IMPOSSIBLE_COLOR = new DColors(null, 0);

        enum DColorIds {
            C(0), M(1), Y(2), K(3);

            public final int id;

            DColorIds(int id) {
                this.id = id;
            }
        }

        public void read() throws Exception {
            int testCases = help.nInt();
            for(int i = 1; i <= testCases; ++i) {
                DPrinter p1 = buildPrinterFromHelp(help);
                DPrinter p2 = buildPrinterFromHelp(help);
                DPrinter p3 = buildPrinterFromHelp(help);
                DColors colors = solveCase(new DPrinters(p1, p2, p3), DFS);
                help.out.printf(RESULT, i==1?"":"\n",  i, colors.toString());
                help.out.flush();
            }
            help.out.print("\n");
            help.close();
        }

        private static DColors dfs(DPrinters printers) {
            final Stack<Node> dq = new Stack<>();
            dq.push(new Node(printers));
            while(dq.size() > 0) {
                Node node = dq.pop();
                if(node.ready()) {
                    return node.color;
                }
                node.children().forEach(dq::push);
            }
            return IMPOSSIBLE_COLOR;
        }

        private static DColors bfs(DPrinters prins) {
            ArrayDeque<Node> dq = new ArrayDeque<>();
            dq.add(new Node(prins));
            while(dq.size() > 0) {
                Node node = dq.remove();
                if(node.ready()) {
                    return node.color;
                }
                dq.addAll(node.children());
            }
            return IMPOSSIBLE_COLOR;
        }

        public static DColors solveCase(DPrinters printers, boolean dfs) {
            return dfs ? dfs(printers) : bfs(printers);
        }

        private static DPrinter buildPrinterFromHelp(Help help) throws IOException {
            return new DPrinter(help.nInt(), help.nInt(), help.nInt(), help.nInt());
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

            private Node(int depth, DPrinters prins, DColors color){
                this.prins = prins;
                this.color = color;
                this.depth = depth;
            }

            private Collection<Node> children() {
                Collection<Node> list = new ArrayList<>();
                int newDepth = depth + 1;
                for (DColorIds colorId : DColorIds.values()) {
                    process(colorId, list, newDepth);
                }
                return list;
            }

            private void process(DColorIds colorId, Collection<Node> list, int newDepth) {
                int min = prins.minimalInkAvailableOnAllPrinters(colorId);
                if(min > 0) {
                    int qty = Math.min(color.missing, min);
                    Node child = new Node(newDepth, this.prins.minus(colorId, qty), color.add(colorId, qty));
                    list.add(child);
                }
            }

            public boolean ready() {
                return color.total == INK_REQ;
            }
        }

        protected static class DPrinters {
            final DPrinter p1;
            final DPrinter p2;
            final DPrinter p3;

            protected DPrinters(DPrinter p1, DPrinter p2, DPrinter p3) {
                this.p1 = p1;
                this.p2 = p2;
                this.p3 = p3;
            }

            public DPrinters minus(DColorIds colorId, int min) {
                return new DPrinters(p1.cloneMinus(colorId, min), p2.cloneMinus(colorId, min), p3.cloneMinus(colorId, min));
            }

            public int minimalInkAvailableOnAllPrinters(DColorIds color) {
                return Math.min(p1.get(color), Math.min(p2.get(color), p3.get(color)));
            }

            static DPrinters fromMatrix(int[][] printers) {
                return new DPrinters(new DPrinter(printers[0]), new DPrinter(printers[1]),
                        new DPrinter(printers[2]));
            }
        }

        static class DColors {
            final int missing;
            final int total;
            final int[] ink;

            DColors() {
                this.ink = new int[]{0, 0, 0, 0};
                this.total = 0;
                this.missing = INK_REQ;
            }

            DColors(int[] ink, int total) {
                this.ink = ink;
                this.total = total;
                this.missing = INK_REQ - total;
            }

            public DColors add(DColorIds colorId, int qty) {
                int[] copy = Arrays.copyOf(ink, ink.length);
                copy[colorId.id] =  copy[colorId.id] + qty;
                return new DColors(copy, total + qty);
            }

            public boolean equals(Object o) {
                return o != null && o.getClass() == DColors.class && o.toString().equals(toString());
            }

            @Override
            public String toString() {
                if(missing == 0) {
                    return ink[DColorIds.C.id] + " " + ink[DColorIds.M.id]
                            + " " + ink[DColorIds.Y.id] + " " + ink[DColorIds.K.id];
                }
                return "IMPOSSIBLE";
            }
        }

        private static class DPrinter {
            private final int[] ink;

            private DPrinter(int[] ink) {
                this.ink = ink;
            }

            public DPrinter(int c, int m, int y, int k) {
                this.ink = new int[]{c, m, y, k};
            }

            public DPrinter cloneMinus(DColorIds id, int minus) {
                int[] copyOf = Arrays.copyOf(ink, ink.length);
                copyOf[id.id] = copyOf[id.id] - minus;
                return new DPrinter(copyOf);
            }

            public int get(DColorIds colorId) {
                return ink[colorId.id];
            }
        }
    }
}
