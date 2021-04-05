package com.acabra.gtechdevalgs.gset.cjam2021.qround;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem2_MoonsUmbrellasTest {

    @Test
    public void test() throws Exception {
        Problem2_MoonsUmbrellas.Solution solution = Problem2_MoonsUmbrellas.Solution.ofTestFile("cjam2021/qround/p2.txt");
        solution.read();
    }

    @Test
    public void test1() {
        String s = Problem2_MoonsUmbrellas.Solution.optimizeString("???C??J???".toCharArray());
        Assertions.assertEquals("?C?J?", s);
    }

    @Test
    public void test2() {
        int cost = Problem2_MoonsUmbrellas.Solution.solveCase(2, 3, "CJ?C");
        Assertions.assertEquals(5, cost);
    }

}