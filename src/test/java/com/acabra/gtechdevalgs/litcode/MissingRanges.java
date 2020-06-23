package com.acabra.gtechdevalgs.litcode;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    private class Range {
        int start;
        int end;
        Range(int s, int e){
            this.start = s;
            this.end = e;
        }

        public String toString() {
            if(start == end) return "" + start;
            return start + "->" + end;
        }
    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        //System.out.println(lower+ " " +upper);
        Range last = null;
        List<String> missing = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            missing.add(new Range(lower, upper).toString());
            return missing;
        }
        int prev = nums[0];
        if (prev > lower) {
            last = new Range(lower, prev-1);
            missing.add(last.toString());
        }
        for(int i = 1; i < nums.length; ++i) {
            //System.out.println(Math.abs(nums[i]));
            long a1 = nums[i];
            long a2 = prev;
            if (a1 - a2 > 1) {
                last = new Range(prev+1, nums[i]-1);
                missing.add(last.toString());
            }
            prev =  nums[i];
        }
        if(prev < upper) {
            missing.add(new Range(prev+1, upper).toString());
        }
        return missing;
    }
}