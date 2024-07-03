package org.example;

import java.util.HashMap;
import java.util.Map;

public class PairRooks {

    private  int countBeatingRooks(int[][] rookcoords) {
        Map<Integer, Integer> rooksInRow = new HashMap<>();
        Map<Integer, Integer> rooksInCol = new HashMap<>();
        for (int[] coord : rookcoords) {
            rooksInRow.put(coord[0], rooksInRow.getOrDefault(coord[0], 0) + 1);
            rooksInCol.put(coord[1], rooksInCol.getOrDefault(coord[1], 0) + 1);
        }
        int sum = 0;
        for (Integer value : rooksInCol.values()) {
            sum += value - 1;
        }
        for (Integer value : rooksInRow.values()) {
            sum += value - 1;
        }
        return sum;
    }

}
