package org.example.solutions.stringmanipulations;

import org.example.utils.algorithms.LongestCommonSubsequenceUtils;

public class CommonChild {

    /*
     * Complete the 'commonChild' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */
    public static int commonChild(String s1, String s2) {
        return LongestCommonSubsequenceUtils.lcsEfficient(s1.toCharArray(), s2.toCharArray());
    }
}
