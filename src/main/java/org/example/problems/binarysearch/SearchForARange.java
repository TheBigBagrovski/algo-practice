package org.example.leetcode;

import java.util.Arrays;

public class searchForARange {

    public static void main(String[] args) {
        int[] arr = new int[] {5,5,5,5,7,7,7,7,8};
        System.out.println(Arrays.toString(searchRange(arr, 7)));
        System.out.println(Arrays.toString(searchRange(arr, 8)));
        System.out.println(Arrays.toString(searchRange(arr, 5)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        return new int[] {left(nums, n, target), right(nums, n, target)};
    }

    private static int left(int[] nums, int n, int target) {
        int left = 0, right = n - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target && (mid - 1 < 0 || nums[mid - 1] != target)) {
                return mid;
            } else if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private static int right(int[] nums, int n, int target) {
        int left = 0, right = n - 1;
        int mid;
        while(left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target && (mid + 1 >= n || nums[mid + 1] != target)) {
                return mid;
            } else if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


}
