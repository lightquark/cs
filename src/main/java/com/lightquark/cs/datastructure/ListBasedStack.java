package com.lightquark.cs.datastructure;

import lombok.ToString;

import java.util.LinkedList;

@ToString
public class ListBasedStack<T> implements Stack<T> {

    private final LinkedList<T> values;

    public ListBasedStack() {
        this.values = new LinkedList<>();
    }

    @Override
    public long size() {
        return values.size();
    }

    @Override
    public boolean isEmpty() {
        return values.size() <= 0;
    }

    @Override
    public void push(T value) {
        values.add(0, value);
    }

    @Override
    public T pop() {
        if (values.size() > 0) {
            T v = values.get(0);
            values.remove(0);
            return v;
        }
        return null;
    }

    @Override
    public T peek() {
        if (values.size() > 0) {
            return values.get(0);
        }
        return null;
    }
}
