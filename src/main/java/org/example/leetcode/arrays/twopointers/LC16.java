package org.example.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.abs;

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 * РЕШЕНИЕ:
 * аналогично 15, только убираем условие перебора до <= target т.к. таргет может быть отриц
 */
public class LC16 {

    public static void main(String[] args) {
        int[] arr = new int[] {-1,2,1,-4};
        System.out.println(threeSumClosest(arr, 1));
        arr = new int[] {-1,2,1,-4};
        System.out.println(threeSumClosest(arr, 2));
        arr = new int[] {0,0,0};
        System.out.println(threeSumClosest(arr, 1));
        arr = new int[] {-1,-1,-1};
        System.out.println(threeSumClosest(arr, -3));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE, best = 0;
        Arrays.sort(nums);
        int len = nums.length;
        int j, k, sum;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            j = i + 1;
            k = len - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (abs(target - sum) < minDiff) {
                    minDiff = abs(target - sum);
                    best = sum;
                }
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    j++;
                    while (nums[j] == nums[j - 1] && j < k) j++;
                } else {
                    k--;
                    while (nums[k] == nums[k + 1] && j < k) k--;
                }
            }
        }
        return best;
    }

}
