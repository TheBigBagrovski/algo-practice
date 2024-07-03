package org.example.leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 *Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * РЕШЕНИЕ:
 * делаем ХМ <число, частота>
 * создаем кучу/список и сортируем по значению, выдаем к нааибольших элементов
 * O(NlogN) O(N)
 */
public class LC347 {

    public static void main(String[] args) {

    }

    public int[] topKFrequent(int[] nums, int k) { // O(NlogN) O(N)
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        int[] ans = new int[k];

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(b)-map.get(a));
        queue.addAll(map.keySet());
        for(int i=0; i<k; i++){
            ans[i]=queue.poll();
        }
        /* ИЛИ (СКОРОСТЬ ОДИНАКОВАЯ):
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return map.get(b)-map.get(a);
            }
        });
        for(int i=0; i<k; i++){
            ans[i]=list.get(i);
        }
        */
        return ans;
    }

}
