package com.acabra.gtechdevalgs.gset.cjam2018;

import java.io.InputStream;
import java.util.Scanner;

public class Problem1_Waffles {

    static public class Solution {

        public static void main(String... args) throws Exception{
            solve(System.in);
        }

        public static void solve(InputStream is) {
            Scanner in  = new Scanner(is);
            int T, R, C, V, H;
            T = in.nextInt();
            for (int i = 1; i <= T; i++) {
                R = in.nextInt();
                C = in.nextInt();
                H = in.nextInt();
                V = in.nextInt();
                in.nextLine();
                boolean[][] waffle = new boolean[R][C];
                for (int j = 0; j < R; j++) {
                    String cCols = in.nextLine();
                    for (int k = 0; k < C; k++) {
                       waffle[j][k] = cCols.charAt(k) == '@';
                    }
                }
                boolean solved = false;
                System.out.println(String.format("Case #%d: %s", i, solved ? "POSSIBLE" : "IMPOSSIBLE"));
                System.out.flush();
            }

        }
    }
}
