package com.acabra.gtechdevalgs.google;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Predirator<E> implements Iterator<E> {

    private final Iterator<E> iterator;
    E internalNext = null;
    final java.util.function.Predicate<E> predicate;

    public Predirator(Iterator<E> iterator, Predicate<E>predicate) {
        this.predicate = predicate;
        this.iterator = iterator;
    }

    public boolean hasNext() {
        E tmp = null;
        if (internalNext != null) {
            return true;
        }
        while (iterator.hasNext()) {
            tmp = iterator.next();
            if (!predicate.test(tmp)) {
                internalNext = tmp;
                return true;
            }
        }
        return false;
    }

    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Iterator is empty");
        }
        if (internalNext != null) {
            E tmp = internalNext;
            this.internalNext = null;
            return tmp;
        }
        while (hasNext()) {
            E element = iterator.next();
            if (!predicate.test(element)) {
                return element;
            }
        }
        return null;
    }


    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}