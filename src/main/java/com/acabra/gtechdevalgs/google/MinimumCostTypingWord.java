package com.acabra.gtechdevalgs.google;

import java.util.Arrays;

public class MinimumCostTypingWord {

    /**
     * Given an english keyboard (represented as a 2D array of 5-rows * 6-columns where the top left corner
     * contains the letter A and the Z is located on the last row and the second column) and a word,
     * find the minimal cost (total distance traveled by fingers within the keyboard)
     * to type it. At most 1 finger on each hand can be used.
     * The distance cost between 2 letters within the keyboard at coordinates (x1,y1) and (x2,y2)
     * is given by the formula Abs(x1 - x2) + Abs(y1 - y2).
     * @param word the minimal cost of typing a word in a keyboard
     */
    public int minimalCostToType(String word) {
        if (null == word || word.length() < 3) return 0;
        memo = initializeMemo(word.length());
        char[] arr = word.toCharArray();
        int finger1Pos = arr[0] - 'A' + 1; //first letter is free
        return solve(arr, 1, finger1Pos, 0);
    }

    private int solve(char[] word, int i, int finger1Pos, int finger2Pos) {
        if(word.length == i) return 0; //all typed
        if(memo[i][finger1Pos][finger2Pos] != -1) return memo[i][finger1Pos][finger2Pos];
        int posNextLetter = word[i] - 'A' + 1;

        int cost1 = keyboardLetterDistance(posNextLetter, finger1Pos) + solve(word, i+1, posNextLetter, finger2Pos); //continue typing with finger1Pos
        int cost2 = solve(word, i+1, finger1Pos, posNextLetter); //start typing with finger2
        if(finger2Pos > 0) {
            cost2 += keyboardLetterDistance(posNextLetter, finger2Pos); // add the cost of moving from the previous key
        }
        memo[i][finger1Pos][finger2Pos] = Math.min(cost1, cost2);
        return memo[i][finger1Pos][finger2Pos];
    }


    /**
     * The 2D keyboard is represented by a single array 0-26, in this method
     * a translation from the single position is made to the real 2D position.
     * @param posNextLetter index in the flat 1D keyboard representation of the next letter
     * @param posFinger index in the flat 1D keyboard representation of next letter
     * @return
     */
    private int keyboardLetterDistance(int posNextLetter, int posFinger) {
        int xn = posFinger - 1;
        int yn = posNextLetter - 1;
        return Math.abs(xn / 6 - yn / 6) + Math.abs( xn % 6 - yn % 6);
    }

    private int[][][] initializeMemo(int N) {
        int[][][] memo = new int[N][LETTER_COUNT][LETTER_COUNT];
        for(int i=0;i<N;++i) {
            for(int j = 0; j< LETTER_COUNT; ++j){
                Arrays.fill(memo[i][j], -1);
            }
        }
        return memo;
    }
    int[][][] memo;
    static final int LETTER_COUNT = 27;
}
