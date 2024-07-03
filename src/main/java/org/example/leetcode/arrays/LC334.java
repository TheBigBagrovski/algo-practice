package org.example.leetcode;

/**
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and
 * nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 * РЕШЕНИЕ:
 * проход с ведением 3 счетчиков, минимум, средний и максимум
 * изначально в первых двух большие числа
 * новое число располагаем в один из счетчиков, если новое число больше мидла то тру
 */
public class LC334 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(solve(nums));
        nums = new int[]{5, 4, 3, 2, 1};
        System.out.println(solve(nums));
        nums = new int[]{2, 1, 5, 0, 4, 6};
        System.out.println(solve(nums));
        nums = new int[]{2, 1, 5, 0, 6};
        System.out.println(solve(nums));
    }

    public static boolean solve(int[] nums) {
        int left = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;
        for (int right : nums) {
            if (right < left) {
                left = right;
            } else if (right < middle && right > left) {
                middle = right;
            } else if (right > middle) {
                return true;
            }
        }
        return false;
    }

}
