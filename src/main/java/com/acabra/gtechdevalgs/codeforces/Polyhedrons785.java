package com.acabra.gtechdevalgs.codeforces;

import java.io.*;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

public class Polyhedrons785 {
    static public class Solution implements Runnable {
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
            static Help of(InputStream in, OutputStreamWriter iOut) {return new Help(new BufferedReader(new InputStreamReader(in)), new PrintWriter(iOut));}
        }
        public Solution(InputStream in, boolean isOnlineJudge) {this.help = Solution.Help.of(in); this.onlineJudge = isOnlineJudge;}
        private static Solution ofConsole() { return new Solution(System.in, true); }
        public static Solution ofTestFile(String fileName) { return new Solution(fileAsStream(fileName), false);}
        public static InputStream fileAsStream(String fileName) { return Solution.class.getClassLoader().getResourceAsStream(fileName); }
        private static Solution get(String file) { return System.getProperty("ONLINE_JUDGE") != null ? ofConsole() : ofTestFile(file); }

        public static void main(String[] args) {
            new Thread(null, Solution.get("codeforces/below1000/705A_0.txt"), "", 256 * (1L << 20)).start();
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
            System.out.println(solution(help));
        }

        private static final Map<String, Integer> NAME_TO_SIDES = Map.of("Tetrahedron", 4, "Cube", 6, "Octahedron", 8, "Dodecahedron", 12, "Icosahedron", 20);

        public static int solution(Help help) throws IOException {
            int n = help.nInt();
            int total = 0;
            for (int i = 0; i < n; ++i) {
                total += NAME_TO_SIDES.get(help.next());
            }
            return total;
        }
    }
}
