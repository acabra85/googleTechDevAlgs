package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        StringBuilder sol = new StringBuilder();
        char[] cArr = s.toCharArray();
        int idx = 0;
        for(;idx<cArr.length;) {
            char a = cArr[idx];
            if (Character.isDigit(a)) {
                MyStr myStr = new MyStr(a - '0', idx+1, cArr);
                if(!myStr.encoded) {
                    sol.append(myStr.toString());
                } else {
                    sol.append(decodeString(myStr.toString()));
                }
                idx = myStr.end;
            } else {
                sol.append(a);
                ++idx;
            }
        }
        return sol.toString();
    }

    static private class MyTimes {

        int val;
        final int length;

        public MyTimes(int num, int idx, char[] arr) {
            Stack<Integer> stack = new Stack<>();
            stack.push(num);
            int i = idx;
            for(;i<arr.length && Character.isDigit(arr[i]);++i) {
                stack.push(arr[i] - '0');
            }
            val = 0;
            int exp = 0;
            length = stack.size();
            while(!stack.isEmpty()) {
                val += stack.pop() * Math.pow(10, exp++);
            }
        }

    }

    static private class MyStr {
        final String decoded;
        boolean encoded = false;
        final int end;
        public MyStr(int num, int start, char[] cArr) {
            MyTimes myT = new MyTimes(num, start, cArr);
            StringBuilder sb = new StringBuilder();
            int open = 1;
            int i = start + myT.length;
            while(open > 0 && i < cArr.length) {
                if('[' == cArr[i]) {
                    ++open;
                    encoded = true;
                }
                else if(']' == cArr[i]) {
                    --open;
                }
                if(open>0) sb.append(cArr[i]);
                ++i;
            }
            end = i;
            decoded = sb.toString().repeat(myT.val);
        }

        @Override
        public String toString() {
            return decoded;
        }
    }
}
