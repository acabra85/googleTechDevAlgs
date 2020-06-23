package com.acabra.gtechdevalgs.litcode;
import java.util.ArrayDeque;

class MovingAverage {

    int count;
    double sum;
    ArrayDeque<Integer> queue;
    int size;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.sum = 0;
        this.count = 0;
        this.size = size;
        this.queue = new ArrayDeque<>(size);
    }

    public double next(int val) {
        this.queue.addFirst(val);
        if (this.queue.size() <= this.size) {
            sum += val;
            ++count;
            return sum / count;
        }
        sum -= this.queue.removeLast();
        sum += val;
        return sum / size;
    }
}

