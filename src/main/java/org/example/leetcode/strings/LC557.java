package org.example.leetcode;

/**
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * РЕШЕНИЕ:
 * разбить сплитом на массив строк (слов)
 * пишем функцию разворота свапами
 * О(н), О(н)
 */
public class LC557 {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }

    private static String simplest(String s) { // O(n), O(n)
        StringBuilder result = new StringBuilder();
        String[] words = s.split(" ");
        for (String word : words) {
            result.append(new StringBuilder(word).reverse().toString());
            result.append(" ");
        }
        return result.toString().trim();
    }

    private static String reverseWords(String s) { // O(n), O(n)
        char[] str = s.toCharArray();
        int left = 0, right, wordSize = 0;
        char temp;
        for (int i = 0; i <= str.length; i++) {
            if (i == str.length || str[i] == ' ') {
                left = i - wordSize;
                right = i - 1;
                while (left <= right) {
                    temp = str[right];
                    str[right] = str[left];
                    str[left] = temp;
                    left++;
                    right--;
                }
                wordSize = 0;
            } else wordSize++;
        }
        return String.valueOf(str);
    }

}
