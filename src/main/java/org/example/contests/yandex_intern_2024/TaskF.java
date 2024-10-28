package org.example.contests.yandex_intern_2024;

import java.io.*;
import java.util.*;

public class TaskA {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        String[] line = reader.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int target = Integer.parseInt(line[1]);
        String[] line2 = reader.readLine().split(" ");
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(line2[i]);
        }
//        writer.write(Long.toString(currentPrice));
        reader.close();
        writer.close();
    }


}
