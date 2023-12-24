package org.example.utils.algorithms;

public class LongestCommonSubsequenceUtils {

    /**
     * Find Longest Common Subsequence (LCS)
     * Recursive - top-down approach
     * time complexity - O(2^(m+n))
     * space complexity - O(m+n)
     *
     * @param arr1     character array of a string
     * @param arr2     character array of another string
     * @param sizeArr1 size of arr1 (m)
     * @param sizeArr2 size of arr2 (n)
     * @return LCS
     */
    public static int lcsRecursive(char[] arr1, char[] arr2, int sizeArr1, int sizeArr2) {
        if (sizeArr1 <= 0 || sizeArr2 <= 0) {
            return 0;
        }
        if (arr1[sizeArr1 - 1] == arr2[sizeArr2 - 1]) {
            return 1 + lcsRecursive(arr1, arr2, sizeArr1 - 1, sizeArr2 - 1);
        } else {
            return Math.max(lcsRecursive(arr1, arr2, sizeArr1, sizeArr2 - 1), lcsRecursive(arr1, arr2, sizeArr1 - 1, sizeArr2));
        }
    }

    /**
     * Find Longest Common Subsequence (LCS)
     * Recursive - with memoization, to skip the operations for already computed result
     *
     * @param arr1     character array of a string
     * @param arr2     character array of another string
     * @param sizeArr1 size of arr1
     * @param sizeArr2 size of arr2
     * @param memo     memoization storage
     * @return LCS
     */
    public static int lcsWithMemo(char[] arr1, char[] arr2, int sizeArr1, int sizeArr2, Integer[][] memo) {
        if (sizeArr1 <= 0 || sizeArr2 <= 0) {
            return 0;
        }
        if (memo[sizeArr1][sizeArr2] != null) {
            return memo[sizeArr1][sizeArr2];
        }
        if (arr1[sizeArr1 - 1] == arr2[sizeArr2 - 1]) {
            return 1 + lcsWithMemo(arr1, arr2, sizeArr1 - 1, sizeArr2 - 1, memo);
        } else {
            return memo[sizeArr1][sizeArr2] = Math.max(
                    lcsWithMemo(arr1, arr2, sizeArr1, sizeArr2 - 1, memo),
                    lcsWithMemo(arr1, arr2, sizeArr1 - 1, sizeArr2, memo));
        }
    }

    /**
     * Find Longest Common Subsequence (LCS)
     * DP - Bottom-up approach
     * in polynomial time, but more space
     * time complexity - O(m*n)
     * space complexity - O(m*n)
     *
     * @param arr1 character array of a string
     * @param arr2 character array of another string
     *             m size of arr1
     *             n size of arr2
     * @return LCS
     */
    public static int lcsDynamicProgramming(char[] arr1, char[] arr2) {
        // memoization storage for resultant values
        int[][] memo = new int[arr1.length + 1][arr2.length + 1];

        for (int row = 1; row <= arr1.length; row++) {
            for (int col = 1; col <= arr2.length; col++) {
                if (row == 0 || col == 0) {
                    memo[row][col] = 0;
                } else if (arr1[row - 1] == arr2[col - 1]) {
                    memo[row][col] = 1 + memo[row - 1][col - 1];
                } else {
                    memo[row][col] = Math.max(memo[row - 1][col], memo[row][col - 1]);
                }
            }
        }
        return memo[arr1.length][arr2.length];
    }

    /**
     * Find Longest Common Subsequence (LCS)
     * DP - Bottom-up approach
     * in polynomial time
     * time complexity - O(m*n)
     * space complexity - O(n)
     *
     * @param arr1 character array of a string
     * @param arr2 character array of another string
     *             m size of arr1
     *             n size of arr2
     * @return LCS
     */
    public static int lcsEfficient(char[] arr1, char[] arr2) {
        // memoization storage for resultant values
        int[] memo = new int[arr2.length + 1];

        for (int row = 1; row <= arr1.length; row++) {
            int prev = 0;
            for (int col = 1; col <= arr2.length; col++) {
                int temp = memo[col];
                if (arr1[row - 1] == arr2[col - 1]) {
                    memo[col] = prev + 1;
                } else {
                    memo[col] = Math.max(memo[col], memo[col - 1]);
                }
                prev = temp;
            }
        }
        return memo[arr2.length];
    }
}
