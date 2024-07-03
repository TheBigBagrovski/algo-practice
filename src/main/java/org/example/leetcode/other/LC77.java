package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 *
 * You may return the answer in any order.
 * РЕШЕНИЕ:
 * рекурсия
 * УВ1: если K > N или к меньше 0 - возвр результат
 * УВ2:
 */
public class LC77 {

    public static void main(String[] args) {
        System.out.println(combine(4, 3));
    }


    public static List<List<Integer>> combine(int n, int k) {// faster
        List<List<Integer>> result = new ArrayList<>();
        if (k > n || k < 0) {
            return result;
        }
        if (k == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        result = combine(n - 1, k - 1);
        for (List<Integer> list : result) {
            list.add(n);
        }
        result.addAll(combine(n - 1, k));
        return result;
    }

//    public static List<List<Integer>> combine(int n, int k) {
//        List<List<Integer>> combs = new ArrayList<List<Integer>>();
//        combine(combs, new ArrayList<Integer>(), 1, n, k);
//        return combs;
//    }
//    public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
//        if(k==0) {
//            combs.add(new ArrayList<Integer>(comb));
//            return;
//        }
//        for(int i=start;i<=n;i++) {
//            comb.add(i);
//            combine(combs, comb, i+1, n, k-1);
//            comb.remove(comb.size()-1);
//        }
//    }

}
