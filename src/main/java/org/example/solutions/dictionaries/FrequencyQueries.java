package org.example.solutions.dictionaries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyQueries {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Long>> queries) {

        Map<Long, Long> valuesCountMap = new HashMap<>();
        Map<Long, Long> frequencyMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (List<Long> query : queries) {
            Long operationType = query.get(0);
            Long givenNumber = query.get(1);
            if (operationType == 1L) { // insert operation
                insert(valuesCountMap, givenNumber, frequencyMap);
            } else if (operationType == 2L) { // delete operation
                delete(valuesCountMap, givenNumber, frequencyMap);
            } else if (operationType == 3L) { // search for the given value and add 1 if exists, otherwise 0
                searchFrequency(frequencyMap, givenNumber, result);
            }
        }

        return result;
    }

    private static void searchFrequency(Map<Long, Long> frequencyMap, Long givenNumber, List<Integer> result) {
        Long freqMapValue = frequencyMap.get(givenNumber);
        if (freqMapValue != null && freqMapValue > 0) {
            result.add(1);
        } else {
            result.add(0);
        }
    }

    private static void delete(Map<Long, Long> valuesCountMap, Long givenNumber, Map<Long, Long> frequencyMap) {
        Long prevValue = valuesCountMap.get(givenNumber);
        if (prevValue != null && prevValue > 0) {
            Long updatedValue = prevValue - 1;
            valuesCountMap.put(givenNumber, updatedValue);
            decrementFreq(frequencyMap, prevValue);
            incrementFreq(frequencyMap, updatedValue);
        }
    }

    private static void insert(Map<Long, Long> valuesCountMap, Long givenNumber, Map<Long, Long> frequencyMap) {
        Long prevValue = valuesCountMap.get(givenNumber);
        if (prevValue != null) {
            Long updatedValue = prevValue + 1;
            valuesCountMap.replace(givenNumber, updatedValue);
            decrementFreq(frequencyMap, prevValue);
            incrementFreq(frequencyMap, updatedValue);
        } else {
            valuesCountMap.put(givenNumber, 1L);
            incrementFreq(frequencyMap, 1L);
        }
    }

    private static void incrementFreq(Map<Long, Long> map, Long key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1L);
        }
    }

    private static void decrementFreq(Map<Long, Long> map, Long key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) - 1);
        }
    }
}
