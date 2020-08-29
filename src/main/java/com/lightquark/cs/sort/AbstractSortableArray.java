package com.lightquark.cs.sort;

import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;

@Getter
@ToString
public abstract class AbstractSortableArray implements Sortable {

    protected final int[] values;

    public AbstractSortableArray(int[] values) {
        // copy values to make sure that any other function will not modify them
        this.values = Arrays.copyOf(values, values.length);
    }

    /**
     * An auxiliary function for reducing boilerplate code
     */
    protected void swap(int i, int j) {
        int tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
    }
}
