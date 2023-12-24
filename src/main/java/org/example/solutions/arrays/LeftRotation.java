package org.example.solutions.arrays;

import java.util.ArrayList;
import java.util.List;

public class LeftRotation {

    /*
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a: the array to rotate
     *  2. INTEGER d: the number of rotations
     */
    public static List<Integer> rotLeft(List<Integer> a, int d) {

        if (a.size() == d) {
            return a;
        }
        List<Integer> result = new ArrayList<>(a.size());
        result.addAll(a.subList(d, a.size()));
        result.addAll(a.subList(0, d));

        return result;
    }
}
