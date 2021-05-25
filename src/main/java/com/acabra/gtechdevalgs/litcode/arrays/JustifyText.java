package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JustifyText {

    /**
     * Given a list of words and a maximum width of the page, return a list of strings
     * where each element corresponds to one formatted line of the text in "Justified" version.
     * As follows:
     *    1. Lines are fully justified meaning that the line must not end with spaces.
     *    2. All additional spaces are evenly distributed between all words per line.
     *    3. If the additional spaces can not be evenly distributed the most amount of spaces will go on the left
     *       and the least on the right.
     *    3. The last line is fully justified to the left with no padding spaces.
     * @param words
     * @param maxWidth
     * @return
     */
    public List<String> justifyText(String[] words, int maxWidth) {
        if (words == null || words.length == 0) return Collections.emptyList();
        if (words.length == 1) new Line(maxWidth, words[0], true).lastString();
        List<String> res = new ArrayList<>();
        Line line = new Line(maxWidth, words[0], false);///check TODO
        for(int i=1;i<words.length;++i) {
            String word = words[i];
            if(line.canAppend(word)) {
                line.appendWord(word);
            } else {
                res.add(line.toString());
                line = new Line(maxWidth, word, false); //TODO CHECK
            }
        }
        res.add(line.lastString());
        return res;
    }

    static class Line {
        final ArrayDeque<String> aq;
        int length;
        int spaces = 0;
        final int maxLength;
        final private boolean isLastLine;

        Line(int mLength, String word, boolean isLastLine){
            aq = new ArrayDeque<>();
            aq.addLast(word);
            this.length = word.length();
            this.maxLength = mLength;
            this.isLastLine = isLastLine;
        }

        boolean canAppend(String word) {
            return this.length + word.length() + spaces <= maxLength;
        }

        void appendWord(String word) {
            if (canAppend(word)) {
                this.length += word.length();
                ++spaces;
                aq.addLast(word);
                return;
            }
            throw new RuntimeException("invalid input");
        }

        public String lastString() {
            StringBuilder sb = new StringBuilder();
            while(!aq.isEmpty()) {
                sb.append(aq.removeFirst());
                if(spaces > 0) {
                    sb.append(" ");
                    --spaces;
                }
            }
            sb.append(" ".repeat(this.maxLength - sb.length()));
            return sb.toString();
        }

        @Override
        public String toString() {
            if(this.isLastLine) {
                return this.lastString();
            }
            int missingSpace = this.maxLength  - this.length;
            StringBuilder sb = new StringBuilder();
            if(missingSpace == 0) {
                while(!aq.isEmpty()) {
                    sb.append(aq.removeFirst());
                    if(spaces > 0) {
                        sb.append(" ");
                        --spaces;
                    }
                }
                return sb.toString();
            }
            int div = missingSpace / spaces;
            int mod = missingSpace % spaces;
            while(!aq.isEmpty()) {
                sb.append(aq.removeFirst());
                if(spaces > 0) {
                    sb.append(" ".repeat(1 + div + (mod>0?1:0)));
                    --mod;
                    --spaces;
                }
            }
            return sb.toString();
        }
    }
}
