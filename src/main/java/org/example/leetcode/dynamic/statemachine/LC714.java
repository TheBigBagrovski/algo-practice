package org.example.leetcode.statemachine;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
 *
 * Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
 *
 * Note:
 *
 * You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * The transaction fee is only charged once for each stock purchase and sale.
 * РЕШЕНИЕ:
 * This proplem is an introduction to state machine logic. In order to solve it, we can consider
 * the two possible distinct states of being: having no stock and being ready to buy (buying) and owning stock
 * and being ready to sell (selling).
 *
 * We just need to iterate through the prices (P) and keep track of the best possible value for these two
 * states of being for each day. The difficulty is that the tracks of the two states cross over regulary.
 *
 * For example, if we consider the state of being ready to buy stock after this iteration (buying), it can be
 * reached from being ready to buy today and doing nothing, OR it can be reached by being ready to sell today
 * and selling (with the additional fee [F]). We just need to pick whichever one yields the best value.
 *
 * The same is true of the selling state. The new selling state is the better result between the previous
 * selling state with no action and the previous buying state with a stock purchase today.
 */
public class LC714 {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {1,3,2,8,4,9}, 2));
        System.out.println(maxProfit(new int[] {1,3,7,5,10,3}, 3));
        System.out.println(maxProfit(new int[] {9,8,7,1,2}, 3));
    }

    public static int maxProfit(int[] P, int F) {
        int len = P.length, buying = 0, selling = -P[0];
        for (int i = 1; i < len; i++) {
            buying = Math.max(buying, selling + P[i] - F);
            selling = Math.max(selling, buying - P[i]);
        }
        return buying;
    }

}
