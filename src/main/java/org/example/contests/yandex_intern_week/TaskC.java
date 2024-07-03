package org.example.contest.yandex_intern_week;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskC {

    public static void main(String[] args) throws IOException { // O(N), O(N)
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        int n = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();
        list.add(new Node(0));
        for (int i = 1; i <= n; i++) {
            int val = Integer.parseInt(br.readLine());
            Node node = new Node(i);
            list.add(node);
            list.get(val).children.add(node);
        }

        int[] arr = dfs(list.get(0), 0, new int[] {0, 0});

        bw.write(Integer.toString(arr[1]));
        br.close();
        bw.close();
    }

    private static int[] dfs(Node root, int currentDepth, int[] max) {
        currentDepth++;
        if (currentDepth > max[0]) {
            max[0] = currentDepth;
            max[1] = root.number;
        }
        for (Node child : root.children) {
            int[] res = dfs(child, currentDepth, max);
            if (res[0] > max[0]) {
                max = res;
            }
        }
        return max;
    }

    static class Node {
        int number;

        List<Node> children = new ArrayList<>();

        public Node(int number) {
            this.number = number;
        }
    }

}
