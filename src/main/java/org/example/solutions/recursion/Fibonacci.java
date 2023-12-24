package org.example.solutions.recursion;

public class Fibonacci {

    /**
     * Recursive approach
     * easy to read, but compute same result multiple times
     *
     * @param n
     * @return
     */
    public static int fiboRecursive(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fiboRecursive(n - 1) + fiboRecursive(n - 2);
        }
    }

    /**
     * Iterative approach with Memoization
     * better solution, store only the last two results
     *
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        int[] fiboStorage = {0, 1};

        for (int i = 2; i <= n; i++) {
            int temp = fiboStorage[1] + fiboStorage[0];
            fiboStorage[0] = fiboStorage[1];
            fiboStorage[1] = temp;
        }

        return fiboStorage[1];
    }
}
