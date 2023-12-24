package org.example.utils;

import java.util.HashMap;
import java.util.Map;

public class StringUtils {

    /**
     * Returns a map of all possible substrings with their frequency
     *
     * @param str Given string
     * @return Map<Substring, Frequency>
     */
    public static Map<String, Integer> getAllSubstringCombinations(String str) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String subString = str.substring(i, j);
                map.computeIfPresent(subString, (k, v) -> v + 1);
                map.putIfAbsent(subString, 1);
            }
        }
        return map;
    }
}
