package com.acabra.gtechdevalgs.gset.cjam2020.qround;

import org.junit.Test;

public class Problem1_VestigiumTest {

    @Test
    public void read_input_file_test() throws Exception {
        Problem1_Vestigium.Solution solution = Problem1_Vestigium.Solution.ofTestFile("cjam2020/qround/p1.txt");
        solution.read();
    }
}
