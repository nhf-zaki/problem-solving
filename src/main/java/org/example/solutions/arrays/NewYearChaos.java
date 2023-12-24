package org.example.solutions.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NewYearChaos {
    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */
    public static void minimumBribes(List<Integer> q) {
        int totalBribes = 0;
        int p1 = 1;
        int p2 = 2;
        int p3 = 3;
        for (Integer value : q) {
            if (value == p1) {
                p1 = p2;
                p2 = p3;
                p3++;
            } else if (value == p2) {
                totalBribes++;
                p2 = p3;
                p3++;
            } else if (value == p3) {
                totalBribes += 2;
                p3++;
            } else {
                System.out.println("Too chaotic");
                return;
            }
        }
        System.out.println(totalBribes);
    }
}
