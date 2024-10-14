package org.example.leetcode.backtracking;

public class LC377 {

    public static void main(String[] args) {
        int[] arr = new int[] {-1, 1, 2};
        System.out.println(combinationSum4(arr, 2));
    }

    public static int combinationSum4(int[] nums, int target) {
        return backtrack( nums, target, 0);
    }

    public static int backtrack(int[] nums, int target, int current) {
        if (current == target) {
            return 1;
        }
        if (current > target) {
            return 0;
        }
        int answer = 0;
        for (int num : nums) {
            answer += backtrack(nums, target, current + num);
        }
        return answer;
    }

}
