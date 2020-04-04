package com.acabra.gtechdevalgs.gset.cjam2019.round1a;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Problem2GolfersTest {

    @Test
    public void test() throws Exception {
        InputStream resourceAsStream = Problem2_Golfers.class.getClassLoader().getResourceAsStream("cjam2019/round1a/p2.txt");
        new Problem2_Golfers.Solver(new BufferedReader(new InputStreamReader(resourceAsStream))).solve();
    }
}
