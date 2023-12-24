package org.example.solutions.arrays;

import java.util.List;

public class DS2DArray {
    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */
    public static int hourglassSum(List<List<Integer>> arr) {
        int max = Integer.MIN_VALUE;
        for (int row = 1; row < 5; row++) {
            int sum = 0;
            for (int col = 1; col < 5; col++) {
                sum = arr.get(row).get(col);
                sum += getSumOfRow(arr, row - 1, col);
                sum += getSumOfRow(arr, row + 1, col);

                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    private static int getSumOfRow(List<List<Integer>> arr, int row, int col) {
        return arr.get(row).get(col - 1) + arr.get(row).get(col) + arr.get(row).get(col + 1);
    }
}
