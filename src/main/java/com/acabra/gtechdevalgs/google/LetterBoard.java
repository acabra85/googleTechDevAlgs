package com.acabra.gtechdevalgs.google;

import java.util.HashMap;
import java.util.Map;

public class LetterBoard {

    final static char[][] board = new char[6][5];

    static {
        board[0] = "abcde".toCharArray();
        board[1] = "fghij".toCharArray();
        board[2] = "klmno".toCharArray();
        board[3] = "pqrst".toCharArray();
        board[4] = "uvwxy".toCharArray();
        board[5] = "z0000".toCharArray();
    }
    final Map<Integer, Integer> letterToRow = new HashMap<>(){{
        put(0, 0);
        put(1, 0);
        put(2, 0);
        put(3, 0);
        put(4, 0);
        put(5, 1);
        put(6, 1);
        put(7, 1);
        put(8, 1);
        put(9, 1);
        put(10, 2);
        put(11, 2);
        put(12, 2);
        put(13, 2);
        put(14, 2);
        put(15, 3);
        put(16, 3);
        put(17, 3);
        put(18, 3);
        put(19, 3);
        put(20, 4);
        put(21, 4);
        put(22, 4);
        put(23, 4);
        put(24, 4);
        put(25, 5);
    }};

    /**
     * Given an alphabet board and a target word, starting at position 0,0
     * give the minimal amount of steps needed to build the word.
     * Available steps Up ('U') Down (D) Left (L), Right(R), Choose Character(!)
     * @param itarget a word to build
     * @return the directions needed to build the word starting at position 0,0
     */
    public String alphabetBoardPath(String itarget) {
        if(null == itarget || itarget.length() == 0) return "";
        String target = itarget.toLowerCase();
        StringBuilder directions = new StringBuilder();
        int[] pos = {0,0};
        int idx = 0;
        while(idx < target.length()) {
            char nextLetter = target.charAt(idx);
            int row = letterToRow.get(nextLetter - 'a');
            int col = (nextLetter - 'a') % 5;
            char currentChar = board[pos[0]][pos[1]];
            if (currentChar != nextLetter) {
                if (currentChar == 'z') {
                    append(directions, Math.abs(row - pos[0]), 'U');
                    pos[0] = row;
                    pos[1] = col;
                    append(directions, pos[1], 'R');
                } else if (nextLetter == 'z') {
                    append(directions, pos[1], 'L');
                    pos[1] = 0;
                    append(directions, 5 - pos[0], 'D');
                    pos[0] = 5;
                } else {
                    append(directions, Math.abs(col-pos[1]), col>pos[1] ? 'R': 'L');
                    pos[1] = col;
                    append(directions, Math.abs(row-pos[0]), row>pos[0] ? 'D': 'U');
                    pos[0] = row;
                }
            }
            directions.append('!');
            ++idx;
        }
        return directions.toString();
    }

    private void append(StringBuilder dir, int num, char c) {
        for(int i = 0; i < num; ++i) {
            dir.append(c);
        }
    }
}
