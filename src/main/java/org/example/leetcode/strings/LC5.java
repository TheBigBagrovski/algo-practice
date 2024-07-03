package org.example.leetcode;

/**
 * Given a string s, return the longest
 * palindromic substring in s.
 * РЕШЕНИЕ:
 * пишем функцию, которая для двух введенных координат (на случай четного и нечетного палиндрома) начинает расширяться из центра
 * пока символы слева и справа равны и сохраняет макс длину  и начало палиндрома (глоб переменные)
 * О(н^2), О(1)
 */
public class LC5 {

    public static void main(String[] args) {

    }

    int maxLen = 0;
    int lo = 0;

    public String longestPalindrome(String s) {
        char[] input = s.toCharArray();
        if (s.length() < 2) {
            return s;
        }
        for (int i = 0; i < input.length; i++) {
            expandPalindrome(input, i, i);
            expandPalindrome(input, i, i + 1);
        }
        return s.substring(lo, lo + maxLen);
    }

    public void expandPalindrome(char[] s, int j, int k) {
        while (j >= 0 && k < s.length && s[j] == s[k]) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            maxLen = k - j - 1;
            lo = j + 1;
        }
    }

}
