package com.acabra.gtechdevalgs.gset.cjam2021.qround;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Problem2_MoonsUmbrellas {

    static class Solution {
        private final static String RESULT = "%sCase #%d: %d";

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

        public void read() throws Exception {
            int testCases = help.nInt();
            for(int i = 1; i <= testCases; i++) {
                int result = solveCase(help.nInt(), help.nInt(), help.next());
                help.out.printf(RESULT, i==1?"":"\n",  i, result);
                help.out.flush();
            }
            help.close();
        }

        protected static int solveCase(int x, int y, String muralStr) {
            char[] mural = muralStr.toCharArray();
            CJResult result = process(mural);
            if (result.c == 0 || result.j == 0) {
                return 0;
            }
            if (result.gaps == 0) {
                return regularCost(x, y, mural);
            }
            return optimizeCost(x, y, mural);
        }

        private static int optimizeCost(int x, int y, char[] mural) {
            String minimized = optimizeString(mural);
            mural = minimized.toCharArray();
            int cost = 0;
            int start = mural[0] == '?' ? 1 : 0;
            int end = mural[mural.length - 1] == '?' ? mural.length - 1 : mural.length;
            for (int i = start + 1; i < end; ++i) {
                if (mural[i]!= mural[i-1]){
                    String key = mural[i-1] + "" +  mural[i];
                    if(key.equals("CJ")) {
                        cost+=x;
                    } else if("JC".equals(key)) {
                        cost += y;
                    } else {
                        if("J?".equals(key)) {
                            mural[i] = 'J';
                        } else if("C?".equals(key)) {
                            mural[i] = 'C';
                        }
                    }
                }
            }
            return cost;
        }

        protected static String optimizeString(char[] mural) {
            StringBuilder minimized = new StringBuilder();
            for (int i = 0; i < mural.length; i++) {
                if(mural[i] == 'C' || mural[i] == 'J' || i == mural.length - 1) {
                    minimized.append(mural[i]);
                } else if(mural[i+1] != '?') {
                    minimized.append(mural[i]);
                }
            }
            return minimized.toString();
        }

        private static CJResult process(char[] mural) {
            int gaps = 0;
            int c = 0;
            int j = 0;
            for(char i: mural) {
                switch (i) {
                    case '?':
                        ++gaps;
                        break;
                    case 'C':
                        ++c;
                        break;
                    default:
                        ++j;
                        break;
                }
            }
            return new CJResult(c, j, gaps);
        }

        private static int regularCost(int x, int y, char[] mural) {
            int cost = 0;
            for (int i = 0; i < mural.length - 1; i++) {
                if(mural[i] != mural[i+1]) {
                    if (mural[i] == 'C') {
                        cost += x;
                    } else {
                        cost += y;
                    }
                }
            }
            return cost;
        }

        private static class CJResult {
            private final int c;
            private final int j;
            private final int gaps;

            public CJResult(int c, int j, int gaps) {
                this.c = c;
                this.j = j;
                this.gaps = gaps;
            }
        }
    }
}
