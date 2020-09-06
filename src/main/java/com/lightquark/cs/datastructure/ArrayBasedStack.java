package com.lightquark.cs.datastructure;

import lombok.ToString;

@ToString
public class ArrayBasedStack implements Stack<Integer> {

    private static final int DEFAULT_SIZE = 10;

    private final int[] values;
    private int index;

    public ArrayBasedStack() {
        this(DEFAULT_SIZE);
    }

    public ArrayBasedStack(int initialSize) {
        this.values = new int[initialSize];
        this.index = -1;
    }

    @Override
    public void push(Integer value) {
        if (index == values.length - 1) {
            throw new IndexOutOfBoundsException("Exceed stack size of " + values.length + " elements");
        }
        index++;
        values[index] = value;
    }

    @Override
    public Integer pop() {
        if (0 <= index && index <= values.length) {
            index--;
            return values[index + 1];
        }
        return null;
    }

    @Override
    public Integer peek() {
        if (0 <= index && index <= values.length) {
            return values[index];
        }
        return null;
    }
}
