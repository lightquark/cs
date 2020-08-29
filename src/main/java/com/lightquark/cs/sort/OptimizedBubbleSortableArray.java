package com.lightquark.cs.sort;

/**
 * Optimized version of Bubble sort
 * Repeatedly swap the adjacent elements if they are in wrong order
 * The sorting process breaks when there are no swaps
 *
 * Worst and Average Case Time Complexity: O(n^2). Worst case occurs when array is reverse sorted.
 * Best Case Time Complexity: O(n). Best case occurs when array is already sorted.
 * Auxiliary Space: O(1)
 * Sorting In Place: Yes
 * Stable: Yes
 */
public class OptimizedBubbleSortableArray extends AbstractSortableArray {

    @Override
    protected int[] internalSort(int[] values) {
        boolean swapped;
        int size = values.length;
        for (int i = 0; i < size - 1; i++) {
            swapped = false;
            for (int j = 0; j < size - i - 1; j++) {

                if (values[j] > values[j + 1]) {
                    swap(values, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return values;
    }
}
