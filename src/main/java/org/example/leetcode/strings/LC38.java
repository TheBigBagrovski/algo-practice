package org.example.leetcode;

/**
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 *
 * countAndSay(1) = "1"
 * countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
 * To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.
 * РЕШЕНИЕ:
 * цикл от 2 до числа (т.к. кейс 1 = 11)
 * втупую идем, считываем, записываем, сохраняем предыдущую строку
 */
public class LC38 {

    public static void main(String[] args) {
        System.out.println(solve(1));
        System.out.println(solve(4));
        System.out.println(solve(5));
        System.out.println(solve(6));
        System.out.println(solve(7));
        System.out.println(solve(30));
    }

    private static String solve(int n) { // O(n*k), O(1)
        if (n == 1) return "1";
        String prevTerm = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            char current = prevTerm.charAt(0);
            int counter = 1;
            for (int j = 1; j < prevTerm.length(); j++) {
                char c = prevTerm.charAt(j);
                if (c == current) {
                    counter++;
                } else {
                    sb.append(counter);
                    sb.append(current);
                    current = c;
                    counter = 1;
                }
            }
            sb.append(counter);
            sb.append(current);
            prevTerm = sb.toString();
        }
        return prevTerm;
    }

}
