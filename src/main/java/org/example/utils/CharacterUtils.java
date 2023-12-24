package org.example.utils;

import java.util.HashMap;
import java.util.Map;

public class CharacterUtils {

    private static final Integer NUMBER_OF_CHARACTERS = 26;

    /**
     * Returns a map of character frequencies of the given string str
     *
     * @param str Given String
     * @return map of character frequency
     */
    public static Map<Character, Integer> getCharCountMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            map.computeIfPresent(ch, (k, v) -> v + 1);
            map.putIfAbsent(ch, 1);
        }
        return map;
    }

    /**
     * Returns an array of character frequencies of the given string
     *
     * @param str    Given String
     * @param offset i.e. for a_z -> (int) 'a'; or for A_Z -> (int) 'A'
     * @return character counts array
     */
    public static int[] getCharCount(String str, int offset) {
        int[] charCount = new int[NUMBER_OF_CHARACTERS];
        for (char ch : str.toCharArray()) {
            int position = ch - offset;
            charCount[position]++;
        }
        return charCount;
    }
}
