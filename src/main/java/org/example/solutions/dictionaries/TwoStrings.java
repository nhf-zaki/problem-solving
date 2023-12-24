package org.example.solutions.dictionaries;

import java.util.HashMap;
import java.util.Map;

public class TwoStrings {

    /*
     * Complete the 'twoStrings' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */
    public static String twoStrings(String s1, String s2) {
        Map<Character, Integer> charFreq = new HashMap<>();
        for (int i = 0; i < s1.length() / 2; i++) {
            char currentChar = s1.charAt(i);
            insertChar(charFreq, currentChar);

            char charFromReverse = s1.charAt(s1.length() - i - 1);
            insertChar(charFreq, charFromReverse);
        }
        for (int i = 0; i < s2.length() / 2; i++) {
            if (isMatched(s2, charFreq, i)) {
                return "YES";
            }
        }
        return "NO";
    }

    private static boolean isMatched(String s2, Map<Character, Integer> charFreq, int i) {
        return charFreq.containsKey(s2.charAt(i)) || charFreq.containsKey(s2.charAt(s2.length() - i - 1));
    }

    private static void insertChar(Map<Character, Integer> charFreq, char currentChar) {
        charFreq.computeIfPresent(currentChar, (k, v) -> v + 1);
        charFreq.putIfAbsent(currentChar, 1);
    }
}
