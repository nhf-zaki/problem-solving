package org.example.solutions.recursion;

public class DavisStaircase {

    /*
     * Complete the 'stepPerms' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */
    public static int stepPerms(int n) {
        int[] perms = {1, 2, 4};

        if (n < 1) {
            return 0;
        } else if (n < 4) {
            return perms[n - 1];
        }

        for (int i = 4; i <= n; i++) {
            swapValues(perms);
        }

        return perms[2];
    }

    private static void swapValues(int[] perms) {
        int temp = perms[2] + perms[1] + perms[0];
        perms[0] = perms[1];
        perms[1] = perms[2];
        perms[2] = temp;
    }
}
