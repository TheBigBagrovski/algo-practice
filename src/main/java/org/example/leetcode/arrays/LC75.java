package org.example.leetcode;

import java.util.Arrays;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * <p>
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * <p>
 * You must solve this problem without using the library's sort function.
 */
public class LC75 {

    public static void main(String[] args) {
        int[] test = new int[]{0,1,0,2};
        sortColors(test);
        System.out.println(Arrays.toString(test)); // 0 0 1 2      0 2 0 1       0 1 0 2
    }

    public static void sortColors(int[] nums) { // O(N) O(1)
        int low = 0, high = nums.length - 1, mid = 0;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, mid, low);
                low++;
            } else if (nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
                mid--;
            }
            mid++;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

}
