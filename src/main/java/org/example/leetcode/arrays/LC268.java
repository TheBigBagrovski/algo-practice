package org.example.leetcode;

/**
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 * РЕШЕНИЕ:
 * нужная сумма - реальная сумма
 * О(н), О(1)
 */
public class LC268 {

    public static void main(String[] args) {

    }

    public int missingNumber(int[] nums) {
        int expSum = 0, actSum = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            expSum += i;
            actSum += nums[i];
        }
        expSum += n;
        return expSum - actSum;
    }

}
