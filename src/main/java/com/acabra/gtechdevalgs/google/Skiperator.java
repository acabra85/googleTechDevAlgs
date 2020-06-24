package com.acabra.gtechdevalgs.google;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;

public class Skiperator<E> implements Iterator<E> {
    private final Iterator<E> iterator;
    E internalNext = null;
    private final Map<E, AtomicInteger> elementsToSkip = new HashMap<>();

    public Skiperator(Iterator<E> iterator){
        this.iterator = iterator;
        this.internalNext = iterator.hasNext()?iterator.next():null;
    }

    public void skip(E element){
        if (internalNext != null && internalNext.equals(element)) {
            internalNext = null;
            return;
        }
        AtomicInteger counter = elementsToSkip.get(element);
        if (counter != null) {
            counter.incrementAndGet();
        } else {
            elementsToSkip.put(element, new AtomicInteger(1));
        }
    }

    public boolean hasNext() {
        E tmp = null;
        if (internalNext != null) {
            return true;
        }
        while (iterator.hasNext()) {
            tmp = iterator.next();
            AtomicInteger counter = elementsToSkip.get(tmp);
            if (counter == null || counter.get() == 0) {
                internalNext = tmp;
                return true;
            }
            counter.decrementAndGet();
        }
        return false;
    }

    public E next() {
        if(!hasNext()) {
            throw new NoSuchElementException("Iterator is empty");
        }
        if (internalNext != null) {
            E tmp = internalNext;
            this.internalNext = null;
            return tmp;
        }
        while(hasNext()) {
            E element = iterator.next();
            AtomicInteger counter = elementsToSkip.get(element);
            if (counter == null || counter.get() == 0) {
                return element;
            }
            counter.decrementAndGet();
        }
        return null;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}







