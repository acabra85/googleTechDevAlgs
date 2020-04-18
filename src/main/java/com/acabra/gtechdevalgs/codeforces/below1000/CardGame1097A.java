package com.acabra.gtechdevalgs.codeforces.below1000;

import java.io.*;
import java.util.Locale;
import java.util.StringTokenizer;

public class CardGame1097A {
    static public class Solution implements Runnable {
        // solution
        void solve() throws IOException {
            System.out.println(solution(help));
        }

        public static String solution(Help help) throws IOException {
            String openCard = help.next();
            String handCard;
            for (int i = 0; i < 5; ++i) {
                handCard = help.next();
                if (sameSuit(openCard, handCard) || sameRank(openCard, handCard)) {
                    return "YES";
                }
            }
            return "NO";
        }

        private static boolean sameRank(String openCard, String handCard) {
            return openCard.charAt(1) == handCard.charAt(1);
        }

        private static boolean sameSuit(String openCard, String handCard) {
            return openCard.charAt(0) == handCard.charAt(0);
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
        public Solution(InputStream in, OutputStreamWriter iOut, boolean isOnlineJudge) {this.help = new Solution.Help(new BufferedReader(new InputStreamReader(in)), new PrintWriter(iOut)); this.onlineJudge = isOnlineJudge;}
        private static Solution ofConsole() { return new Solution(System.in, new OutputStreamWriter(System.out), true); }
        public static InputStream fileAsStream(String fileName) { return Solution.class.getClassLoader().getResourceAsStream(fileName); }
        public static Solution ofTestFile(String fileName) { return new Solution(Solution.class.getClassLoader().getResourceAsStream(fileName), new OutputStreamWriter(System.out), false);}
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
