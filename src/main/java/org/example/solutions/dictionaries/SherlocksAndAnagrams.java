package org.example.solutions.dictionaries;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlocksAndAnagrams {

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
    public static int sherlockAndAnagrams(String s) {
        Map<String, Integer> subStringsMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                char[] subChar = s.substring(i, j).toCharArray();
                Arrays.sort(subChar);
                computeSubstringFreq(new String(subChar), subStringsMap);
            }
        }
        return getSubstringCount(subStringsMap);
    }

    private static int getSubstringCount(Map<String, Integer> subStringsMap) {
        int count = 0;
        for (int val : subStringsMap.values()) {
            if (val > 1) {
                count += (val * (val - 1) / 2);
            }
        }
        return count;
    }

    private static void computeSubstringFreq(String subString, Map<String, Integer> subStringsMap) {
        subStringsMap.computeIfPresent(subString, (k, v) -> v + 1);
        subStringsMap.putIfAbsent(subString, 1);
    }
}
