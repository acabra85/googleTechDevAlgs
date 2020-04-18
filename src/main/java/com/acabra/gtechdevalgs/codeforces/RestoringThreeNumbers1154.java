package com.acabra.gtechdevalgs.codeforces;

import java.io.*;
import java.util.*;

public class RestoringThreeNumbers1154 {
    static public class Solution implements Runnable {
        void solve() throws IOException {
            int[] arr = {help.nInt(), help.nInt(), help.nInt(), help.nInt()};
            for (int o : solution(arr)) {
                System.out.print(o+" ");
            }
        }

        public static Collection<Integer> solution(int[] arr) {
            int sumIdx = findMaxIdx(arr);
            List<Integer> filtered = new ArrayList<>(3);
            for (int i = 0; i < arr.length; ++i) {
                if (i != sumIdx) {
                    filtered.add(arr[sumIdx] - arr[i]);
                }
            }
            filtered.sort(Comparator.comparingInt(a -> a));
            return filtered;
        }

        private static int findMaxIdx(int[] arr) {
            int idx = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; ++i) {
                if (arr[i] > max) {
                    idx = i;
                    max = arr[i];
                }
            }
            return idx;
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
        public static void main(String[] args) { new Thread(null, Solution.ofConsole(), "", 256 * (1L << 20)).start(); }
        public void run() {
            try {long t1 = System.nanoTime();Locale.setDefault(Locale.US);solve();if (!onlineJudge) System.err.println("Time = " + (System.nanoTime() - t1)/1000.0 + ": ms");}
            catch (Throwable t) {System.exit(-1);}
            finally {try {help.close();} catch (IOException e) {e.printStackTrace();}}
        }
        //--END helper submission code
    }
}
