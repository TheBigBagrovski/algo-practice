package org.example.LeetCode;

public class LC231 {

    public static void main(String[] args) {
        System.out.println(solve(2));
        System.out.println(solve(16));
        System.out.println(solve(3));
        System.out.println(solve(1));
        System.out.println(solve(129));
    }

    private static boolean solve(int n) {
        return (n > 0 && (n & (n - 1)) == 0);
    }

}
