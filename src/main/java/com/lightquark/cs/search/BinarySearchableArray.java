package com.lightquark.cs.search;

/**
 * Input array should be sorted.
 * Does not account position of the value. If the input array contains several target values, any position may be
 * returned.
 */
public class BinarySearchableArray extends AbstractSearchableArray {

    @Override
    protected int internalSearch(int[] values, int target) {
        int size = values.length;
        int start = 0;
        int end = size - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (values[middle] == target) {
                return middle;
            } else if (target < values[middle]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }
}
