package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.
 *
 * Return the intersection of these two interval lists.
 *
 * A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
 *
 * The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].
 * РЕШЕНИЕ:
 * идем по спискам интерваов синхронно, формируем результирующий
 * для нового отрезка - старт в большем из 2 стартов
 * конец - в меньшем из концов
 * если старт меньше конца - корректный отрезок, иначе [1,2] и [3,4]
 * апаем счетчик из того списка, чей интервал окончился раньше
 */
public class LC986 {

    public static void main(String[] args) {
        int[][] firstList = new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] secondList = new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        System.out.println(Arrays.deepToString(solve(firstList, secondList)));
        secondList = new int[0][0];
        System.out.println(Arrays.deepToString(solve(firstList, secondList)));
    }

    public static int[][] solve(int[][] firstList, int[][] secondList) { // O(n+m)
        List<int[]> result = new ArrayList<>();
        int i = 0; // pointer for firstList
        int j = 0; // pointer for secondList
        while (i < firstList.length && j < secondList.length) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            if (start <= end) {
                result.add(new int[]{start, end});
            }
            // Move the pointer of the list with the interval that ends first
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return result.toArray(new int[0][0]);
    }

    public static int[][] shit(int[][] firstList, int[][] secondList) { // O(n*m)
        List<int[]> result = new ArrayList<>();
        int start, end;
        int[] pair;
        for (int[] firstInterval : firstList) {
            for (int[] secondInterval : secondList) {
                if (secondInterval[1] < firstInterval[0]) continue;
                if (secondInterval[0] > firstInterval[1]) break;
                start = max(firstInterval[0], secondInterval[0]);
                end = min(firstInterval[1], secondInterval[1]);
                pair = new int[]{start, end};
                result.add(pair);
            }
        }
        return result.toArray(new int[0][0]);
    }

}
