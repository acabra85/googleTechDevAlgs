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
    char[] currentLine = null;
    String currentLineStr = null;
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
        this.currentLine = s!= null ? s.toCharArray() : null;
        this.indexCurrentLine = s!= null ? 0 : -1;
        this.currentLineStr = s;
    }


    @Override
    public char getNextChar() {
        validateRead();
        if (indexCurrentLine < currentLine.length) {
            return currentLine[indexCurrentLine++];
        } else {
            readNextLine();
            if (endOfFile) return '\0';
            if (currentLineStr.length()==0) {
                indexCurrentLine++;
                return '\n';
            }
            return currentLine[indexCurrentLine++];
        }
    }

    @Override
    public String getNextLine() {
        validateRead();
        if (indexCurrentLine < currentLine.length) {
            String substring = currentLineStr.substring(indexCurrentLine);
            indexCurrentLine = currentLine.length;
            return substring;
        } else {
            readNextLine();
            if (endOfFile) return "";
            indexCurrentLine = currentLine.length;
            return currentLineStr;
        }
    }

    @Override
    public boolean isEOF() {
        return this.endOfFile;
    }

    private void validateRead() {
        if (endOfFile) {
            throw new NoSuchElementException("reached end of file");
        }
    }
    private void readNextLine() {
        String s = null;
        try {
            s = bf.readLine();
        } catch (IOException e) {
            System.out.println("unable to read line: " + e.getMessage());
        }
        if (s == null) {
            this.endOfFile = true;
            this.currentLine = null;
            this.indexCurrentLine = -1;
            this.currentLineStr = null;
        } else {
            this.currentLine = s.toCharArray();
            this.indexCurrentLine = 0;
            this.currentLineStr = s;
        }
    }
}
