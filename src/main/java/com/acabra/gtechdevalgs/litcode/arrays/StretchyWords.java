package com.acabra.gtechdevalgs.litcode.arrays;

/**
 * Describe your class
 */
public class StretchyWords {

    private static final Integer MIN_STRETCH_LENGTH = 3;

    public int expressiveWords(String S, String[] words) {
        if (S == null || S.length() == 0 || words == null || words.length == 0) return 0;
        int stretchyWords = 0;
        RunLengthEncoding sRLE = new RunLengthEncoding(S);
        RunLengthEncoding wRLE;
        for (String word : words) {
            wRLE = new RunLengthEncoding(word);
            if(isStretchy(sRLE, wRLE)) {
                stretchyWords++;
            }
        }
        return stretchyWords;
    }

    private boolean isStretchy(RunLengthEncoding sRLE, RunLengthEncoding wRLE) {
        if (!sRLE.key.equals(wRLE.key)) return false;
        for (int i = 0; i < sRLE.encodings.size(); i++) {
            if (!canCharBeStretched(sRLE.encodings.get(i))
                    && (sRLE.encodings.get(i) != wRLE.encodings.get(i))
                    || (sRLE.encodings.get(i) < wRLE.encodings.get(i)) ) {
                return false;
            }
        }
        return true;
    }

    private boolean canCharBeStretched(Integer charGroupLength) {
        return charGroupLength >= MIN_STRETCH_LENGTH;
    }

    private int advanceToNewGroup(int index, String str) {
        char groupScope = str.charAt(index);
        for (int i = index; i < str.length(); i++) {
            if (str.charAt(i) != groupScope) {
                return i;
            }
        }
        return str.length();
    }
}
