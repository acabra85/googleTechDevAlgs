package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class SumKToNumArray {

    /**
     * Given an array num of integers representing a number and an integer k
     * return the array representation of their sum.
     * e.g.   ([1,2, 0, 0], 34) -> [1,2,3,4]
     * @param num an array representing the number
     * @param k a number to sum
     * @return the array representation of their sum
     */
    public List<Integer> sumKToArray(int[] num, int k) {
        char[] strK = String.valueOf(k).toCharArray();
        Stack<Integer> q = new Stack<>();
        int lenK = strK.length;
        int lenNum = num.length;
        int div = 0, i, j, val;
        for(i = lenK-1, j=lenNum-1; i>=0 && j>=0;--i,--j) {
            val = num[j] + (strK[i] - '0') + div;
            div = val / 10;
            q.push(val % 10);
        }
        if(lenK > lenNum) {
            for(;i >=0;--i) {
                if (div > 0) {
                    val = div + (strK[i] - '0');
                    div = val / 10;
                    q.push(val % 10);
                } else {
                    q.push(strK[i] - '0');
                }
            }
        } else {
            for(; j>=0;--j) {
                if(div > 0) {
                    val = div + num[j];
                    div = val / 10;
                    q.push(val % 10);
                } else {
                    q.push(num[j]);
                }
            }
        }
        if(div > 0) {
            q.push(div);
        }
        return new ArrayList<Integer>(){{
            while(!q.isEmpty())
                add(q.pop());
        }};
    }
}
