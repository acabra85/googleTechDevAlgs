package com.acabra.gtechdevalgs.gset;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.function.Consumer;

public class MedianFromStream implements Consumer<Double> {

    private static final Comparator<Double> DESCENDING_ORDER_COMPARATOR = new Comparator<Double>() {
        @Override
        public int compare(Double o1, Double o2) {
            return Double.compare(o2, o1);
        }
    };

    // lower elements will be a MaxHeap, since the biggest element here will be smaller than the highest element on the other queue
    private PriorityQueue<Double> lowerElements = new PriorityQueue<>(DESCENDING_ORDER_COMPARATOR);

    private PriorityQueue<Double> higherElements = new PriorityQueue<>();

    public double getMedian() {
        if (this.lowerElements.isEmpty()) throw new NoSuchElementException("no elements present");
        PriorityQueue<Double> smaller = getSmaller();
        PriorityQueue<Double> bigger = getBigger(smaller);
        if (smaller.size() == bigger.size()) {
            return (lowerElements.peek() + higherElements.peek()) / 2.0;
        }
        return bigger.peek();
    }

    private PriorityQueue<Double> getBigger(PriorityQueue<Double> smaller) {
        return smaller == lowerElements ? higherElements : lowerElements;
    }

    private PriorityQueue<Double> getSmaller() {
        return lowerElements.size() < higherElements.size() ? lowerElements : higherElements;
    }

    @Override
    public void accept(Double num) {
        if (lowerElements.isEmpty() || num < lowerElements.peek()) {
            lowerElements.offer(num);
        } else {
            higherElements.offer(num);
        }
        reBalance();
    }

    private void reBalance() {
        if (Math.abs(lowerElements.size() - higherElements.size()) > 1) {
            PriorityQueue<Double> smaller = getSmaller();
            smaller.offer(getBigger(smaller).poll());
        }
    }
}
