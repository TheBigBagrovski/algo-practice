package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * РЕШЕНИЕ:
 * сортим массив по возрастанию
 * идем по массиву, если текущий равен предыдущему - скипаем
 * для каждого элемента запускаем цикл с двумя указателями - в начале и в конце оставшейся части массива
 * если сумма меньше таргета, двигаем вправо левый указатель, иначе двигаем правый
 * О(н^2), О(1)
 */
public class LC15 {

    public static void main(String[] args) {
        int[] arr1 = new int[]{-1, 0, 1, 2, -1, -4};
        int[] arr2 = new int[]{0, 1, 1};
        int[] arr3 = new int[]{0, 0, 0};
        System.out.println(solve(arr1));
        System.out.println(solve(arr2));
        System.out.println(solve(arr3));
    }

    public static List<List<Integer>> solve(int[] nums) { // O(n^2)
        List<List<Integer>> result = new ArrayList<>();
        nums = Arrays.stream(nums).sorted().toArray();
        int len = nums.length;
        int j, k, sum;
        for (int i = 0; i <= len - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            j = i + 1;
            k = len - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    result.add(triplet);
                    j++;
                    while (nums[j] == nums[j - 1] && j < k) j++;
                    k--;
                    while (nums[k] == nums[k + 1] && j < k) k--;
                } else if (sum < 0) {
                    j++;
                    while (nums[j] == nums[j - 1] && j < k) j++;
                } else {
                    k--;
                    while (nums[k] == nums[k + 1] && j < k) k--;
                }
            }
        }
        return result;
    }

}
