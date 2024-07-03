package org.example.contest.yandex_test2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskD {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        int n = Integer.parseInt(br.readLine());
        backtrack(bw, n, new ArrayList<>(), 0, 0);
        br.close();
        bw.close();
    }

    private static void backtrack(BufferedWriter bw, int n, List<Character> current, int set, int toClose) throws IOException {
        if (set == n) {
            for (Character c : current) {
                bw.write(c);
            }
            bw.write("\n");
        } else {
            if (set + toClose < n) {
                current.add('(');
                backtrack(bw, n, current, set, toClose + 1);
                current.remove(current.size() - 1);
            }
            if (toClose != 0) {
                current.add(')');
                backtrack(bw, n, current, set + 1, toClose - 1);
                current.remove(current.size() - 1);
            }
        }
    }

}
