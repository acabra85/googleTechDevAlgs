package com.acabra.gtechdevalgs.gset.cjam2022.qround;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P3_DiceStraight {
    static public class Solution {

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

        private final static String RESULT = "%sCase #%d: %d";

        public void read() throws Exception {
            int testCases = help.nInt();
            for(int i = 1; i <= testCases; ++i) {
                help.out.printf(RESULT, i==1?"":"\n",  i, solveCase(help));
                help.out.flush();
            }
            help.close();
        }

        private int solveCase(Help help) throws IOException {
            int n = help.nInt();
            List<Integer> dice = new ArrayList<>(n);
            int max = -1;
            for (int i = 0; i < n; ++i) {
                dice.add(help.nInt());
                max = Math.max(max, dice.get(i));
            }
            if(n<=4) return n;
            return solve(n, dice, max);
        }

        protected int solve(int n, List<Integer> dice, int max) {
            dice.sort(Integer::compareTo);
            int sx=0;
            for (int i = 0; i < n;++i) {
                if(dice.get(i) > sx) {
                    ++sx;
                }
            }
            return sx;
        }
    }
}
