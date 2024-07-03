package org.example.leetcode;

/**
 * та самая задача с 1 уникальным символом
 * РЕШЕНИЯ:
 * хэшмап
 * O(n). O(n)
 * ---------------
 * биты, ксор
 * O(N), O(1)
 */
public class LC136 {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 2, 3, 3, 1, 0, 5, 5};
        System.out.println(solve(nums));
        nums = new int[] {1, 1, 0};
        System.out.println(solve(nums));
    }

    private static int solve(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

}
