package com.acabra.gtechdevalgs.gset.cjam2022.qround;

import java.io.*;
import java.util.StringTokenizer;

public class AsciiPunchCards {
    public static class Solution {
        private final static String RESULT = "%sCase #%d:\n%s";

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
            for(int i = 1; i <= testCases; ++i) {
                String iconStr = solveCase(help.nInt(), help.nInt());
                help.out.printf(RESULT, i==1?"":"\n",  i, iconStr);
                help.out.flush();
            }
            help.close();
        }

        private String solveCase(int R, int C) {
            String header = "..+" + "-+".repeat(C - 1);
            String footer = "\n+"+"-+".repeat(C);
            String line = "\n|" + ".|".repeat(C);
            //firstLine
            StringBuilder sb = new StringBuilder(header);
            sb.append("\n.").append(".|".repeat(C)).append(footer);
            for (int i = 1; i < R; i++) {
                sb.append(line)
                  .append(footer);
            }
            return sb.toString();
        }
    }
}
