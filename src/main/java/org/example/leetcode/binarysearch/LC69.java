package org.example.leetcode;

/**
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
 * The returned integer should be non-negative as well.
 * You must not use any built-in exponent function or operator.
 * РЕШЕНИЕ:
 * двоичный поиск от 0 до н
 * если квадрат мида меньше н - левую границу + 1
 * если меньше - правую границу - 1
 * иначе возвр мид
 */
public class LC69 {

    public static void main(String[] args) {
        System.out.println(mySqrt(0));
        System.out.println(mySqrt(1));
        System.out.println(mySqrt(2));
        System.out.println(mySqrt(3));
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(7));
        System.out.println(mySqrt(15));
        System.out.println(mySqrt(16));
        System.out.println(mySqrt(63));
        System.out.println(mySqrt(64));
        System.out.println(mySqrt(2147395599));
    }

    public  static int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = (left + right) / 2;
            long sqr = (long) mid * mid;
            if (sqr > x) {
                right = mid - 1;
            } else if (sqr < x) {
                left = mid + 1;
            } else return mid;
        }
        return right;
    }

}
