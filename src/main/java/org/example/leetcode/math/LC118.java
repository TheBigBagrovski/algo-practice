package org.example.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * РЕШЕНИЕ:
 * идти вложенным циклом, перебирая прошлый ряд, формируем новый, сохраняем в прев
 */
public class LC118 {

    public static void main(String[] args) {
        System.out.println(generate(1));
        System.out.println(generate(2));
        System.out.println(generate(3));
        System.out.println(generate(5));
        System.out.println(generate(30));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        answer.add(first);
        for (int i = 1; i < numRows; i++) {
            List<Integer> current = new ArrayList<>();
            List<Integer> prev = answer.get(i - 1);
            int prevSize = prev.size();
            current.add(prev.get(0));
            for (int j = 0; j < prevSize - 1; j++) {
                 current.add(prev.get(j) + prev.get(j + 1));
            }
            current.add(prev.get(prevSize - 1));
            answer.add(current);
        }
        return answer;
    }

}
