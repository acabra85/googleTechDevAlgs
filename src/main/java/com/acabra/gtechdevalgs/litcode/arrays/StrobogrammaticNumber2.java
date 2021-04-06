package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Describe your class
 */
public class StrobogrammaticNumber2 {
    static final List<String> BASE_0 = new ArrayList<String>(){{add("");}};
    static final List<String> BASE_1 = new ArrayList<String>(){{
        add("0");
        add("1");
        add("8");
    }};
    public List<String> findStrobogrammatic(int n) {
        return solve(n, n);
    }

    private List<String> solve(int n, int target) {
        if (n == 0) {
            return BASE_0;
        } else if (n == 1) {
            return BASE_1;
        }
        List<String> prev = solve(n-2, target); //adding 2 elements on each side
        List<String> res = new ArrayList<>((n<target?5:4) * prev.size());
        for(String val: prev) {
            if(n < target) {
                res.add("0" + val + "0" );
            }
            res.add("1" + val + "1");
            res.add("6" + val + "9");
            res.add("8" + val + "8");
            res.add("9" + val + "6");
        }
        return res;
    }
}
