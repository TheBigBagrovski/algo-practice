package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 *
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * If multiple answers are possible, return any of them.
 *
 * It is guaranteed that the length of the answer string is less than 104 for all the given inputs.
 */
public class LC166 { // странная задача

    public static void main(String[] args) {

    }

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder ans = new StringBuilder();
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0))
            ans.append("-");

        long num = (long) Math.abs((long) numerator);
        long den = (long) Math.abs((long) denominator);

        long quotient = num / den;
        long remainder = num % den;

        ans.append(String.valueOf(quotient));

        if (remainder == 0)
            return ans.toString();

        ans.append(".");

        Map<Long, Integer> map = new HashMap<>();

        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                int pos = map.get(remainder);
                ans.insert(pos, "(");
                ans.append(")");
                return ans.toString();
            } else {
                map.put(remainder, ans.length());
                remainder *= 10;
                quotient = remainder / den;
                remainder %= den;
                ans.append(String.valueOf(quotient));
            }
        }

        return ans.toString();
    }

}
