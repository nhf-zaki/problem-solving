package org.example.solutions.stringmanipulations;

public class AlternatingCharacters {
    /*
     * Complete the 'alternatingCharacters' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
    public static int alternatingCharacters(String s) {
        int minDeletions = 0;
        char prevValidChar = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            if (prevValidChar == s.charAt(i)) {
                minDeletions++;
            } else {
                prevValidChar = s.charAt(i);
            }
        }

        return minDeletions;
    }
}
