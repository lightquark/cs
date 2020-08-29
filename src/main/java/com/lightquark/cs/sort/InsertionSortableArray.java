package com.lightquark.cs.sort;

/**
 * Insertion Sort
 * The array is virtually split into a sorted and an unsorted part.
 * Values from the unsorted part are picked and placed at the correct position in the sorted part.
 *
 * Worst and Average Case Time Complexity: O(n*2). Worst case occurs when array is reverse sorted.
 * Best Case Time Complexity: O(n). Best case occurs when array is already sorted.
 * Auxiliary Space: O(1)
 * Sorting In Place: Yes
 * Stable: Yes
 *
 * Possible improvements: use binary search to determine the position of shift
 *
 * TODO: implement for Linked list
 */
public class InsertionSortableArray extends AbstractSortableArray {

    @Override
    protected int[] internalSort(int[] values) {
        int size = values.length;
        for (int i = 1; i < size; i++) {

            if (values[i - 1] > values[i]) {

                int tmp = values[i];
                int j = i - 1;
                while (j >= 0 && values[j] > tmp) {
                    values[j + 1] = values[j];
                    j--;
                }
                values[j + 1] = tmp;
            }
        }
        return values;
    }
}
