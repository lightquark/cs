package com.lightquark.cs.sort;

/**
 * Comb Sort
 * Comb Sort improves on Bubble Sort by using gap of size more than 1.
 * The gap starts with a large value and shrinks by a factor of 1.3 in every iteration until it reaches the value 1.
 *
 * Worst Case Time Complexity: O(n^2).
 * Best Case Time Complexity: O(n).
 * Auxiliary Space: O(1)
 * Sorting In Place: Yes
 * Stable: Yes
 */
public class CombSortableArray extends AbstractSortableArray {

    private static final float SHRINK_FACTOR = 1.3f;

    @Override
    protected int[] internalSort(int[] values) {
        int size = values.length;

        int gap = size;
        boolean swapped = true;

        while (gap > 1 || swapped) {

            gap = (int) Math.round(Math.floor(gap / SHRINK_FACTOR));

            swapped = false;
            for (int i = 0; i < size - gap; i++) {
                if (values[i] > values[i + gap]) {
                    swap(values, i, i + gap);
                    swapped = true;
                }
            }
        }
        return values;
    }
}
