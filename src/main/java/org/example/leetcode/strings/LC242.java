package org.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * определить анаграммы
 * РЕШЕНИЯ:
 * сортировка
 * О(нлогн), О(1)
 * ----------------
 * хэшмап
 * О(н), О(н)
 * ----------------
 * массив на 26
 * О(н), О(1)
 */
public class LC242 {

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(hashMap(s, t));
        s = "rat"; t = "car";
        System.out.println(hashMap(s, t));
    }

    public boolean hashmapUpgraded(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();

        // Count the frequency of characters in string s
        for (char x : s.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        // Decrement the frequency of characters in string t
        for (char x : t.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) - 1);
        }

        // Check if any character has non-zero frequency
        for (int val : count.values()) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean array(String s, String t) {
        int[] count = new int[26];

        // Count the frequency of characters in string s
        for (char x : s.toCharArray()) {
            count[x - 'a']++;
        }

        // Decrement the frequency of characters in string t
        for (char x : t.toCharArray()) {
            count[x - 'a']--;
        }

        // Check if any character has non-zero frequency
        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean sortUpgraded(String s, String t) { // O(nlogn), O(n)
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }

    private static boolean sort(String s, String t) { // O(nlogn), O(n)
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        int len1 = arr1.length;
        int len2 = arr2.length;
        if (len2 != len1) {
            return false;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < arr2.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean hashMap(String s, String t) { // O(n), O(n)
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        int len1 = arr1.length;
        int len2 = arr2.length;
        if (len2 != len1) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : arr1) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        for (char c : arr2) {
            if (map.containsKey(c)) {
                if (map.get(c) == 1) {
                    map.remove(c);
                } else {
                    map.put(c, map.get(c) - 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }

}
