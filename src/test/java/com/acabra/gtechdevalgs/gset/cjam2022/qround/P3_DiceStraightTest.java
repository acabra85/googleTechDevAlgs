package com.acabra.gtechdevalgs.gset.cjam2022.qround;


import org.junit.jupiter.api.Test;

class P3_DiceStraightTest {

    @Test
    public void test() throws Exception {
        P3_DiceStraight
                .Solution.ofTestFile("cjam2022/qround/p3.txt")
                .read();
    }
}