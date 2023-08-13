package org.example;

public class LC35 {

    static int[] nums = new int[]{1,3,4};
    static int target = 2;

    public static void main(String[] args) {
        System.out.println(bestSolution(nums, target));
    }

    public static int bestSolution(int[] nums, int target) {
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
        return left;
    }

}
