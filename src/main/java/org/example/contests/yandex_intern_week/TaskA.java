package org.example.contest.yandex_intern_week;

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
        long ports = Long.parseLong(s);
        s = br.readLine();
        long devices = Long.parseLong(s);
        s = br.readLine();
        int c1 = Integer.parseInt(s);
        s = br.readLine();
        int c2 = Integer.parseInt(s);
        if (devices <= ports) {
            bw.write(Integer.toString(0));
            br.close();
            bw.close();
            return;
        }
        long currentPrice = 0L;
        double ratio2 = (double) c2 / 4;
        int bestOption;
        int bestPrice;
        if (ratio2 < (double) c1) {
            bestOption = 4;
            bestPrice = c2;
        } else {
            bestOption = 1;
            bestPrice = c1;
        }
        long toBuy = (devices - ports) / bestOption;
        currentPrice += toBuy * bestPrice;
        int left = (int) (devices - ports - bestOption * toBuy);
        if (left * c1 > c2) {
            currentPrice += c2;
        } else {
            currentPrice += (long) left * c1;
        }
        bw.write(Long.toString(currentPrice));
        br.close();
        bw.close();
    }

}
