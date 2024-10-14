package org.example.leetcode.dynamic;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
 * <p>
 * After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * РЕШЕНИЯ:
 * dp with memo
 * конечный автомат с 3 состояниями
 * s0[i] = max(s0[i - 1], s2[i - 1]); // Stay at s0, or rest from s2
 * s1[i] = max(s1[i - 1], s0[i - 1] - prices[i]); // Stay at s1, or buy from s0
 * s2[i] = s1[i - 1] + prices[i]; // Only one way from s1
 * Then, you just find the maximum of s0[n] and s2[n], since they will be the maximum profit we need
 * О(н) О(н)
 * из этого легко получить
 * ----------------------------
 * простой перебор
 * О(н) О(1)
 */
public class LC309 {

    public static void main(String[] args) {
//        int[] prices = new int[]{1, 3, 1, 5, 2, 3, 5, 3, 6, 2, 4, 7, 8, 3};
//        System.out.println(dpmemo(prices));
        int[] prices = new int[]{1, 2, 3, 0, 2};
        System.out.println(dpmemo(prices));
    }

    public static int dpmemo(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int[] s0 = new int[prices.length];
        int[] s1 = new int[prices.length];
        int[] s2 = new int[prices.length];
        s1[0] = -prices[0];
        s0[0] = 0;
        s2[0] = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            s0[i] = max(s0[i - 1], s2[i - 1]);
            s1[i] = max(s1[i - 1], s0[i - 1] - prices[i]);
            s2[i] = s1[i - 1] + prices[i];
        }
        return max(s0[prices.length - 1], s2[prices.length - 1]);
    }

    public static int maxProfit(int[] prices) {
        int sold = 0, hold = Integer.MIN_VALUE, rest = 0;
        for (int price : prices) {
            int prvSold = sold;
            sold = hold + price;
            hold = max(hold, rest - price);
            rest = max(rest, prvSold);
        }
        return max(sold, rest);
    }

}
