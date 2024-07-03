package org.example.contests.yandexcup.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TaskA {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        String[] str = br.readLine().split(" ");
        int[] arr = new int[str.length];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        int counter = 0;
        for (int i : arr) {
            if (i <= counter + 1) {
                counter = i;
            }
        }
        bw.write(Long.toString(counter));
        br.close();
        bw.close();
    }

}
