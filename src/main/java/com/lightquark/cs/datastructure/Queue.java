package com.lightquark.cs.datastructure;

/**
 * A queue or FIFO (first in, first out) is an abstract data type that serves as a collection of elements,
 * with two principal operations:
 * - enqueue, the process of adding an element to the collection.(The element is added from the rear side)
 * - dequeue, the process of removing the first element that was added. (The element is removed from the front side).
 *
 * Insertion : O(1)
 * Deletion  : O(1)
 * Access Time : O(n) [Worst Case]
 *
 * Source: https://www.geeksforgeeks.org/
 */
public interface Queue<T> {

    long size();

    boolean isEmpty();

    void enqueue(T value);

    T dequeue();

    T peek();

}
