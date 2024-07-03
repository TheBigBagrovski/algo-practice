package org.example.leetcode;

import java.util.Arrays;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you from
 * robbing each of them is that adjacent houses have security systems connected and it will
 * automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum
 * amount of money you can rob tonight without alerting the police.
 * РЕШЕНИЕ:
 * итератив + мемо: идем по массиву и сохраняем в другой массив максимум из 2 вариантов:
 * либо этот элемеент, либо предыдущий + следующий
 * сохрааняем лишние элементы, тк пользуемся всего 2 предыдущими
 * О(н), О(н)
 * ----------------------
 * итератив с 2 переменными: идем по массиву и сохраняем результаты предыдущего и предпредыдущего
 * на каждой итерации обновляем prev1: либо оставляем, либо предпредыдущий + текущий
 * в конце в прев1 будем максимум
 */
public class LC198 {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 1};
        System.out.println(solve(array));
        array = new int[]{2, 7, 9, 3, 1}; //    2, 7, 11, 10, 12
        System.out.println(solve(array));
        array = new int[]{1, 1, 7, 1, 1, 7, 1, 1, 7, 1, 1, 7, 1, 1};
        System.out.println(solve(array));
        array = new int[]{1, 2};
        System.out.println(solve(array));
        array = new int[]{1, 3, 1};
        System.out.println(solve(array));
        array = new int[]{1, 2, 3, 4, 5};
        System.out.println(solve(array));
    }

    public int best(int[] nums) { // 2, 7, 9, 3, 1             12  11
        if (nums.length == 0) return 0;
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
    }

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            memo[i+1] = Math.max(memo[i], memo[i-1] + val);
        }
        return memo[nums.length];
    }

    private static int solve(int[] array) { // O(n), O(1)
        int max = Arrays.stream(array).max().getAsInt();
        if (array.length < 3) {
            return max;
        }
        int localmax;
        localmax = array[0];  // 2 5 5 9 17 13
        for (int i = 2; i < array.length; i++) {
            array[i] += localmax;
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i - 1] > localmax) {
                localmax = array[i - 1];
            }
        }
        return max;
    }

}
