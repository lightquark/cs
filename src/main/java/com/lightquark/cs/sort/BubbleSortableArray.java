package com.lightquark.cs.sort;

/**
 * Bubble Sort
 * Repeatedly swap the adjacent elements if they are in wrong order
 *
 * Best, Worst and Average Case Time Complexity: O(n^2).
 * Auxiliary Space: O(1)
 * Sorting In Place: Yes
 * Stable: Yes
 */
public class BubbleSortableArray extends AbstractSortableArray {

    @Override
    protected int[] internalSort(int[] values) {
        int size = values.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {

                if (values[j] > values[j + 1]) {
                    swap(values, j, j + 1);
                }
            }
        }
        return values;
    }
}
