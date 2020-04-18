package com.acabra.gtechdevalgs.gset.cjam2020.round1a;

import org.junit.Test;

public class Problem1Test {
    @Test
    public void test1() throws Exception {
        Problem1.Solution solution = Problem1.Solution.ofTestFile("cjam2020/round1a/p1.txt");
        solution.read();
    }
}
