package org.example.euristic;

import java.util.Random;

import static java.lang.Math.pow;

/**
 * вычисление пи методом Монте-Карло
 * входной параметр - точность
 * выбираем рандомные точки от 0 до 1 n раз и проверяем, попали ли они в круг с радиусом 1
 * считаем количество попаданий
 * вероятность попадания составляет pi/4, prob = hit / n, prob = pi/4 => pi = hit * 4 / n
 */
public class MonteCarloPi {

    public static void main(String[] args) {
        System.out.println(countPi(100000000));
    }

    public static double countPi(int n) {
        int count = 0, i = 0;
        double x, y;
        Random random = new Random();
        while (i < n) {
            x = random.nextDouble();
            y = random.nextDouble();
            if ((pow(x, 2) + pow(y, 2)) < 1) {
                count++;
            }
            i++;
        }
        return (4.0 * count) / n;
    }

}
