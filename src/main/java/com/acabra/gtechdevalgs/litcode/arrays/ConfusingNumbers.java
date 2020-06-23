package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ConfusingNumbers {
    private final static Set<Integer> NON_ROTABLE = new HashSet<Integer>(){{
        add(2);
        add(3);
        add(4);
        add(5);
        add(7);
    }};

    private final static Map<Integer, Integer> ROTABLE = new HashMap<Integer, Integer>(){{
        put(0, 0);
        put(1, 1);
        put(6, 9);
        put(8, 8);
        put(9, 6);
    }};

    private final static int MAX_INPUT = 1000000000;

    public boolean confusingNumber(int N) {
        if (N<0 || N > MAX_INPUT) {
            throw new IllegalArgumentException("input must be >= 0 and <= 10^9 given:" + N);
        }
        if (N < 10) {
            if (NON_ROTABLE.contains(N)) {
                return false;
            }
            return N != ROTABLE.get(N).intValue();
        }
        Integer confusing = rotate(N);
        //System.out.println(confusing);
        if ( confusing != null && confusing.intValue() != N) {
            return true;
        }
        return false;
    }


    private Integer rotate(int N) {
        char[] numStr = (N + "").toCharArray();
        for (char c : numStr) {
            if(NON_ROTABLE.contains(c - '0')) {
                return null;
            }
        }
        int[] numArr = new int[numStr.length];
        int total = 0;
        int num = N;
        int mod = num % 10;
        int div = num / 10;
        while(div >= 10) {
            numArr[total] = ROTABLE.get(mod);
            ++total;
            num = div;
            div = num / 10;
            mod = num % 10;
        }
        numArr[total] = ROTABLE.get(mod);
        numArr[++total] =  ROTABLE.get(div);
        return buildNumber(numArr);
    }

    private Integer buildNumber(int[] numArr) {
        int total = 0;
        int start = findStart(numArr);
        if (start == numArr.length) return 0;
        for (int i = start; i < numArr.length; ++i) {
            if (total > 0) {
                total = total * 10;
            }
            total += numArr[i];
        }
        return total;
    }

    private int findStart(int[] numArr) {
        for (int i = 0; i < numArr.length; ++i) {
            if (numArr[i] != 0) {
                return i;
            }
        }
        return numArr.length;
    }
}
