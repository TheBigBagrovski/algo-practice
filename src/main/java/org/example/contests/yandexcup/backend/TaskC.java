package org.example.contests.yandexcup.backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TaskC {

    public static void main(String[] args) throws IOException { // O(N), O(N)
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        int n = Integer.parseInt(br.readLine());
//        List<Node> list = new ArrayList<>();
//        list.add(new Node(0));
//        for (int i = 1; i <= n; i++) {
//            int val = Integer.parseInt(br.readLine());
//            Node node = new Node(i);
//            list.add(node);
//            list.get(val).children.add(node);
//        }
//
//        bw.write(Integer.toString(arr[1]));
        br.close();
        bw.close();
    }

}
