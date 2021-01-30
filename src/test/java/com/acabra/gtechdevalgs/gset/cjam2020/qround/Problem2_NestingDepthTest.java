package com.acabra.gtechdevalgs.gset.cjam2020.qround;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

public class Problem2_NestingDepthTest {

    @Test
    public void read_input_file_test() throws Exception {
        Problem2_NestingDepth.Solution solution = Problem2_NestingDepth.Solution.ofTestFile("cjam2020/qround/p2.txt");
        solution.read();
    }

    @Test
    public void test_0() {
        MatcherAssert.assertThat("(((((5(6))))))", Is.is(Problem2_NestingDepth.Solution.solveCase("56")));
    }

    @Test
    public void test_1() {
        MatcherAssert.assertThat("(((((5(6))4)3)2)1)", Is.is(Problem2_NestingDepth.Solution.solveCase("564321")));
    }

    @Test
    public void test_2() {
        MatcherAssert.assertThat("00(((((5))))1((3)))00", Is.is(Problem2_NestingDepth.Solution.solveCase("0051300")));
    }

    @Test
    public void test_3() {
        MatcherAssert.assertThat("0((2)1)", Is.is(Problem2_NestingDepth.Solution.solveCase("021")));
    }

    @Test
    public void test_4() {
        MatcherAssert.assertThat("(((3))1(2))", Is.is(Problem2_NestingDepth.Solution.solveCase("312")));
    }

    @Test
    public void test_5() {
        MatcherAssert.assertThat("((((4))))", Is.is(Problem2_NestingDepth.Solution.solveCase("4")));
    }

    @Test
    public void test_6() {
        MatcherAssert.assertThat("((22)1)", Is.is(Problem2_NestingDepth.Solution.solveCase("221")));
    }
}
