package com.fooduniverse.iterator;

public interface Iterator<T> {
    boolean hasNext();

    T next();
}