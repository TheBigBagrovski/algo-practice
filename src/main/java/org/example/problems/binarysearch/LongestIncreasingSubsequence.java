package org.example;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

    //временные затраты: O(NlogN)
    //затраты памяти: O(N)
    public static List<Integer> longestIncreasingSubSequence(List<Integer> list) {
        int longestLength = 0;
        int[] prevIndices = new int[list.size()];
        int[] curIndices = new int[list.size() + 1];
        for (int i = list.size() - 1; i >= 0; i--) {
            //бинарный поиск (+ обход по списку => трудоемкость O(N*logN) )
            int lo = 1; //нижняя граница
            int hi = longestLength; //верхняя граница
            while (lo <= hi) {
                int mid = (hi + lo) / 2;
                if (list.get(curIndices[mid]) >= list.get(i)) lo = mid + 1;
                else hi = mid - 1;
            }
            if (lo > longestLength) longestLength = lo;
            prevIndices[i] = curIndices[lo - 1];
            curIndices[lo] = i;
        }
        int k = curIndices[longestLength];
        List<Integer> answer = new ArrayList<>(longestLength);
        for (int i = longestLength - 1; i >= 0; i--) {
            answer.add(list.get(k));
            k = prevIndices[k];
        }
        return answer;
    }

}
