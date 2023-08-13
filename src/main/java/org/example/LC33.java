package org.example;

public class LC33 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 4, 5, 6, 7};
        int target = 7;
        System.out.println(solve(nums, target));
        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        target = 0;
        System.out.println(solve(nums, target));
        target = 6;
        System.out.println(solve(nums, target));
        target = 3;
        System.out.println(solve(nums, target));
        nums = new int[]{1};
        target = 0;
        System.out.println(solve(nums, target));
        nums = new int[]{1,3};
        target = 3;
        System.out.println(solve(nums, target));
        nums = new int[]{1,3};
        target = 1;
        System.out.println(solve(nums, target));
        nums = new int[]{3,1};
        target = 1;
        System.out.println(solve(nums, target));
        nums = new int[]{3,1};
        target = 3;
        System.out.println(solve(nums, target));
    }

    private static int solve(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == nums[mid])
                return mid;
            else if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target <= nums[mid]) end = mid - 1;
                else start = mid + 1;
            } else if (nums[mid] < nums[end]) {
                if (target >= nums[mid] && target <= nums[end]) start = mid + 1;
                else end = mid - 1;
            } else return -1;
        }
        return -1;
    }

}
