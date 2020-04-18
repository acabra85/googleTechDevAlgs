package com.acabra.gtechdevalgs.codeforces.below1000;

import java.io.*;
import java.util.Locale;
import java.util.StringTokenizer;

public class SearchEasyProblem1030A {
    static class Solution implements Runnable {
        // solution
        void solve() throws IOException {
            System.out.println(solution(help));
        }

        public static String solution(Help help) throws IOException {
            int n = help.nInt();
            for (int i = 0; i < n; ++i) {
                if (help.nInt() != 0) return "HARD";
            }
            return "EASY";
        }

        //--START helper submission code
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
            public static Help of(InputStream in) { return of(in, new OutputStreamWriter(System.out)); }
            public static Help of(String fileName) { return of(fileAsStream(fileName), new OutputStreamWriter(System.out)); }
            static Help of(InputStream in, OutputStreamWriter iOut) {return new Help(new BufferedReader(new InputStreamReader(in)), new PrintWriter(iOut));}
        }
        public Solution(InputStream in, boolean isOnlineJudge) {this.help = Solution.Help.of(in); this.onlineJudge = isOnlineJudge;}
        private static Solution ofConsole() { return new Solution(System.in, true); }
        public static Solution ofTestFile(String fileName) { return new Solution(fileAsStream(fileName), false);}
        public static InputStream fileAsStream(String fileName) { return Solution.class.getClassLoader().getResourceAsStream(fileName); }
        private static Solution get(String file) { return System.getProperty("ONLINE_JUDGE") != null ? ofConsole() : ofTestFile(file); }
        public static void main(String[] args) {new Thread(null, Solution.ofConsole(), "", 256 * (1L << 20)).start();}
        public void run() {
            try {long t1 = System.nanoTime();Locale.setDefault(Locale.US);solve();if (!onlineJudge) System.err.println("Time = " + (System.nanoTime() - t1)/1000.0 + ": ms");}
            catch (Throwable t) {System.exit(-1);}
            finally {try {help.close();} catch (IOException e) {e.printStackTrace();}}
        }
        //--END helper submission code
    }
}
