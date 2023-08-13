package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC120 {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        list1.add(2);
        list2.add(3);
        list2.add(4);
        list3.add(6);
        list3.add(5);
        list3.add(7);
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        System.out.println(solve(list));
    }

    private static int solve(List<List<Integer>> triangle) { // O(n*m), O(1)/O(m)
        int size = triangle.size();
        if (size == 1) return triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            List<Integer> row = triangle.get(i);
            int len = row.size();
            row.set(0, triangle.get(i-1).get(0) + row.get(0));
            row.set(len - 1, triangle.get(i-1).get(len - 2) + row.get(len - 1));
            for (int j = 1; j < len - 1; j++) {
                row.set(j,  row.get(j) + Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1)));
            }
            triangle.set(i, row);
        }
        return triangle.get(size - 1).stream().min(Integer::compare).get();
    }

}
