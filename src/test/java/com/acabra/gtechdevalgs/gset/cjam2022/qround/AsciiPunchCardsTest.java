package com.acabra.gtechdevalgs.gset.cjam2022.qround;

import org.junit.Test;

public class AsciiPunchCardsTest {

    @Test
    public void test() throws Exception {
        AsciiPunchCards.Solution solution = AsciiPunchCards.Solution.ofTestFile("cjam2022/qround/p1.txt");
        solution.read();
    }

}