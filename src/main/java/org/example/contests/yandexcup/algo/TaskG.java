package org.example.contests.yandexcup.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            int[] arr = new int[2];
            arr[0] = Integer.parseInt(str[0]);
            arr[1] = Integer.parseInt(str[1]);
            list.add(arr);
        }
        String[] str = br.readLine().split(" ");
        int[] toRemove = new int[str.length];
        for (int i = 0; i < toRemove.length; i++) {
            toRemove[i] = Integer.parseInt(str[i]);
        }
        calc(list, bw);
        for (int i = 0; i < toRemove.length; i++) {
            list.remove(toRemove[i] -1);
            calc(list, bw);
        }
        br.close();
        bw.close();
    }

    private static void calc(List<int[]> list, BufferedWriter bw) throws IOException {
        double a = list.get(list.size() - 1)[0];
        double b = list.get(list.size() - 1)[1];
        for (int i = list.size() - 2; i >= 0; i--) {
             int[] cur = list.get(i);
             a *= cur[0];
             b *= cur[0];
             b += cur[1];
        }
        if (a == 0.0) {
            bw.write("-1" + "\n");
        } else {
            printRes(-b /a, bw);
        }
    }

    private static void printRes(double result, BufferedWriter bw) throws IOException {
        int x = (int) result;
        double f = result -  x;
        if (f == 0.0) {
            bw.write((int)((result + 1000000007) % 1000000007) + "\n");
        } else {
            bw.write((int)((result * 1000000007) + 1000000007)  + "\n");
        }
    }

}
