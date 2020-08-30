package com.lightquark.cs.sort;

import lombok.Getter;
import lombok.Setter;

/**
 * Bucket Sort
 * Distribute the elements into a number of buckets. Each bucket is then sorted individually.
 * At the end, sorted values from the buckets are concatenated into the one array.
 *
 * Worst and Average Case Time Complexity: O(n*2). Occurs when all the elements are placed in a single bucket.
 * Average Case Time Complexity: O(n + n^2/k + k).
 * Best Case Time Complexity: O(n). Occurs when k is equal to n, and input array has a uniformly distributed values.
 * Auxiliary Space: O(n*k) in the worst case
 * Sorting In Place: Yes
 * Stable: No
 */
public class BucketSortableArray extends AbstractSortableArray {

    private static final int BUCKETS = 10;

    @Override
    protected int[] internalSort(int[] values) {
        int size = values.length;

        // determine the Maximum value from the input array
        // we expect that there is at least one positive value
        int maxValue = 1;
        for (int i = 0; i < size; i++) {
            if (maxValue < values[i]) {
                maxValue = values[i];
            }
        }

        Bucket[] buckets = new Bucket[BUCKETS];
        for (int i = 0; i < BUCKETS; i++) {
            buckets[i] = new Bucket();
        }

        // distribute values into buckets
        for (int i = 0; i < size; i++) {
            int bucketIndex = ((values[i] * BUCKETS) / maxValue) - 1;

            // zero and non-positive values will be added into the first bucket.
            if (bucketIndex < 0) {
                bucketIndex = 0;
            }

            buckets[bucketIndex].addValue(values[i]);
        }

        // sort buckets and concatenate the sorted values
        int k = 0;
        InsertionSortableArray sortMethod = new InsertionSortableArray();
        for (int i = 0; i < BUCKETS; i++) {
            Bucket bucket = buckets[i];
            bucket.array = sortMethod.sort(bucket.array);

            for (int j = 0; j < bucket.currentSize; j++) {
                values[k] = bucket.array[j];
                k++;
            }
        }

        return values;
    }

    @Getter
    @Setter
    private static class Bucket {

        private static final int DEFAULT_BUCKET_SIZE = 0;

        private int[] array = new int[DEFAULT_BUCKET_SIZE];
        private int currentSize = 0;

        private void addValue(int value) {
            if (currentSize < array.length) {
                array[currentSize] = value;
            } else {
                //double the size of the inner array
                int[] newArray = new int[array.length + 1];
                System.arraycopy(array, 0, newArray, 0, array.length);
                array = newArray;

                array[currentSize] = value;
            }
            currentSize++;
        }
    }
}
