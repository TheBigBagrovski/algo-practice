package org.example.contest.yandex_test2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TaskE {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/org/example/contest/yandex_test2/input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/org/example/contest/yandex_test2/output.txt"));
        String a = br.readLine();
        String b = br.readLine();
        int[] arr = new int[26];
        for (int i = 0; i < a.length(); i++) {
            arr[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            arr[b.charAt(i) - 'a']--;
        }
        for (int i : arr) {
            if (i != 0) {
                bw.write(Integer.toString(0));
                bw.close();
                return;
            }
        }
        bw.write(Integer.toString(1));
        br.close();
        bw.close();
    }

}
