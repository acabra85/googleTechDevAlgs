package com.acabra.gtechdevalgs.gset.cjam2021.qround;

import org.junit.jupiter.api.Test;

public class Problem5_FindCheaterTest {

    @Test
    public void test() throws Exception {
        Problem5_FindCheater.Solution solution = Problem5_FindCheater.Solution.ofTestFile("cjam2021/qround/p5.txt");
        solution.read();
    }
}
