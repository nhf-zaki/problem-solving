package org.example.solutions.arrays;

import java.util.List;

public class ArrayManipulation {
    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */
    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        long[] result = new long[n];

        for (List<Integer> query : queries) {
            int start = query.get(0) - 1;
            int end = query.get(1) - 1;
            int add = query.get(2);
            result[start] += add;
            if (end + 1 < n) {
                result[end + 1] -= add;
            }
        }

        return findMax(n, result);
    }

    private static long findMax(int n, long[] result) {
        long max = Long.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            result[i] += result[i - 1];
            max = Math.max(result[i], max);
        }
        return max;
    }
}
