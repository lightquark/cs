package com.lightquark.cs.datastructure;

import lombok.ToString;

import java.util.LinkedList;

@ToString
public class ListBasedStack implements Stack<Integer> {

    private final LinkedList<Integer> values;

    public ListBasedStack() {
        this.values = new LinkedList<>();
    }

    @Override
    public void push(Integer value) {
        values.add(0, value);
    }

    @Override
    public Integer pop() {
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
