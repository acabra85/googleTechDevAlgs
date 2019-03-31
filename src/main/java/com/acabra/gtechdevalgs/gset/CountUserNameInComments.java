package com.acabra.gtechdevalgs.gset;

/**
 * Describe your class
 */
public class CountUserNameInComments {

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
                        count += countUserNameWithinMultiBlockComments(myFile, userName);
                    } else if (nextChar == '/') {
                        count += countUserNameWithinSingleLineComment(myFile, userName);
                    }
                }
            }
        }
        return count;
    }

    private int countUserNameWithinSingleLineComment(MyFile myFile, String userName) {
        String line = myFile.getNextLine();
        if (line.length() >= userName.length()) {
            int count = 0;
            int idxUserName = 0;
            for (int i = 0; i < line.length() && (line.length() - i) >= userName.length() - idxUserName ; i++) {
                if (userName.charAt(idxUserName) == line.charAt(i)) {
                    if (equalWords(userName, line, i)) {
                        count++;
                        i += userName.length();
                    }
                }
            }
            return count;
        }
        return 0;
    }

    private boolean equalWords(String userName, String line, int idx) {
        if (line.length() - idx >= userName.length()) {
            for (int i = idx, j = 0; j < userName.length(); j++, i++) {
                if (line.charAt(i) != userName.charAt(j)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private int countUserNameWithinMultiBlockComments(MyFile myFile, String userName) {
        int count = 0;
        char prevChar = '\0';
        char curr = '\0';
        while(!myFile.isEOF()) {
            if ((curr = myFile.getNextChar()) == '/' && prevChar == '*'){
                break;
            }
            if (userName.charAt(0) == curr) {
                if (equalWords(userName, myFile)) {
                    count++;
                }
            }
            prevChar = curr;
        }
        return count;
    }

    private boolean equalWords(String userName, MyFile myFile) {
        char curr;
        int i;
        for (i = 1; i < userName.length(); i++) {
            if (!myFile.isEOF() && userName.charAt(i) != myFile.getNextChar()) {
                return false;
            }
        }
        return i == userName.length();
    }

    private void moveFileToNextChar(MyFile myFile, char iChar) {
        while (!myFile.isEOF()) {
            if (myFile.getNextChar() == iChar) {
                return;
            }
        }
    }
}
