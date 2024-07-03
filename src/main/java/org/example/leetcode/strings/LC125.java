package org.example.leetcode;

/**
 * оставить в строке только буквы и сказать палиндром ли это
 * РЕШЕНИЕ:
 * регексом заменяем все кроме букв на пустой символ, проверяем палиндром
 */
public class LC125 {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(solve(s));
    }

    public boolean isPalindrome(String s) { // much faster
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int last = s.length() - 1;
        while(start <= last) {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(last);
            if (!Character.isLetterOrDigit(currFirst )) {
                start++;
            } else if(!Character.isLetterOrDigit(currLast)) {
                last--;
            } else {
                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }

    private static boolean solve(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        char[] arr = s.toCharArray();
        int start = 0;
        int end  = s.length() - 1;
        while (start < (s.length() - 1) / 2) {
            if (arr[start] != arr[end - start]) {
                return false;
            }
            start++;
        }
        return true;
    }

}
