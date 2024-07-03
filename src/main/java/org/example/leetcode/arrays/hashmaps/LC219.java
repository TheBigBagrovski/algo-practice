package org.example.leetcode.arrays.hashmaps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 * РЕШЕНИЯ:
 * мап с парами значение - индекс
 * О(н) О(н)
 * ---------------------------------
 * аналогично с сетом с удалениями
 * О(н) О(н)
 */
public class LC219 {

    public boolean set(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ;i<nums.length;i++ ){
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (i >= k) {
                set.remove(nums[i-k]);
            }
        }
        return false;
    }

    public boolean map(int[] nums, int k) {
        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ;i<len;i++ ){
            if (map.containsKey(nums[i])) {
                if (Math.abs(map.get(nums[i]) - i) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

}
