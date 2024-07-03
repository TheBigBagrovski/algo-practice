package org.example.leetcode;

import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * РЕШЕНИЯ:
 * сортировка: сортируем массив строк, тогда самое большое различие в начальных символах будет у первой и последней строки
 * идем по первой и последней строки, запоминаем последний индекс равных символов, в конце выводим подстроку
 * О(нлогн), О(1)
 */
public class LC14 {

    public static void main(String[] args) {
        String[] str = new String[]{"flower", "flow", "flight"};
        System.out.println(solve(str));
        str = new String[]{"dog", "racecar", "car"};
        System.out.println(solve(str));
    }

    public String sort(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int idx = 0;
        while(idx < s1.length() && idx < s2.length()){
            if(s1.charAt(idx) == s2.charAt(idx)){
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }

    private static String solve(String[] arr) {
        StringBuilder builder = new StringBuilder();
        builder.append(arr[0]);
        int i;
        for (int j = 1; j < arr.length; j++) {
            char[] chArr = arr[j].toCharArray();
            i = 0;
            while (i < chArr.length && i < builder.length()) {
                if (chArr[i] != builder.charAt(i)) {
                    break;
                }
                i++;
            }
            builder.delete(i, builder.length());
            if (builder.isEmpty()) {
                return "";
            }
        }
        return builder.toString();
    }

}
