package org.example.solutions.sorting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FraudulentActivityNotifications {

    /*
     * Complete the 'activityNotifications' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY expenditure
     *  2. INTEGER d
     */
    public static int activityNotifications(List<Integer> expenditure, int d) {
        Map<Integer, Integer> numberFrequency = new HashMap<>();
        int notifications = 0;
        for (int i = 0; i < expenditure.size(); i++) {
            while (i < d) {
                increaseFreq(expenditure.get(i), numberFrequency);
                i++;
            }
            if (expenditure.get(i) >= findMedianCoefficient(numberFrequency, d)) {
                notifications++;
            }
            updateNumberFreq(numberFrequency, expenditure.get(i - d), expenditure.get(i));
        }
        return notifications;
    }

    private static int findMedianCoefficient(Map<Integer, Integer> noFreq, int d) {
        int median1 = -1;
        int median2 = -1;
        int lookbackMid1 = d / 2;
        int lookbackMid2 = d / 2 + 1;
        int counter = 0;

        for (Map.Entry<Integer, Integer> entry : noFreq.entrySet()) {
            counter += entry.getValue();
            if (counter >= lookbackMid1 && median1 == -1) {
                median1 = entry.getKey();
            }
            if (counter >= lookbackMid2) {
                median2 = entry.getKey();
                break;
            }
        }

        return d % 2 == 0 ? median1 + median2 : 2 * median2;
    }

    private static void increaseFreq(int key, Map<Integer, Integer> numberFrequency) {
        numberFrequency.computeIfPresent(key, (k, v) -> v + 1);
        numberFrequency.putIfAbsent(key, 1);
    }

    private static void decreaseFreq(int key, Map<Integer, Integer> numberFrequency) {
        numberFrequency.computeIfPresent(key, (k, v) -> v - 1);
    }

    private static void updateNumberFreq(Map<Integer, Integer> numberFrequency, int removedValue, int addedValue) {
        decreaseFreq(removedValue, numberFrequency);
        increaseFreq(addedValue, numberFrequency);
    }
}
