package org.example.leetcode;

import java.util.Arrays;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 * РЕШЕНИЕ:
 * два указателя, сноубол
 */
public class LC283 {

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        solve2(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void solve(int[] nums) {
        int snowBallSize = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                snowBallSize++;
            }
            else if (snowBallSize > 0) {
                int t = nums[i];
                nums[i]=0;
                nums[i-snowBallSize]=t;
            }
        }
    }

    private static void solve2(int[] nums) {
        int n = nums.length;
        int first = 0;
        int second = 0;
        while (second < n) {
            if (nums[second] == 0) {
                second++;
            } else {
                int temp = nums[first];
                nums[first] = nums[second];
                nums[second] = temp;
                first++;
                second++;
            }
        }
    }
}
