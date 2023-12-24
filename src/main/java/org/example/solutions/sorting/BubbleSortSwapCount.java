package org.example.solutions.sorting;

import java.util.Collections;
import java.util.List;

public class BubbleSortSwapCount {

    /*
     * Complete the 'countSwaps' function below.
     *
     * The function accepts INTEGER_ARRAY a as parameter.
     */
    public static void countSwaps(List<Integer> a) {
        long numSwaps = 0L;
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.size() - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a.get(j) > a.get(j + 1)) {
                    Collections.swap(a, j, j + 1);
                    numSwaps++;
                }
            }
        }
        System.out.println("Array is sorted in " + numSwaps + " swaps.");
        System.out.println("First Element: " + a.get(0));
        System.out.println("Last Element: " + a.get(a.size() - 1));
    }
}
