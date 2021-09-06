package com.acabra.gtechdevalgs.litcode.arrays;
/*
Write a function checking that the given string is valid. We consider a string
to be valid if all the characters of the string have exactly the same frequency.

Examples:
"aabbcc" is a valid string
"aabbccc" is an invalid string

Check if the string is valid as it is (same condition as before) or if one character
at one position can be removed from the string so it will become valid.
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
    public static void main(String[] args) {
        mustReturnTrue_validString();
        mustReturnFalse_nullInput();
        mustReturnFalse_inputHasDifferentCharacterFrequence();
        mustReturnTrue_inputIsEmptyString();
        mustReturnTrue_allCharactersTheSame();
        mustReturnFalse_multipleCharacters();
    }

    private static void mustReturnFalse_multipleCharacters() {
        SameCharacterFrequencyValidator underTest = new SameCharacterFrequencyValidator();
        String input = "aabbbccddd";

        runTestCase(false, input, underTest::validateString);
    }


    static public void mustReturnTrue_allCharactersTheSame() {
        SameCharacterFrequencyValidator underTest = new SameCharacterFrequencyValidator();
        String input = "aaaaaaaaa";

        runTestCase(true, input, underTest::validateString);
    }
    static public void mustReturnTrue_validString() {
        SameCharacterFrequencyValidator underTest = new SameCharacterFrequencyValidator();
        String input = "aabbcc";

        runTestCase(true, input, underTest::validateString);
    }

    static public void mustReturnFalse_nullInput() {
        SameCharacterFrequencyValidator underTest = new SameCharacterFrequencyValidator();
        String input = null;

        runTestCase(false, input, underTest::validateString);
    }

    static public void mustReturnFalse_inputHasDifferentCharacterFrequence() {
        SameCharacterFrequencyValidator underTest = new SameCharacterFrequencyValidator();
        String input = "aabbccc";

        runTestCase(false, input, underTest::validateString);
    }

    static public void mustReturnTrue_inputIsEmptyString() {
        SameCharacterFrequencyValidator underTest = new SameCharacterFrequencyValidator();
        String input = "";

        runTestCase(true, input, underTest::validateString);
    }

    static private void runTestCase(boolean expected, String input, Function<String, Boolean> function) throws RuntimeException {
        boolean actual = function.apply(input);
        if(actual == expected) {
            System.out.println("Test passed");
        } else {
            throw new RuntimeException(String.format("Test failed: the given string is invalid: expected[%s] got[%s]", 
                    expected, actual));
        }
    }

    static class SameCharacterFrequencyValidator {
        public boolean validateString(String input) {
            if(null == input) return false;
            if(input.length() == 0) return true;
            if(input.length() == 1) return true;

            Integer frequency = null;
            Map<Character, AtomicInteger> freqMap = buildFrequencyMap(input);
            for(Map.Entry<Character, AtomicInteger> entry: freqMap.entrySet()) {
                if(null != frequency) {
                    if(entry.getValue().get() != frequency) {
                        return false;
                    }
                }
                frequency = entry.getValue().get();
            }
            return oneCharacterRemovedIsValid(freqMap);
        }

        private boolean oneCharacterRemovedIsValid(Map<Character, AtomicInteger> freqMap) {
            Map<Integer,AtomicInteger> freqCount = buildFreqCount(freqMap);

            if(freqCount.size() == 1) return true;
            if(freqCount.size() == 2) {
                Iterator<Map.Entry<Integer, AtomicInteger>> iterator = freqCount.entrySet().iterator();
                Map.Entry<Integer, AtomicInteger> e1 = iterator.next();
                Map.Entry<Integer, AtomicInteger> e2 = iterator.next();
                return Math.abs(e1.getKey()-e2.getKey())==1 && (e1.getValue().get() == 1 ||
                        e2.getValue().get() == 1);
            }
            return false;
        }

        private Map<Integer, AtomicInteger> buildFreqCount(Map<Character, AtomicInteger> freqMap) {
            Map<Integer, AtomicInteger> freqCount = new HashMap<>();
            for (Map.Entry<Character, AtomicInteger> entry : freqMap.entrySet()) {
                AtomicInteger atomicInteger = freqCount.get(entry.getValue().get());
                if(atomicInteger == null) {
                    freqCount.put(entry.getValue().get(), new AtomicInteger(1));
                } else{
                    atomicInteger.incrementAndGet();
                }
            }
            return freqCount;
        }

        private Map<Character, AtomicInteger> buildFrequencyMap(String input) {
            final HashMap<Character, AtomicInteger> freqMap = new HashMap<>();
            for(char c: input.toCharArray()) {
                AtomicInteger count = freqMap.get(c);
                if(null == count) {
                    count = new AtomicInteger();
                    freqMap.put(c, count);
                }
                count.incrementAndGet();
            }
            return freqMap;
        }
    }
}

// "aabbbccddd"
//
//        freq{a:2, b:3, c:2, d:3};
//
//        FreqCount{2:2, 3:2}; false
//        FreqCount{2:2, 3:1}; false
