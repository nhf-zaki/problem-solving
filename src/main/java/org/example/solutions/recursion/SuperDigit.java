package org.example.solutions.recursion;

public class SuperDigit {

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */
    public static int superDigit(String n, int k) {
        if (n.length() == 1) {
            return Integer.parseInt(n);
        }

        long sum = getSum(n) * k;

        return superDigit("" + sum, 1);
    }

    private static long getSum(String n) {
        long sum = 0;
        for (char digitChar : n.toCharArray()) {
            sum += Character.getNumericValue(digitChar);
        }
        return sum;
    }
}
