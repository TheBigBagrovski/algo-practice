package org.example;

import java.util.LinkedHashMap;
import java.util.Map;

public class ReduceString {

    public static void main(String[] args) {
        String s = "AAAABBBXXXXXXXYYYHHHHMLR";
        System.out.println(map(s));
        s = "";
        System.out.println(map(s));
    }

    private static String solve(String s) {
        if (s.isEmpty()) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        char[] arr = s.toCharArray();
        char current = arr[0];
        int counter = 0;
        for (char c : arr) {
            if (c == current) {
                counter++;
            } else {
                builder.append(current);
                if (counter != 1) {
                    builder.append(counter);
                }
                counter = 1;
                current = c;
            }
        }
        builder.append(current);
        if (counter != 1) {
            builder.append(counter);
        }
        return builder.toString();
    }

    private static String map(String s) {
        StringBuilder builder = new StringBuilder();
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            builder.append(entry.getKey());
            if (entry.getValue() != 1) builder.append(entry.getValue());
        }
        return builder.toString();
    }

}
