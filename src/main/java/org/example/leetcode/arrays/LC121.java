package org.example.leetcode;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0
 * РЕШЕНИЕ:
 * идем по ценам, если текущая меньше цены покупки - ставим минимальную, цену продажи в 0
 * если текущая больше цены продажи и при этом текущий профит больше максимума  - ставим максимальную, фиксируем новый макспрофит
 */
class LC121 {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
        prices = new int[]{7, 6, 5, 4, 3, 2};
        System.out.println(maxProfit(prices));
        prices = new int[]{0};
        System.out.println(maxProfit(prices));
        prices = new int[]{3,2,6,5,0,3};
        System.out.println(maxProfit(prices));
    }

    static int maxProfit(int[] prices) { // O(N), O(1)
        int buy = prices[0], sell = 0;
        int profit = 0;
        for (int price : prices) {
            if (price < buy) {
                buy = price;
                sell = 0;
            } else if (price > sell && profit < price - buy) {
                sell = price;
                profit = sell - buy;
            }
        }
        return profit;
    }

}
