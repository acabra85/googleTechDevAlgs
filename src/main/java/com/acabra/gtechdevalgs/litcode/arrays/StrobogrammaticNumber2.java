package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Describe your class
 */
public class StrobogrammaticNumber2 {
    public List<String> findStrobogrammatic(int n) {
        List<String> BASE_0 = new ArrayList<>(){{add("");}};
        List<String> BASE_1 = new ArrayList<>(){{
            add("0");
            add("1");
            add("8");
        }};
        for (int i = 2; i <= n; ++i) {
            List<String> res = new ArrayList<>((i < (n - 1)?5:4) * BASE_0.size());
            for(String val: BASE_0) {
                if(i < n - 1) {
                    res.add("0" + val + "0" );
                }
                res.add("1" + val + "1");
                res.add("6" + val + "9");
                res.add("8" + val + "8");
                res.add("9" + val + "6");
            }
            BASE_0 = BASE_1;
            BASE_1 = res;
        }
        return BASE_1;
    }
}
