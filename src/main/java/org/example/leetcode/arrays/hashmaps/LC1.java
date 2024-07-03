package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * РЕШЕНИЕ:
 * идем по массиву, добавляем в ХМ каждое число
 * если на очередном числе недостащее есть в ХМ - возвращаем ответ
 * О(н), О(н) - т.к. операции с ХМ О(1)
 * -----------------
 * идем по массиву и для каждого число бинарным поиском пытаемся найти недостающее в оставшейся части массива
 * О(нлогн) О(1)
 */
public class LC1 {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }
        return new int[]{};
    }

}
