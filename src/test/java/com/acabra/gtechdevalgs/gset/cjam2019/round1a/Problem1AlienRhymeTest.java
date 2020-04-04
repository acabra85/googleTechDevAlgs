package com.acabra.gtechdevalgs.gset.cjam2019.round1a;

import org.junit.Test;

public class Problem1AlienRhymeTest {

    @Test
    public void test_read_file() throws Exception {
        String fileName = "cjam/2019/round1a/p1.txt";
        Problem1_AlienRhyme.Solution.ofTestFile(fileName).read();
    }
}
