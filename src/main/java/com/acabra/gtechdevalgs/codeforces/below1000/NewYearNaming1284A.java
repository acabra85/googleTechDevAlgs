package com.acabra.gtechdevalgs.codeforces.below1000;

import java.util.Scanner;

public class NewYearNaming1284A {
    static public class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String[] s = new String[sc.nextInt()];
            String[] t = new String[sc.nextInt()];
            for (int i = 0; i < s.length; ++i) {
                s[i] = sc.next();
            }
            for (int i = 0; i < t.length; ++i) {
                t[i] = sc.next();
            }
            int q = sc.nextInt();
            int qi;
            while(q-- > 0) {
                qi = sc.nextInt();
                System.out.println(solution(s, t, qi));
            }
        }

        public static String solution(String[] s, String[] t, int qi) {
            int idxA = (qi % s.length) - 1;
            int idxB = (qi % t.length) - 1;
            if(idxA == -1) idxA = s.length - 1;
            if(idxB == -1) idxB = t.length - 1;
            return s[idxA] + t[idxB];
        }
    }
}