package com.lightquark.cs.search;

import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;

@Getter
@ToString
public abstract class AbstractSearchableArray implements Searchable<int[], Integer> {

    @Override
    public Integer search(int[] values, Integer target) {
        // copy input values to make sure that any other function will not modify them
        int[] v = Arrays.copyOf(values, values.length);
        return internalSearch(v, target);
    }

    protected abstract int internalSearch(int[] values, int target);

}
