package com.acabra.gtechdevalgs.google;

import java.util.HashMap;
import java.util.Map;

public class LoggerRaterLimiter {

    private final Map<String, Integer> lastPrintedAt = new HashMap<>();
    /** Initialize your data structure here. */
    public LoggerRaterLimiter() {
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer lastPrinted = lastPrintedAt.get(message);
        if(null == lastPrinted ||  (timestamp - lastPrinted) >= 10) {
            lastPrintedAt.put(message, timestamp);
            return true;
        }
        return false;
    }
}
