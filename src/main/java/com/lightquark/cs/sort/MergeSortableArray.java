package com.lightquark.cs.sort;

/**
 * Merge Sort
 * Divide input array in two halves, call itself for the two halves and then merge the two sorted halves.
 *
 * Time Complexity: O(n*Logn)
 * Auxiliary Space: O(n)
 * Sorting In Place: No
 * Stable: Yes
 *
 * TODO: implement for Linked list ???
 */
public class MergeSortableArray extends AbstractSortableArray {

    @Override
    protected int[] internalSort(int[] values) {
        sort(values, 0, values.length - 1);
        return values;
    }

    private void sort(int[] values, int left, int right) {

        if (left < right) {
            int middle = (left + right) / 2;

            sort(values, left, middle);
            sort(values, middle + 1, right);

            merge(values, left, middle, right);
        }
    }

    private void merge(int[] values, int left, int middle, int right) {
        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = values[left + i];
        }
        for (int i = 0; i < rightSize; i++) {
            rightArray[i] = values[middle + 1 + i];
        }

        int valuesIndex = left;
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (leftArray[leftIndex] < rightArray[rightIndex]) {
                values[valuesIndex] = leftArray[leftIndex];
                valuesIndex++;
                leftIndex++;
            } else {
                values[valuesIndex] = rightArray[rightIndex];
                valuesIndex++;
                rightIndex++;
            }
        }

        while (leftIndex < leftSize) {
            values[valuesIndex] = leftArray[leftIndex];
            valuesIndex++;
            leftIndex++;
        }

        while (rightIndex < rightSize) {
            values[valuesIndex] = rightArray[rightIndex];
            valuesIndex++;
            rightIndex++;
        }
    }
}
