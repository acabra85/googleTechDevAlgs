package com.acabra.gtechdevalgs.gset.cjam2018;

import org.junit.Test;

import java.io.InputStream;

public class WafflesTest {

    @Test
    public void test_() {
        //Problem1_Waffles.Solution solution = new Problem1_Waffles.Solution();
        InputStream resourceAsStream = Problem1_Waffles.class.getClassLoader().getResourceAsStream("cjam2018/Problem_1_test01.txt");
        Problem1_Waffles.Solution.solve(resourceAsStream);
    }
}
