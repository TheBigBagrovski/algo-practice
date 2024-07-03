package org.example.leetcode;

import java.util.Arrays;

import static java.lang.Math.abs;

/**
 * 
 */
public class LC977 {

    public static void main(String[] args) {
        int[] nums = new int[]{-7,-3,2,3,11};
        System.out.println(Arrays.toString(best(nums)));
    }

    public static int[] solve(int[] nums) { //O(nlogn) - Arrays.sort()
        int leng = nums.length;
        int[] ret = new int[leng];
        for (int i = 0; i < leng; i++) {
            ret[i] = nums[i] * nums[i];
        }
        Arrays.sort(ret);
        return ret;
    }

    public static int[] best(int[] nums) {
        int leng = nums.length;
        int left = 0;
        int right = leng - 1;
        int[] ret = new int[leng];
        int index = right;
        while(left<=right) {
            if(abs(nums[right]) > abs(nums[left])) {
                ret[index] = nums[right] * nums[right];
                right--;
            }
            else {
                ret[index] = nums[left] * nums[left];
                left++;
            }
            index--;
        }
        return ret;
    }

}
