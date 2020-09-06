package com.lightquark.cs.datastructure;

import lombok.ToString;

@ToString
public class ArrayBasedQueue implements Queue<Integer> {

    private static final int DEFAULT_SIZE = 10;

    private final int[] values;
    private int head;
    private int tail;
    private int size;

    public ArrayBasedQueue() {
        this(DEFAULT_SIZE);
    }

    public ArrayBasedQueue(int initialSize) {
        this.values = new int[initialSize];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    @Override
    public void enqueue(Integer value) {
        if (size >= values.length) {
            throw new IndexOutOfBoundsException("Exceed queue size of " + values.length + " elements");
        }
        values[head] = value;
        head = getNextIndex(head);
        size++;
    }

    @Override
    public Integer dequeue() {
        if (size > 0) {
            Integer v = values[tail];
            tail = getNextIndex(tail);
            size--;
            return v;
        }
        return null;
    }

    @Override
    public Integer peek() {
        if (size > 0) {
            return values[tail];
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
