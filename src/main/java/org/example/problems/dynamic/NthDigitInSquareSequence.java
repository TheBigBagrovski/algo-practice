package org.example;

public class NthDigitInSquareSequence {

    public static int digitNumber(int n) {
        int answer = 0;
        int number = Math.abs(n);
        do {
            number /= 10;
            answer++;
        } while (number > 0);
        return answer;
    }

    public static int squareSequenceDigit(int n) {
        int i = 0;
        int number = 0;
        int numberSqr;
        int answer = 0;
        int rank;
        while (i != n) {
            number++;
            numberSqr = sqr(number);
            rank = digitNumber(numberSqr);
            for (int a = 1; a <= rank; a++) {
                answer = (int) ((numberSqr / Math.pow(10.0, rank - a)) % 10);
                i++;
                if (i == n)
                    break;
            }
        }
        return answer;
    }

    public static int sqr(int n) {
        return n * n;
    }

}
