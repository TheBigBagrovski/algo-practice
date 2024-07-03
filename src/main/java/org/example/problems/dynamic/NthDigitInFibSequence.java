package org.example;

public class NthDigitInFibSequence {

    public static int digitNumber(int n) {
        int answer = 0;
        int number = Math.abs(n);
        do {
            number /= 10;
            answer++;
        } while (number > 0);
        return answer;
    }

    public static int fibSequenceDigit(int n) {
        int i = 0;
        int number = 0;
        int answer = 0;
        int value;
        int rank;
        while (i != n) {
            number++;
            value = fib(number);
            rank = digitNumber(value);
            for (int a = 1; a <= rank; a++) {
                answer = (int) ((value / Math.pow(10.0, rank - a)) % 10);
                i++;
                if (i == n)
                    break;
            }
        }
        return answer;
    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int fib1 = 0;
        int fib2 = 1;
        int fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = fib1 + fib2;
            fib1 = fib2;
            fib2 = fibN;
        }
        return fibN;
    }

}
