package com.acabra.gtechdevalgs.social;

public class RotCypher {
    static final char[] ALF_L = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    static final char[] ALF_U = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    static final char[] NUMS = "0123456789".toCharArray();

    /*
    Rot cypher is not by any means a method for secure communication but is fuN!
    Given a rotation factor and the alphabets (lower or upper case) and numbers
    a rotation with a given factor means for each letter in the input choose the
    corresponding factor rotated letter on the output, other letters are ignored.
     */
    public String rotationalCipher(String input, int rotationFactor) {
        if (input == null || input.length() == 0) return input;

        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sb.append(rotate(ALF_L, c - 'a', rotationFactor, ALF_L.length));
            } else if (c >= 'A' && c <= 'Z') {
                sb.append(rotate(ALF_U, c - 'A', rotationFactor, ALF_U.length));
            } else if (c >= '0' && c <= '9') {
                sb.append(rotate(NUMS, c - '0', rotationFactor, NUMS.length));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private char rotate(char[] arr, int pos, int factor, int n) {
        return arr[(pos + (factor % n)) % n];
    }
}
