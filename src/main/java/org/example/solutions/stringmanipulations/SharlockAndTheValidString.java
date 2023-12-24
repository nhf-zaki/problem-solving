package org.example.solutions.stringmanipulations;

import org.example.utils.CharacterUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SharlockAndTheValidString {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    public static String isValid(String s) {
        return isValidString(s) ? "YES" : "NO";
    }

    private static boolean isValidString(String s) {
        Collection<Integer> frequencyMapValues = CharacterUtils.getCharCountMap(s).values();
        Set<Integer> uniqueFreqs = new HashSet<>(frequencyMapValues);

        // same freq for all
        if (uniqueFreqs.size() == 1) {
            return true;
        }
        // more than 2 freq
        if (uniqueFreqs.size() > 2) {
            return false;
        }

        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int freq : uniqueFreqs) {
            max = Math.max(freq, max);
            min = Math.min(freq, min);
        }
        if (isOnlyOneCharAppearsOnce(frequencyMapValues, min)) {
            return true;
        } else {
            return !isMultipleCharRemovalRequired(frequencyMapValues, max, min);
        }
    }

    private static boolean isOnlyOneCharAppearsOnce(Collection<Integer> frequencyMapValues, int min) {
        return min == 1 && frequencyMapValues.stream().filter(val -> val == min).count() == 1;
    }

    private static boolean isMultipleCharRemovalRequired(Collection<Integer> frequencyMapValues, int max, int min) {
        return frequencyMapValues.stream().filter(val -> val == max).count() > 1 || max - min > 1;
    }
}
