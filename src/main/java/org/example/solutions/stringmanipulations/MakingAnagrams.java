package org.example.solutions.stringmanipulations;

import org.example.utils.CharacterUtils;

public class MakingAnagrams {

    private static final Integer NUMBER_OF_CHARACTERS = 26;

    /*
     * Complete the 'makeAnagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */
    public static int makeAnagram(String a, String b) {
        char offset = 'a';
        int[] aFrequencies = CharacterUtils.getCharCount(a, offset);
        int[] bFrequencies = CharacterUtils.getCharCount(b, offset);

        return getDelta(aFrequencies, bFrequencies);
    }

    private static int getDelta(int[] array1, int[] array2) {
        int delta = 0;
        for (int i = 0; i < NUMBER_OF_CHARACTERS; i++) {
            int difference = Math.abs(array1[i] - array2[i]);
            delta += difference;
        }
        return delta;
    }
}
