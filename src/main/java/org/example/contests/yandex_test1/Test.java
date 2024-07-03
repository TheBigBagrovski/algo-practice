package org.example.contest.yandex_test1;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int[] arr = new int[a];
        for (int i = 0; i < a; i++) {
             arr[i] = scanner.nextInt();
        }
        System.out.println("\n" + a);
        for (int i = 0; i < a; i++) {
            System.out.println(arr[i]);
        }
    }

}
