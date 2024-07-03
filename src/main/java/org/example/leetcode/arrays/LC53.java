package org.example.leetcode;

/**
 * Given an integer array nums, find the
 * subarray
 *  with the largest sum, and return its sum.
 *
*  РЕШЕНИЕ:
 *  алгоритм кадана:
 *  движемся по массиву, храним текущую сумму, если сумма падает ниже 0 - сброс
 *  выводим макс сумму
 */
public class LC53 {



    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(kadane(arr));
        arr = new int[] {1};
        System.out.println(kadane(arr));
        arr = new int[] {5,4,-1,7,8};
        System.out.println(kadane(arr));
        arr = new int[] {-3, -2 ,-1};
        System.out.println(kadane(arr));
    }

    static int kadane(int[] nums) { // O(n), O(1)
        int max = -10001, current = 0;
        for (int num : nums) {
            current += num;
            if (current > max) {
                max = current;
            }
            if (current < 0) {
                current = 0;
            }
        }
        return max;
    }

}
