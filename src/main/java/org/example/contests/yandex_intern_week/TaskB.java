package org.example.contest.yandex_intern_week;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class TaskB {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        if (n == 0) {
            bw.write(Integer.toString(0));
            br.close();
            bw.close();
            return;
        }
        int[] lens = new int[n];
        str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            lens[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(lens);
        int start = 0;
        int end = n - k - 1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            if (lens[end] - lens[start] < min) {
                min = lens[end] - lens[start];
            }
            start++;
            end++;
        }
        bw.write(Integer.toString(min));
        br.close();
        bw.close();
    }

}
