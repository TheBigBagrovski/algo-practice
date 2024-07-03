package org.example.leetcode;

import java.util.Arrays;

/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * сдвинуть массив вправо на К
 * РЕШЕНИЕ:
 * пишем функцию разворота массива
 * разворачиваем весь массива
 * потом первые К элементов
 * потом остальное
 */
public class LC189 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 5;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public static void reverse(int nums[], int start, int end){ // time: O(N) space: O(1)
        // While start index is less than end index
        while(start < end){
            // Swap elements at start and end indices
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            // Increment start index and decrement end index
            start++;
            end--;
        }
    }

    public static void rotate(int[] nums, int k) {
        // Ensure k is within array bounds
        k %= nums.length;
        // Reverse entire array
        reverse(nums, 0, nums.length - 1);
        // Reverse first k elements
        reverse(nums, 0, k - 1);
        // Reverse remaining elements
        reverse(nums, k, nums.length - 1);
    }


}
