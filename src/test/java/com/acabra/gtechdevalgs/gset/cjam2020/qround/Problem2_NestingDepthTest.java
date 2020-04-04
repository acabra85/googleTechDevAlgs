package com.acabra.gtechdevalgs.gset.cjam2020.qround;

import org.junit.Assert;
import org.junit.Test;

public class Problem2_NestingDepthTest {

    @Test
    public void read_input_file_test() throws Exception {
        Problem2_NestingDepth.Solution solution = Problem2_NestingDepth.Solution.ofTestFile("cjam2020/qround/p2.txt");
        solution.read();
    }

    @Test
    public void test_0() {
        Assert.assertEquals("(((((5(6))))))", Problem2_NestingDepth.Solution.solveCase("56"));
    }

    @Test
    public void test_1() {
        Assert.assertEquals("(((((5(6))4)3)2)1)", Problem2_NestingDepth.Solution.solveCase("564321"));
    }

    @Test
    public void test_2() {
        Assert.assertEquals("00(((((5))))1((3)))00", Problem2_NestingDepth.Solution.solveCase("0051300"));
    }

    @Test
    public void test_3() {
        Assert.assertEquals("0((2)1)", Problem2_NestingDepth.Solution.solveCase("021"));
    }

    @Test
    public void test_4() {
        Assert.assertEquals("(((3))1(2))", Problem2_NestingDepth.Solution.solveCase("312"));
    }

    @Test
    public void test_5() {
        Assert.assertEquals("((((4))))", Problem2_NestingDepth.Solution.solveCase("4"));
    }

    @Test
    public void test_6() {
        Assert.assertEquals("((22)1)", Problem2_NestingDepth.Solution.solveCase("221"));
    }
}
