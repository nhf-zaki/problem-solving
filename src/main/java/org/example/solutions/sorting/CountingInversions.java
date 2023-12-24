package org.example.solutions.sorting;

import java.util.List;

public class CountingInversions {

    /*
     * Complete the 'countInversions' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static long countInversions(List<Integer> arr) {
        return mergeSort(arr.stream().mapToInt(Integer::intValue).toArray(), new int[arr.size()], 0, arr.size() - 1);
    }

    private static long mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd) {
        long count = 0;
        if (leftStart >= rightEnd) {
            return count;
        }
        int mid = (leftStart + rightEnd) / 2;
        count += mergeSort(arr, temp, leftStart, mid);
        count += mergeSort(arr, temp, mid + 1, rightEnd);
        count += mergeHalves(arr, temp, leftStart, rightEnd);
        return count;
    }

    private static long mergeHalves(int[] arr, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        long count = 0;
        while (left <= leftEnd && right <= rightEnd) {
            if (arr[left] <= arr[right]) {
                temp[index] = arr[left];
                left++;
            } else { // right is smaller
                temp[index] = arr[right];
                count += leftEnd - left + 1;
                right++;
            }
            index++;
        }
        System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
        System.arraycopy(arr, right, temp, index, rightEnd - right + 1);

        System.arraycopy(temp, leftStart, arr, leftStart, size);

        return count;
    }
}
