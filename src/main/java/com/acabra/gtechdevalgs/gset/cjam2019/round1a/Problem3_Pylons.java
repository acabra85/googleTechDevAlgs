package com.acabra.gtechdevalgs.gset.cjam2019.round1a;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem3_Pylons {

    public static class Solution {

//        public static Solution ofTestFile(String testFile) {
//            return new Solver(Solution.class.getClassLoader().getResourceAsStream(testFile), new OutputStreamWriter(System.out));
//        }
        public static void main(String... args) throws Exception {
            new Solver(new BufferedReader(new InputStreamReader(System.in)), new PrintWriter(new OutputStreamWriter(System.out))).solve();
        }

        public static class Solver {

            private final BufferedReader bf;
            private final PrintWriter pw;
            private boolean SOLVED = false;

            public Solver(BufferedReader bf, PrintWriter iPw) {
                this.bf = bf;
                this.pw = iPw;
            }

            public void solve() throws Exception {
                int testCases = Integer.parseInt(bf.readLine());
                for (int i = 1; i <= testCases; i++) {
                    String[] R_C = bf.readLine().split("\\s+");
                    int R = Integer.parseInt(R_C[0]);
                    int C = Integer.parseInt(R_C[1]);
                    SOLVED = false;
                    attemptToSolve(R, C, i);
                    if (!SOLVED) System.out.println(String.format("Case #%d: IMPOSSIBLE", i));
                    System.out.flush();
                }
            }

            private void attemptToSolve(int r, int c, int caseN) {
                int[][] grid = new int[r][c];
                tour(grid, r, c, 0, 0, 1,  new Stack<>(), caseN);
            }

            private void tour(int[][] grid, int r, int c, int x, int y, int pos, Stack<Step> steps, int caseN) {
                grid[x][y] = pos;
                steps.push(new Step(x, y));
                if (pos >= r*c) {
                    if (pos == r*c){
                        System.out.println(String.format("Case #%d: POSSIBLE", caseN));
                        while(!steps.isEmpty()) {
                            System.out.println(steps.pop());
                        }
                        SOLVED = true;
                    }
                    return;
                }
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (grid[i][j]==0 && !invalid(i, j, x, y)) {
                            tour(grid, r, c, i, j, pos + 1, steps, caseN);
                        }
                    }
                }

                grid[x][y] = 0;
                if(!steps.isEmpty()) steps.pop();
            }

            private boolean invalid(int i, int j, int x, int y) {
                return i == x || j == y || x-y == i - j || x+y == i+j;
            }

            private class Step {
                final int x;
                final int y;

                public Step(int x, int y) {
                    this.x = x + 1;
                    this.y = y + 1;
                }

                @Override
                public String toString() {
                    return x + " " + y;
                }
            }
        }
    }

    BufferedReader reader;
    StringTokenizer tokenizer;
    PrintWriter out;

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }


}
