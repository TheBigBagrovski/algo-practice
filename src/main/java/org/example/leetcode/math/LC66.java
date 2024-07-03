package org.example.leetcode;

import java.util.Arrays;

public class LC66 {

    public static void main(String[] args) {
        int[] digits = new int[] {1,2,3};
        System.out.println(Arrays.toString(solve(digits)));
        digits = new int[] {4,3,2,1};
        System.out.println(Arrays.toString(solve(digits)));
        digits = new int[] {9};
        System.out.println(Arrays.toString(solve(digits)));
    }

    private static int[] moreElegant(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    private static int[] solve(int[] digits) { // O(n), O(n)
        boolean c = true;
        int len = digits.length;
        int currentIndex = len - 1;
        while (c) {
            if (currentIndex == 0 && digits[currentIndex] == 9) {
                digits[currentIndex] = 0;
                int[] result = new int[len + 1];
                result[0] = 1;
                System.arraycopy(digits, 0, result, 1, result.length - 1);
                return result;
            }
            if (digits[currentIndex] == 9) {
                digits[currentIndex] = 0;
                currentIndex--;
            } else {
                digits[currentIndex]++;
                c = false;
            }
        }
        return digits;
    }

}
