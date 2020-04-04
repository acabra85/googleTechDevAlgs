package com.acabra.gtechdevalgs.gset.cjam2019.round1a;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1_AlienRhyme {

    public static class Solution {

        protected final Help help;

        public static Solution ofConsole() {
            return new Solution(System.in, new OutputStreamWriter(System.out));
        }

        public static Solution ofTestFile(String fileName) {
            InputStream resourceAsStream = Solution.class.getClassLoader().getResourceAsStream(fileName);
            return new Solution(resourceAsStream, new OutputStreamWriter(System.out));
        }

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

            public void printsol(String solutionLine, int caseN, Object... args) {
                out.printf("%sCase #%d: " + solutionLine, caseN==1?"":"\n", caseN, args);
                out.flush();
            }
        }

        public Solution(InputStream in, OutputStreamWriter iOut) {
            this.help = new Help(new BufferedReader(new InputStreamReader(in)), new PrintWriter(iOut));
        }

        public static void main(String... args) throws Exception {
            Solution.ofConsole().read();
        }

        public void read() throws Exception {
            int testCases = help.nInt();
            for (int i = 1; i <= testCases; i++) {
                int numWords = help.nInt();
                help.printsol("%d", numWords);
            }
            help.close();
        }
    }
}
