package com.acabra.gtechdevalgs.gset.cjam2019.qround;

import com.acabra.gtechdevalgs.TestUtils;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.io.IOException;

public class Problem2_EasiestMazeTest {

    @Test
    public void test_01() {
        Problem2_EasiestMaze.Solution solution = Problem2_EasiestMaze.Solution.ofConsole();
        String lydiasSteps = "SE";
        int squareSize = 2;
        String mySteps = solution.solve(squareSize, lydiasSteps);
        TestUtils.iAssertTrue(Problem2_EasiestMaze.Solution.validateAnswer(squareSize, mySteps, lydiasSteps));
    }

    @Test
    public void test_02() {
        Problem2_EasiestMaze.Solution solution = Problem2_EasiestMaze.Solution.ofConsole();
        String lydiasSteps = "EESSSESE";
        int squareSize = 5;
        String mySteps = solution.solve(squareSize, lydiasSteps);
        TestUtils.iAssertTrue(Problem2_EasiestMaze.Solution.validateAnswer(squareSize, mySteps, lydiasSteps));
    }

    @Test
    public void read_input_file_test() throws IOException {
        Problem2_EasiestMaze.Solution solution = Problem2_EasiestMaze.Solution.ofTestFile("cjam2019/qround/p2.txt");
        solution.read();
    }
}