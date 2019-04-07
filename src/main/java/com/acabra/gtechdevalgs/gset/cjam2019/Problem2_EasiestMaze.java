package com.acabra.gtechdevalgs.gset.cjam2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Problem2_EasiestMaze {

static class Solution {

    public static void main(String... args) {
        new Solution().read();
    }

    private void read() {
        //InputStream in = System.in;
        InputStream in = Problem2_EasiestMaze.class.getClassLoader().getResourceAsStream("Problem2_test01.txt");
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(in))) {
            int testCases = toLong(bf.readLine()).intValue();
            for(int i = 1; i <= testCases; i++) {
                solve(i, toLong(bf.readLine()).intValue(), bf.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void solve(int caseN, int N, String lydiasSteps) {
        StringBuilder mySteps = new StringBuilder();
        for (int i = 0; i < lydiasSteps.length() ; i++) {
            mySteps.append(lydiasSteps.charAt(i) == 'E' ? 'S' : 'E');
        }
        printSolution(caseN, mySteps.toString());
    }

    private void printSolution(int caseN, String mySteps) {
        System.out.println(String.format("Case #%d: " + mySteps, caseN));
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
