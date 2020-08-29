package com.lightquark.cs.sort;

import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;

@Getter
@ToString
public abstract class AbstractSortableArray implements Sortable<int[]> {

    @Override
    public int[] sort(int[] values) {
        // copy input values to make sure that any other function will not modify them
        int[] v = Arrays.copyOf(values, values.length);
        return internalSort(v);
    }

    protected abstract int[] internalSort(int[] values);

    /**
     * An auxiliary function for reducing boilerplate code
     */
    protected void swap(int[] v, int i, int j) {
        int tmp = v[i];
        v[i] = v[j];
        v[j] = tmp;
    }
}
