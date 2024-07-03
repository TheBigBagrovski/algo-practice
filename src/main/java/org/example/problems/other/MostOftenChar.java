package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MostOftenChar {

    public static void main(String[] args) {
        String s = "abababa";
        System.out.println(solve(s));
        s = "abababaccccccc";
        System.out.println(solve(s));
    }

    private static Character solve(String s) {
        if (s.isEmpty()) {
            return null;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
//        int max = 0;
//        Character answer = null;
//        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            if (entry.getValue() > max) {
//                max = entry.getValue();
//                answer = entry.getKey();
//            }
//        }
        Optional<Map.Entry<Character, Integer>> maxEntry = map.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());
        return maxEntry.get().getKey();
    }

}
