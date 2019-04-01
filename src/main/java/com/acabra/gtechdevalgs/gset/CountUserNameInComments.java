package com.acabra.gtechdevalgs.gset;

import java.util.HashSet;
import java.util.Set;

/**
 * Describe your class
 */
public class CountUserNameInComments {

    private final static Set<Character> VALID_CHARS = new HashSet<Character>() {{
        add('_');
        add('-');
        add('@');
    }};

    public int countOccurrences(MyFile myFile, String userName) {
        if (myFile == null || userName == null || userName.length() == 0) return 0;
        int count = 0;
        while(!myFile.isEOF()) {
            char iChar = myFile.getNextChar();
            if (iChar == '"') {
                moveFileToEndOfStringDeclaration(myFile);
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
            char prevChar = '\0';
            for (int i = 0; i < line.length() && (line.length() - i) >= userName.length() - idxUserName ; i++) {
                if (userName.charAt(idxUserName) == line.charAt(i)
                        && validSurroundingCharacter(prevChar) && equalWordsInSingleLineComments(userName, line, i)) {
                    count++;
                    i += userName.length();
                }
                prevChar = line.charAt(i);
            }
            return count;
        }
        return 0;
    }

    private int countUserNameWithinMultiBlockComments(MyFile myFile, String userName) {
        int count = 0;
        char prevChar = '\0';
        char curr = '\0';
        while(!myFile.isEOF()) {
            if ((curr = myFile.getNextChar()) == '/' && prevChar == '*'){
                break;
            }
            if (userName.charAt(0) == curr
                    && validSurroundingCharacter(prevChar) && equalWordsInMultiComments(userName, myFile)) {
                count++;
            }
            prevChar = curr;
        }
        return count;
    }

    private boolean equalWordsInSingleLineComments(String userName, String line, int idx) {
        if (line.length() - idx >= userName.length()) {
            int i = idx, j=0;
            for (; j < userName.length(); j++, i++) {
                if (line.charAt(i) != userName.charAt(j)) {
                    return false;
                }
            }
            return j == userName.length() && validSurroundingCharacter(line.charAt(i));
        }
        return false;
    }

    private boolean equalWordsInMultiComments(String userName, MyFile myFile) {
        char curr;
        int i;
        for (i = 1; i < userName.length(); i++) {
            if (!myFile.isEOF() && userName.charAt(i) != myFile.getNextChar()) {
                return false;
            }
        }
        if(myFile.isEOF()) return i == userName.length();
        return i == userName.length() && nextCharNotPartOfUserName(myFile);
    }

    private boolean nextCharNotPartOfUserName(MyFile myFile) {
        char nextChar = myFile.getNextChar();
        boolean notPartOfUsername = validSurroundingCharacter(nextChar);
        myFile.goBackNCharactersOrNone(1);
        return notPartOfUsername;
    }

    private boolean validSurroundingCharacter(char prevChar) {
        return !Character.isAlphabetic(prevChar) && !Character.isDigit(prevChar)
                && !VALID_CHARS.contains(prevChar);
    }

    private void moveFileToEndOfStringDeclaration(MyFile myFile) {
        while (!myFile.isEOF()) {
            if (myFile.getNextChar() == '"') {
                return;
            }
        }
    }
}
