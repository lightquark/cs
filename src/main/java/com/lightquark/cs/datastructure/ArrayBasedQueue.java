package com.lightquark.cs.datastructure;

import lombok.ToString;

@ToString
public class ArrayBasedQueue<T> implements Queue<T> {

    private static final int DEFAULT_SIZE = 10;

    private final Object[] values;
    private int head;
    private int tail;
    private int size;

    public ArrayBasedQueue() {
        this(DEFAULT_SIZE);
    }

    public ArrayBasedQueue(int initialSize) {
        this.values = new Object[initialSize];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    @Override
    public long size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public void enqueue(T value) {
        if (size >= values.length) {
            throw new IndexOutOfBoundsException("Exceed queue size of " + values.length + " elements");
        }
        values[head] = value;
        head = getNextIndex(head);
        size++;
    }

    @Override
    public T dequeue() {
        if (size > 0) {
            T v = (T) values[tail];
            tail = getNextIndex(tail);
            size--;
            return v;
        }
        return null;
    }

    @Override
    public T peek() {
        if (size > 0) {
            return (T) values[tail];
        }
        return null;
    }

    private int getNextIndex(int index) {
        if (index + 1 < values.length) {
            return index + 1;
        }
        return 0;
    }
}
