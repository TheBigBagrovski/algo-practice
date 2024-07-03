package org.example.contest.yandex_intern_week;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskD {

    public static void main(String[] args) throws IOException { // O(k*n), O(k*n)
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        String[] str = br.readLine().split(" ");
        int digs = Integer.parseInt(str[1]);
        int budget = Integer.parseInt(str[2]);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < digs; i++) {
            str = br.readLine().split(" ");
            int sw = Integer.parseInt(str[1]);
            int day = Integer.parseInt(str[0]);
            if (map.containsKey(sw)) {
                map.get(sw).add(day);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(day);
                map.put(sw, list);
            }
        }
        if (map.size() > budget) {
            bw.write(Integer.toString(-1));
            br.close();
            bw.close();
            return;
        }
        budget -= map.size();
        List<Long> happiness = new ArrayList<>();
        for (List<Integer> list : map.values()) {
            if (list.size() > 1) {
                for (int i = 1; i < list.size(); i++) {
                    happiness.add((long) (list.get(i) - list.get(i - 1)));
                }
            }
        }
        Collections.sort(happiness);
        Long answer = 0L;
        for (int i = 0; i < happiness.size() - budget; i++) {
             answer += happiness.get(i);
        }
        bw.write(Long.toString(answer));
        br.close();
        bw.close();
    }

}
