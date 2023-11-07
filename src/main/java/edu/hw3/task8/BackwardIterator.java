package edu.hw3.task8;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BackwardIterator<T> implements Iterator<T> {
    private final List<T> list;
    private int curIndex;

    public BackwardIterator(Collection<T> list) {
        this.list = list.stream().toList();
        curIndex = list.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return curIndex >= 0;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException();
        }

        return list.get(curIndex--);
    }
}
