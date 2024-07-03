package org.example.contest.yandex_test2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TaskC {

    public static void main(String[] args) {
        try (FileReader fr = new FileReader("input.txt");
             BufferedReader br = new BufferedReader(fr);
             FileWriter fw = new FileWriter("output.txt");
             BufferedWriter bw = new BufferedWriter(fw)) {
            int size = Integer.parseInt(br.readLine());
            String prev = "";
            for (int i = 0; i < size; i++) {
                String a = br.readLine();
                if (!a.equals(prev)) {
                    prev = a;
                    bw.write(a);
                    bw.write("\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
