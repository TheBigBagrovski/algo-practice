package org.example.leetcode.math;

import java.util.HashMap;

/**
 * You are given an integer array deck where deck[i] represents the number written on the ith card.
 * <p>
 * Partition the cards into one or more groups such that:
 * <p>
 * Each group has exactly x cards where x > 1, and
 * All the cards in one group have the same integer written on them.
 * Return true if such partition is possible, or false otherwise.
 */
public class CR914 {

    public boolean hasGroupsSizeX(int[] deck) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < deck.length; i++) {
            map.put(deck[i], map.getOrDefault(deck[i], 0) + 1);
        }

        int ans = 0;

        for (int key : map.keySet()) {

            ans = gcd(ans, map.get(key));
        }

        return ans >= 2 ? true : false;


    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
