package com.acabra.gtechdevalgs.gset.cjam2022.qround;

import org.junit.jupiter.api.Test;

class P2_PrintingDsTest {

    @Test
    public void testBfs() throws Exception {
        long start = System.currentTimeMillis();
        P2_PrintingDs.Solution solution = P2_PrintingDs.Solution.ofTestFile("cjam2022/qround/p2.txt", false);
        solution.read();
        System.out.println("bfs_taken:" + (System.currentTimeMillis()-start) / 1000.0d);
    }

    @Test
    public void testDfs() throws Exception {
        long start = System.currentTimeMillis();
        P2_PrintingDs.Solution solution = P2_PrintingDs.Solution.ofTestFile("cjam2022/qround/p2.txt", true);
        solution.read();
        System.out.println("dfs_taken:" + (System.currentTimeMillis()-start) / 1000.0d);
    }
}