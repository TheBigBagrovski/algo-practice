package org.example.contests.yandexcup.backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskA {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int c = Integer.parseInt(str[1]);
        str = br.readLine().split(" ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            int num = Integer.parseInt(str[i]);
            if (num != 0) {
                list.add(num);
            }
        }

        long result = 0L;
        for (int i = 0; i < list.size() && list.get(i) != 0; i++) {
            result += (long) list.get(i) * list.get(i);
            for (int j = i + 1; j <= i + list.get(i) && j < list.size(); j++) {
                result += list.get(j);
            }
        }

        bw.write(Long.toString(result));
        br.close();
        bw.close();
    }

}
