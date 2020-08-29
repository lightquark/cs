package com.lightquark.cs.sort;

/**
 * Insertion Sort
 *
 * Time Complexity: O(n*2)
 * Auxiliary Space: O(1)
 * Boundary Cases: Insertion com.lightquark.cs.sort takes maximum time to com.lightquark.cs.sort if elements are sorted in reverse order. And it takes minimum time (Order of n) when elements are already sorted.
 * Sorting In Place: Yes
 * Stable: Yes
 *
 * Possible improvements: use binary search to determine the position of shift
 *
 * TODO: implement for Linked list
 */
public class InsertionSortableArray extends AbstractSortableArray {

    public InsertionSortableArray(int[] values) {
        super(values);
    }

    @Override
    public void sort() {

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
    }
}
