package org.example.coderun.itmo_mag.airports;

public class Main {

    public static void main(String[] args) {
        int N = 3;  // длина числа
        int K = 2;  // количество нулей подряд, которые запрещены

        int result = countBinaryNumbers(N, K);
        System.out.println(result);  // вывод результата
    }

    private static int countBinaryNumbers(int N, int K) {
        return countBinaryNumbersHelper(N, K, 0, 0);
    }

    private static int countBinaryNumbersHelper(int N, int K, int currentLength, int zeroCount) {
        if (zeroCount == K) {
            return 0;
        }

        if (currentLength == N) {
            return 1;
        }

        int countWithOne = countBinaryNumbersHelper(N, K, currentLength + 1, 0);
        int countWithZero = countBinaryNumbersHelper(N, K, currentLength + 1, zeroCount + 1);

        return countWithOne + countWithZero;
    }

}
