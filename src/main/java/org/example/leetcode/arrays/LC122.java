package org.example.leetcode;

/**
 * макс прибыль с несколькими сделками
 * РЕШЕНИЕ:
 *
 * идем по массиву,
 * если цена упала - если профит больше 0 - добавляем к макспрофиту, обнуляем продажу и цену
 * если текущая больше цены продажи - обновляем цену продажи
 * если текущая меньше цены покупки - обновляем покупку, обнуляем продажу
 */
public class LC122 {

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(solve(prices));
        prices = new int[]{1, 2, 3, 4, 5};
        System.out.println(solve(prices));
        prices = new int[]{7, 6, 4, 3, 1};
        System.out.println(solve(prices));
        prices = new int[]{1,1,0};
        System.out.println(solve(prices));
    }

    private static int solve(int[] prices) { // O(n), O(1)
        if (prices.length == 1) {
            return 0;
        }
        int buyPrice = prices[0];
        int sellPrice = 0;
        int answer = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1] && sellPrice - buyPrice > 0) {
                answer += sellPrice - buyPrice;
                buyPrice = Integer.MAX_VALUE;
                sellPrice = 0;
            }
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
                sellPrice = 0;
            } else if (prices[i] > sellPrice) {
                sellPrice = prices[i];
            }
        }
        if (sellPrice - buyPrice > 0) {
            answer += sellPrice - buyPrice;
        }
        return answer;
    }

}
