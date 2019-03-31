package com.acabra.gtechdevalgs.gset;

/**
 * Describe your class
 */
public class CountUsernameInComments {



    public int countOccurrences(MyFile myFile, String userName) {
        if (myFile == null || userName == null || userName.length() == 0) return 0;
        int count = 0;
        while(!myFile.isEOF()) {
            char iChar = myFile.getNextChar();
            if (iChar == '"') {
                moveFileToNextChar(myFile, '"');
            } else if (iChar == '/') {
                if (!myFile.isEOF()) {
                    char nextChar = myFile.getNextChar();
                    if (nextChar == '*') {
                        count += countUserNameWithinMultiBlockComments(myFile);
                    } else if (nextChar == '/') {
                        count += countUsernameWithinSingleLineComment(myFile);
                    }
                }
            }
        }
        return count;
    }

    private int countUsernameWithinSingleLineComment(MyFile myFile) {
        return 0;
    }

    private int countUserNameWithinMultiBlockComments(MyFile myFile) {
        int count = 0;
        while (!myFile.isEOF()) {

        }
        return count;
    }

    private void moveFileToNextChar(MyFile myFile, char iChar) {
        while (!myFile.isEOF()) {
            if (myFile.getNextChar() == iChar) {
                return;
            }
        }
    }
}
