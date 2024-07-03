package org.example.leetcode;

import java.util.Arrays;

import static java.lang.Thread.sleep;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * РЕШЕНИЯ:
 * брутфорс: рекурсивно пробуем к текущему числу прибавть 1 или 2, возвращенное число суммируем к ответу
 * строим дерево, но наоборот
 * УВ 1:  если дошли до н - возвр 1
 * УВ 2: если перешагнули - возвр 0
 * // O(2^n) + считается одно и то же несколько раз, O(n) - стек рекурсивных вызовов
 * -----------------
 * дп с мемо:
 * заводим массив на 2 элемента больше (на случай перешага), заполняем -1
 * рекурсивно  пробуем к текущему числу прибавть 1 или 2
 * строим дерево, но наоборот
 * УВ 1 : если в мемо есть наше число - возвр его
 * УВ 2:  если дошли до н - возвр 1
 * УВ 3: если перешагнули - возвр 0
 */
public class LC70 {

    public static void main(String[] args)  {
        System.out.println(climbStairs(5));
        System.out.println(climbStairs(41));
        System.out.println(climbStairs(45));
    }

    public static int climbStairs(int n) {
        int[] memo = new int[n + 2];
        Arrays.fill(memo, -1);
        return rec(0, n, memo);
    }

    public static int rec(int sum, int n, int[] memo) { // O(n), O(n)
        if (memo[sum] != -1) {
            return memo[sum];
        }
        if (sum == n) {
            return 1;
        } else if (sum > n) {
            return 0;
        }
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
