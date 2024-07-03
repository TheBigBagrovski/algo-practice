package org.example.contests.yandex_test2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TaskF {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/org/example/contest/yandex_test2/input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/org/example/contest/yandex_test2/output.txt"));
        int n = Integer.parseInt(br.readLine());
        int[][] cities = new int[n][2];
        for (int i = 0; i < n; i++) {
             String city = br.readLine();
             cities[i][0] = Integer.parseInt(city.split(" ")[0]);
             cities[i][1] = Integer.parseInt(city.split(" ")[1]);
        }
        int k = Integer.parseInt(br.readLine());
        String last = br.readLine();
        int to = Integer.parseInt(last.split(" ")[1]) - 1;
        int from = Integer.parseInt(last.split(" ")[0]) - 1;
        if (to == from) {
            bw.write(Integer.toString(0));
            br.close();
            bw.close();
            return;
        }
        int[] used = new int[n];
        int answer = go(cities, used, k, from, to, 0);
        bw.write(Integer.toString(answer));
        br.close();
        bw.close();
    }

    private static int go(int[][] cities, int[] used, int k, int current, int to, int currentDist) {
        long x = countDist(cities[current][0], cities[current][1], cities[to][0], cities[to][1]);
        if (x <= k) {
            return currentDist + 1;
        }
        used[current] = 1;
        for (int i = 0; i < cities.length; i++) {
            if (used[i] != 1 && countDist(cities[current][0], cities[current][1], cities[i][0], cities[i][1]) <= k) {
                int y = go(cities, used, k, i, to, currentDist + 1);
                if (y != -1)
                    return y;
            }
        }
        used[current] = 0;
        return -1;
    }

    private static long countDist(int fromX, int fromY, int toX, int toY) {
        return Math.abs(toX - fromX) + Math.abs(toY - fromY);
    }


}
