package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Run length encodings
 * e.g. for aaabbbcccaa
 * RLE { key= "abca" encodings=[3,3,3,2]}
 */
public class RunLengthEncoding {

    public final String key;
    public final List<Integer> encodings = new ArrayList<>();

    public RunLengthEncoding(String toEncode) {
        if (null == toEncode) {
            this.key = "";
            return;
        }
        char[] charArray = toEncode.toCharArray();
        StringBuilder sb = new StringBuilder();
        char last = '\0';
        int cont = 0;
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i] != last) {
                if (cont>0) {
                    encodings.add(cont);
                }
                sb.append(charArray[i]);
                cont=1;
                last = charArray[i];
            } else {
                cont++;
            }
        }
        encodings.add(cont);
        this.key=sb.toString();
    }
}
