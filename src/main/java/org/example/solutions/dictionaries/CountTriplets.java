package org.example.solutions.dictionaries;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {


    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        // two maps needed to look over
        // maps to keeping track for all the pairings of the common ratio

        Map<Long, Long> secondNumberMap = new HashMap<>();
        Map<Long, Long> thirdNumberMap = new HashMap<>();
        long tripletsCount = 0;

        for (Long currentValue : arr) { // 100000 1 all 1237 correct_ans: 166661666700000, my_ans: 18644208777952
            if (thirdNumberMap.containsKey(currentValue)) {
                tripletsCount += thirdNumberMap.get(currentValue);
            }
            if (secondNumberMap.containsKey(currentValue)) {
                Long valueFromSecondNumberMap = secondNumberMap.get(currentValue);
                thirdNumberMap.computeIfPresent(currentValue * r, (k, v) -> v + valueFromSecondNumberMap);
                thirdNumberMap.putIfAbsent(currentValue * r, valueFromSecondNumberMap);
            }
            secondNumberMap.putIfAbsent(currentValue * r, 0L);
            secondNumberMap.computeIfPresent(currentValue * r, (k, v) -> v + 1);
        }

        return tripletsCount;
    }
}
