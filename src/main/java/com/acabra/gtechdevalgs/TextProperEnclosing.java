package com.acabra.gtechdevalgs;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class TextProperEnclosing {

    // Defines the valid closer characters for a given open character. Note: characters can have the same open as closing
    private static final Map<Character, Character> OPENER_TO_CLOSER = Collections.unmodifiableMap(new HashMap<Character, Character>(){{
        put('{', '}');
        put('[', ']');
        put('(', ')');
        put('<', '>');
        put('\'', '\'');
        put('\"', '\"');
    }});

    //Openers
    private static final Set<Character> OPENERS = Collections.unmodifiableSet(OPENER_TO_CLOSER.keySet());

    //closers
    private static final Set<Character> CLOSERS = Collections.unmodifiableSet(new HashSet<>(OPENER_TO_CLOSER.values()));

    /**
     * evaluates if a text has valid nesting according to the OPENER_TO_CLOSER map defined above
     * @param text
     * @return
     */
    public boolean isProperlyNestedText(String text) {
        if (null == text) throw new NullPointerException("Given text is null");
        if (text.length() == 0) return true;
        Stack<Character> openersStack = new Stack<>();
        for (int i = 0; i < text.length();i++) {
            Character curr = text.charAt(i);
            boolean isOpen = OPENERS.contains(curr);
            if (isOpen || CLOSERS.contains(curr)) {
                Character peek = OPENER_TO_CLOSER.get(openersStack.peek());
                if(OPENER_TO_CLOSER.get(curr) == null){ //not a self closer
                    if (isOpen) {
                        openersStack.push(curr);
                    } else {
                        if (openersStack.isEmpty() || !peek.equals(curr)) {
                            return false; //trying to close an unopened item
                        } else {
                            openersStack.pop();
                        }
                    }
                } else { //character is selfclosing
                    if (openersStack.isEmpty() || !peek.equals(curr)) {
                        openersStack.push(curr);
                    } else {
                        openersStack.pop();
                    }
                }
            }
        }
        return openersStack.isEmpty();
    }
}
