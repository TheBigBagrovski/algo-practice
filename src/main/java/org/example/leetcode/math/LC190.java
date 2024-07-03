package org.example.leetcode;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * <p>
 * Note:
 * <p>
 * Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.
 */
public class LC190 {

    public static void main(String[] args) {
        System.out.println(solve(3));
    }

    private static int solve(int n) { /// 0011   res=0001|0001=0001 n = 0001, res=0011|0001=0011 n=0000, res=0110|0000 n=0, res=1100
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) | (n & 1);
            n = n >> 1;
        }
        return res;
    }

}
