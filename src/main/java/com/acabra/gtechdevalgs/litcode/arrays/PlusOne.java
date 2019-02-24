package com.acabra.gtechdevalgs.litcode.arrays;

public class PlusOne {
    /**
     * Computes the next integer represented as an int array in-place
     * @param input an array representing an integer
     * @return an array representing the input + 1
     */
    public int[] plusOne(int[] input) {
        boolean carryOver = true;
        int newNum;
        for (int i = input.length-1; i >= 0; i--) {
            newNum = input[i] + (carryOver ? 1 : 0);
            if (newNum >= 10) {
                input[i] = 0;
                carryOver = true;
            } else {
                input[i] = newNum;
                return input;
            }
        }

        int[] carry = new int[input.length+1];
        carry[0] = 1;
        for (int i = 0; i < input.length; i++) {
            carry[i+1] = input[i];
        }
        return carry;
    }
}
