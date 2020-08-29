package com.lightquark.cs.sort;

/**
 * Quick Sort
 * Pick an element as pivot and partition the given array around the picked pivot.
 * Partition function should put pivot at its correct position in sorted array
 * and put all smaller elements before pivot, and put all greater elements after pivot.
 *
 * Worst Case Time Complexity: O(n^2). Best case occurs when array is already sorted.
 * Average Case Time Complexity: O(n*Logn). Best case occurs when array is already sorted.
 * Best Case Time Complexity: O(n*Logn). Best case occurs when array is already sorted.
 * Auxiliary Space: O(1)
 * Sorting In Place: Yes
 * Stable: No
 */
public class QuickSortableArray extends AbstractSortableArray {

    @Override
    protected int[] internalSort(int[] values) {
        sort(values, 0, values.length - 1);
        return values;
    }

    private void sort(int[] values, int left, int right) {

        if (left < right) {
            int pivotIndex = partition(values, left, right);

            sort(values, left, pivotIndex - 1);
            sort(values, pivotIndex + 1, right);
        }
    }

    private int partition(int[] values, int left, int right) {

        int pivot = values[right];

        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (values[j] < pivot) {
                i++;
                swap(values, i, j);
            }
        }

        i++;
        swap(values, i, right);

        return i;
    }
}
