package com.acabra.gtechdevalgs.gset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

/**
 * Describe your class
 */
public class MyFileImpl implements MyFile {


    private boolean endOfFile;
    private final BufferedReader bf;
    private String currentLineStr = null;
    private StringBuilder seenContent = new StringBuilder();
    int indexCurrentLine = 0;

    public MyFileImpl(InputStream resourceAsStream) {
        this.bf = new BufferedReader(new InputStreamReader(resourceAsStream));
        String s = null;
        try {
            s = bf.readLine();
        } catch (IOException e) {
            System.out.println("unable to read line: " + e.getMessage());
        }
        if (s == null) {
            this.endOfFile = true;
        }
        this.indexCurrentLine = s!= null ? 0 : -1;
        this.currentLineStr = s;
    }


    @Override
    public char getNextChar() {
        validateRead();
        if (currentLineStr.length() > 0 && indexCurrentLine < currentLineStr.length()) {
            return currentLineStr.charAt(indexCurrentLine++);
        } else {
            readNextLine();
            if (endOfFile) return '\0';
            if (currentLineStr.length()==0) {
                indexCurrentLine++;
                return '\n';
            }
            return currentLineStr.charAt(indexCurrentLine++);
        }
    }

    @Override
    public String getNextLine() {
        validateRead();
        if (currentLineStr.length() > 0 && indexCurrentLine < currentLineStr.length()) {
            String substring = currentLineStr.substring(indexCurrentLine);
            indexCurrentLine = currentLineStr.length();
            return substring;
        } else {
            readNextLine();
            if (endOfFile) return "";
            indexCurrentLine = currentLineStr.length();
            return currentLineStr;
        }
    }

    @Override
    public boolean isEOF() {
        return this.endOfFile;
    }

    @Override
    public void goBackNCharactersOrNone(int n) {
        if (this.seenContent.length() + indexCurrentLine >= n) {
            if (n <= indexCurrentLine) {
                this.indexCurrentLine -= n;
            } else {
                int remainder = n - this.indexCurrentLine;
                String pending = this.seenContent.substring(this.seenContent.length() - remainder);
                this.seenContent.setLength(this.seenContent.length() - remainder);
                this.currentLineStr = pending + this.currentLineStr;
                this.indexCurrentLine = 0;
            }
        }
    }

    private void validateRead() {
        if (endOfFile) {
            throw new NoSuchElementException("reached end of file");
        }
    }
    private void readNextLine() {
        this.seenContent.append(this.currentLineStr);
        String s = null;
        try {
            s = bf.readLine();
        } catch (IOException e) {
            System.out.println("unable to read line: " + e.getMessage());
        }
        if (s == null) {
            reachedEndOfFile();
        } else {
            s = s + "\n";
            this.indexCurrentLine = 0;
            this.currentLineStr = s;
        }
    }

    private void reachedEndOfFile() {
        this.endOfFile = true;
        this.indexCurrentLine = -1;
        this.currentLineStr = null;
    }
}
