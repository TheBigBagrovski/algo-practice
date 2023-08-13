package org.example;

public class LC153 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 4, 5, 6, 7};
        System.out.println(solve(nums));
        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(solve(nums));
        nums = new int[]{2, 1};
        System.out.println(solve(nums));
        nums = new int[]{2};
        System.out.println(solve(nums));
        nums = new int[]{3,1,2};
        System.out.println(solve(nums));
    }

    private static int solve(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if(nums[start] <= nums[mid] && nums[mid] <= nums[end]) return nums[start];
            else if (nums[start] <= nums[mid]) {
                start = mid + 1;
            } else if (nums[mid] <= nums[end]) {
                end = mid;
            }
        }
        return nums[start];
    }

}
