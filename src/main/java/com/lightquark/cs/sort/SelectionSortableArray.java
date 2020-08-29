package com.lightquark.cs.sort;

/**
 * Selection Sort
 * Repeatedly find the minimum element from unsorted part and put it at the beginning.
 *
 * Advantage: It never makes more than O(n) swaps and can be useful when memory write is a costly operation.
 *
 * Time Complexity: O(n^2) as there are two nested loops.
 * Auxiliary Space: O(1)
 * Sorting In Place: Yes
 * Stable: No
 */
public class SelectionSortableArray extends AbstractSortableArray {

    @Override
    protected int[] internalSort(int[] values) {
        int size = values.length;
        for (int i = 0; i < size - 1; i++) {

            int minIndex = i;
            for (int j = i + 1; j < size; j++) {

                if (values[j] < values[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                swap(values, i, minIndex);
            }
        }
        return values;
    }
}
