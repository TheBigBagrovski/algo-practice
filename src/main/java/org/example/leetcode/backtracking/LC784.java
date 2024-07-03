package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC784 {

    public static void main(String[] args) {
        String s = "a1b2";
        System.out.println(letterCasePermutation(s));

    }

    public static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        permute(s.toCharArray(), 0, result);
        return result;
    }

    private static void permute(char[] chars, int index, List<String> result) { // O(2^n), O(2^n)
        if (index == chars.length) {
            result.add(new String(chars));
            return;
        }
        char c = chars[index];
        if (Character.isLetter(c)) {
            chars[index] = Character.toUpperCase(c);
            permute(chars, index + 1, result);
            chars[index] = Character.toLowerCase(c);
            permute(chars, index + 1, result);
        } else {
            permute(chars, index + 1, result);
        }
    }

    public static List<String> loop(String s) { // O(n*2^n), O(2^n)
        char[] str = s.toCharArray();
        int index = 1;
        List<String> answer = new ArrayList<>();
        if (Character.isLetter(str[0])) {
            answer.add(String.valueOf(Character.toLowerCase(str[0])));
            answer.add(String.valueOf(Character.toUpperCase(str[0])));
        } else {
            answer.add(String.valueOf(str[0]));
        }
        while (index != str.length) {
            if (Character.isLetter(str[index])) {
                answer.addAll(new ArrayList<>(answer));
                for (int i = 0; i < answer.size()/2; i++) {
                    answer.set(i, answer.get(i) + Character.toLowerCase(str[index]));
                }
                for (int i = answer.size()/2; i < answer.size(); i++) {
                    answer.set(i, answer.get(i) + Character.toUpperCase(str[index]));
                }
            } else {
                for (int i = 0; i < answer.size(); i++) {
                    answer.set(i, answer.get(i) + str[index]);
                }
            }
            index++;
        }
        return answer;
    }

}
