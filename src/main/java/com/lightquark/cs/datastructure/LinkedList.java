package com.lightquark.cs.datastructure;

public interface LinkedList<T> {

    long size();

    void add(T value);

    void addFirst(T value);

    T get(long index);

    T getFirst();

    T getLast();

    void remove(long index);

    void removeFirst();

    void removeLast();

}
