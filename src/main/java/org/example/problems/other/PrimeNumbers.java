package org.example;

public class PrimeNumbers {

    //временные затраты: O(N*log(logN)) (решето Эратосфена)
    //затраты памяти: O(N)    (массив длиной limit + 1)
    static public int calcPrimesNumber(int limit) {
        if (limit <= 1) return 0;
        boolean[] isPrime = new boolean[limit + 1];
        for (int i = 2; i <= limit; i++) isPrime[i] = true;
        int result = 0;
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) result++;
            for (int j = i * 2; j <= limit; j += i) { //при j=i*i на больших значениях происходит выход за пределы int
                isPrime[j] = false;
            }
        }
        return result;
    }

}
