package com.lightquark.cs.datastructure;

/**
 * A stack or LIFO (last in, first out) is an abstract data type that serves as a collection of elements,
 * with two principal operations:
 * - push, which adds an element to the collection,
 * - pop, which removes the last element that was added.
 * In stack both the operations of push and pop takes place at the same end that is top of the stack.
 *
 * Insertion: O(1)
 * Deletion:  O(1)
 * Access Time: O(n) [Worst Case]
 * Insertion and Deletion are allowed on one end.
 *
 * Source: https://www.geeksforgeeks.org/
 */
public interface Stack<T> {

    long size();

    boolean isEmpty();

    void push(T value);

    T pop();

    T peek();

}
