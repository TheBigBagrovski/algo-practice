package org.example;

import java.util.ArrayList;
import java.util.List;

public class LC77 {

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }


    public static List<List<Integer>> combine(int n, int k) {// faster
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k > n || k < 0) {
            return result;
        }
        if (k == 0) {
            result.add(new ArrayList<Integer>());
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
