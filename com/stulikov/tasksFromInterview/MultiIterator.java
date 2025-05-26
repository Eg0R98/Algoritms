package com.stulikov.tasksFromInterview;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MultiIterator<T> implements Iterator<T> {

    private final Iterator<T> a;

    private final Iterator<T> b;

    private int iteratorIndex = 0;

    public MultiIterator(Iterator<T> a, Iterator<T> b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean hasNext() {
        return a.hasNext() || b.hasNext();
    }

    @Override
    public T next() {
        if (a.hasNext()) {
            iteratorIndex = 1;
            return a.next();
        }
        iteratorIndex = 2;
        return b.next();
    }

    @Override
    public void remove() {
        if (iteratorIndex == 0) throw new NoSuchElementException("No element");

        if (iteratorIndex == 1) a.remove();
        b.remove();
    }
}

