package org.example.solutions.arrays;

public class MinimumSwaps2 {

    static int minimumSwaps(int[] arr) {
        int swapCount = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            while (arr[i] != i + 1) {
                swap(arr, i);
                swapCount++;
            }
        }
        return swapCount;
    }

    private static void swap(int[] arr, int i) {
        int value = arr[i];
        arr[i] = arr[value - 1];
        arr[value - 1] = value;
    }
}
