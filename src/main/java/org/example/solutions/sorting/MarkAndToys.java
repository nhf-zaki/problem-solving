package org.example.solutions.sorting;

import java.util.Collections;
import java.util.List;

public class MarkAndToys {

    /*
     * Complete the 'maximumToys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY prices
     *  2. INTEGER k, the budget
     */
    public static int maximumToys(List<Integer> prices, int budget) {
        int numOfPurchase = 0;
        Collections.sort(prices);
        for (Integer toyPrice : prices) {
            if (toyPrice <= budget) {
                numOfPurchase++;
                budget -= toyPrice;
            }
        }
        return numOfPurchase;
    }
}
