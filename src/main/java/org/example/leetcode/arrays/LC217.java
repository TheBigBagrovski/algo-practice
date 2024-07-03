package org.example.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LC217 {

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4};
        System.out.println(solve(nums));
        nums = new int[] {1,2,3,1};
        System.out.println(solve(nums));
        nums = new int[] {1,1,1,3,3,4,3,2,4,2};
        System.out.println(solve(nums));
    }

    private static boolean solve(int[] nums) { // O(n), O(n)
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(!set.contains(num)) {
                set.add(num);
            } else {
                return true;
            }
        }
        return false;
    }

}
