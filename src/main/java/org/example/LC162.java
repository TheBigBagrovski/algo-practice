package org.example;

public class LC162 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(solve(nums));
        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(solve(nums));
        nums = new int[]{2, 1};
        System.out.println(solve(nums));
        nums = new int[]{2};
        System.out.println(solve(nums));
        nums = new int[]{3, 1, 2};
        System.out.println(solve(nums));
        nums = new int[]{1, 2, 1, 3, 5, 6, 4};
        System.out.println(solve(nums));
    }

    private static int solve(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int length = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if ((mid <= 0 || nums[mid] > nums[mid - 1]) && (mid >= length - 1 || nums[mid] > nums[mid + 1])) return mid;
            else if (nums[mid] < nums[mid + 1]) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }


}
