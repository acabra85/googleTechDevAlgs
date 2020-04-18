package com.acabra.gtechdevalgs.codeforces;

import java.io.*;
import java.util.Locale;
import java.util.StringTokenizer;

public class BearAndBigBrother791A {
    static class Solution implements Runnable {

        private final Help help;
        private final boolean onlineJudge;
        static class Help {
            final BufferedReader bf;final PrintWriter out;StringTokenizer tokenizer;
            public Help(BufferedReader bf, PrintWriter out) {this.bf = bf;this.out = out;}
            public int nInt() throws IOException {return Integer.parseInt(next());}
            public long nLong() throws IOException {return Long.parseLong(next());}
            public double nDouble() throws IOException {return Double.parseDouble(next());}
            String next() throws IOException {while (tokenizer == null || !tokenizer.hasMoreTokens()) {tokenizer = new StringTokenizer(bf.readLine());}return tokenizer.nextToken();}
            public void close() throws IOException {bf.close();out.flush();}
        }
        public Solution(InputStream in, OutputStreamWriter iOut, boolean isOnlineJudge) {this.help = new Solution.Help(new BufferedReader(new InputStreamReader(in)), new PrintWriter(iOut)); this.onlineJudge = isOnlineJudge;}
        private static Solution ofConsole() { return new Solution(System.in, new OutputStreamWriter(System.out), true); }
        public static Solution ofTestFile(String fileName) { return new Solution(Solution.class.getClassLoader().getResourceAsStream(fileName), new OutputStreamWriter(System.out), false);}
        private static Solution get(String file) { return System.getProperty("ONLINE_JUDGE") != null ? ofConsole() : ofTestFile(file); }

        public static void main(String[] args) {
            new Thread(null, Solution.get("codeforces/below1000/791A.txt"), "", 256 * (1L << 20)).start();
        }

        public void run() {
            try {
                long t1 = System.nanoTime();
                Locale.setDefault(Locale.US);
                solve();
                long t2 = System.nanoTime();
                if (!onlineJudge) System.err.println("Time = " + (t2 - t1)/1000.0 + ": ms");
            } catch (Throwable t) {
                System.exit(-1);
            } finally {
                try {
                    help.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // solution
        void solve() throws IOException {
            System.out.println(solution(help.nInt(), help.nInt()));
        }

        public static int solution(int limak, int bob) {
            int ans = 0;
            while (limak <= bob) {
                limak *= 3;
                bob *= 2;
                ++ans;
            }
            return ans;
        }
    }
}
