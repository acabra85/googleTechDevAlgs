package com.acabra.gtechdevalgs.gset.cjam2019.qround;

import java.io.*;
import java.util.HashMap;
import java.util.Objects;
import java.util.StringTokenizer;

public class Problem2_EasiestMaze {

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

        public void printf(String s, Object... args) {
            out.printf(s, args);
            out.flush();
        }
    }

    public Solution(InputStream in, OutputStreamWriter iOut) {
        this.help = new Help(new BufferedReader(new InputStreamReader(in)), new PrintWriter(iOut));
    }

    public static void main(String... args) throws Exception {
        new Solution(System.in, new OutputStreamWriter(System.out)).read();
    }

    void read() throws IOException {
        int testCases = help.nInt();
        for(int i = 1; i <= testCases; i++) {
            String mySteps = solve(help.nInt(), help.next());
            help.printf("%sCase #%d: " + mySteps, i==1 ? "": "\n", i);
        }
        help.close();
    }

    String solve(int N, String lydiasSteps) {
        StringBuilder mySteps = new StringBuilder();
        for (int i = 0; i < lydiasSteps.length() ; i++) {
            mySteps.append(lydiasSteps.charAt(i) == 'E' ? 'S' : 'E');
        }
        return mySteps.toString();
    }private static class MyPoint {

        private final int x;
        private final int y;

        public MyPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static MyPoint of(int x, int y) {
            return new MyPoint(x, y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyPoint myPoint = (MyPoint) o;
            return x == myPoint.x &&
                    y == myPoint.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public MyPoint east() {
            return of(this.x + 1, this.y);
        }

        public MyPoint south() {
            return of(this.x, this.y + 1);
        }
    }

    static boolean validateAnswer(int N, String mySteps, String lydiasSteps) {
        HashMap<MyPoint, MyPoint> fromTo = new HashMap<>();
        MyPoint step = MyPoint.of(0, 0);
        MyPoint next;
        for (int i = 0; i < N; i++) {
            next = lydiasSteps.charAt(i) == 'E' ? step.east() : step.south();
            fromTo.put(step, next);
            step = next;
        }
        step = MyPoint.of(0, 0);
        for (int i = 0; i < N; i++) {
            next = mySteps.charAt(i) == 'E' ? step.east() : step.south();
            if (next.equals(fromTo.get(step))) {
                return false;
            }
            step = next;
        }
        return true;
    }
}

}
