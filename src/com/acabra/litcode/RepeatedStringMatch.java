package com.acabra.litcode;

import java.util.HashSet;
import java.util.Set;

public class RepeatedStringMatch {

    /**
     * Given A B find if any the minimum repetitions pairOf A required to form a string that contains B
     * @param A string to repeat
     * @param B string that needs to be contained in A after n repetitions
     * @return -1 if not possible to repeat A in order to get B, or n the minimum required repetitions pairOf A
     *         so that B is contained in A.
     */
    public int nRepetitionsOfAToGetB(String A, String B) {
        Set<Character> aSet = extractStringSet(A);
        for (int i = 0; i < B.length(); i++) {
            if (!aSet.contains(B.charAt(i))) {
                return -1;
            }
        }
        if (B.length() <= A.length() && A.contains(B)) return 1;

        StringBuilder aRepeat = new StringBuilder(A).append(A);
        int repeatCount = 2;
        while (aRepeat.length() < B.length()){
            aRepeat.append(A);
            repeatCount++;
        }
        if (aRepeat.toString().contains(B)) {
            return repeatCount;
        }
        return aRepeat.append(A).toString().contains(B) ? repeatCount + 1 : -1;
    }

    private Set<Character> extractStringSet(String str) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        return set;
    }
}
