package com.acabra.litcode;

/**
 * return a String with size (a + b) that does not contains "aaa" nor "bbb"
 * and contains as many a's as a and as many b's as b.
 * if not possible then return null.
 */
public class StringWithout3a3b {

    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        int aLeft = a;
        int bLeft = b;
        boolean writeA;
        while (aLeft > 0 || bLeft > 0) {
            writeA = false;
            if(sb.length() >= 2 && sb.charAt(sb.length()-1) == sb.charAt(sb.length()-2)) {
                if(sb.charAt(sb.length()-1) == 'b') {
                    writeA = true;
                }
            } else {
                if (aLeft >= bLeft) {
                    writeA = true;
                }
            }
            if(writeA) {
                if (aLeft<=0) return null;
                sb.append("a");aLeft--;
            } else {
                if (bLeft<=0) return null;
                sb.append("b");bLeft--;
            }
        }
        String no3ANo3B = sb.toString();
        return invalid(no3ANo3B) ? null : no3ANo3B;
    }

    protected boolean invalid(String no3ANo3B) {
        return no3ANo3B.contains("aaa") || no3ANo3B.contains("bbb");
    }
}
