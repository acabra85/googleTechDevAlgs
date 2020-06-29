package com.acabra.gtechdevalgs.litcode.arrays;

public class RemoveDuplicates {
    public String removeDuplicates(String S) {
        String str = S;
        int has = hasConsecutiveDuplicates(str);
        while(has >= 0) {
            str = str.substring(0, has) + str.substring(has+2);
            has = hasConsecutiveDuplicates(str);
        }
        return str;
    }

    private static int hasConsecutiveDuplicates(String str) {
        if (str.length() < 2) return -1;
        for(int i=0;i<str.length() - 1; ++i) {
            if (str.charAt(i) == str.charAt(i+1)) {
                return i;
            }
        }
        return -1;
    }
}
