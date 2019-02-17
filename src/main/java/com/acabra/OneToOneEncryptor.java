package com.acabra;

import java.util.HashMap;
import java.util.Map;

/*
Input is two words: plain word and encrypted word.
Encryption algorithm is following: replace every char in source word with another predefined character.
Implement a function which returns true if the second word was encrypted version of the first one.

Example:
foo -> bar  - impossible
foof -> quuq - possible
foof -> foof - possible
fff -> oo - impossible
bar -> foo - impossible
*/
public class OneToOneEncryptor {

    public boolean isOneToOneEncryptionPossibleForGivenPair(String plainText, String encryptedText) {
        if(null == plainText || null == encryptedText || plainText.length() != encryptedText.length()) {
            return false;
        }
        Map<Character, Character> encryptionMap = new HashMap<>();
        Map<Character, Character> decryptionMap = new HashMap<>();

        for (int i=0; i<plainText.length();i++) {
            Character charAtPlain = plainText.charAt(i);
            Character charAtEncrypt = encryptedText.charAt(i);

            Character encryptValue = encryptionMap.get(charAtPlain);
            Character decryptValue = decryptionMap.get(charAtEncrypt);

            if(null == encryptValue) {
                if (null != decryptValue) {
                    return false;
                }
                encryptionMap.put(charAtPlain, charAtEncrypt);
                decryptionMap.put(charAtEncrypt, charAtPlain);

            } else {
                if (!encryptValue.equals(charAtEncrypt) || !decryptValue.equals(charAtPlain)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isOneToOneEncryptionPossibleForGivenPairLinearSearch(String plainText, String encryptedText) {
        if(null == plainText || null == encryptedText || plainText.length() != encryptedText.length()) {
            return false;
        }
        Map<Character, Character> encryptionMap = new HashMap<>();

        for (int i=0; i<plainText.length();i++) {
            Character charAtPlain = plainText.charAt(i);
            Character charAtEncrypt = encryptedText.charAt(i);
            Character encryptValue = encryptionMap.get(charAtPlain);

            if (null == encryptValue) {
                for(Character encryptedVal: encryptionMap.values()) {
                    if (encryptedVal.equals(charAtEncrypt)) {
                        return false;
                    }
                }
                encryptionMap.put(charAtPlain, charAtEncrypt);
            } else {
                if (!encryptValue.equals(charAtEncrypt)) {
                    return false;
                }
            }
        }
        return true;
    }
}

