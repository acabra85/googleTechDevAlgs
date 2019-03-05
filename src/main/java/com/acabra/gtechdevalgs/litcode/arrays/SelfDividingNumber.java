package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelfDividingNumber {
    public List<Integer> selfDividingNumbers(int left, int right) {
        if (left >= right) return Collections.EMPTY_LIST;
        List<Integer> ansA = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if(isSelfDividing(i+"", i)) {
                ansA.add(i);
            }
        }
        return ansA;
    }

    private boolean isSelfDividing(String s, int num) {
        if (s.contains("0")) return false;
        if (s.length() == 1) return true;
        for (int i = 0; i < s.length(); i++) {
            int intVal = Character.getNumericValue(s.charAt(i));
            if(num%intVal != 0) {
                return false;
            }
        }
        return true;
    }
}
