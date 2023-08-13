package org.example;

import java.util.Arrays;

import static java.lang.Thread.sleep;

public class LC70 {

    public static void main(String[] args)  {
        System.out.println(climbStairs(40));
        System.out.println(climbStairs(41));
        System.out.println(climbStairs(45));
    }

    public static int climbStairs(int n) {
        int[] memo = new int[n + 2];
        Arrays.fill(memo, -1);
        return rec(0, n, memo);
    }

    public static int rec(int sum, int n, int[] memo) { // O(n), O(n)
        if (memo[sum] != -1) return memo[sum];
        if (sum == n) return 1;
        else if (sum > n) return 0;
        int currentAnswer = 0;
        currentAnswer += rec(sum + 1, n, memo);
        currentAnswer += rec(sum + 2, n, memo);
        memo[sum] = currentAnswer;
        return currentAnswer;
    }

    public static int bullshitStairs(int n) {
        return bullshit(0, n);
    }

    public static int bullshit(int sum, int n) { // O(2^n) + считается одно и то же несколько раз, O(n) - стек рекурсивных вызовов
        if (sum == n) return 1;
        else if (sum > n) return 0;
        int currentAnswer = 0;
        currentAnswer += bullshit(sum + 1, n);
        currentAnswer += bullshit(sum + 2, n);
        return currentAnswer;
    }

}
