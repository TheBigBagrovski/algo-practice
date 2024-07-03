package org.example.leetcode;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, return the Hamming distance between them.
 * РЕШЕНИЕ:
 * Integer.bitCount - считает единичные биты в числе
 * количество 1 по максимум - количество общих единиц = расстояние хэмминга
 */
public class LC461 {

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }

    public static int hammingDistance(int x, int y) {
        return Integer.bitCount((x | y) - (x & y));
    }

}
