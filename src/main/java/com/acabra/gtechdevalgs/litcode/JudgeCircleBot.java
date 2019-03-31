package com.acabra.gtechdevalgs.litcode;

/**
 * Describe your class
 */
public class JudgeCircleBot {

    public boolean judgeCircle(String moves) {
        int posX = 0;
        int posY = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U':
                    posY++;
                    break;
                case 'D':
                    posY--;
                    break;
                case 'L':
                    posX--;
                    break;
                case 'R':
                    posX++;
                    break;
                default:
                    break;
            }
        }
        return posX == 0 && posY == 0;
    }
}
