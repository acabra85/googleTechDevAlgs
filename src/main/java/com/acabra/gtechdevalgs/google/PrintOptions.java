package com.acabra.gtechdevalgs.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintOptions {

    static class Option {
        String[] chars;
        int pos;
        Option(String[] arr, int pos) {
            Arrays.sort(arr);
            this.chars = arr;
            this.pos = pos;
        }
        Option(String prefix, String[] arr, int pos) {
            Arrays.sort(arr);
            this.chars = arr;
            int i = 0;
            for(String str: arr) {
                chars[i++] = prefix + str.charAt(0);
            }
            this.pos = pos;
        }

        void append(String txt) {
            for(int i=0;i<chars.length;++i) {
                chars[i] = chars[i] + txt;
            }
        }
    }

    public String[] expand(String S) {
        if(S.length() == 0) return new String[]{""};
        int idxOpen = S.indexOf('{');
        if (idxOpen == -1) {
            return new String[]{S};
        }

        int pos = -1;
        List<Option> options = new ArrayList();

        String tmpFixed =  S.substring(0, idxOpen);
        int idxClose = S.indexOf('}');
        if (tmpFixed.length()>0) {
            options.add(new Option(tmpFixed, S.substring(idxOpen + 1, idxClose).split(","), ++pos));
        } else {
            options.add(new Option(S.substring(idxOpen + 1, idxClose).split(","), ++pos));
        }
        String rest = S.substring(idxClose + 1);
        idxOpen = rest.indexOf('{');
        while(idxOpen >= 0) {
            idxClose = rest.indexOf('}');
            tmpFixed =  rest.substring(0, idxOpen);
            if (tmpFixed.length()>0) {
                options.add(new Option(tmpFixed, rest.substring(idxOpen + 1, idxClose).split(","), ++pos));
            } else {
                options.add(new Option(rest.substring(idxOpen + 1, idxClose).split(","), ++pos));
            }
            rest = rest.substring(idxClose + 1);
            idxOpen = rest.indexOf('{');
        }
        if (rest.length()>0) {
            options.get(options.size()-1).append(rest);
        }
        while (options.size() > 1) {
            Option op1 = options.remove(0);
            Option op2 = options.remove(0);
            String[] tmp = new String[op1.chars.length*op2.chars.length];
            int i = 0;
            for (String aChar : op1.chars) {
                for (String strChars : op2.chars) {
                    tmp[i++] = aChar+strChars;
                }
            }
            options.add(0, new Option(tmp, op2.pos));
        }
        return options.get(0).chars;
    }
}
