package org.example.solutions.stringmanipulations;

public class SpecialStringAgain {

    // Complete the substrCount function below.
    public static long substrCount(int n, String s) {
        long count = 0;
        for (int left = 0; left < n; left++) {
            count++;
            for (int right = left + 1; right < n; right++) {
                if (s.charAt(left) != s.charAt(right)) { // aabaa
                    if (isAllOthersAreSame(n, s, right, left)) {
                        count++;
                    }
                    break;
                } else {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isAllOthersAreSame(int n, String s, int right, int left) {
        int bound = 2 * right - left;
        return bound < n && s.substring(left, right).equals(s.substring(right + 1, bound + 1));
    }
}
