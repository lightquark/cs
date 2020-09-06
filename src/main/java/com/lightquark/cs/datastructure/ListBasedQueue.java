package com.lightquark.cs.datastructure;

import lombok.ToString;

import java.util.LinkedList;

@ToString
public class ListBasedQueue implements Queue<Integer> {

    private final LinkedList<Integer> values;

    public ListBasedQueue() {
        this.values = new LinkedList<>();
    }

    @Override
    public void enqueue(Integer value) {
        values.add(value);
    }

    @Override
    public Integer dequeue() {
        if (values.size() > 0) {
            Integer v = values.get(0);
            values.remove(0);
            return v;
        }
        return null;
    }

    @Override
    public Integer peek() {
        if (values.size() > 0) {
            return values.get(0);
        }
        return null;
    }

}
