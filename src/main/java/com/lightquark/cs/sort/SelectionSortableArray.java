package com.lightquark.cs.sort;

/**
 * Selection Sort
 *
 * Time Complexity: O(n2) as there are two nested loops.
 * Auxiliary Space: O(1)
 * Stability : The default implementation is not stable. However it can be made stable. Please see stable selection com.lightquark.cs.sort for details.
 * In Place : Yes, it does not require extra space.
 *
 * The good thing about selection com.lightquark.cs.sort is it never makes more than O(n) swaps and can be useful when memory write is a costly operation.
 */
public class SelectionSortableArray extends AbstractSortableArray {

    public SelectionSortableArray(int[] values) {
        super(values);
    }

    @Override
    public void sort() {

        int size = values.length;
        for (int i = 0; i < size - 1; i++) {

            int minIndex = i;
            for (int j = i + 1; j < size; j++) {

                if (values[j] < values[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                swap(i, minIndex);
            }
        }
    }
}
