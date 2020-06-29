package com.acabra.gtechdevalgs;

import java.util.ArrayDeque;

public class EmptyTextEditor {
    public boolean backspaceCompare(String S, String T) {
        return process(S).equals(process(T));
    }

    private String process(String str) {
        ArrayDeque<Character> stackS = new ArrayDeque<>();
        for(char s: str.toCharArray()) {
            if (s == '#' && stackS.size() > 0) {
                stackS.pop();
            }
            else if (s != '#') {
                stackS.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(stackS.size()>0) {
            sb.append(stackS.removeFirst());
        }
        return sb.toString();
    }
}
