package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.StringTokenizer;

/**
 * Describe your class
 */
public class ParseInt {

    public int myAtoi(String str) {
        StringTokenizer st = new StringTokenizer(str, " ", false);
        if (st.hasMoreTokens()) {
            char[] candidate = st.nextToken().toCharArray();
            if (validFirstChar(candidate, candidate[0])) {
                String number = trimLeadingZeros(retrieveNumberPrefix(candidate));
                if (null != number) {
                    if (fitsIntoInt(number.toCharArray(), number.charAt(0))) {
                        return Integer.parseInt(number);
                    }
                    return number.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            }
        }
        return 0;
    }

    private String trimLeadingZeros(char[] in) {
        if (null == in) return null;
        int start = in[0] == '-' ? 1 : 0;
        if (in[start] == '0') {
            StringBuilder sb = new StringBuilder();
            boolean collect = false;
            for (int i = start; i < in.length; i++) {
                if (!collect && in[i] != '0') {
                    collect = true;
                }
                if (collect) {
                    sb.append(in[i]);
                }
            }
            if (sb.length() > 0) {
                return start == 1 ? "-" + sb.toString() : sb.toString();
            } else { //it was only zeroes and possibly a sign
                return null;
            }
        }
        return String.valueOf(in);
    }

    private char[] retrieveNumberPrefix(char[] candidate) {
        StringBuilder sb = new StringBuilder();
        boolean negative = candidate[0] == '-';
        int start = candidate[0] == '+' || negative ? 1 : 0;
        for (int i = start; i < candidate.length; i++) {
            if (candidate[i]<'0' || candidate[i] > '9') {
                break;
            }
            if (negative && i == 1) sb.append('-');
            sb.append(candidate[i]);
        }
        String prefix = sb.toString();
        if (prefix.length() > 0 && (prefix.charAt(0) != '-' || prefix.charAt(0) > 1)) {
            return prefix.toCharArray();
        }
        return null;
    }

    private boolean validFirstChar(char[] val, char firstChar) {
        return charIsNum(firstChar) || val.length > 1 && (firstChar == '+' || firstChar == '-');
    }

    private boolean fitsIntoInt(char[] val, char firstChar) {
        boolean negative = firstChar == '-';
        char[] refArr = (negative ?
                "-2147483648":
                "2147483647").toCharArray();
        if(val.length > refArr.length) {
            return false;
        }
        if (val.length < refArr.length) {
            return true;
        }
        int start = negative ? 1 : 0;
        for(int i = start; i < val.length;i++) {
            if(val[i] > refArr[i]) {
                return false;
            }
            if (val[i] < refArr[i]) {
                return true;
            }
        }
        return true;
    }

    private boolean charIsNum(char c) {
        return c >= '0' && c <= '9';
    }
}
