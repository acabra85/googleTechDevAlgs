package com.acabra.gtechdevalgs.gset.cjam2019.round1a;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class Problem3PylonsTest {

    @Test
    public void test() throws Exception {
        long l = System.nanoTime();
        String testFile = "cjam2019/round1a/p3.txt";
        //Problem3_Pylons.Solution.ofTestFile(testFile).read();
        long current = (System.nanoTime() - l) / 1000000;
        Assert.assertTrue(current < 20000);
    }
}
