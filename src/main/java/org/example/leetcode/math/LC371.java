package org.example.leetcode;

public class LC371 {

    public static void main(String[] args) {
        System.out.println(getSum(15, 15));
    }

    static int getSum(int a, int b) { // 1111 1111 | c = 1111, a = 00000, b = 11110 | c = 00000, a = 11110, b = 00000
        while (b != 0) {
            int carry = a & b;
            a = a ^ b; // 00 = 0, 11 = 1, 01= 1, 10=1
            b = carry << 1;
        }
        return a;
    }

}
