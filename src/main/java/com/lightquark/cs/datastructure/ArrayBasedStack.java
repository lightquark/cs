package com.lightquark.cs.datastructure;

import lombok.ToString;

@ToString
public class ArrayBasedStack<T> implements Stack<T> {

    private static final int DEFAULT_SIZE = 10;

    private final Object[] values;
    private int index;

    public ArrayBasedStack() {
        this(DEFAULT_SIZE);
    }

    public ArrayBasedStack(int initialSize) {
        this.values = new Object[initialSize];
        this.index = -1;
    }

    @Override
    public long size() {
        return index + 1;
    }

    @Override
    public boolean isEmpty() {
        return index < 0;
    }

    @Override
    public void push(T value) {
        if (index == values.length - 1) {
            throw new IndexOutOfBoundsException("Exceed stack size of " + values.length + " elements");
        }
        index++;
        values[index] = value;
    }

    @Override
    public T pop() {
        if (0 <= index && index <= values.length) {
            index--;
            return (T) values[index + 1];
        }
        return null;
    }

    @Override
    public T peek() {
        if (0 <= index && index <= values.length) {
            return (T) values[index];
        }
        return null;
    }
}
