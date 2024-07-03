package org.example.leetcode;

import static java.util.Arrays.copyOfRange;

/**
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 * You must write an algorithm with O(log n) runtime complexity.
 * РЕШЕНИЕ:
 * бинарный поиск
 */
public class LC704 {

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = -20;
        System.out.println(LC704.bestSolution(nums, target));
    }

    public static int bestSolution(int[] nums, int target) { // best
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int solution(int[] nums, int target) {
        int cur = -10001, curInd = 0;
        return solve(nums, target, cur, curInd)[0];
    }

    private int[] solve(int[] nums, int target, int cur, int curInd) {
        cur = nums[nums.length / 2];
        if (target == cur) return new int[]{curInd + nums.length / 2};
        else if (nums.length == 1) return new int[]{-1};
        else if (target > cur) return solve(copyOfRange(nums, nums.length/2, nums.length), target, cur, curInd + nums.length/2);
        else return solve(copyOfRange(nums, 0, nums.length/2), target, cur, curInd);
    }

}
