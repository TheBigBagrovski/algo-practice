package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {

    public static void main(String[] args) {
        String s1 = "ehllo";
        String s2 = "llohe";
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        System.out.println(constArrays(str1, str2));
    }

    public static boolean constArrays(char[] str1, char[] str2) { // O(n), O(1)
        if(str1.length != str2.length) return false;
        int[] charCount = new int[256];
        for(char c : str1) {
            charCount[c]++;
        }
        for(char c : str2) {
            charCount[c]--;
        }
        for(int count : charCount) {
            if(count != 0) return false;
        }
        return true;
    }

    public static boolean withSort(char[] str1, char[] str2) { // O(nlogn), O(n)
        if(str1.length != str2.length) return false;
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    public static boolean hashmaps(char[] str1, char[] str2) { // O(n), O(n)
        if(str1.length != str2.length) return false;
        boolean isAn = false;
        Map<Character, Integer> map1 = new HashMap<Character, Integer>();
        Map<Character, Integer> map2 = new HashMap<Character, Integer>();
        for (char c : str1) {
            if (!map1.containsKey(c)) map1.put(c, 1);
            else map1.put(c, map1.get(c) + 1);
        }
        for (char c : str2) {
            if (!map2.containsKey(c)) map2.put(c, 1);
            else map2.put(c, map2.get(c) + 1);
        }
        return map1.equals(map2);
    }

}
