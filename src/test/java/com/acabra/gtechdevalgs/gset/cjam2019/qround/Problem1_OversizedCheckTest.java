package com.acabra.gtechdevalgs.gset.cjam2019.qround;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.LongSummaryStatistics;

public class Problem1_OversizedCheckTest {

    @Test
    public void test_1() {
        String originalCheck = "44444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444442";
        Problem1_OversizedCheck.Solution.CheckResult result = Problem1_OversizedCheck.Solution.ofConsole().solve_str(originalCheck);
        MatcherAssert.assertThat("33333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333332", Is.is(result.a));
        MatcherAssert.assertThat("11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110", Is.is(result.b));
        MatcherAssert.assertThat(originalCheck, Is.is(new BigInteger(result.a).add(new BigInteger(result.b)).toString()));
    }

    @Test
    public void test_2() throws Exception {
        Problem1_OversizedCheck.Solution.ofTestFile("cjam2019/qround/p1.txt").read();
    }

    @Test
    public void test_performance() throws IOException {
        LongSummaryStatistics pow = new LongSummaryStatistics();
        LongSummaryStatistics str = new LongSummaryStatistics();

        for (int i = 0; i < 100; i++) {
            pow.accept(read_measure(new Problem1_OversizedCheck.Solution(Problem1_OversizedCheck.class.getClassLoader().getResourceAsStream("cjam2019/qround/p1.txt"), new OutputStreamWriter(System.out)), true));
            str.accept(read_measure(new Problem1_OversizedCheck.Solution(Problem1_OversizedCheck.class.getClassLoader().getResourceAsStream("cjam2019/qround/p1.txt"), new OutputStreamWriter(System.out)), false));
        }
        if (pow.getAverage() < str.getAverage()) {
            System.out.println("POW faster than STR :" + pow.getAverage()*100.0/str.getAverage() + " times");
        } else {
            System.out.println("STR faster than POW :" + str.getAverage()*100.0/pow.getAverage() + " times");
        }
    }

    private long read_measure(Problem1_OversizedCheck.Solution solution, boolean pow) throws IOException {
        long startTime = System.nanoTime();
        Long testCases = solution.help.nLong();
        for(int i = 1; i <= testCases; i++) {
            String nStr = solution.help.next();
            if (pow)
                solution.solve_pow(nStr);
            else
                solution.solve_str(nStr);
        }
        return System.nanoTime() - startTime;
    }
}
