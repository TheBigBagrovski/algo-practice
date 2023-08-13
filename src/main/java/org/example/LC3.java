package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC3 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(arrayWithLastVisited(s));
    }

    public static int arrayWithLastVisited(String s) { // O(n), O(n)
        int n = s.length();
        int[] lastIndex = new int[128]; // ASCII characters
        Arrays.fill(lastIndex, -1);
        int left = 0, right = 0, maxLen = 0;
        while (right < n) {
            char c = s.charAt(right);
            if (lastIndex[c] >= left) {
                left = lastIndex[c] + 1;
            }
            lastIndex[c] = right;
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }

    public static int hashSet(String s) { // O(n), O(n)
        int end = 0, start = 0, ans = 0;
        Set<Character> set = new HashSet<>();
        while (end < s.length()) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;
                if (set.size() > ans) ans = set.size();
            } else {
                set.remove(s.charAt(start));
                start++;
            }
        }
        return ans;
    }

    public static int cringe(String s) { // O(n^3), O(n)
        if (s.length() == 0) return 0;
        String window;
        int answer = 0, start = 0;
        Set<Character> set = new HashSet<>();
        while (answer + start < s.length()) {
            window = s.substring(start, start + answer + 1);
            set.clear();
            for (int i = 0; i < answer + 1; i++) {
                set.add(window.charAt(i));
            }
            if (set.size() != window.length()) {
                start++;
            } else answer++;
        }
        return answer;
    }

}
