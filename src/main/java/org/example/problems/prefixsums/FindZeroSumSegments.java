package org.example;

import java.util.HashMap;
import java.util.Map;

public class FindZeroSumSegments {

    public static void main(String[] args) {
        int[] arr = {1, 1, -1, -1};
        System.out.println(solve(arr));
    }

    static int solve(int[] arr) { // O(N)
        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0 ,1);
        int currentSum = 0;
        for (int j : arr) {
            currentSum += j;
            prefixSums.put(currentSum, prefixSums.getOrDefault(currentSum, 0) + 1);
        }
        int answer = 0;
        for (Map.Entry<Integer, Integer> entry : prefixSums.entrySet()) {
            int current = entry.getValue();
            answer += current * (current - 1) / 2;
        }
        return answer;
    }

}
