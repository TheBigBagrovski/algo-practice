package org.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 * РЕШЕНИЕ:
 * массив на 26 доя первой строки
 * считаем в него частоты символов
 * проходимся окном длиной в первую строку по второй строке, считаем такой же масив частот для окна
 * если массивы равны то перестановка есть
 */
public class LC567 {

    public static void main(String[] args) {
        String s1 = "adc", s2 = "dcda";
        System.out.println(fixedFrequencyArrays(s1, s2));
    }

    public static boolean fixedFrequencyArrays(String s1, String s2) { // O(n^2), O(1)
        int[] s1freq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1freq[s1.charAt(i) - 'a']++;         // 5head
        }
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] windowFreq = new int[26];
            for (int j = i; j < i + s1.length(); j++) {
                windowFreq[s2.charAt(j) - 'a']++;
            }
            if (Arrays.equals(s1freq, windowFreq)) {
                return true;
            }
        }
        return false;
    }

    public static boolean cringe2(String s1, String s2) { // O(n^2*logn), O(n)
        String sub;
        char[] arr = s1.toCharArray();
        Arrays.sort(arr);
        s1 = new String(arr);
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            sub = s2.substring(i, i + s1.length());
            arr = sub.toCharArray();
            Arrays.sort(arr);
            sub = new String(arr);
            if(s1.equals(sub)) return true;
        }
        return false;
    }

    public static boolean cringe(String s1, String s2) { // O(n^2*logn), O(n)
        Map<Character, Integer> init = makeMap(s1);
        Map<Character, Integer> cur;
        String sub;
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            sub = s2.substring(i, i + s1.length());
            cur = makeMap(sub);
            if(init.equals(cur)) return true;
        }
        return false;
    }

    private static Map<Character, Integer> makeMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (!map.containsKey(ch)) map.put(ch, 1);
            else map.put(ch, map.get(ch) + 1);
        }
        return map;
    }
}
