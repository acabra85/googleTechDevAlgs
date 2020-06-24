package com.acabra.gtechdevalgs.litcode.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SumClosestToKTest {

    @Test
    public void should_return_5_6() {
        int[] a = {2,0,9,5,3};
        int[] b = {2,6,4,5,11};
        int k = 13;
        List<SumClosestToK.SumClosestToKResult> res = new SumClosestToK().solve(a, b, k);
        Assert.assertEquals(2, res.size());

        for (SumClosestToK.SumClosestToKResult re : res) {
            Assert.assertEquals(0, re.dist);
        }
    }

    @Test
    public void test() {
        LinkedList<Integer> integers = new LinkedList<>(){{
            addAll(Arrays.asList(1, 2, 34, 4, 6));
        }};
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
            if (next == 34) {
                iterator.remove();
                integers.add(55);
            }
        }
    }
}