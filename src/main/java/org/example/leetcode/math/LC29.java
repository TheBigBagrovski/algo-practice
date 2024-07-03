package org.example.leetcode;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 *
 * The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
 *
 * Return the quotient after dividing dividend by divisor.
 */
public class LC29 {

    public static void main(String[] args) {
        System.out.println(divide(2147483647, 1));
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE; //Cornor case when -2^31 is divided by -1 will give 2^31 which doesnt exist so overflow
        boolean negative = dividend < 0 ^ divisor < 0; //Logical XOR will help in deciding if the results is negative only if any one of them is negative
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int quotient = 0;
//        while (dividend - divisor >= 0) {
//            dividend -= divisor;
//            quotient += 1;
//        }
        //FASTER
        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);
        while (longDividend >= longDivisor) {
            int shift = 0;
            while (longDividend >= (longDivisor << shift)) {
                shift++;
            }
            shift--;
            longDividend -= longDivisor << shift;
            quotient += 1 << shift;
        }
        return negative ? -quotient : quotient;
    }

}
