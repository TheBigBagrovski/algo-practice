package org.example.leetcode;

/**
 * A peak element is an element that is strictly greater than its neighbors.
 * Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
 * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
 * You must write an algorithm that runs in O(log n) time.
 * важное условие - соседи не бывают равными
 * РЕШЕНИЕ:
 * бинарный поиск, если соблюдаются условия - кидаем ответ
 * иначе если текущий меньше следующего - идем вправо, лефт + 1
 * иначе идем влево - райт - 1
 */
public class LC162 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, 2, 3, 4};
        System.out.println(solve(nums));
//        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
//        System.out.println(solve(nums));
//        nums = new int[]{2, 1};
//        System.out.println(solve(nums));
//        nums = new int[]{2};
//        System.out.println(solve(nums));
//        nums = new int[]{3, 1, 2};
//        System.out.println(solve(nums));
//        nums = new int[]{1, 2, 1, 3, 5, 6, 4};
//        System.out.println(solve(nums));
    }

    private static int solve(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int length = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if ((mid <= 0 || nums[mid] > nums[mid - 1]) && (mid >= length - 1 || nums[mid] > nums[mid + 1])) return mid;
            else if (nums[mid] < nums[mid + 1]) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }


}
