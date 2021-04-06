package com.acabra.gtechdevalgs.google;

public class ReArrangeSpaces {

    /**
     * Reorder the spaces in the given text such that they are evenly distributed between words and also that
     * is maximum.
     * @param text
     * @return
     */
    public String reorderSpaces(String text) {
            int countSpaces = count(' ', text);
            String[] words = text.trim().split("\\s+");
            if(words.length == 1) {
                return words[0] + " ".repeat(countSpaces);
            }
            StringBuilder sb = new StringBuilder();
            if (words.length == 2) {
                return sb.append(words[0])
                        .append(" ".repeat(countSpaces))
                        .append(words[1]).toString();
            }
            int spaces = countSpaces / (words.length - 1);
            int mod = countSpaces % (words.length - 1);

            String spacer = " ".repeat(spaces);
            for(int i=0; i<words.length;++i) {
                sb.append(words[i]);
                if (i<words.length - 1) {
                    sb.append(spacer);
                }
            }
            if(mod > 0) {
                sb.append(" ".repeat(mod));
            }

            return sb.toString();
        }

        static int count(char c, String text) {
            int count = 0;
            for(char tc : text.toCharArray()) {
                if(tc == c) {
                    ++count;
                }
            }
            return count;
        }
}
