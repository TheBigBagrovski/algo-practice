package org.example.leetcode.arrays;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 */
public class LC42 {

    public static void main(String[] args) {
        System.out.println(trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trap(new int[] {4,2,0,3,2,5}));
    }

    public static int trap(int[] h) {
        int l = 0, r = h.length - 1, lmax = Integer.MIN_VALUE, rmax = Integer.MIN_VALUE, ans = 0;
        while (l < r) {
            lmax = Math.max(lmax, h[l]);
            rmax = Math.max(rmax, h[r]);
            if (lmax < rmax) {
                ans += lmax - h[l];
                l++;
            } else {
                ans += rmax - h[r];
                r--;
            }
        }
        return ans;
    }
}
