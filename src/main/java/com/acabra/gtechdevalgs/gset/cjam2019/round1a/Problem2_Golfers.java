package com.acabra.gtechdevalgs.gset.cjam2019.round1a;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem2_Golfers {

    public static class Solution {
        public static void main(String... args) throws Exception {
            new Solver(new BufferedReader(new InputStreamReader(System.in))).solve();
        }
    }

    public static class Solver {

        private final BufferedReader bf;

        public Solver(BufferedReader bf) {
            this.bf = bf;
        }

        public void solve() throws Exception {
            String[] T_N_M = bf.readLine().split("\\s+");
            int testCases = Integer.parseInt(T_N_M[0]);
            int N = Integer.parseInt(T_N_M[1]);
            int M = Integer.parseInt(T_N_M[2]);
            for (int i = 1; i <= testCases; i++) {
                System.out.println(solutionLine(i));
                System.out.flush();
            }
        }

        public String solutionLine(int caseN) {
            return String.format("Case #%d: ", caseN);
        }
    }
}
