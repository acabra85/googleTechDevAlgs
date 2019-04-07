package com.acabra.gtechdevalgs.gset.cjam2019;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LongSummaryStatistics;

public class Problem1_OversizedChecked {

    private static class Solution {

        public void test_performance(){
            LongSummaryStatistics pow = new LongSummaryStatistics();
            LongSummaryStatistics str = new LongSummaryStatistics();

            for (int i = 0; i < 1000; i++) {
                pow.accept(new Solution().read_measure(true));
                str.accept(new Solution().read_measure(false));
            }
            System.out.println("POW:"  + pow);
            System.out.println("str:"  + str);
        }

        private long read_measure(boolean pow) {
            InputStream in = Problem1_OversizedChecked.class.getClassLoader().getResourceAsStream("Problem1_test01.txt");
            long startTime = System.nanoTime();
            try(BufferedReader bf = new BufferedReader(new InputStreamReader(in))) {
                Long testCases = toLong(bf.readLine());
                for(int i = 1; i <= testCases; i++) {
                    String nStr = bf.readLine();
                    if (pow)
                        solve_pow(nStr, i);
                    else
                        solve_str(nStr, i);
                }
                return System.nanoTime() - startTime;
                //System.out.println((pow?"P":"S") + ": " + total);
            } catch (IOException e) {
                e.printStackTrace();
            }
            throw new NullPointerException();
        }

        public static void main(String... args) {
            new Solution().read();
        }

        private void read() {
            try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
                Long testCases = toLong(bf.readLine());
                for(int i = 1; i <= testCases; i++) {
                    solve_str(bf.readLine(), i);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void solve_pow(String nStr, int i) {
            long N = toLong(nStr);
            int idx = nStr.indexOf('4');
            int pow = nStr.length() - idx - 1;
            long B = 0L;
            char curr;
            for (int j = idx; j < nStr.length(); j++, pow--) {
                curr = nStr.charAt(j);
                if (curr == '4') {
                    B += Math.pow(10, pow);
                }
            }
            printSolution(i, N-B, B);
        }

        private void solve_str(String nStr, int i) {
            long N = toLong(nStr);
            int idx = nStr.indexOf('4');
            int pow = nStr.length() - idx - 1;
            StringBuilder sbB = new StringBuilder();
            char curr;
            for (int j = idx; j < nStr.length(); j++, pow--) {
                curr = nStr.charAt(j);
                if (curr == '4') {
                    sbB.append(1);
                } else {
                    sbB.append(0);
                }
            }
            long B = toLong(sbB.toString());
            printSolution(i, N-B, B);
        }

        private void printSolution(int caseN, long A, long B) {
            System.out.println(String.format("Case #%d: %d %d", caseN, A, B));
        }

        private Long toLong(String readLine) {
            try{
                return Long.parseLong(readLine);
            }catch (Exception e) {
                return -1L;
            }
        }
    }

}
