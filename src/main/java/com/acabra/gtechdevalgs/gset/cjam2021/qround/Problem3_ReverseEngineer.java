package com.acabra.gtechdevalgs.gset.cjam2021.qround;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Describe your class
 */
public class Problem3_ReverseEngineer {

    static class Solution {
        private final static String RESULT = "%sCase #%d: %s";

        private final Help help;

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
        public static Solution ofConsole() {
            return new Solution(System.in, new OutputStreamWriter(System.out));
        }

        public static Solution ofTestFile(String fileName) {
            InputStream resourceAsStream = Solution.class.getClassLoader().getResourceAsStream(fileName);
            return new Solution(resourceAsStream, new OutputStreamWriter(System.out));
        }

        public Solution(InputStream in, OutputStreamWriter iOut) {
            this.help = new Solution.Help(new BufferedReader(new InputStreamReader(in)), new PrintWriter(iOut));
        }

        public static void main(String... args) throws Exception {
            new Solution(System.in, new OutputStreamWriter(System.out)).read();
        }

        public void read() throws Exception {
            int testCases = help.nInt();
            for(int i = 1; i <= testCases; i++) {
                help.out.printf(RESULT, i==1?"":"\n",  i, solveCase(help.nInt(), help.nInt()));
                help.out.flush();
            }
            help.close();
        }

        private static String solveCase(int N, int C) {
            return "s";
        }

        private int costReverseSort(int[] nums) {
            int totalCost=0;
            boolean sorted = false;
            for (int i = 0; i < nums.length; i++) {
                sorted = sorted || isSorted(nums);
                if (sorted) {
                    return totalCost + nums.length - i - 1;
                }
                int j = findMinPos(nums, i);
                totalCost += j-i+1;
                reverse(nums, i, j + 1);
            }
            return totalCost;
        }

        private boolean isSorted(int[] nums) {
            for (int i = 0; i < nums.length - 1; i++) {
                if(nums[i] > nums[i+1]) {
                    return false;
                }
            }
            return true;
        }

        private void reverse(int[] array, int startIndexInclusive, int endIndexExclusive) {
            if (array != null) {
                int i = startIndexInclusive < 0 ? 0 : startIndexInclusive;

                for(int j = Math.min(array.length, endIndexExclusive) - 1; j > i; ++i) {
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                    --j;
                }

            }
        }

        private int findMinPos(int[] nums, int start) {
            int minPos = 0;
            int minVal = Integer.MAX_VALUE;
            for (int i = start; i < nums.length; i++) {
                if (nums[i] < minVal) {
                    minVal = nums[i];
                    minPos = i;
                }
            }
            return minPos;
        }
    }
}
