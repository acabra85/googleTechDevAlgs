package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * Java limited implementation of UNIX chdir (cd) command.
 */
public class ChangeDirectory {

    private static final String PARENT_TOKEN = "..";
    private static final String PATH_DELIMITER = "/";


    public static String changeDir(String input) {
        if (null == input || input.length() == 0) {
            return "";
        }
        boolean reachedRoot = false;
        ArrayDeque<String> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(input, PATH_DELIMITER, false);
        while (st.hasMoreTokens()) {
            String next = st.nextToken();
            if (next.equals(PARENT_TOKEN)) {
                if (!deque.isEmpty()) {
                    deque.pollFirst();
                } else {
                    reachedRoot = true;
                }
            } else {
                deque.offerFirst(next);
            }
        }
        if (deque.isEmpty())
            return "/";
        return buildPathFromStack(deque, isAbsolute(input) || reachedRoot);
    }

    private static boolean isAbsolute(String input) {
        return input.charAt(0) == '/';
    }

    private static String buildPathFromStack(ArrayDeque<String> deque, boolean includeRoot) {
        StringBuilder sb = new StringBuilder();
        if (includeRoot) {
            sb.append("/");
        }
        while (!deque.isEmpty()) {
            sb.append(deque.removeLast());
            if (!deque.isEmpty())
                sb.append("/");
        }
        return sb.toString();
    }
}
