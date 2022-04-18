package com.acabra.gtechdevalgs.gset.cjam2022.qround;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.acabra.gtechdevalgs.gset.cjam2022.qround.P2_PrintingDs.Solution.INK_REQ;

class P2_PrintingDsTest {

    @Test
    public void testBfs() throws Exception {
        long start = System.currentTimeMillis();
        P2_PrintingDs.Solution solution = P2_PrintingDs.Solution.ofTestFile("cjam2022/qround/p2.txt", false);
        solution.read();
        System.out.println("bfs_taken:" + (System.currentTimeMillis()-start) / 1000.0d);
    }


    @Test
    public void testDfs() throws Exception {
        long start = System.currentTimeMillis();
        P2_PrintingDs.Solution solution = P2_PrintingDs.Solution.ofTestFile("cjam2022/qround/p2.txt", true);
        solution.read();
        System.out.println("dfs_taken:" + (System.currentTimeMillis()-start) / 1000.0d);
    }

    @Test
    public void mustReturnValidSolution1() {
        int[][] valid = getValid1();

        P2_PrintingDs.Solution.DColors colorDFS = P2_PrintingDs.Solution.solveCase(
                P2_PrintingDs.Solution.DPrinters.fromMatrix(valid), true);

        P2_PrintingDs.Solution.DColors colorBFS = P2_PrintingDs.Solution.solveCase(
                P2_PrintingDs.Solution.DPrinters.fromMatrix(valid), true);

        Assertions.assertThat(colorDFS).isNotNull();
        Assertions.assertThat(colorDFS.missing).isEqualTo(0);
        Assertions.assertThat(colorDFS.total).isEqualTo(INK_REQ);
        Assertions.assertThat(colorDFS).isEqualTo(colorBFS);
    }

    @Test
    public void mustReturnValidSolution2() {
        int[][] valid = getValid2();

        P2_PrintingDs.Solution.DColors colorDFS = P2_PrintingDs.Solution.solveCase(
                P2_PrintingDs.Solution.DPrinters.fromMatrix(valid), true);

        P2_PrintingDs.Solution.DColors colorBFS = P2_PrintingDs.Solution.solveCase(
                P2_PrintingDs.Solution.DPrinters.fromMatrix(valid), true);

        Assertions.assertThat(colorDFS).isNotNull();
        Assertions.assertThat(colorDFS.missing).isEqualTo(0);
        Assertions.assertThat(colorDFS.total).isEqualTo(INK_REQ);
        Assertions.assertThat(colorDFS).isEqualTo(colorBFS);
    }

    @Test
    public void mustReturnImpossible() {
        int[][] impossible = getImpossible();

        P2_PrintingDs.Solution.DColors colorDFS = P2_PrintingDs.Solution.solveCase(
                P2_PrintingDs.Solution.DPrinters.fromMatrix(impossible), true);

        P2_PrintingDs.Solution.DColors colorBFS = P2_PrintingDs.Solution.solveCase(
                P2_PrintingDs.Solution.DPrinters.fromMatrix(impossible), true);

        Assertions.assertThat(colorDFS).isNotNull();
        Assertions.assertThat(colorDFS.missing).isEqualTo(INK_REQ);
        Assertions.assertThat(colorDFS.total).isEqualTo(0);
        Assertions.assertThat(colorDFS).isEqualTo(colorBFS);
    }

    private static int[][] getValid1() {
        int[][] ints = {
                {300000, 200000, 300000, 500000},
                {300000, 200000, 500000, 300000},
                {300000, 500000, 300000, 200000}
        };
        return ints;
    }

    private static int[][] getValid2() {
        int[][] ints = {
            {768763, 148041, 178147, 98417},
            {699508, 515362, 534729, 71438},
            {949704, 625054, 946212, 95118}
        };
        return ints;
    }

    private static int[][] getImpossible() {
        int[][] ints = {
            {1000000, 1000000, 0, 0},
            {0, 1000000, 1000000, 100000},
            {999999, 999999, 999999, 99999}
        };
        return ints;
    }
}