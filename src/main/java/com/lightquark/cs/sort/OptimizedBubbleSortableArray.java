package com.lightquark.cs.sort;

public class OptimizedBubbleSortableArray extends AbstractSortableArray {

    public OptimizedBubbleSortableArray(int[] values) {
        super(values);
    }

    @Override
    public void sort() {

        boolean swapped;
        int size = values.length;
        for (int i = 0; i < size - 1; i++) {
            swapped = false;
            for (int j = 0; j < size - i - 1; j++) {

                if (values[j] > values[j + 1]) {
                    swap(j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
