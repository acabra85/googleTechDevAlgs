package com.acabra.gtechdevalgs.gset;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class MedianFromStream {

    private static final Comparator<Double> COMP = new Comparator<Double>() {
        @Override
        public int compare(Double o1, Double o2) {
            return o1 < o2 ? 1 : o1 == o2 ? 0 : -1;
        }
    };

    // lower elements will be a MaxHeap, since the biggest element here will be smaller than the highest element on the other queue
    private PriorityQueue<Double> lowerElements = new PriorityQueue<>(COMP);

    private PriorityQueue<Double> higherElements = new PriorityQueue<>();

    public double getMedian() {
        if (this.lowerElements.isEmpty()) throw new NoSuchElementException("no elements present");
        PriorityQueue<Double> smaller = this.lowerElements.size() < this.higherElements.size() ? this.lowerElements : this.higherElements;
        PriorityQueue<Double> bigger = smaller == this.lowerElements ? this.higherElements : this.lowerElements;
        if (smaller.size() == bigger.size()) {
            return (lowerElements.peek() + higherElements.peek()) / 2.0;
        }
        return bigger.peek();
    }

    public void add(double num) {
        if (lowerElements.isEmpty() || num < lowerElements.peek()) {
            lowerElements.offer(num);
        } else {
            higherElements.offer(num);
        }
        rebalance();
    }

    private void rebalance() {
        PriorityQueue<Double> smaller = this.lowerElements.size() < this.higherElements.size() ? this.lowerElements : this.higherElements;
        PriorityQueue<Double> bigger = smaller == this.lowerElements ? this.higherElements : this.lowerElements;
        if (bigger.size() - smaller.size() > 1) {
            smaller.offer(bigger.poll());
        }
    }
}
