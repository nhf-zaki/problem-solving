package org.example.solutions.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SortingComparator {
    static class Player {
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    static class Checker implements Comparator<Player> {
        public int compare(Player p1, Player p2) {
            if (p1.score < p2.score) {
                return 1;
            } else if (p1.score > p2.score) {
                return -1;
            } else {
                return p1.name.compareTo(p2.name);
            }
        }
    }

    public static class Solution {

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();

            Player[] players = new Player[n];
            Checker checker = new Checker();

            for (int i = 0; i < n; i++) {
                players[i] = new Player(scan.next(), scan.nextInt());
            }
            scan.close();

            Arrays.sort(players, checker);
            for (Player player : players) {
                System.out.printf("%s %s\n", player.name, player.score);
            }
        }
    }
}
