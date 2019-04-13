package com.acabra.gtechdevalgs.gset.cjam2019.qround;


import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Problem1_OversizedCheck {

    static class Solution {

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
        }

        public Solution(InputStream in, OutputStreamWriter iOut) {
            this.help = new Help(new BufferedReader(new InputStreamReader(in)), new PrintWriter(iOut));
        }

        public static void main(String... args) throws Exception {
            new Solution(System.in, new OutputStreamWriter(System.out)).read();
        }

        public void read() throws Exception {
            int testCases = help.nInt();
            for(int i = 1; i <= testCases; i++) {
                CheckResult result = solve_str(help.next());
                help.out.printf("%sCase #%d: %s %s", i==1?"":"\n",  i, result.a, result.b);
                help.out.flush();
            }
            help.close();
        }

        CheckResult solve_pow(String nStr) {
            BigInteger N = new BigInteger(nStr);
            int idx = nStr.indexOf('4');
            int pow = nStr.length() - idx - 1;
            BigInteger B = BigInteger.ZERO;
            char curr;
            for (int j = idx; j < nStr.length(); j++, pow--) {
                curr = nStr.charAt(j);
                if (curr == '4') {
                    B = B.add(BigInteger.TEN.pow(pow));
                }
            }
            return CheckResult.of(N.subtract(B).toString(), B.toString());
        }

        CheckResult solve_str(String nStr) {
            int idx = nStr.indexOf('4');
            StringBuilder sbB = new StringBuilder();
            StringBuilder sbA = new StringBuilder();
            char curr;
            for (int j = 0; j < idx; j++) {
                sbA.append(nStr.charAt(j));
            }
            for (int j = idx; j < nStr.length(); j++) {
                curr = nStr.charAt(j);
                if (curr == '4') {
                    sbA.append('3');
                    sbB.append('1');
                } else {
                    sbA.append(curr);
                    sbB.append('0');
                }
            }
            return CheckResult.of(sbA.toString(), sbB.toString());
        }

        static class CheckResult {
            public final String a;
            public final String b;

            public CheckResult(String a, String b) {
                this.a = a;
                this.b = b;
            }

            public static CheckResult of(String A, String B) {
                return new CheckResult(A, B);
            }
        }
    }

}
