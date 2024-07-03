package org.example.leetcode;

import java.util.Arrays;

public class LC88 {

    public static void main(String[] args) {
        int n = 5, m = 5;
        int[] nums1 = new int[]{1, 3, 5, 6, 8, 0, 0, 0, 0, 0};
        int[] nums2 = new int[]{0, 2, 4, 10, 11};
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }

}
