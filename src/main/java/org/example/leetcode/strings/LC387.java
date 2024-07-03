package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 * РЕШЕНИЕ:
 * создаем мапу, кладем в нее символ и когда последний раз встретили, если там уже не ноль, то кладем -1
 * дальше проходим по значениям и берем наименьшее
 */
public class LC387 {

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(solve(s));
    }

    private static int solve(String s) {// O(n), O(n)
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], i);
            } else {
                map.put(arr[i], -1);
            }
        }
        int result = -1;
        for (Integer value : map.values()) {
            if (value != -1 && (value < result || result == -1)) {
                result = value;
            }
        }
        return result;
    }

}
