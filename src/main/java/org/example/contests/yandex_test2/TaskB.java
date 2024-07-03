package org.example.contest.yandex_test2;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int counter = 0;
        int max = 0;
        for (int i = 0; i < size; i++) {
             if (scanner.nextInt() == 1) {
                 counter++;
                 if (counter > max) max = counter;
             }
             else {
                 counter = 0;
             }
        }
        System.out.println(max);
    }

}
