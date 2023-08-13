package org.example;

public class LC191 {

    public static void main(String[] args) {
        System.out.println(shifting(3));
        System.out.println(shifting(5));
        System.out.println(shifting(0));
        System.out.println(shifting(10));
    }

    private static int shifting(int n) {
        int ones = 0;
        while(n!=0) {
            ones = ones + (n & 1); // или n % 2
            n = n>>>1;
        }
        return ones;
    }

    private static int solve(int n) {
        String s = Integer.toBinaryString(n);
        int result = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
             if(arr[i] == '1') result++;
        }
        return result;
    }

}
