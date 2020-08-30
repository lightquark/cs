package com.lightquark.cs.sort;

/**
 * Shell Sort
 * The method starts by sorting pairs of elements far apart from each other,
 * then progressively reducing the gap between elements to be compared.
 *
 * Time Complexity: O(n*2)
 * Auxiliary Space: O(1)
 * Sorting In Place: Yes
 * Stable: No
 */
public class ShellSortableArray extends AbstractSortableArray {

    @Override
    protected int[] internalSort(int[] values) {
        int size = values.length;

        for (int gap = size / 2; gap > 0; gap = gap / 2) {

            for (int i = gap; i < size; i++) {

                int tmp = values[i];
                int j = i;
                while (j >= gap && values[j - gap] > tmp) {
                    values[j] = values[j - gap];
                    j -= gap;
                }
                values[j] = tmp;
            }
        }
        return values;
    }
}
