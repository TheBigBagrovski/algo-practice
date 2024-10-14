package org.example.coderun.itmo_mag;

import java.io.*;
import java.util.*;

/**
 Вам дан массив целых чисел
 a
 .

 Для каждого элемента
 a
 i
 массива выведите ближайший элемент слева, который меньше
 a
 i
 и аналогичный справа.
 */
public class Task2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        String[] s = reader.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                leftSmaller[i] = 0;
            } else {
                leftSmaller[i] = arr[stack.peek()];
            }
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                rightSmaller[i] = 0;
            } else {
                rightSmaller[i] = arr[stack.peek()];
            }
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
             writer.write(leftSmaller[i] + " " + rightSmaller[i] + "\n");
        }

        reader.close();
        writer.close();
    }
}
