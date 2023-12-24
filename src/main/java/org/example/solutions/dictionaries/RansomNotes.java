package org.example.solutions.dictionaries;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RansomNotes {

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */
    public static void checkMagazine(List<String> magazine, List<String> note) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : magazine) {
            map.computeIfPresent(word, (k, v) -> v + 1);
            map.putIfAbsent(word, 1);
        }
        for (String wordInNote : note) {
            if (!map.containsKey(wordInNote) || map.get(wordInNote) == 0) {
                System.out.println("No");
                return;
            }
            map.computeIfPresent(wordInNote, (k, v) -> v - 1);
        }
        System.out.println("Yes");
    }
}
