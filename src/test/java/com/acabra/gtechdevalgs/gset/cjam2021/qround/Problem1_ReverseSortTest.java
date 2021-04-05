package com.acabra.gtechdevalgs.gset.cjam2021.qround;

import org.junit.jupiter.api.Test;

class Problem1_ReverseSortTest {

    @Test
    public void read_input_file_test() throws Exception {
        Problem1_ReverseSort.Solution solution = Problem1_ReverseSort.Solution.ofTestFile("cjam2021/qround/p1.txt");
        solution.read();
    }

}