package com.acabra.gtechdevalgs.gset.cjam2021.qround;

import org.junit.jupiter.api.Test;

public class Problem3_ReverseEngineerTest {

    @Test
    public void test() throws Exception {
        Problem3_ReverseEngineer.Solution solution = Problem3_ReverseEngineer.Solution.ofTestFile("cjam2021/qround/p3.txt");
        solution.read();
    }
}
