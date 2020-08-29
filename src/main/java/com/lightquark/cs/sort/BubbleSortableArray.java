package com.lightquark.cs.sort;

/**
 * Bubble Sort
 *
 * Worst and Average Case Time Complexity: O(n*n). Worst case occurs when array is reverse sorted.
 * Best Case Time Complexity: O(n). Best case occurs when array is already sorted.
 * Auxiliary Space: O(1)
 * Boundary Cases: Bubble com.lightquark.cs.sort takes minimum time (Order of n) when elements are already sorted.
 * Sorting In Place: Yes
 * Stable: Yes
 */
public class BubbleSortableArray extends AbstractSortableArray {

    public BubbleSortableArray(int[] values) {
        super(values);
    }

    @Override
    public void sort() {

        int size = values.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {

                if (values[j] > values[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
    }
}
