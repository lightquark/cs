package com.lightquark.cs.search;

public interface Searchable<T, U> {

    U search(T values, U target);

}
