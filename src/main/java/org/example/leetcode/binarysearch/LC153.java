package org.example.leetcode;

/**
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 *
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 *
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 *
 * You must write an algorithm that runs in O(log n) time.
 */
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
