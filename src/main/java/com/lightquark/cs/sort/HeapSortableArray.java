package com.lightquark.cs.sort;

/**
 * Heap Sort
 * Build a max heap from the input data.
 * Then repeatedly replace the root of the heap with the last item of heap followed by reducing the size of heap by 1.
 * Finally, heapify the root of the heap.
 *
 * Time Complexity: O(n*Logn)
 * Auxiliary Space: O(1)
 * Sorting In Place: Yes
 * Stable: No
 */
public class HeapSortableArray extends AbstractSortableArray {

    @Override
    protected int[] internalSort(int[] values) {
        int size = values.length;

        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(values, size, i);
        }

        for (int i = size - 1; i > 0; i--) {
            swap(values, 0, i);
            heapify(values, i, 0);
        }
        return values;
    }

    private void heapify(int[] values, int size, int i) {
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && values[left] > values[max]) {
            max = left;
        }

        if (right < size && values[right] > values[max]) {
            max = right;
        }

        if (max != i) {
            swap(values, i, max);
            heapify(values, size, max);
        }
    }
}
