package com.acabra.gtechdevalgs.google;

public class WordsInTyping {

    public int wordsTyping(String[] sentence, int rows, int cols) {
        CircularIterator itr = new CircularIterator(sentence);
        String tmp = null;
        boolean remainder = false;
        boolean cycle = false;
        for(int i=0;i<rows;++i) {
            for(int j=0;j<cols;) {
                tmp = remainder ? itr.prev() : itr.next(j);
                if (j==0) {
                    if (tmp.length() > cols) {
                        return 0;
                    }
                    remainder = false;
                    j += tmp.length();
                    if (!cycle && itr.firstWord() && i > 0) {
                        cycle = true;
                        int cycleSize = i;
                        int remaining = rows - i;
                        if (remaining >= cycleSize) {
                            int cyclesToAdvance = remaining / cycleSize;
                            itr.advanceCycle(cyclesToAdvance);
                            i += cycleSize * cyclesToAdvance;
                            if(i>=rows) {
                                remainder=true;
                                break;
                            }
                        }
                    }
                } else {
                    if (tmp.length() + 1 <= cols-j) {
                        remainder = false;
                        j += 1 + tmp.length();
                    } else {
                        remainder = true;
                        break;
                    }
                }
            }
        }
        return itr.getCount() + (itr.lastWord() && !remainder ? 1 : 0);
    }

    private static class CircularIterator {

        private int i = 0;
        private final String[] arr;
        private int count;

        public CircularIterator(String[] arr) {
            this.arr = arr;
            this.count = 0;
        }

        public String prev() {
            if (i-1 < 0)
                return arr[arr.length - 1];
            return arr[i - 1];
        }

        public String next(int j) {
            if (i == arr.length) {
                i = 0;
                ++this.count;
            }
            return arr[i++];
        }

        public boolean lastWord() {
            return i == arr.length;
        }

        public int getCount() {
            return this.count;
        }

        public boolean firstWord() {
            return i - 1 == 0;
        }

        public void advanceCycle(int cyclesToAdvance) {
            this.count += this.count * cyclesToAdvance;
        }
    }
}
