package com.acabra.gtechdevalgs.gset.cjam2020.qround;

import com.acabra.gtechdevalgs.TestUtils;
import edu.emory.mathcs.backport.java.util.Collections;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.*;

public class Problem3_ParentingTest {

    @Test
    public void test() throws Exception {
        Problem3_Parenting.Solution solution = Problem3_Parenting.Solution.ofTestFile("cjam2020/qround/p3.txt");
        solution.read();
    }

    @Test
    public void test_1() {
        PriorityQueue<Problem3_Parenting.Solution.Activity> activities = buildActivities(3, 360, 480, 420, 540, 600, 660);
        Set<String> solutions = getSolutions("CJC", "JCJ");
        TestUtils.iAssertTrue(solutions.contains(Problem3_Parenting.Solution.solveCase(activities)));
    }

    private HashSet<String> getSolutions(String ... solutions) {
        HashSet<String> set = new HashSet<>();
        Collections.addAll(set, solutions);
        return set;
    }

    @Test
    public void test_2() {
        PriorityQueue<Problem3_Parenting.Solution.Activity> activities = buildActivities(3, 0, 1440, 1, 3, 2, 4);
        MatcherAssert.assertThat("IMPOSSIBLE", Is.is(Problem3_Parenting.Solution.solveCase(activities)));
    }

    @Test
    public void test_3() {
        PriorityQueue<Problem3_Parenting.Solution.Activity> activities = buildActivities(5, 99, 150, 1, 100, 100, 301, 2, 5, 150, 250);
        Set<String> solutions = getSolutions("JCCJJ", "CJJCC");
        TestUtils.iAssertTrue(solutions.contains(Problem3_Parenting.Solution.solveCase(activities)));
    }

    @Test
    public void test_4() {
        PriorityQueue<Problem3_Parenting.Solution.Activity> activities = buildActivities(2, 0, 720, 720, 1440);
        Set<String> solutions = getSolutions("CC", "JJ");
        TestUtils.iAssertTrue(solutions.contains(Problem3_Parenting.Solution.solveCase(activities)));
    }

    private PriorityQueue<Problem3_Parenting.Solution.Activity> buildActivities(int n, int ... args) {
        PriorityQueue<Problem3_Parenting.Solution.Activity> activities = new PriorityQueue<>(Problem3_Parenting.Solution.Activity.ACTIVITY_COMPARATOR_BY_START);
        for (int i = 0; i < n; i++) {
            activities.offer(Problem3_Parenting.Solution.Activity.of(args[2*i], args[2*i+1], i));
        }
        return activities;
    }
}
