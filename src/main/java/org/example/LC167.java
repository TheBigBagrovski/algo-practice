package org.example;

import java.util.Arrays;

public class LC167 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,2,4};
        int target = 0;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) { //O(n) O(1)
        int left = 0;
        int right = nums.length - 1;
        int sum = 0;
        int[] ans = new int[2];
        while (left <= right) {
            sum = nums[left] + nums[right];
            if (sum < target) left++;
            else if (sum > target) right--;
            else {
                ans[0] = left + 1;
                ans[1] = right + 1;
                return ans;
            }
        }
        return ans;
    }

    public static int[] alilbetterTwoSum(int[] nums, int target) { //O(nlogn) O(1)
        int[] ans = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            int find = target - nums[i];
            nums[i] = -1001;
            Integer a = binarySearch(nums, find);
            if (a != null) {
                ans[0] = i + 1;
                ans[1] = a + 1;
                return ans;
            }
        }
        return ans;
    }

    private static Integer binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }


    public static int[] badTwoSum(int[] nums, int target) { //O(N^2) O(1)
        int[] ans = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i + 1;
                    ans[1] = j + 1;
                    return ans;
                }

            }
        }
        return ans;
    }

}
